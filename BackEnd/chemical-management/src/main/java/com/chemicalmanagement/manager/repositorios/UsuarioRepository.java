package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método personalizado para buscar un usuario por correo electrónico
    Optional<Usuario> findByEmail(String email);
}
