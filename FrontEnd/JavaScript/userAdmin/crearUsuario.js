// Función para inicializar el formulario
async function inicializarFormularioUsuario() {
    // Aquí podrías cargar dinámicamente opciones para select si las hubiera
    console.log("Formulario de usuario inicializado.");
}

// Función para enviar el formulario
async function enviarFormularioUsuario(event) {
    event.preventDefault();

    const usuarioData = {
        dni: document.getElementById("dni").value.trim(),
        nombres: document.getElementById("nombres").value.trim(),
        apellidos: document.getElementById("apellidos").value.trim(),
        fechaNacimiento: document.getElementById("fechaNacimiento").value.trim(),
        correoPersonal: document.getElementById("correoPersonal").value.trim(),
        correoInstitucional: document.getElementById("correoInstitucional").value.trim(),
        tipoUsuario: document.getElementById("tipoUsuario").value.trim(),
        user: document.getElementById("user").value.trim(),
        password: document.getElementById("password").value.trim(),
    };

    try {
        const response = await fetch(`${API_BASE_URL}/usuario`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(usuarioData),
        });

        if (!response.ok) {
            const error = await response.json();
            alert(`Error al crear el usuario: Posible duplicidad en DNI o Usuario Asignado`);
        } else {
            alert("Usuario creado exitosamente.");
            document.getElementById("crearUsuarioN").reset();
        }
    } catch (error) {
        console.error("Error al enviar el formulario de usuario:", error);
        alert("Error al conectar con el servidor.");
    }
}

// Función para manejar el botón de cancelar
function cancelarFormularioUsuario(event) {
    event.preventDefault();
    const confirmacion = confirm("¿Está seguro de que desea cancelar y borrar los datos del formulario?");
    if (confirmacion) {
        document.getElementById("crearUsuarioN").reset();
        alert ("Formulario limpiado correctamente")
    }
}

// Inicializar
document.addEventListener("DOMContentLoaded", () => {
    inicializarFormularioUsuario();

    // Asociar eventos a los botones
    document.getElementById("guardarUsuarioN").addEventListener("click", enviarFormularioUsuario);
    document.getElementById("cancelarUsuarioN").addEventListener("click", cancelarFormularioUsuario);
});
