/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.MRendonTelcelExamenPractico.Service;

import com.example.MRendonTelcelExamenPractico.JPA.Result;
import com.example.MRendonTelcelExamenPractico.JPA.TRole;
import com.example.MRendonTelcelExamenPractico.Repository.TRoleRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digis
 */
@Service
public class TRoleService {

    @Autowired
    private TRoleRepository tRoleRepository;

    public Result getAll() {
        Result result = new Result();
        try {
            List<TRole> roles = tRoleRepository.findAll();
            result.objects = new ArrayList<>();
            if (roles.isEmpty()) {
                result.correct = true;
                result.objects.add(roles);
            } else {
                result.correct = true;
                result.objects.add(roles);
            }
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }

    public Result add(TRole role) {
        Result result = new Result();
        try {
            tRoleRepository.save(role);
            result.correct = true;
            result.errorMessage = "Rol insertado correctamente";
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }

    public Result update(TRole role) {
        Result result = new Result();
        try {
            if (tRoleRepository.existsById(role.getId())) {
                tRoleRepository.save(role);
                result.correct = true;
                result.errorMessage = "Rol actualizado correctamente";
            } else {
                result.correct = false;
                result.errorMessage = "Rol no encontrado";
            }
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }

    public Result delete(String id) {
        Result result = new Result();
        try {
            if (tRoleRepository.existsById(id)) {
                tRoleRepository.deleteById(id);
                result.correct = true;
                result.errorMessage = "Rol eliminado correctamente";
            } else {
                result.correct = false;
                result.errorMessage = "Rol no encontrado";
            }
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }

    public Result getById(String id) {
        Result result = new Result();
        try {
            TRole role = tRoleRepository.findById(id).orElse(null);
            if (role != null) {
                result.correct = true;
                result.object = role;
            } else {
                result.correct = false;
                result.errorMessage = "Rol no encontrado";
            }
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }
}
