package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> obtenerTodos();
    Optional<Usuario> obtenerPorId(Integer id);
    Usuario crear(Usuario usuario);
    Optional<Usuario> actualizar(Integer id, Usuario usuario);
    boolean eliminar(Integer id);
    Optional<Usuario> iniciarSesion(String user, String password); // Método de autenticación
}
