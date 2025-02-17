/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.MRendonTelcelExamenPractico.Repository;

import com.example.MRendonTelcelExamenPractico.JPA.TUsuario;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public interface TUsuarioRepository extends MongoRepository<TUsuario, String> {

    List<TUsuario> findByNombre(String Nombre);
}
