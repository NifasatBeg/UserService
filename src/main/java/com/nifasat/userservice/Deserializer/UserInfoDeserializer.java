package com.nifasat.userservice.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nifasat.userservice.Entities.UserInfoDto;
import org.apache.kafka.common.serialization.Deserializer;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {
    @Override
    public UserInfoDto deserialize(String topic, byte[] data) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserInfoDto user = null;
        try{
            user = objectMapper.readValue(data, UserInfoDto.class);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }
}
