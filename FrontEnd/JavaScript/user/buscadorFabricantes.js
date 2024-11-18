async function buscarFabricantes() {
    const input = document.getElementById("buscarFabricante").value.trim();
    const tbody = document.getElementById("fabricantesTableBody");

    try {
        let url = `${API_BASE_URL}/fabricante`;
        if (input) {
            url += `/buscar?nombre=${encodeURIComponent(input)}`;
        }

        console.log("Buscando fabricantes con URL:", url);

        const response = await fetch(url);
        if (!response.ok) {
            throw new Error("Error al obtener los datos de los fabricantes");
        }

        const fabricantes = await response.json();

        tbody.innerHTML = "";

        if (fabricantes.length === 0) {
            tbody.innerHTML = `<tr><td colspan="7" class="text-center">No se encontraron resultados</td></tr>`;
            return;
        }

        fabricantes.forEach((fabricante) => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${fabricante.id || ""}</td>
                <td>${fabricante.nombre || ""}</td>
                <td>${fabricante.numContacto || ""}</td>
                <td>${fabricante.direccion || ""}</td>
                <td>${fabricante.pais || ""}</td>
                <td>${fabricante.numeroEmergencia || ""}</td>
                <td>
                    <button class="btn btn-warning btn-editar" data-id="${fabricante.id}">Editar</button>
                    <button class="btn btn-danger btn-eliminar" data-id="${fabricante.id}">Eliminar</button>
                </td>
            `;
            tbody.appendChild(row);
        });

        agregarEventosBotonesFabricante();
    } catch (error) {
        console.error("Error durante la búsqueda de fabricantes:", error);
        alert("No se pudieron cargar los fabricantes.");
    }
}

function agregarEventosBotonesFabricante() {
    document.querySelectorAll(".btn-editar").forEach((button) => {
        button.addEventListener("click", (event) => {
            const id = event.target.dataset.id;
            window.location.href = `editorFabricante.html?id=${id}`;
        });
    });

    document.querySelectorAll(".btn-eliminar").forEach((button) => {
        button.addEventListener("click", async (event) => {
            const id = event.target.dataset.id;
            const confirmar = confirm("¿Estás seguro de que deseas eliminar este fabricante?");
            if (confirmar) {
                try {
                    const response = await fetch(`${API_BASE_URL}/fabricante/${id}`, {
                        method: "DELETE",
                    });
                    if (response.ok) {
                        alert("Fabricante eliminado correctamente.");
                        buscarFabricantes();
                    } else {
                        alert("Error al eliminar el fabricante.");
                    }
                } catch (error) {
                    console.error("Error al eliminar el fabricante:", error);
                    alert("No se pudo eliminar el fabricante.");
                }
            }
        });
    });
}

document.getElementById("buscarFabricantebtn").addEventListener("click", buscarFabricantes);
document.addEventListener("DOMContentLoaded", buscarFabricantes);