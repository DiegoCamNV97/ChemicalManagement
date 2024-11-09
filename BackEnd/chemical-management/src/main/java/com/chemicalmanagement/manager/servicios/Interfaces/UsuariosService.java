package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.Usuarios;
import java.util.List;
import java.util.Optional;

public interface UsuariosService {
    Optional<Usuarios> buscarPorId(int id);
    Usuarios guardarUsuario(Usuarios usuario);
    void eliminarUsuario(int id);
    List<Usuarios> listarTodos();
    Optional<Usuarios> buscarPorCorreoInstitucional(String correoInstitucional);
    Optional<Usuarios> buscarPorUsuarioYPassword(String usuario, String password); // Nuevo método para autenticación
}
