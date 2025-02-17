/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.MRendonTelcelExamenPractico.Configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

/**
 *
 * @author digis
 */
@Configuration
public class DataSourceConfig {

    @Bean
    public MongoTemplate mongoTemplate() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(mongoClient, "UsuariosRoles"));
    }
}
