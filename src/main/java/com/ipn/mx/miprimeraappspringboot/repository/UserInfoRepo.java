package com.ipn.mx.miprimeraappspringboot.repository;

import com.ipn.mx.miprimeraappspringboot.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {

    // select * from useriinfo where username = ?;
    UserInfo findByUsername(String username);
}
