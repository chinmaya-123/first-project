package com.project.shoppingcart.modelmapper;

import com.project.shoppingcart.dto.request.ConsumerRequestDto;
import com.project.shoppingcart.dto.response.ConsumerResponseDto;
import com.project.shoppingcart.entity.Consumer;
import com.project.shoppingcart.enumclass.Status;
import com.project.shoppingcart.enumclass.Type;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class ConsumerMapper {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ModelMapper mapper;

    public Consumer dtoToEntity(ConsumerRequestDto consumerRequestDto) {
        Consumer consumer = mapper.map(consumerRequestDto, Consumer.class);
        consumer.setPassword(passwordEncoder.encode(consumer.getPassword()));
        consumer.setUserType(Type.CONSUMER);
        consumer.setStatus(Status.ACTIVE);
        return consumer;
    }

    public ConsumerResponseDto entityToDto(Consumer consumer) {
        ConsumerResponseDto theUser = mapper.map(consumer, ConsumerResponseDto.class);
        return theUser;
    }

    public List<ConsumerResponseDto> entityToDto(List<Consumer> consumer) {
        List<ConsumerResponseDto> tempUser = new ArrayList<>();
        for (Consumer theConsumer : consumer)
            tempUser.add(mapper.map(theConsumer, ConsumerResponseDto.class));
        return tempUser;
    }
}
