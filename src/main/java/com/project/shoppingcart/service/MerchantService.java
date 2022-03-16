package com.project.shoppingcart.service;

import com.project.shoppingcart.dto.request.MerchantRequestDto;
import com.project.shoppingcart.dto.response.MerchantResponseDto;
import com.project.shoppingcart.entity.Merchant;
import com.project.shoppingcart.enumclass.UserStatus;
import com.project.shoppingcart.enumclass.UserType;
import com.project.shoppingcart.exception.EmailFoundException;
import com.project.shoppingcart.exception.MerchantNotFoundException;
import com.project.shoppingcart.modelmapper.MerchantMapper;
import com.project.shoppingcart.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    MerchantMapper merchantMapper;


    public MerchantResponseDto create(MerchantRequestDto merchantDto) {
        Merchant theMerchant = merchantMapper.dtoToEntity(merchantDto);

        if (merchantRepository.findByEmail(theMerchant.getEmail()) != null)
            throw new EmailFoundException("email exists..");

        merchantRepository.save(theMerchant);
        return merchantMapper.entityToDto(theMerchant);
    }

    public List<Merchant> getAll() {

        return merchantRepository.findAll();
    }

    public Merchant getById(int id) {

        Optional<Merchant> merchant=merchantRepository.findById(id);
        if(merchant.isPresent())
            return merchant.get();
        else
            throw new MerchantNotFoundException("merchant not found");
    }

    public void statusUpdate(UserType type, int id) {
        Merchant theMerchant = merchantRepository.getById(id);
        if(theMerchant==null)
            throw new MerchantNotFoundException("merchant id not found");
        theMerchant.setStatus(UserStatus.INACTIVE);
        merchantRepository.save(theMerchant);
    }
}

