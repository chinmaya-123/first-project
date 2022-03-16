package com.project.shoppingcart.controller;

import com.project.shoppingcart.common.ApiResponse;
import com.project.shoppingcart.dto.request.AddressRequestDto;
import com.project.shoppingcart.dto.request.ConsumerRequestDto;
import com.project.shoppingcart.dto.request.MerchantRequestDto;
import com.project.shoppingcart.dto.request.ProductRequestDto;
import com.project.shoppingcart.dto.response.MerchantResponseDto;
import com.project.shoppingcart.entity.Address;
import com.project.shoppingcart.entity.AuthUser;
import com.project.shoppingcart.exception.ConsumerNotFoundException;
import com.project.shoppingcart.modelmapper.MerchantMapper;
import com.project.shoppingcart.repository.AuthUserRepository;
import com.project.shoppingcart.service.ConsumerService;
import com.project.shoppingcart.service.MerchantService;
import com.project.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    ConsumerService consumerService;

    @Autowired
    ProductService productService;

    @Autowired
    AuthUserRepository authUserRepository;

    @Autowired
    MerchantService merchantService;

    @Autowired
    MerchantMapper merchantMapper;


    @PostMapping("/register")
    public ApiResponse create(@RequestBody MerchantRequestDto merchantRequestDto) {
        merchantService.create(merchantRequestDto);
        return new ApiResponse(true, "Merchant Registered successfully");
    }
    @PostMapping("/{id}/address")
    public ApiResponse addAddress(
            @Valid @RequestBody AddressRequestDto addressRequestDto,
            @PathVariable Integer id
    ) {
        Optional<AuthUser> user = authUserRepository.findById(id);
        if (user.isPresent())
            consumerService.addAddress(addressRequestDto, user.get());
        else
            throw new ConsumerNotFoundException("user does not exist");

        return new ApiResponse(true, "Address added successfully ");
    }

    @GetMapping("/address/{userId}")
    public List<Address> getAddress(@PathVariable int userId) {
        return consumerService.getAddress(userId);
    }

    @PostMapping("/product/{pid}/{cname}")
    public ApiResponse addProducts(
            @Valid @RequestBody ProductRequestDto productRequestDto,
            @PathVariable int pid, @PathVariable String cname
    ) {
        productService.addProducts(productRequestDto,pid,cname);
        return new ApiResponse(true, "products added successfully ");
    }

    @GetMapping("/{id}")
    public MerchantResponseDto getById(int id)
    {
       return merchantMapper.entityToDto(merchantService.getById(id));
    }

    @PutMapping("/product/{productName}")
    public ApiResponse updateProduct(@PathVariable String productName,@RequestBody ProductRequestDto productRequestDto)
    {
       productService.updateProduct(productName,productRequestDto);
       return new ApiResponse(true,"product updated successfully");
    }

    @DeleteMapping("/product/{productName}")
    @Transactional
    public ApiResponse deleteProduct(@PathVariable String productName)
    {
        productService.deleteProduct(productName);
        return new ApiResponse(true,"product--"+productName+" deleted ");
    }

    @DeleteMapping("/product/{productId}")
    @Transactional
    public ApiResponse deleteProductById(@PathVariable int productId)
    {
        productService.deleteProductById(productId);
        return new ApiResponse(true,"product-- deleted ");
    }
}
