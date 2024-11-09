document.addEventListener("DOMContentLoaded", function() {
    cargarReactivos(); // Cargar todos los reactivos al inicio
  
    document.getElementById("buscar").addEventListener("click", function() {
      const searchValue = document.getElementById("searchInput").value.toLowerCase();
      buscarReactivos(searchValue);
    });
  });
  
  function cargarReactivos() {
    fetch("http://localhost:8080/api/reactivos")
      .then(response => response.json())
      .then(data => mostrarReactivosEnTabla(data))
      .catch(error => console.error("Error al cargar los reactivos:", error));
  }
  
  function buscarReactivos(valor) {
    fetch(`http://localhost:8080/api/reactivos/buscar?valor=${valor}`) // Ajusta la URL según tu API
      .then(response => response.json())
      .then(data => mostrarReactivosEnTabla(data))
      .catch(error => console.error("Error en la búsqueda de reactivos:", error));
  }
  
  function mostrarReactivosEnTabla(reactivos) {
    const tbody = document.getElementById("reactivosTableBody");
    tbody.innerHTML = ""; // Limpiar la tabla
  
    reactivos.forEach(reactivo => {
      const row = document.createElement("tr");
      row.innerHTML = `
        <td>${reactivo.id}</td>
        <td>${reactivo.nombreReactivo}</td>
        <td>${reactivo.cas}</td>
        <td>${reactivo.ubicacion}</td>
        <td>${reactivo.unidadMedida}</td>
        <td>${reactivo.presentacion}</td>
        <td>${reactivo.lote}</td>
        <td>${reactivo.palabraAdvertencia}</td>
        <td>${reactivo.pictogramasSGA}</td>
        <td>${reactivo.frasesH}</td>
        <td>${reactivo.frasesP}</td>
        <td>${reactivo.fechaFabricacion}</td>
        <td>${reactivo.fechaVencimiento}</td>
        <td>${reactivo.distribuidor}</td>
        <td>
          <button class="btn btn-primary m-1" onclick="editarReactivo(${reactivo.id})">Editar</button>
          <button class="btn btn-danger m-1" onclick="eliminarReactivo(${reactivo.id})">Eliminar</button>
        </td>
      `;
      tbody.appendChild(row);
    });
  }
  
  function editarReactivo(id) {
    window.location.href = `editorReactivos.html?id=${id}`;
  }
  
  function eliminarReactivo(id) {
    if (confirm("¿Estás seguro de que deseas eliminar este reactivo?")) {
      fetch(`http://localhost:8080/api/reactivos/${id}`, {
        method: "DELETE"
      })
      .then(response => {
        if (response.ok) {
          alert("Reactivo eliminado con éxito");
          cargarReactivos(); // Recargar la lista completa
        } else {
          alert("Error al eliminar el reactivo");
        }
      })
      .catch(error => console.error("Error al eliminar el reactivo:", error));
    }
  }
  