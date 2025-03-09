package com.nifasat.userservice.Consumers;

import com.nifasat.userservice.Entities.UserInfo;
import com.nifasat.userservice.Entities.UserInfoDto;
import com.nifasat.userservice.Repository.UserRepository;
import com.nifasat.userservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceConsumer{
    @Autowired
    private UserService userService;

    @Autowired
    AuthServiceConsumer(UserService userService){
        this.userService = userService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(UserInfoDto eventData){
        try{
            userService.createOrUpdateUser(eventData);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
