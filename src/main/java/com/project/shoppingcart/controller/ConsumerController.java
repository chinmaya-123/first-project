package com.project.shoppingcart.controller;

import javax.validation.Valid;

import com.project.shoppingcart.common.ApiResponse;
import com.project.shoppingcart.dto.request.AddressRequestDto;
import com.project.shoppingcart.dto.response.ConsumerResponseDto;
import com.project.shoppingcart.entity.Consumer;
import com.project.shoppingcart.modelmapper.ConsumerMapper;
import com.project.shoppingcart.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.project.shoppingcart.dto.request.ConsumerRequestDto;
import com.project.shoppingcart.service.ConsumerService;

import java.util.Optional;

@Validated
@RestController
@RequestMapping("/user")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    ConsumerRepository consumerRepository;

    @Autowired
    ConsumerMapper consumerMapper;

    @PostMapping("/register")
    public ApiResponse create(@RequestBody ConsumerRequestDto consumerRequestDto) {
        consumerService.createUser(consumerRequestDto);
        return new ApiResponse(true, "user Registered successfully");
    }

    @GetMapping("/{userId}")
    public ConsumerResponseDto getById(@PathVariable int userId) {
        return consumerMapper.entityToDto(consumerService.getById(userId));
    }

    @PostMapping("/{id}/address")
    public ApiResponse addAddress(
            @Valid @RequestBody AddressRequestDto addressRequestDto,
            @PathVariable Integer id
    ) {
        Optional<Consumer> consumer = consumerRepository.findById(id);
        if (consumer.isPresent())
            consumerService.addAddress(addressRequestDto,consumer.get());
        else
            throw new RuntimeException("ghjgsj");

        return new ApiResponse(true, "Address added successfully ");
    }
}
