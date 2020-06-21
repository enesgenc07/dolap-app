package com.trendyol.dolapapp.converter;

import com.trendyol.dolapapp.converter.base.BaseConverter;
import com.trendyol.dolapapp.dto.ProductDto;
import com.trendyol.dolapapp.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductConverter extends BaseConverter<Product, ProductDto> {

}
