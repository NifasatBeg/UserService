package com.nifasat.userservice.Repository;

import com.nifasat.userservice.Entities.UserInfo;
import com.nifasat.userservice.Entities.UserInfoDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, String> {
    Optional<UserInfo> findByUserId(String userId);
}
