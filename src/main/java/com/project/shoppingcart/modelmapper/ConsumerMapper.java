package com.project.shoppingcart.modelmapper;

import com.project.shoppingcart.dto.request.ConsumerRequestDto;
import com.project.shoppingcart.dto.response.ConsumerResponseDto;
import com.project.shoppingcart.entity.AuthUser;
import com.project.shoppingcart.entity.Consumer;
import com.project.shoppingcart.entity.Roles;
import com.project.shoppingcart.enumclass.UserStatus;
import com.project.shoppingcart.enumclass.UserType;
import com.project.shoppingcart.repository.AuthUserRepository;
import com.project.shoppingcart.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ConsumerMapper {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ModelMapper mapper;

    @Autowired
    AuthUserRepository authUserRepository;

    @Autowired
    RoleRepository roleRepository;

    public Consumer dtoToEntity(ConsumerRequestDto consumerRequestDto) {
        AuthUser authUser=new AuthUser();
        authUser.setUserName(consumerRequestDto.getEmail());
        authUser.setPassword(passwordEncoder.encode(consumerRequestDto.getPassword()));
        authUser.setUserType(UserType.CONSUMER);
        authUser.setRoles(Arrays.asList(roleRepository.getByName("Normal_Consumer")));
        Consumer consumer = mapper.map(consumerRequestDto, Consumer.class);
        consumer.setStatus(UserStatus.ACTIVE);
        consumer.setAuthUser1(authUser);
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
