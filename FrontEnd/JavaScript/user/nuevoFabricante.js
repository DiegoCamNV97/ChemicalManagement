async function guardarFabricante() {
    // Obtener los valores de los campos del formulario
    const nombre = document.getElementById("nombreFabricante").value.trim();
    const numContacto = document.getElementById("numContacto").value.trim();
    const direccion = document.getElementById("direccion").value.trim();
    const pais = document.getElementById("pais").value.trim();
    const numeroEmergencia = document.getElementById("numeroEmergencia").value.trim();

    // Validar que no haya campos vacíos
    if (!nombre || !numContacto || !direccion || !pais || !numeroEmergencia) {
        alert("Por favor, complete todos los campos.");
        return;
    }

    // Crear el objeto del nuevo fabricante
    const nuevoFabricante = {
        nombre,
        numContacto,
        direccion,
        pais,
        numeroEmergencia,
    };

    try {
        // Enviar la solicitud POST al servidor
        const response = await fetch(`${API_BASE_URL}/fabricante`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(nuevoFabricante),
        });

        if (response.ok) {
            // Fabricante creado correctamente
            alert("Fabricante registrado con éxito.");
            document.getElementById("formNuevoFabricante").reset();
        } else {
            // Manejar errores de servidor
            const errorData = await response.json();
            alert(`Error al registrar el fabricante: ${errorData.message || "Nombre de Fabricante, Número de Contacto o Dirección duplicados"}`);
        }
    } catch (error) {
        console.error("Error al guardar el fabricante:", error);
        alert("Hubo un error al intentar registrar el fabricante. Por favor, inténtelo nuevamente.");
    }
}

// Asociar el evento de clic al botón de guardar
window.addEventListener("DOMContentLoaded", () => {
    document.getElementById("guardarFabricante").addEventListener("click", guardarFabricante);
});