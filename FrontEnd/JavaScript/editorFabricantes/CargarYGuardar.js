document.addEventListener('DOMContentLoaded', () => {
    const idFabricante = new URLSearchParams(window.location.search).get('id');

    if (idFabricante) {
        // Si existe un ID en la URL, cargar los datos del fabricante
        fetch(`http://localhost:8080/api/fabricante/${idFabricante}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al cargar los datos del fabricante');
                }
                return response.json();
            })
            .then(fabricante => precargarFormulario(fabricante))
            .catch(error => console.error('Error al cargar el fabricante:', error));
    }

    // Guardar cambios en el fabricante
    document.getElementById('btnGuardarF').addEventListener('click', (event) => {
        event.preventDefault(); // Previene el comportamiento por defecto del formulario

        const fabricante = obtenerDatosFormulario();

        if (idFabricante) {
            // Actualiza un fabricante existente
            fetch(`http://localhost:8080/api/fabricante/${idFabricante}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(fabricante),
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Error al guardar los cambios');
                    }
                    return response.json();
                })
                .then(() => {
                    alert('Fabricante actualizado exitosamente');
                    window.location.href = 'user.html'; // Redirige después de guardar
                })
                .catch(error => {
                    console.error('Error al guardar el fabricante:', error);
                    alert('Error al guardar los cambios. Intente nuevamente.');
                });
        } else {
            // Crea un nuevo fabricante
            fetch(`http://localhost:8080/api/fabricante`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(fabricante),
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Error al crear el fabricante');
                    }
                    return response.json();
                })
                .then(() => {
                    alert('Fabricante creado exitosamente');
                    window.location.href = 'user.html'; // Redirige después de guardar
                })
                .catch(error => {
                    console.error('Error al crear el fabricante:', error);
                    alert('Error al crear el fabricante. Intente nuevamente.');
                });
        }
    });

    // Cancelar y redirigir al administrador
    document.getElementById('btnCancelarF').addEventListener('click', (event) => {
        event.preventDefault();
        window.location.href = 'user.html'; // Redirige al listado de fabricantes
    });
});

// Función para precargar los datos en el formulario
function precargarFormulario(fabricante) {
    document.getElementById('nombreEmpresa').value = fabricante.nombre || '';
    document.getElementById('numContacto').value = fabricante.numContacto || '';
    document.getElementById('direccion').value = fabricante.direccion || '';
    document.getElementById('pais').value = fabricante.pais || '';
    document.getElementById('numEmergencia').value = fabricante.numeroEmergencia || '';
}

// Función para obtener los datos del formulario
function obtenerDatosFormulario() {
    return {
        nombre: document.getElementById('nombreEmpresa').value,
        numContacto: document.getElementById('numContacto').value,
        direccion: document.getElementById('direccion').value,
        pais: document.getElementById('pais').value,
        numeroEmergencia: document.getElementById('numEmergencia').value,
    };
}
