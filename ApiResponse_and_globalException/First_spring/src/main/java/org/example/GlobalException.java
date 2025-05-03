package org.example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleNotFound(ResourceNotFoundException ex) {
        ApiResponse<String> apiResponse=new ApiResponse<>(false,ex.getMessage(),null);
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String,String>>> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String,String> errorMessage=new HashMap<>();
        ex.getBindingResult().getFieldErrors().stream()
                .map(err -> errorMessage.put(err.getField(),err.getDefaultMessage()));
        ApiResponse<Map<String,String>> apiResponse=new ApiResponse<>(false,"Validation failed",errorMessage);
       return new ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGenericException(Exception ex) {
     ApiResponse<String> apiResponse=new ApiResponse<>(false,"An unexpected error occurred: ",ex.getMessage());
     return new ResponseEntity<>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
