/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.MRendonTelcelExamenPractico.Repository;

import com.example.MRendonTelcelExamenPractico.JPA.TRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public interface TRoleRepository extends MongoRepository<TRole, String>{
    
}
