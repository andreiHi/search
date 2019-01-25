package com.arrival.dto;

import lombok.Data;

import java.util.List;

/**
 * Base dto for pages.
 * @author Victor Karetko.
 */
@Data
public class PageDTO<T> {
    private int totalPages;
    private long totalElements;
    private boolean hasNext;
    private List<T> content;
}
