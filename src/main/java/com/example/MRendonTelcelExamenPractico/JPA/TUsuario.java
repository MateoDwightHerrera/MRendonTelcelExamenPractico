/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.MRendonTelcelExamenPractico.JPA;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author digis
 */
@Document(collection = "TUSUARIO")
public class TUsuario {

    @Id
    private String id;
    private String nombre;
    private String a_Paterno;
    private String a_Materno;

    @DBRef
    public List<TRole> id_TROLES;

    public TUsuario() {
    }

    public TUsuario(String id, String nombre, String a_Paterno, String a_Materno) {
        this.id = id;
        this.nombre = nombre;
        this.a_Paterno = a_Paterno;
        this.a_Materno = a_Materno;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setA_Paterno(String a_Paterno) {
        this.a_Paterno = a_Paterno;
    }

    public String getA_Paterno() {
        return a_Paterno;
    }

    public void setA_Materno(String a_Materno) {
        this.a_Materno = a_Materno;
    }

    public String getA_Materno() {
        return a_Materno;
    }
}
