document.addEventListener('DOMContentLoaded', () => {
    const idReactivo = new URLSearchParams(window.location.search).get('id');

    if (idReactivo) {
        fetch(`http://localhost:8080/api/reactivo/${idReactivo}`)
            .then(response => response.json())
            .then(reactivo => cargarDatos(reactivo))
            .catch(error => console.error('Error al cargar los datos del reactivo:', error));
    }

    // Prevenir comportamiento predeterminado del formulario
    document.getElementById('guardarCambios').addEventListener('click', (event) => {
        event.preventDefault(); // Evita que se recargue la página
        guardarCambios();
    });

    document.getElementById('cancelarCambios').addEventListener('click', () => {
        window.location.href = 'user.html';
    });
});

function cargarDatos(reactivo) {
    // Nombre y código
    document.getElementById('nombreReactivo').value = reactivo.nombreReactivo;
    document.getElementById('qr').value = reactivo.qr;

    // Ubicación
    document.getElementById('ubicacion').value = reactivo.ubicacion;

    // Fabricante
    fetch('http://localhost:8080/api/fabricante')
        .then(response => response.json())
        .then(fabricantes => {
            const selectFabricante = document.getElementById('fabricante');
            fabricantes.forEach(fabricante => {
                const option = document.createElement('option');
                option.value = fabricante.id;
                option.textContent = fabricante.nombre;
                if (fabricante.id === reactivo.fabricante.id) {
                    option.selected = true;
                }
                selectFabricante.appendChild(option);
            });
        });

    // Presentación
    document.getElementById('presentacion').value = reactivo.presentacion;

    // Unidad de medida
    document.getElementById('unidadMedida').value = reactivo.unidadMedida;

    // Lote
    document.getElementById('lote').value = reactivo.lote;

    // Fechas
    document.getElementById('fechaFabricacion').value = reactivo.fechaFabricacion;
    document.getElementById('fechaVencimiento').value = reactivo.fechaVencimiento;

    // Existencia
    document.getElementById('existencia').value = reactivo.existencia;

    // CAS y Fórmula
    document.getElementById('cas').value = reactivo.cas;
    document.getElementById('formula').value = reactivo.formula;

    // Palabra de advertencia
    document.getElementById('palabraAdvertencia').value = reactivo.palabraAdvertencia;

    // Pictogramas
    const pictogramasSeleccionados = reactivo.pictogramasSGA.split(';'); // String del JSON
    pictogramasSeleccionados.forEach(pictograma => {
        // Busca el checkbox por el valor correspondiente
        const checkbox = document.querySelector(`input[type="checkbox"][value="${pictograma}"]`);
        if (checkbox) {
            checkbox.checked = true; // Marca la casilla
        } else {
            console.warn(`Pictograma no encontrado: ${pictograma}`);
        }
    });

    // Frases H y P
    document.getElementById('frasesH').value = reactivo.frasesH;
    document.getElementById('frasesP').value = reactivo.frasesP;

    // FDS
    if (reactivo.fichaDatosSeguridad === 'Si' || reactivo.fichaDatosSeguridad === 'No') {
        document.getElementById('fichaDatosSeguridad').value = reactivo.fichaDatosSeguridad;
    } else {
        console.error('Valor inesperado en FDS:', reactivo.fichaDatosSeguridad);
    }
    document.getElementById('vigenciaFDS').value = reactivo.vigenciaFDS || '';
}

function guardarCambios() {
    const idReactivo = new URLSearchParams(window.location.search).get('id');

    const reactivo = {
        nombreReactivo: document.getElementById('nombreReactivo').value,
        qr: document.getElementById('qr').value,
        ubicacion: document.getElementById('ubicacion').value,
        fabricante: {
            id: parseInt(document.getElementById('fabricante').value, 10)
        },
        presentacion: parseFloat(document.getElementById('presentacion').value),
        unidadMedida: document.getElementById('unidadMedida').value,
        lote: document.getElementById('lote').value,
        fechaFabricacion: document.getElementById('fechaFabricacion').value,
        fechaVencimiento: document.getElementById('fechaVencimiento').value,
        existencia: parseFloat(document.getElementById('existencia').value),
        cas: document.getElementById('cas').value.toUpperCase(),
        formula: document.getElementById('formula').value.toUpperCase(),
        palabraAdvertencia: document.getElementById('palabraAdvertencia').value,
        pictogramasSGA: Array.from(document.querySelectorAll('input[type="checkbox"]:checked'))
            .map(input => input.value)
            .join(';'),
        frasesH: document.getElementById('frasesH').value,
        frasesP: document.getElementById('frasesP').value,
        fichaDatosSeguridad: document.getElementById('fichaDatosSeguridad').value,
        vigenciaFDS: document.getElementById('vigenciaFDS').value
    };

    fetch(`http://localhost:8080/api/reactivo/${idReactivo}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(reactivo)
    })
        .then(response => {
            if (response.ok) {
                alert('Reactivo actualizado correctamente');
                window.location.href = 'user.html';
            } else {
                return response.text().then(text => {
                    throw new Error(text);
                });
            }
        })
        .catch(error => {
            console.error('Error al guardar los cambios:', error);
            alert('Hubo un error al guardar los cambios. Por favor, inténtelo nuevamente.');
        });
}
