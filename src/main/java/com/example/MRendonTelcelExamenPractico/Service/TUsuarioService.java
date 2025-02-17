package com.example.MRendonTelcelExamenPractico.Service;

import com.example.MRendonTelcelExamenPractico.JPA.Result;
import com.example.MRendonTelcelExamenPractico.JPA.TUsuario;
import com.example.MRendonTelcelExamenPractico.JPA.TRole;
import com.example.MRendonTelcelExamenPractico.Repository.TUsuarioRepository;
import com.example.MRendonTelcelExamenPractico.Repository.TRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TUsuarioService {

    @Autowired
    private TUsuarioRepository tUsuarioRepository;

    @Autowired
    private TRoleRepository tRoleRepository;

    public Result getAll() {
        Result result = new Result();
        try {
            List<TUsuario> usuarios = tUsuarioRepository.findAll();
            if (!usuarios.isEmpty()) {
                result.objects = new ArrayList<>();
                for (TUsuario usuario : usuarios) {
                    List<TRole> roles = new ArrayList<>();
                    for (TRole role : usuario.id_TROLES) {
                        roles.add(role);
                    }
                    usuario.id_TROLES = roles;
                    result.objects.add(usuario);
                }
                result.correct = true;
            } else {
                result.correct = false;
                result.errorMessage = "No se encontraron usuarios.";
            }
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }

    public Result add(TUsuario usuario) {
        Result result = new Result();
        try {
            tUsuarioRepository.save(usuario);
            result.correct = true;
            result.errorMessage = "Usuario insertado correctamente";
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }

    public Result update(TUsuario usuario) {
        Result result = new Result();
        try {
            if (tUsuarioRepository.existsById(usuario.getId())) {
                tUsuarioRepository.save(usuario);
                result.correct = true;
                result.errorMessage = "Usuario actualizado correctamente";
            } else {
                result.correct = false;
                result.errorMessage = "Usuario no encontrado";
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
            if (tUsuarioRepository.existsById(id)) {
                tUsuarioRepository.deleteById(id);
                result.correct = true;
                result.errorMessage = "Usuario eliminado correctamente";
            } else {
                result.correct = false;
                result.errorMessage = "Usuario no encontrado";
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
            TUsuario usuario = tUsuarioRepository.findById(id).orElse(null);
            if (usuario != null) {
                result.objects = new ArrayList<>();
                List<TRole> roles = new ArrayList<>();
                for (TRole role : usuario.id_TROLES) {
                    roles.add(role);
                }
                usuario.id_TROLES = roles;
                result.objects.add(usuario);
                result.correct = true;
            } else {
                result.correct = false;
                result.errorMessage = "Usuario no encontrado.";
            }
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }

    public Result getByName(String Nombre) {
        Result result = new Result();
        try {
            List<TUsuario> usuarios = tUsuarioRepository.findByNombre(Nombre);
            if (!usuarios.isEmpty()) {
                result.objects = new ArrayList<>();
                for (TUsuario usuario : usuarios) {
                    List<TRole> roles = new ArrayList<>();
                    for (TRole role : usuario.id_TROLES) {
                        roles.add(role);
                    }
                    usuario.id_TROLES = roles;
                    result.objects.add(usuario);
                }
                result.correct = true;
            } else {
                result.correct = false;
                result.errorMessage = "No se encontraron usuarios con ese nombre.";
            }
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }

    public Result getByRole(String roleId) {
        Result result = new Result();
        try {
            List<TUsuario> usuarios = tUsuarioRepository.findAll();
            if (!usuarios.isEmpty()) {
                result.objects = new ArrayList<>();
                for (TUsuario usuario : usuarios) {
                    for (TRole role : usuario.id_TROLES) {
                        if (role.getId().equals(roleId)) {
                            result.objects.add(usuario);
                        }
                    }
                }
                if (!result.objects.isEmpty()) {
                    result.correct = true;
                } else {
                    result.correct = false;
                    result.errorMessage = "No se encontraron usuarios con el rol proporcionado.";
                }
            } else {
                result.correct = false;
                result.errorMessage = "No se encontraron usuarios.";
            }
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }
}
