function formatFecha(fecha) {
    if (!fecha) return "";
    const date = new Date(fecha);
    const dia = String(date.getDate()).padStart(2, "0");
    const mes = String(date.getMonth() + 1).padStart(2, "0"); // Los meses empiezan desde 0
    const anio = date.getFullYear();
    return `${dia}/${mes}/${anio}`;
}

async function cargarTodosLosUsuarios() {
    const tbody = document.querySelector("#userTableBody");

    try {
        const response = await fetch(`${API_BASE_URL}/usuario`);
        if (!response.ok) {
            throw new Error(`Error al obtener los datos de los usuarios. Status: ${response.status}`);
        }

        const usuarios = await response.json();
        console.log("Usuarios obtenidos:", usuarios);

        tbody.innerHTML = "";

        if (usuarios.length === 0) {
            tbody.innerHTML = `<tr><td colspan="11" class="text-center">No hay usuarios registrados</td></tr>`;
            return;
        }

        actualizarTablaUsuarios(usuarios);
    } catch (error) {
        console.error("Error al cargar los usuarios:", error);
        alert(`No se pudieron cargar los usuarios: ${error.message}`);
    }
}

function actualizarTablaUsuarios(usuarios) {
    const tbody = document.querySelector("#userTableBody");
    tbody.innerHTML = "";

    usuarios.forEach((usuario) => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${usuario.id || ""}</td>
            <td>${usuario.dni || ""}</td>
            <td>${usuario.nombres || ""}</td>
            <td>${usuario.apellidos || ""}</td>
            <td>${formatFecha(usuario.fechaNacimiento) || ""}</td>
            <td>${usuario.correoPersonal || ""}</td>
            <td>${usuario.correoInstitucional || ""}</td>
            <td>${usuario.tipoUsuario || ""}</td>
            <td>${usuario.user || ""}</td>
            <td>${usuario.password || ""}</td>
            <td>
                <button class="btn btn-warning btn-editar" data-id="${usuario.id}">Editar</button>
                <button class="btn btn-danger btn-eliminar" data-id="${usuario.id}">Eliminar</button>
            </td>
        `;
        tbody.appendChild(row);
    });

    agregarEventosBotonesUsuario();
}

function agregarEventosBotonesUsuario() {
    document.querySelectorAll(".btn-editar").forEach((button) => {
        button.addEventListener("click", (event) => {
            const id = event.target.dataset.id;
            window.location.href = `editorUsuarios.html?id=${id}`;
        });
    });

    document.querySelectorAll(".btn-eliminar").forEach((button) => {
        button.addEventListener("click", async (event) => {
            const id = event.target.dataset.id;
            const confirmar = confirm("¿Estás seguro de que deseas eliminar este usuario?");
            if (confirmar) {
                try {
                    const response = await fetch(`${API_BASE_URL}/usuario/${id}`, {
                        method: "DELETE",
                    });
                    if (response.ok) {
                        alert("Usuario eliminado correctamente.");
                        cargarTodosLosUsuarios();
                    } else {
                        alert("Error al eliminar el usuario.");
                    }
                } catch (error) {
                    console.error("Error al eliminar el usuario:", error);
                    alert("No se pudo eliminar el usuario.");
                }
            }
        });
    });
}

async function buscarUsuarios() {
    const searchInput = document.querySelector("#searchImput").value.trim();
    const tbody = document.querySelector("#userTableBody");

    if (!searchInput) {
        // Si no hay búsqueda, carga todos los usuarios
        await cargarTodosLosUsuarios();
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/usuario/buscar`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ query: searchInput }),
        });

        if (!response.ok) {
            throw new Error(`Error al buscar usuarios. Status: ${response.status}`);
        }

        const usuarios = await response.json();
        console.log("Resultados de búsqueda:", usuarios);

        if (usuarios.length === 0) {
            tbody.innerHTML = `<tr><td colspan="11" class="text-center">No se encontraron usuarios</td></tr>`;
            return;
        }

        actualizarTablaUsuarios(usuarios);
    } catch (error) {
        console.error("Error al buscar usuarios:", error);
        alert(`No se pudo realizar la búsqueda: ${error.message}`);
    }
}

document.addEventListener("DOMContentLoaded", () => {
    cargarTodosLosUsuarios();

    const buscarButton = document.querySelector("#buscarUser");
    buscarButton.addEventListener("click", buscarUsuarios);
});
