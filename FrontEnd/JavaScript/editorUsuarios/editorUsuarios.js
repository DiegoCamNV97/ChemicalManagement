document.addEventListener("DOMContentLoaded", () => {
    const params = new URLSearchParams(window.location.search);
    const userId = params.get("id");

    if (userId) {
        cargarUsuario(userId);
    }

    // Evita la recarga del formulario al hacer clic en los botones
    document.getElementById("guardarUsuario").addEventListener("click", (event) => {
        event.preventDefault(); // Prevenir comportamiento por defecto
        guardarUsuario(userId);
    });

    document.getElementById("cancelarEdicionU").addEventListener("click", cancelarEdicion);
});

// Función para cargar los datos del usuario
async function cargarUsuario(userId) {
    try {
        const response = await fetch(`${API_BASE_URL}/usuario/${userId}`);
        if (!response.ok) {
            throw new Error(`Error al obtener los datos del usuario. Código: ${response.status}`);
        }

        const usuario = await response.json();

        document.getElementById("dni").value = usuario.dni || "";
        document.getElementById("nombres").value = usuario.nombres || "";
        document.getElementById("apellidos").value = usuario.apellidos || "";
        document.getElementById("fechaNacimiento").value = formatFechaISO(usuario.fechaNacimiento) || "";
        document.getElementById("email").value = usuario.correoPersonal || "";
        document.getElementById("correoInstitucional").value = usuario.correoInstitucional || "";
        document.getElementById("tipoUsuario").value = usuario.tipoUsuario || "";
        document.getElementById("user").value = usuario.user || "";
        document.getElementById("password").value = usuario.password || "";
    } catch (error) {
        console.error("Error al cargar los datos del usuario:", error);
        alert("No se pudieron cargar los datos del usuario.");
        window.location.href = "userAdmin.html";
    }
}

// Función para guardar los datos del usuario actualizado
async function guardarUsuario(userId) {
    const usuario = {
        dni: document.getElementById("dni").value.trim(),
        nombres: document.getElementById("nombres").value.trim(),
        apellidos: document.getElementById("apellidos").value.trim(),
        fechaNacimiento: document.getElementById("fechaNacimiento").value.trim(),
        correoPersonal: document.getElementById("email").value.trim(),
        correoInstitucional: document.getElementById("correoInstitucional").value.trim(),
        tipoUsuario: document.getElementById("tipoUsuario").value.trim(),
        user: document.getElementById("user").value.trim(),
        password: document.getElementById("password").value.trim(),
    };

    try {
        const response = await fetch(`${API_BASE_URL}/usuario/${userId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(usuario),
        });

        if (response.ok) {
            alert("Usuario actualizado correctamente.");
            window.location.href = "userAdmin.html";
        } else {
            throw new Error(`Error al actualizar el usuario. Código: ${response.status}`);
        }
    } catch (error) {
        console.error("Error al actualizar el usuario:", error);
        alert("No se pudo actualizar el usuario. Revisa los datos e intenta nuevamente.");
    }
}

// Función para manejar la cancelación de la edición
function cancelarEdicion() {
    const confirmar = confirm("¿Estás seguro de que deseas cancelar? Los cambios no se guardarán.");
    if (confirmar) {
        window.location.href = "userAdmin.html";
    }
}

// Función para formatear la fecha a formato ISO (yyyy-MM-dd) para el input
function formatFechaISO(fecha) {
    if (!fecha) return "";
    const date = new Date(fecha);
    return date.toISOString().split("T")[0]; // Devuelve "yyyy-MM-dd"
}
