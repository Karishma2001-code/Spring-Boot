package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;
@Data
@AllArgsConstructor
public class PageResponse<T>{
    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

    public PageResponse(Page<T> page) {
        this.content = page.getContent();  // List<T> data
        this.pageNumber = page.getNumber();  // Current page number
        this.pageSize = page.getSize();  // Page size (items per page)
        this.totalElements = page.getTotalElements();  // Total number of elements in all pages
        this.totalPages = page.getTotalPages();  // Total number of pages
        this.last = page.isLast();  // Whether it's the last page
    }
}