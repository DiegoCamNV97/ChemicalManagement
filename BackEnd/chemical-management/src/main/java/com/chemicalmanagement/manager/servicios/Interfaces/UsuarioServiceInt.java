package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioServiceInt {
    List<Usuario> obtenerTodosLosUsuarios();
    Optional<Usuario> obtenerUsuarioPorId(Long id);
    Usuario guardarUsuario(Usuario usuario);
    Usuario actualizarUsuario(Long id, Usuario usuarioActualizado);
    void eliminarUsuario(Long id);
}
