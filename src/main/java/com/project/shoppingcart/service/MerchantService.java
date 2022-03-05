package com.project.shoppingcart.service;

import com.project.shoppingcart.dto.request.MerchantRequestDto;
import com.project.shoppingcart.dto.response.MerchantResponseDto;
import com.project.shoppingcart.entity.Merchant;
import com.project.shoppingcart.enumclass.Status;
import com.project.shoppingcart.enumclass.Type;
import com.project.shoppingcart.modelmapper.MerchantMapper;
import com.project.shoppingcart.repository.MerchantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    MerchantMapper merchantMapper;


    public MerchantResponseDto create(MerchantRequestDto merchantDto) {
        Merchant theMerchant = merchantMapper.dtoToEntity(merchantDto);
        merchantRepository.save(theMerchant);
        return merchantMapper.entityToDto(theMerchant);
    }

    public List<MerchantResponseDto> getAll() {

        List<Merchant> merchant = merchantRepository.findAll();
        return merchantMapper.entityToDto(merchant);
    }

    public void statusUpdate(Type type, int id) {
        Merchant theMerchant = merchantRepository.getById(id);
        theMerchant.setStatus(Status.INACTIVE);
        merchantRepository.save(theMerchant);
    }
}

