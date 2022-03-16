package com.project.shoppingcart.modelmapper;

import com.project.shoppingcart.dto.request.MerchantRequestDto;
import com.project.shoppingcart.dto.response.MerchantResponseDto;
import com.project.shoppingcart.entity.AuthUser;
import com.project.shoppingcart.entity.Merchant;
import com.project.shoppingcart.enumclass.UserRoles;
import com.project.shoppingcart.enumclass.UserStatus;
import com.project.shoppingcart.enumclass.UserType;
import com.project.shoppingcart.repository.AuthUserRepository;
import com.project.shoppingcart.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MerchantMapper {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ModelMapper mapper;

    @Autowired
    AuthUserRepository authUserRepository;

    @Autowired
    RoleRepository roleRepository;

    public Merchant dtoToEntity(MerchantRequestDto merchantRequestDto) {
        AuthUser authUser=new AuthUser();
        authUser.setUserName(merchantRequestDto.getEmail());
        authUser.setPassword(passwordEncoder.encode(merchantRequestDto.getPassword()));
        authUser.setUserType(UserType.MERCHANT);
        authUser.setRoles(Arrays.asList(roleRepository.getByName("Merchant_Assistant")));
        Merchant merchant = mapper.map(merchantRequestDto, Merchant.class);
        merchant.setStatus(UserStatus.ACTIVE);
        merchant.setAuthUser(authUser);
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
