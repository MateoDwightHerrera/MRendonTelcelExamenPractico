/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.MRendonTelcelExamenPractico.RestController;

import com.example.MRendonTelcelExamenPractico.JPA.Result;
import com.example.MRendonTelcelExamenPractico.JPA.TUsuario;
import com.example.MRendonTelcelExamenPractico.Service.TUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/usuarios")
public class TUsuarioController {

    @Autowired
    private TUsuarioService tUsuarioService;

    @GetMapping
    public ResponseEntity<?> getAllUsuarios() {
        Result result = tUsuarioService.getAll();
        if (result.correct) {
            return ResponseEntity.ok(result.objects);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<?> addUsuario(@RequestBody TUsuario usuario) {
        Result result = tUsuarioService.add(usuario);
        if (result.correct) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result.errorMessage);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.errorMessage);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable String id, @RequestBody TUsuario usuario) {
        usuario.setId(id);
        Result result = tUsuarioService.update(usuario);
        if (result.correct) {
            return ResponseEntity.ok(result.errorMessage);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.errorMessage);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable String id) {
        Result result = tUsuarioService.delete(id);
        if (result.correct) {
            return ResponseEntity.ok(result.errorMessage);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.errorMessage);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable String id) {
        Result result = tUsuarioService.getById(id);
        if (result.correct) {
            return ResponseEntity.ok(result.objects);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.errorMessage);
        }
    }

    @GetMapping("/GetByNombre/{Nombre}")
    public ResponseEntity<?> getUsuarioByNombre(@PathVariable String Nombre) {
        Result result = tUsuarioService.getByName(Nombre);
        if (result.correct) {
            return ResponseEntity.ok(result.objects);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.errorMessage);
        }
    }

    @GetMapping("/GetByRol/{roleId}")
    public ResponseEntity<?> getUsuariosByRole(@PathVariable String roleId) {
        Result result = tUsuarioService.getByRole(roleId);
        if (result.correct) {
            return ResponseEntity.ok(result.objects);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.errorMessage);
        }
    }

}
