package com.trendyol.dolapapp.dto;

import com.trendyol.dolapapp.converter.base.AbstractDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class ProductDto extends AbstractDto {
    private Long id;
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private BigDecimal price;
    private String note;
    @NotBlank
    private CategoryDto category;
}
