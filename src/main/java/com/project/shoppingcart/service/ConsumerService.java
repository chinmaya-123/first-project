package com.project.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import com.project.shoppingcart.dto.request.AddressRequestDto;
import com.project.shoppingcart.dto.request.ConsumerRequestDto;
import com.project.shoppingcart.entity.Address;
import com.project.shoppingcart.entity.AuthUser;
import com.project.shoppingcart.entity.Consumer;
import com.project.shoppingcart.enumclass.UserStatus;
import com.project.shoppingcart.enumclass.UserType;
import com.project.shoppingcart.exception.EmailFoundException;
import com.project.shoppingcart.exception.ConsumerNotFoundException;
import com.project.shoppingcart.modelmapper.AddressMapper;
import com.project.shoppingcart.modelmapper.ConsumerMapper;
import com.project.shoppingcart.repository.AddressRepository;
import com.project.shoppingcart.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shoppingcart.repository.ConsumerRepository;

@Service
public class ConsumerService {

    @Autowired
    ConsumerRepository consumerRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ConsumerMapper consumerMapper;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    AuthUserRepository authUserRepository;

    public void createUser(ConsumerRequestDto consumerRequestDto) {

        Consumer consumer = consumerMapper.dtoToEntity(consumerRequestDto);

        if (consumerRepository.findByEmail(consumer.getEmail()) != null)
            throw new EmailFoundException("email exists..");
        consumerRepository.save(consumer);

    }

    public List<Consumer> getAll() {
        List<Consumer> consumer = consumerRepository.findAll();
        return consumer;
    }

    public Consumer getById(int id) {
       Optional<Consumer> consumer=consumerRepository.findById(id);
       if(consumer.isPresent())
           return consumer.get();
       else
           throw new ConsumerNotFoundException("user id not found");
    }


    public void statusUpdate(UserType type, int id) {
        Consumer theConsumer = consumerRepository.getById(id);
        if(theConsumer==null)
            throw new ConsumerNotFoundException("consumer id not found");
        theConsumer.setStatus(UserStatus.INACTIVE);
        consumerRepository.save(theConsumer);
    }

    public void addAddress(AddressRequestDto addressRequestDto, AuthUser user) {
        Address address = addressMapper.dtoToEntity(addressRequestDto);
        address.setAuthUser(user);
        addressRepository.save(address);
    }

    public List<Address> getAddress(int id)
    {
        return  addressRepository.getByUserId(id);
    }
}
