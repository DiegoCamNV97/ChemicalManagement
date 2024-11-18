// Función para cargar fabricantes dinámicamente
async function cargarFabricantes() {
    const fabricanteSelect = document.getElementById("fabricante");
    try {
        const response = await fetch(`${API_BASE_URL}/fabricante`);
        if (!response.ok) {
            throw new Error("Error al cargar fabricantes");
        }
        const fabricantes = await response.json();
        fabricantes.forEach((fabricante) => {
            const option = document.createElement("option");
            option.value = fabricante.id;
            option.textContent = fabricante.nombre;
            fabricanteSelect.appendChild(option);
        });
    } catch (error) {
        console.error("Error al cargar fabricantes:", error);
        alert("No se pudieron cargar los fabricantes disponibles.");
    }
}

// Enviar formulario
document.getElementById("guardarNR").addEventListener("click", async (event) => {
    event.preventDefault();
    const qr = document.getElementById("qr").value.trim();

    const reactivoData = {
        qr, // Agregar el valor del QR
        ubicacion: document.getElementById("ubicacion").value,
        nombreReactivo: document.getElementById("nombreReactivo").value,
        presentacion: document.getElementById("presentacion").value,
        unidadMedida: document.getElementById("unidadMedida").value,
        lote: document.getElementById("lote").value,
        fechaFabricacion: document.getElementById("fechaFabricacion").value,
        fechaVencimiento: document.getElementById("fechaVencimiento").value,
        existencia: document.getElementById("existencia").value,
        cas: document.getElementById("cas").value,
        formula: document.getElementById("formula").value,
        palabraAdvertencia: document.getElementById("palabraAdvertencia").value,
        pictogramasSGA: Array.from(document.querySelectorAll(".form-check-input:checked"))
            .map((checkbox) => checkbox.value)
            .join(";"),
        frasesH: document.getElementById("frasesH").value,
        frasesP: document.getElementById("frasesP").value,
        fichaDatosSeguridad: document.getElementById("fichaDatosSeguridad").value,
        vigenciaFDS: document.getElementById("vigenciaFDS").value,
        fabricante: { id: document.getElementById("fabricante").value }
    };

    try {
        const response = await fetch(`${API_BASE_URL}/reactivo`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(reactivoData),
        });

        if (!response.ok) {
            const error = await response.json();
            alert(`Error al crear el reactivo: ${error.message || error}`);
        } else {
            alert("Reactivo creado exitosamente");
        }
    } catch (error) {
        console.error("Error al crear el reactivo:", error);
    }
});
// Inicializar
document.addEventListener("DOMContentLoaded", () => {
    cargarFabricantes();
});
