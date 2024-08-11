package com.example.Proyecto_final_bueno.service;


import com.example.Proyecto_final_bueno.Repository.UserMongoRepository;
import com.example.Proyecto_final_bueno.dto.UserDto;
import com.example.Proyecto_final_bueno.entity.UserMongoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMongoRepository userRepository;

    public List<UserDto> getAll() {
        return this.userRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public UserDto getById(String id){
        return this.userRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    public UserDto save(UserDto user) {
        UserMongoEntity entity = new UserMongoEntity();
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        UserMongoEntity entitySaved = userRepository.save(entity);
        UserDto saved = this.toDto(entitySaved);
        return saved;
    }

    public UserDto update(UserDto user, String id) {
        UserMongoEntity entity = this.userRepository.findById(id).orElse(null);
        entity.setEmail(user.getEmail());
        entity.setName(user.getName());
        UserMongoEntity entitySaved = this.userRepository.save(entity);
        UserDto saved = this.toDto(entitySaved);
        return saved;
    }

    public void delete(String id) {
        this.userRepository.deleteById(id);
    }

    private UserDto toDto(UserMongoEntity entity){
        return new UserDto(entity.getId(), entity.getName(), entity.getEmail());
    }
}
