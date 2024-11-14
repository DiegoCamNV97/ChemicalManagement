package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    // Método para buscar usuarios por tipo de usuario (opcional)
    List<Usuario> findByTipoUsuario(String tipoUsuario);

    // Método para buscar por nombre de usuario
    Optional<Usuario> findByUser(String user);

    // Método para verificar usuario y contraseña (para autenticación)
    Optional<Usuario> findByUserAndPassword(String user, String password);
}
