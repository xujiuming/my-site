package com.ming.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ming
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryIndexDTO {
    private String name;
    private Long count;
}
