package com.trendyol.dolapapp.dto;

import com.trendyol.dolapapp.converter.base.AbstractDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CategoryDto extends AbstractDto {
    private Long id;

    @NotBlank
    @Size(min = 3, max = 10)
    private String name;

    @NotBlank
    private String description;


}
