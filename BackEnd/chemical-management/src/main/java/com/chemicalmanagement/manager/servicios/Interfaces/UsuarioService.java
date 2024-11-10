package com.chemicalmanagement.manager.servicios.Interfaces;

import com.chemicalmanagement.manager.entidades.Usuario;
import java.util.List;

public interface UsuarioService {
    Usuario guardarUsuario(Usuario usuario);
    Usuario actualizarUsuario(Usuario usuario);
    void eliminarUsuario(Long id);
    Usuario obtenerUsuarioPorId(Long id);
    Usuario obtenerUsuarioPorDni(String dni);
    Usuario obtenerUsuarioPorUser(String user);
    Usuario autenticarUsuario(String user, String password);
    List<Usuario> listarUsuarios();
}
