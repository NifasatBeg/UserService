package com.nifasat.userservice.Services;

import com.nifasat.userservice.Entities.UserInfo;
import com.nifasat.userservice.Entities.UserInfoDto;
import com.nifasat.userservice.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserInfoDto createOrUpdateUser(UserInfoDto userInfoDto){

        UserInfo userInfo = userRepository.findByUserId(userInfoDto.getUserId())
                .map(user -> userRepository.save(userInfoDto.convertToUserInfo()))
                .orElseGet(() -> userRepository.save(userInfoDto.convertToUserInfo()));
        return UserInfoDto.builder()
                .userId(userInfo.getUserId())
                .firstName(userInfo.getFirstName())
                .lastName(userInfo.getLastName())
                .phoneNumber(userInfo.getPhoneNumber())
                .email(userInfo.getEmail())
                .build();

    }

    public UserInfoDto getUser(String userId){
        Optional<UserInfo> userInfoOpt = userRepository.findByUserId(userId);
        if(userInfoOpt.isEmpty()){
            throw new RuntimeException("User Not found");
        }
        log.info("User Details {}", userInfoOpt.get());
        UserInfo userInfo= userInfoOpt.get();
        return UserInfoDto.builder()
                    .userId(userInfo.getUserId())
                    .firstName(userInfo.getFirstName())
                    .lastName(userInfo.getLastName())
                    .phoneNumber(userInfo.getPhoneNumber())
                    .email(userInfo.getEmail())
                    .build();
    }
}
