async function buscarReactivos() {
    const input = document.getElementById("buscarReactivo").value.trim();
    const tbody = document.getElementById("reactivosTableBody");

    try {
        let url = `${API_BASE_URL}/reactivo`;
        if (input) {
            const tipoBusqueda = input.match(/^\d{2,7}-\d{2}-\d$/) ? "cas" : "nombre";
            url += `/buscar/${tipoBusqueda}?${tipoBusqueda}=${encodeURIComponent(input)}`;
        }

        console.log("Buscando con URL:", url);

        const response = await fetch(url);
        if (!response.ok) {
            throw new Error("Error al obtener los datos de los reactivos");
        }

        const reactivos = await response.json();

        tbody.innerHTML = "";

        if (reactivos.length === 0) {
            tbody.innerHTML = `<tr><td colspan="18" class="text-center">No se encontraron resultados</td></tr>`;
            return;
        }

        reactivos.forEach((reactivo) => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${reactivo.id || ""}</td>
                <td>${reactivo.qr || ""}</td
                <td>${reactivo.nombreReactivo || ""}</td>
                <td>${reactivo.cas || ""}</td>
                <td>
                    <button class="btn btn-success btn-fabricante" data-id="${reactivo.fabricante?.id || ""}">
                        ${reactivo.fabricante?.nombre || "Sin Fabricante"}
                    </button>
                </td>
                <td>${reactivo.presentacion || ""}</td>
                <td>${reactivo.unidadMedida || ""}</td>
                <td>${reactivo.lote || ""}</td>
                <td>${reactivo.fechaFabricacion || ""}</td>
                <td>${reactivo.fechaVencimiento || ""}</td>
                <td>${reactivo.existencia || ""}</td>
                <td>${reactivo.formula || ""}</td>
                <td>${reactivo.palabraAdvertencia || ""}</td>
                <td>${reactivo.pictogramasSGA || ""}</td>
                <td>${reactivo.frasesH || ""}</td>
                <td>${reactivo.frasesP || ""}</td>
                <td>${reactivo.fichaDatosSeguridad || ""}</td>
                <td>${reactivo.vigenciaFDS || ""}</td>
                <td>
                    <button class="btn btn-success btn-editarR" data-id="${reactivo.id}">Editar</button>
                    <button class="btn btn-danger btn-eliminar" data-id="${reactivo.id}">Eliminar</button>
                    <button class="btn btn-secondary btn-regUso" data-id="${reactivo.id}">Registrar Uso</button>
                </td>
            `;
            tbody.appendChild(row);
        });

        agregarEventosBotones();
    } catch (error) {
        console.error("Error durante la búsqueda:", error);
        alert("No se pudieron cargar los reactivos.");
    }
}

function agregarEventosBotones() {
    document.querySelectorAll(".btn-fabricante").forEach((button) => {
        button.addEventListener("click", async (event) => {
            const fabricanteId = event.target.dataset.id;
            if (!fabricanteId) {
                alert("No se encontró información del fabricante.");
                return;
            }
            try {
                const response = await fetch(`${API_BASE_URL}/fabricante/${fabricanteId}`);
                if (!response.ok) {
                    throw new Error("Error al obtener la información del fabricante");
                }

                const fabricante = await response.json();
                alert(
                    `Información del Fabricante:\n\n` +
                    `Nombre: ${fabricante.nombre}\n` +
                    `Número de Contacto: ${fabricante.numContacto}\n` +
                    `Dirección: ${fabricante.direccion}\n` +
                    `País: ${fabricante.pais}\n` +
                    `Número de Emergencia: ${fabricante.numeroEmergencia}`
                );
            } catch (error) {
                console.error("Error al obtener el fabricante:", error);
                alert("No se pudo obtener la información del fabricante.");
            }
        });
    });

    document.querySelectorAll(".btn-regUso").forEach((button) => {
        button.addEventListener("click", (event) => {
            const id = event.target.dataset.id;
            window.location.href = `registroUso.html?id=${id}`;
        });
    });
    document.querySelectorAll(".btn-editarR").forEach((button) => {
        button.addEventListener("click", (event) => {
            const id = event.target.dataset.id;
            window.location.href = `editorReactivos.html?id=${id}`;
        });
    });
    document.querySelectorAll(".btn-eliminar").forEach((button) => {
        button.addEventListener("click", async (event) => {
            const id = event.target.dataset.id;
            const confirmar = confirm("¿Estás seguro de que deseas eliminar este reactivo?");
            if (confirmar) {
                try {
                    const response = await fetch(`${API_BASE_URL}/reactivo/${id}`, {
                        method: "DELETE",
                    });
                    if (response.ok) {
                        alert("Reactivo eliminado correctamente.");
                        buscarReactivos();
                    } else {
                        alert("Error al eliminar el reactivo.");
                    }
                } catch (error) {
                    console.error("Error al eliminar:", error);
                    alert("No se pudo eliminar el reactivo.");
                }
            }
        });
    });
}

document.getElementById("buscarReactivobtn").addEventListener("click", buscarReactivos);
document.addEventListener("DOMContentLoaded", buscarReactivos);
