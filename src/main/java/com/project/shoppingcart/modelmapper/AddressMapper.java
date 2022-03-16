package com.project.shoppingcart.modelmapper;

import com.project.shoppingcart.dto.request.AddressRequestDto;
import com.project.shoppingcart.entity.Address;
import com.project.shoppingcart.repository.ConsumerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AddressMapper {

    @Autowired
    ModelMapper mapper;


    public Address dtoToEntity(AddressRequestDto addressRequestDto) {
        Address address = mapper.map(addressRequestDto, Address.class);
        return address;
    }

    public AddressRequestDto entityToDto(Address address) {
        AddressRequestDto tempAddress = mapper.map(address, AddressRequestDto.class);
        return tempAddress;
    }

    public List<AddressRequestDto> entityToDto(List<Address> addresses) {
        List<AddressRequestDto> tempAddresses = new ArrayList<>();
        for (Address address : addresses)
            tempAddresses.add(mapper.map(address, AddressRequestDto.class));
        return tempAddresses;
    }
}
