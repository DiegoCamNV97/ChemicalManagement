package com.chemicalmanagement.manager.repositorios;

import com.chemicalmanagement.manager.entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

    // Consulta personalizada para buscar usuario por nombre de usuario
    Optional<Usuarios> findByUsuario(String usuario);

    // Consulta personalizada para buscar usuarios por tipo de usuario
    List<Usuarios> findByTipoUsuario(String tipoUsuario);

    // Consulta personalizada para buscar usuario por correo institucional
    Optional<Usuarios> findByCorreoInstitucional(String correoInstitucional);

    // Consulta personalizada para buscar usuarios por nombre o apellido (similar a búsqueda parcial)
    List<Usuarios> findByNombresContainingIgnoreCaseOrApellidosContainingIgnoreCase(String nombres, String apellidos);

    // Nuevo método para autenticación
    Optional<Usuarios> findByUsuarioAndPassword(String usuario, String password); 
}
