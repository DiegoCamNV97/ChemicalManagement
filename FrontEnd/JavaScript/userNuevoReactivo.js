document.getElementById("guardarNR").addEventListener("click", function(event) {
    event.preventDefault(); // Evitar que se envíe el formulario inmediatamente

    // Obtener todos los checkboxes de pictogramas
    const pictogramCheckboxes = document.querySelectorAll(".pictogram-checkbox");
    let selectedPictograms = [];

    // Recorrer cada checkbox y verificar si está seleccionado
    pictogramCheckboxes.forEach(checkbox => {
        if (checkbox.checked) {
            selectedPictograms.push(checkbox.value);
        }
    });

    // Unir los valores seleccionados con ";"
    const pictogramsString = selectedPictograms.join(";");

    // Asignar el resultado a un campo oculto o directamente en el campo "pictogramasSGA" del formulario
    document.getElementById("pictogramasSGA").value = pictogramsString;

    // Opcional: Enviar el formulario
    // document.getElementById("formulario").submit();
});
