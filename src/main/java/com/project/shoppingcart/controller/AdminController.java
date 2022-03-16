package com.project.shoppingcart.controller;

import com.project.shoppingcart.common.ApiResponse;
import com.project.shoppingcart.dto.request.MerchantRequestDto;
import com.project.shoppingcart.dto.response.MerchantResponseDto;
import com.project.shoppingcart.dto.response.ConsumerResponseDto;
import com.project.shoppingcart.entity.AuthUser;
import com.project.shoppingcart.entity.Roles;
import com.project.shoppingcart.enumclass.UserType;
import com.project.shoppingcart.modelmapper.ConsumerMapper;
import com.project.shoppingcart.modelmapper.MerchantMapper;
import com.project.shoppingcart.repository.AuthUserRepository;
import com.project.shoppingcart.repository.RoleRepository;
import com.project.shoppingcart.service.MerchantService;
import com.project.shoppingcart.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    MerchantService merchantService;

    @Autowired
    ConsumerMapper consumerMapper;

    @Autowired
    MerchantMapper merchantMapper;

    @Autowired
    AuthUserRepository authUserRepository;

    @Autowired
    RoleRepository roleRepository;


    @GetMapping("/consumer")
    public List<ConsumerResponseDto> getConsumer() {
        return consumerMapper.entityToDto(consumerService.getAll());
    }

    @PostMapping("/merchant")
    public ApiResponse create(@RequestBody MerchantRequestDto merchantRequestDto) {
        MerchantResponseDto merchant = merchantService.create(merchantRequestDto);
        return new ApiResponse(true, "Merchant " + merchant.getName() + " created successfully");
    }

    @GetMapping("/merchant")
    public List<MerchantResponseDto> getMerchant() {
        return merchantMapper.entityToDto(merchantService.getAll());
    }

    @PostMapping("/inactive/{type}/{id}")
    public ApiResponse statusUpdate(@PathVariable UserType type, @PathVariable int id) {

        if (type.equals(UserType.MERCHANT))
            merchantService.statusUpdate(type, id);
        else
            consumerService.statusUpdate(type, id);

        return new ApiResponse(true, type + " inactivated successfully");
    }

    @PutMapping("/role/{userId}")
    @PreAuthorize("hasAnyRole('Super_Admin')")
    public ApiResponse addRoles(@PathVariable int userId, @RequestBody String roleName) {
        Optional<AuthUser> result = authUserRepository.findById(userId);
        if(!result.isPresent())
            throw new RuntimeException("user id not found");

        AuthUser authUser= result.get();
        authUser.setRoles(Arrays.asList(roleRepository.getByName(roleName)));
        authUserRepository.save(authUser);
        return new ApiResponse(true, "role added successfully");
    }
}
