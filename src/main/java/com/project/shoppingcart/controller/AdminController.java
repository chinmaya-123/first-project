package com.project.shoppingcart.controller;

import com.project.shoppingcart.common.ApiResponse;
import com.project.shoppingcart.dto.request.MerchantRequestDto;
import com.project.shoppingcart.dto.response.MerchantResponseDto;
import com.project.shoppingcart.dto.response.ConsumerResponseDto;
import com.project.shoppingcart.enumclass.Type;
import com.project.shoppingcart.service.MerchantService;
import com.project.shoppingcart.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    MerchantService merchantService;

    @GetMapping("/consumer")
    public List<ConsumerResponseDto> getUser() {

        return consumerService.getAll();
    }

    @GetMapping("/merchant")
    public List<MerchantResponseDto> getMerchant() {

        return merchantService.getAll();
    }

    @PostMapping("/merchant")
    public ApiResponse create(@RequestBody MerchantRequestDto merchantRequestDto) {
        MerchantResponseDto merchant = merchantService.create(merchantRequestDto);
        return new ApiResponse(true, "Merchant "+merchant.getUserName() + " created successfully");
    }

    @PostMapping("/inactive/{type}/{id}")
    public ApiResponse statusUpdate(@PathVariable Type type, @PathVariable int id) {
        if (type.equals(Type.MERCHANT))
            merchantService.statusUpdate(type, id);
        else
            consumerService.statusUpdate(type, id);

        return new ApiResponse(true, type + " inactivated successfully");
    }
}
