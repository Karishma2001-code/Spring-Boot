package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
public class ErrorResponse {
    private String message;
    private int status;
    private LocalDateTime timeStamp;
}
