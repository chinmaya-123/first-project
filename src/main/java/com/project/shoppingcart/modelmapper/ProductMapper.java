package com.project.shoppingcart.modelmapper;

import com.project.shoppingcart.dto.request.AddressRequestDto;
import com.project.shoppingcart.dto.request.ProductRequestDto;
import com.project.shoppingcart.dto.response.ProductResponseDto;
import com.project.shoppingcart.entity.Address;
import com.project.shoppingcart.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    @Autowired
    ModelMapper mapper;


    public Product dtoToEntity(ProductRequestDto productRequestDto) {
        Product product = mapper.map(productRequestDto, Product.class);
        return product;
    }

    public ProductResponseDto entityToDto(Product product) {
        ProductResponseDto tempProduct = mapper.map(product, ProductResponseDto.class);
        return tempProduct;
    }


    public List<Product> dtoToEntity(List<ProductRequestDto> products) {
        List<Product> tempProducts = new ArrayList<>();
        for (ProductRequestDto product : products)
            tempProducts.add(mapper.map(products, Product.class));
        return tempProducts;
    }

    public List<ProductResponseDto> entityToDto(List<Product> products) {
        List<ProductResponseDto> tempProducts = new ArrayList<>();
        for (Product product : products)
            tempProducts.add(mapper.map(products, ProductResponseDto.class));
        return tempProducts;
    }
}
