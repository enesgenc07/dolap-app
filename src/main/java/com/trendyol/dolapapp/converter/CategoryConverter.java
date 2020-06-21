package com.trendyol.dolapapp.converter;

import com.trendyol.dolapapp.converter.base.BaseConverter;
import com.trendyol.dolapapp.dto.CategoryDto;
import com.trendyol.dolapapp.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryConverter extends BaseConverter<Category, CategoryDto> {

}
