package com.pknu26.foodsite.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class PageResponse<T> {
    private List<T> content;
    private int currentPage;
    private int totalPages;
    private int startPage;
    private int endPage;
    private boolean hasPrev;
    private boolean hasNext;

    public PageResponse(List<T> content, long totalCount2, int size, long totalCount) {
        this.content = content;
        this.currentPage = (int) totalCount2;
        this.totalPages = (int) Math.ceil((double) totalCount / size);
        this.endPage = (int) (Math.ceil(totalCount2 / 5.0)) * 5;
        this.startPage = endPage - 4;

        if (totalPages < endPage) endPage = totalPages;

        this.hasPrev = startPage > 1;
        this.hasNext = endPage < totalPages;
    }
}