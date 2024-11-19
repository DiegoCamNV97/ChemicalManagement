// Obtener el nombre del usuario
fetch('/api/usuario/info')
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error("No hay usuario autenticado");
        }
    })
    .then(usuario => {
        document.getElementById('nombreUsuario').textContent = usuario.nombre;
    })
    .catch(error => {
        console.error(error);
        // Redirige al login si no hay sesión
        window.location.href = 'login.html';
    });

// Cerrar sesión
document.getElementById('btnCerrarSesion').addEventListener('click', () => {
    fetch('/api/usuario/logout', {
        method: 'POST',
    }).then(() => {
        window.location.href = 'login.html';
    });
});
