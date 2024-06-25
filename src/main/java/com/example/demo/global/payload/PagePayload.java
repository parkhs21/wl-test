package com.example.demo.global.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
@JsonPropertyOrder({"isSuccess", "code", "message", "pageIdx", "pageSize", "totalPages", "totalElements", "data"})
public class PagePayload<T> {

    private final Boolean isSuccess;
    private final String code;
    private final String message;
    private final int pageIdx;
    private final int pageSize;
    private final int totalPages;
    private final int totalElements;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<T> data;

    public static <T> PagePayload<T> onSuccess(BaseStatus status, Page<T> pageData) {
        return new PagePayload<>(
                true,
                status.getReason().code(),
                status.getReason().message(),
                pageData.getNumber(),
                pageData.getSize(),
                pageData.getTotalPages(),
                pageData.getNumberOfElements(),
                pageData.getContent());
    }
}
