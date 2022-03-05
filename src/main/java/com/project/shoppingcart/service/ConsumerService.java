package com.project.shoppingcart.service;

import java.util.List;

import com.project.shoppingcart.dto.request.AddressRequestDto;
import com.project.shoppingcart.dto.request.ConsumerRequestDto;
import com.project.shoppingcart.dto.response.ConsumerResponseDto;
import com.project.shoppingcart.entity.Address;
import com.project.shoppingcart.entity.Consumer;
import com.project.shoppingcart.enumclass.Status;
import com.project.shoppingcart.enumclass.Type;
import com.project.shoppingcart.exception.EmailExistException;
import com.project.shoppingcart.modelmapper.AddressMapper;
import com.project.shoppingcart.modelmapper.ConsumerMapper;
import com.project.shoppingcart.repository.AddressRepository;
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

    public void createUser(ConsumerRequestDto consumerRequestDto) {

        Consumer consumer = consumerMapper.dtoToEntity(consumerRequestDto);

        if (consumerRepository.findByEmail(consumer.getEmail()) != null)
            throw new EmailExistException("email exists..");
        consumerRepository.save(consumer);

    }

    public List<ConsumerResponseDto> getAll() {
        List<Consumer> consumer = consumerRepository.findAll();
        return consumerMapper.entityToDto(consumer);
    }

    public Consumer getById(int id) {
        return consumerRepository.getById(id);
    }


    public void statusUpdate(Type type, int id) {
        Consumer theConsumer = consumerRepository.getById(id);
        theConsumer.setStatus(Status.INACTIVE);
        consumerRepository.save(theConsumer);
    }

    public void addAddress(AddressRequestDto addressRequestDto, Consumer consumer) {
        Address address = addressMapper.dtoToEntity(addressRequestDto);
        address.setConsumer(consumer);
        addressRepository.save(address);
    }
}
