package com.project.shoppingcart.modelmapper;

import com.project.shoppingcart.dto.request.MerchantRequestDto;
import com.project.shoppingcart.dto.response.MerchantResponseDto;
import com.project.shoppingcart.entity.Merchant;
import com.project.shoppingcart.enumclass.Status;
import com.project.shoppingcart.enumclass.Type;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class MerchantMapper {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ModelMapper mapper;

    public Merchant dtoToEntity(MerchantRequestDto merchantRequestDto) {
        Merchant merchant = mapper.map(merchantRequestDto, Merchant.class);
        merchant.setPassword(passwordEncoder.encode(merchant.getPassword()));
        merchant.setUsertype(Type.MERCHANT);
        merchant.setStatus(Status.ACTIVE);
        return merchant;
    }

    public MerchantResponseDto entityToDto(Merchant merchant) {
        MerchantResponseDto theMerchant = mapper.map(merchant, MerchantResponseDto.class);
        return theMerchant;
    }

    public List<MerchantResponseDto> entityToDto(List<Merchant> merchants) {
        List<MerchantResponseDto> tempUser = new ArrayList<>();
        for (Merchant theUser : merchants)
            tempUser.add(mapper.map(theUser, MerchantResponseDto.class));
        return tempUser;
    }
}
