package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método para buscar por DNI
    Usuario findByDni(String dni);

    // Método para buscar por nombre de usuario
    Usuario findByUser(String user);

    // Método para autenticación (inicio de sesión)
    Usuario findByUserAndPassword(String user, String password);
}
