// Función general para cargar datos en una tabla
const url = `${API_BASE_URL}/registrouso`
async function cargarDatosEnTabla(url, tbodyId, procesarFila) {
    const tbody = document.getElementById(tbodyId);

    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error(`Error al obtener datos desde ${url}: ${response.status}`);
        }

        const datos = await response.json();
        tbody.innerHTML = "";

        if (datos.length === 0) {
            tbody.innerHTML = `<tr><td colspan="5" class="text-center">No se encontraron resultados</td></tr>`;
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

// Función para buscar registros de uso
async function buscarRegistrosDeUso() {
    const input = document.querySelector('input[type="text"]').value.trim();
    const url = input
        ? `${API_BASE_URL}/registrouso/buscar?${isNaN(input) ? `usuarioId=${input}` : `reactivoId=${input}`}`
        : API_BASE_URL;

    cargarDatosEnTabla(url, "trazabilidadUsoBody", (registro) => `
        <td>${registro.reactivo.id}</td>
        <td>${registro.reactivo.nombreReactivo}</td>
        <td>${registro.cantidadUtilizada}</td>
        <td>${registro.unidadMedida}</td>
        <td>${registro.usuario ? registro.usuario.nombre : "Desconocido"}</td>
    `);
}

// Función para cargar todos los registros al inicio
async function cargarTodosLosRegistros() {
    cargarDatosEnTabla(API_BASE_URL, "trazabilidadUsoBody", (registro) => `
        <td>${registro.reactivo.id}</td>
        <td>${registro.reactivo.nombreReactivo}</td>
        <td>${registro.cantidadUtilizada}</td>
        <td>${registro.unidadMedida}</td>
        <td>${registro.usuario ? registro.usuario.nombre : "Desconocido"}</td>
    `);
}

// Función para imprimir la tabla
function imprimirTabla() {
    const tabla = document.getElementById("trazabilidadUso").outerHTML;
    const ventana = window.open("", "Imprimir");
    ventana.document.write(`<html><head><title>Imprimir</title></head><body>${tabla}</body></html>`);
    ventana.document.close();
    ventana.print();
}

// Función para descargar la tabla como PDF
function descargarPDF() {
    alert("Funcionalidad para exportar a PDF en desarrollo."); // Aquí puedes integrar una librería como jsPDF
}

// Inicialización de eventos
window.onload = () => {
    document.getElementById("buscarT").addEventListener("click", buscarRegistrosDeUso);
    document.getElementById("print").addEventListener("click", imprimirTabla);
    document.getElementById("pdf").addEventListener("click", descargarPDF);

    cargarTodosLosRegistros(); // Cargar todos los registros al inicio
};
