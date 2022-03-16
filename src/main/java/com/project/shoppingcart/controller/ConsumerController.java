package com.project.shoppingcart.controller;

import javax.validation.Valid;

import com.project.shoppingcart.common.ApiResponse;
import com.project.shoppingcart.dto.request.AddressRequestDto;
import com.project.shoppingcart.dto.response.ConsumerResponseDto;
import com.project.shoppingcart.entity.*;
import com.project.shoppingcart.exception.ConsumerNotFoundException;
import com.project.shoppingcart.modelmapper.ConsumerMapper;
import com.project.shoppingcart.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.project.shoppingcart.dto.request.ConsumerRequestDto;
import com.project.shoppingcart.service.ConsumerService;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    AuthUserRepository authUserRepository;

    @Autowired
    ConsumerMapper consumerMapper;


    @PostMapping("/register")
    public ApiResponse create(@RequestBody ConsumerRequestDto consumerRequestDto) {
        consumerService.createUser(consumerRequestDto);
        return new ApiResponse(true, "user Registered successfully");
    }

    @GetMapping("/{userId}")
    public ConsumerResponseDto getById(@PathVariable int userId) {
        Consumer consumer = consumerService.getById(userId);
        return consumerMapper.entityToDto(consumer);
    }

    @PostMapping("/{id}/address")
    public ApiResponse addAddress(
            @Valid @RequestBody AddressRequestDto addressRequestDto,
            @PathVariable Integer id
    ) {
        Optional<AuthUser> authUser = authUserRepository.findById(id);
        if (authUser.isPresent())
            consumerService.addAddress(addressRequestDto, authUser.get());
        else
            throw new ConsumerNotFoundException("user does not exist");

        return new ApiResponse(true, "Address added successfully ");
    }

    @GetMapping("/address/{userId}")
    public List<Address> getAddress(@PathVariable int userId) {
        return consumerService.getAddress(userId);
    }


}
