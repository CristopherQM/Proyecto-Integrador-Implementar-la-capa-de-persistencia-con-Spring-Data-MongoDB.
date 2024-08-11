package com.example.Proyecto_final_bueno.Repository;

import com.example.Proyecto_final_bueno.entity.UserMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<UserMongoEntity, String> {


}
