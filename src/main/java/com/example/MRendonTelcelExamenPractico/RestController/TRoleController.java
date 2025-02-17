/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.MRendonTelcelExamenPractico.RestController;

import com.example.MRendonTelcelExamenPractico.JPA.Result;
import com.example.MRendonTelcelExamenPractico.JPA.TRole;
import com.example.MRendonTelcelExamenPractico.Service.TRoleService;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/roles")
public class TRoleController {

    @Autowired
    private TRoleService tRoleService;

    @GetMapping
    public ResponseEntity<?> getAllRoles() {
        Result result = tRoleService.getAll();
        if (result.correct) {
            return ResponseEntity.ok(result.objects);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> addRole(@RequestBody TRole role) {
        Result result = tRoleService.add(role);
        
        if (result.correct) {
            return ResponseEntity.ok(result.errorMessage);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.errorMessage);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRole(@PathVariable String id, @RequestBody TRole role) {
        role.setId(id);
        Result result = tRoleService.update(role); 
        
        if (result.correct) {
            return ResponseEntity.ok(result.errorMessage); 
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.errorMessage); 
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable String id) {
        Result result = tRoleService.delete(id);  
        
        if (result.correct) {
            return ResponseEntity.ok(result.errorMessage);  
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.errorMessage);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable String id) {
        Result result = tRoleService.getById(id);
        if (result.correct) {
            return ResponseEntity.ok(result.object);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.errorMessage);
        }
    }
}
