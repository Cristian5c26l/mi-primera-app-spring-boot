package com.ipn.mx.miprimeraappspringboot.controller;

import com.ipn.mx.miprimeraappspringboot.model.UserInfo;
import com.ipn.mx.miprimeraappspringboot.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;// instancia inyectada que es un bean (@Service y @Repository son beans). Hace referencia a la clase UserInfoServiceImpl, ya que esta implementa la interfaz UserInfoService

    @GetMapping
    public ResponseEntity<List<UserInfo>> getAllUsers() {
        List<UserInfo> users = this.userInfoService.findAll();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> getUserById(@PathVariable("id") Integer id) {
        UserInfo user = this.userInfoService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserInfo> saveUser(@RequestBody UserInfo user) {
        UserInfo createdUser = this.userInfoService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserInfo> updateUserById(@PathVariable("id") Integer id, @RequestBody UserInfo user) {
        UserInfo updatedUser = this.userInfoService.update(id, user);

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserInfo> deleteUserById(@PathVariable("id") Integer id) {
        this.userInfoService.delete(id);

        return ResponseEntity.noContent().build();// Responder a la petición sin nada de contenido. Con build se indica que ya se terminó la petición
    }
}
