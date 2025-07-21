package com.ipn.mx.miprimeraappspringboot.service;

import com.ipn.mx.miprimeraappspringboot.model.UserInfo;

import java.util.List;

public interface UserInfoService {
    UserInfo save(UserInfo userInfo);
    UserInfo update(Integer id, UserInfo userInfo);
    List<UserInfo> findAll();
    UserInfo findById(Integer id);
    void delete(Integer id);
}
