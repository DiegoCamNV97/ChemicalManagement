// Función general para cargar datos en una tabla
async function cargarDatosEnTabla(url, tbodyId, procesarFila) {
    const tbody = document.getElementById(tbodyId);

    try {
        const response = await fetch(url, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        });

        if (!response.ok) {
            throw new Error(`Error al obtener datos desde ${url}: ${response.status}`);
        }

        const datos = await response.json();
        tbody.innerHTML = "";

        if (datos.length === 0) {
            tbody.innerHTML = `<tr><td colspan="4" class="text-center">No se encontraron resultados</td></tr>`;
            return;
        }

        datos.forEach((dato) => {
            const row = document.createElement("tr");
            row.innerHTML = procesarFila(dato);
            tbody.appendChild(row);
        });
    } catch (error) {
        console.error(`Error al cargar datos desde ${url}:`, error);
        alert("No se pudieron cargar los datos.");
    }
}

// Funciones específicas para alertas
async function cargarReactivosPorVencer() {
    cargarDatosEnTabla(
        `${API_BASE_URL}/reactivo/alertas/por-vencer`,
        "reactivosPorVencerTableBody",
        (reactivo) => `
            <td>${reactivo.id}</td>
            <td>${reactivo.nombreReactivo}</td>
            <td>${reactivo.fabricante?.nombre || "N/A"}</td>
            <td>${reactivo.fechaVencimiento}</td>
        `
    );
}

async function cargarReactivosVencidos() {
    cargarDatosEnTabla(
        `${API_BASE_URL}/reactivo/alertas/vencidos`,
        "reactivosVencidosTableBody",
        (reactivo) => `
            <td>${reactivo.id}</td>
            <td>${reactivo.nombreReactivo}</td>
            <td>${reactivo.fabricante?.nombre || "N/A"}</td>
            <td>${reactivo.fechaVencimiento}</td>
        `
    );
}

async function cargarReactivosPocoStock() {
    cargarDatosEnTabla(
        `${API_BASE_URL}/reactivo/alertas/poco-stock`,
        "reactivosPocoStockTableBody",
        (reactivo) => `
            <td>${reactivo.id}</td>
            <td>${reactivo.nombreReactivo}</td>
            <td>${reactivo.fabricante?.nombre || "N/A"}</td>
            <td>${reactivo.existencia}</td>
        `
    );
}

// Función para agregar eventos a las pestañas
function inicializarEventosAlertas() {
    document.querySelector('[href="#por-vencer"]').addEventListener("click", cargarReactivosPorVencer);
    document.querySelector('[href="#vencidos"]').addEventListener("click", cargarReactivosVencidos);
    document.querySelector('[href="#poco-stock"]').addEventListener("click", cargarReactivosPocoStock);
}

// Inicialización al cargar la página
document.addEventListener("DOMContentLoaded", () => {
    inicializarEventosAlertas();
    cargarReactivosPorVencer(); // Cargar "Por Vencer" por defecto
});
