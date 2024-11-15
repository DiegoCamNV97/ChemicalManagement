document.getElementById("btnLogin").addEventListener("click", async function () {
  const usuario = document.getElementById("usuario").value;
  const password = document.getElementById("password").value;
  console.log(JSON.stringify({ user: usuario, password: password }));

  try {
      const response = await fetch("http://localhost:8080/api/usuario/login", {
          method: "POST",
          headers: {
              "Content-Type": "application/json"
          },
          body: JSON.stringify({ user: usuario, password: password }) // Envío en formato JSON
      });

      if (response.ok) {
          const data = await response.json();
          if (data.tipoUsuario === "ADMIN") {
              window.location.href = "userAdmin.html";
          } else if (data.tipoUsuario === "USER") {
              window.location.href = "user.html";
          } else {
              alert("Tipo de usuario desconocido.");
          }
      } else {
          const errorText = await response.text();
          alert(`Error: ${errorText}`);
      }
  } catch (error) {
      console.error("Error en el inicio de sesión:", error);
      alert("Hubo un problema al conectarse con el servidor.");
  }
});
