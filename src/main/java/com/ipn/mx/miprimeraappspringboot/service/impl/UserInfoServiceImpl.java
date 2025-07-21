package com.ipn.mx.miprimeraappspringboot.service.impl;


import com.ipn.mx.miprimeraappspringboot.model.UserInfo;
import com.ipn.mx.miprimeraappspringboot.repository.UserInfoRepo;
import com.ipn.mx.miprimeraappspringboot.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepo userInfoRepo; // instancia inyectada que es un bean (@Service y @Repository son beans).
    private final PasswordEncoder passwordEncoder; // instancia inyectada que es un bean

    @Override
    public UserInfo save(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return this.userInfoRepo.save(userInfo);
    }

    @Override
    public UserInfo update(Integer id, UserInfo userInfo) {
        userInfo.setIdUser(id);
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return this.userInfoRepo.save(userInfo);
    }

    @Override
    public List<UserInfo> findAll() {
        return this.userInfoRepo.findAll();
    }

    @Override
    public UserInfo findById(Integer id) {
        return this.userInfoRepo.findById(id).orElse(new UserInfo(-1, "NONE", "NONE", "NONE"));
    }

    @Override
    public void delete(Integer id) {
        this.userInfoRepo.deleteById(id);
    }
}
