async function login() {
    const usuario = document.getElementById('usuario').value;
    const password = document.getElementById('password').value;

    const response = await fetch('http://localhost:8080/api/usuarios/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ usuario, password })
    });

    if (response.ok) {
        const tipoUsuario = await response.text();

        // Redirige según el tipo de usuario
        if (tipoUsuario === 'ADMINISTRADOR') {
            window.location.href = 'userAdmin.html';
        } else if (tipoUsuario === 'USUARIO') {
            window.location.href = 'user.html';
        }
    } else {
        alert('Credenciales incorrectas');
    }
}
