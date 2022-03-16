package com.project.shoppingcart.service;

import com.project.shoppingcart.dto.request.ProductRequestDto;
import com.project.shoppingcart.entity.Product;
import com.project.shoppingcart.exception.CategoryNotFoundException;
import com.project.shoppingcart.exception.MerchantNotFoundException;
import com.project.shoppingcart.modelmapper.ProductMapper;
import com.project.shoppingcart.repository.CategoryRepository;
import com.project.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MerchantService merchantService;

    public void addProducts(ProductRequestDto productRequestDto,
                            int merchantId, String categoryName) {
        if (categoryRepository.getByName(categoryName) == null)
            throw new CategoryNotFoundException("Requested category is not found");
        else if (merchantService.getById(merchantId)==null)
            throw new MerchantNotFoundException("merchant id does not exists");
        Product products = productMapper.dtoToEntity(productRequestDto);
        products.setCategory(categoryRepository.getByName(categoryName));
        products.setMerchant(merchantService.getById(merchantId));
        productRepository.save(products);
    }

    public void updateProduct(String productName, ProductRequestDto theProduct) {
        Product tempProduct = productRepository.getByName(productName);
        tempProduct.setName(theProduct.getName());
        tempProduct.setDescription(theProduct.getDescription());
        tempProduct.setQty(theProduct.getQty());
        tempProduct.setPrice(theProduct.getPrice());
        tempProduct.setDiscount(theProduct.getDiscount());
        productRepository.save(tempProduct);
    }
    
    public void deleteProduct(String productName)
    {
       if(productRepository.deleteByName(productName)==0)
           throw new RuntimeException("product not found");
    }

    public void deleteProductById(int productId) {

        if(productRepository.getById(productId)==null)
            throw new RuntimeException("product id not found");
        productRepository.deleteById(productId);
    }
}
