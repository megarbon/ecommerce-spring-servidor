// Función para consultar todos los clientes
function consultarClientes() {
  fetch("http://localhost:8080/clients/getAll")
    .then((response) => response.json())
    .then((data) => {
      if (data.length > 0) {
        mostrarClientesEnTabla(data);
      } else {
        mostrarMensaje("No hay datos disponibles.");
      }
    })
    .catch((error) => mostrarError("Error al consultar clientes:", error));
}

// Función para mostrar los clientes en una tabla
function mostrarClientesEnTabla(clientes) {
  const keys = Object.keys(clientes[0]);
  const table = document.createElement("table");
  table.classList.add("table-auto", "min-w-full");

  // Crear la cabecera de la tabla
  const thead = document.createElement("thead");
  const headerRow = document.createElement("tr");
  keys.forEach((key) => {
    const th = document.createElement("th");
    th.classList.add(
      "px-4",
      "py-2",
      "text-left",
      "border-b",
      "border-gray-400",
      "bg-gray-100",
      "text-sm",
      "font-semibold",
      "text-gray-700"
    );
    th.textContent = key;
    headerRow.appendChild(th);
  });
  thead.appendChild(headerRow);
  table.appendChild(thead);

  // Crear el cuerpo de la tabla
  const tbody = document.createElement("tbody");
  clientes.forEach((cliente) => {
    const row = document.createElement("tr");
    keys.forEach((key) => {
      const td = document.createElement("td");
      td.classList.add(
        "px-4",
        "py-2",
        "border-b",
        "border-gray-400",
        "text-sm",
        "text-gray-700"
      );
      td.textContent = cliente[key];
      row.appendChild(td);
    });
    tbody.appendChild(row);
  });
  table.appendChild(tbody);

  // Agregar la tabla al div
  const resultDiv = document.getElementById("consultarClientesResult");
  limpiarElemento(resultDiv);
  resultDiv.appendChild(table);
}

// Función para mostrar un mensaje en el div de resultados
function mostrarMensaje(mensaje) {
  const resultDiv = document.getElementById("consultarClientesResult");
  limpiarElemento(resultDiv);
  resultDiv.textContent = mensaje;
}

// Función para mostrar un error en la consola y en el div de resultados
function mostrarError(mensaje, error) {
  console.error(mensaje, error);
  mostrarMensaje("Ocurrió un error. Por favor, inténtalo de nuevo más tarde.");
}

// Función para limpiar un elemento eliminando su contenido
function limpiarElemento(elemento) {
  elemento.innerHTML = "";
}

// Función para crear un nuevo cliente
function crearCliente() {
  const nombre = document.getElementById("nombre").value;
  const correoElectronico = document.getElementById("correoElectronico").value;
  const contrasena = document.getElementById("contrasena").value;
  const apellidos = document.getElementById("apellidos").value;
  const direccion = document.getElementById("direccion").value;
  const codigoPostal = document.getElementById("codigoPostal").value;
  const numeroTarjeta = document.getElementById("numeroTarjeta").value;
  const fotoPerfilUrl = document.getElementById("fotoPerfilUrl").value;

  const clienteData = {
    nombre: nombre,
    correoElectronico: correoElectronico,
    contrasena: contrasena,
    apellidos: apellidos,
    direccion: direccion,
    codigoPostal: codigoPostal,
    numeroTarjeta: numeroTarjeta,
    fotoPerfilUrl: fotoPerfilUrl,
  };

  fetch("http://localhost:8080/clients/create", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(clienteData),
  })
    .then((response) => response.json())
    .then((createdClient) => {
      console.log("Cliente creado:", createdClient);
      consultarClientes();
    })
    .catch((error) => mostrarError("Error al crear cliente:", error));
}

// Llama a consultarClientes() al cargar la página
window.addEventListener("load", () => {
  consultarClientes();
});

// Función para eliminar un cliente por ID
function eliminarCliente() {
  const idEliminar = document.getElementById("idEliminar").value;
  fetch(`http://localhost:8080/clients/delete/${idEliminar}`, {
    method: "DELETE",
  })
    .then((response) => {
      if (response.ok) {
        mostrarMensaje("Cliente eliminado correctamente.");
        consultarClientes();
      } else {
        mostrarMensaje("Error al eliminar el cliente.");
      }
    })
    .catch((error) => mostrarError("Error al eliminar el cliente:", error));
}

// Función para recuperar un cliente por ID
// Función para recuperar un cliente por ID y mostrar sus datos en una tabla
function consultarClientePorId() {
  const idConsulta = document.getElementById("idConsulta").value;
  fetch(`http://localhost:8080/clients/${idConsulta}`)
    .then((response) => response.json())
    .then((cliente) => {
      if (cliente) {
        mostrarClienteEnTabla(cliente);
      } else {
        mostrarMensaje("No se encontró el cliente.");
      }
    })
    .catch((error) =>
      mostrarError("Error al consultar cliente por ID:", error)
    );
}

// Función para mostrar los datos de un cliente en una tabla con estilos mejorados
function mostrarClienteEnTabla(cliente) {
  const table = document.createElement("table");
  table.classList.add(
    "min-w-full",
    "divide-y",
    "divide-gray-200",
    "shadow-sm",
    "rounded-lg",
    "overflow-hidden"
  );

  const tbody = document.createElement("tbody");

  for (const prop in cliente) {
    if (cliente.hasOwnProperty(prop)) {
      const row = document.createElement("tr");

      // Celda para la clave del cliente
      const tdKey = document.createElement("td");
      tdKey.classList.add(
        "px-6",
        "py-4",
        "whitespace-nowrap",
        "text-sm",
        "font-medium",
        "text-gray-900"
      );
      tdKey.textContent = prop;
      row.appendChild(tdKey);

      // Celda para el valor del cliente
      const tdValue = document.createElement("td");
      tdValue.classList.add(
        "px-6",
        "py-4",
        "whitespace-nowrap",
        "text-sm",
        "text-gray-500"
      );
      tdValue.textContent = cliente[prop];
      row.appendChild(tdValue);

      tbody.appendChild(row);
    }
  }

  table.appendChild(tbody);

  const resultDiv = document.getElementById("consultarClientePorIdResult");
  resultDiv.innerHTML = "";
  resultDiv.appendChild(table);
}

// Función para modificar un cliente
function modificarCliente() {
  const idModificar = document.getElementById("idModificar").value;
  const nombre = document.getElementById("nuevoNombre").value;
  const correoElectronico = document.getElementById(
    "nuevoCorreoElectronico"
  ).value;
  const contrasena = document.getElementById("nuevaContrasena").value;
  const apellidos = document.getElementById("nuevosApellidos").value;
  const direccion = document.getElementById("nuevaDireccion").value;
  const codigoPostal = document.getElementById("nuevoCodigoPostal").value;
  const numeroTarjeta = document.getElementById("nuevoNumeroTarjeta").value;
  const fotoPerfilUrl = document.getElementById("nuevaFotoPerfilUrl").value;

  const clienteData = {
    id: idModificar,
    nombre: nombre,
    correoElectronico: correoElectronico,
    contrasena: contrasena,
    apellidos: apellidos,
    direccion: direccion,
    codigoPostal: codigoPostal,
    numeroTarjeta: numeroTarjeta,
    fotoPerfilUrl: fotoPerfilUrl,
  };

  fetch(`http://localhost:8080/clients/update/${idModificar}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(clienteData),
  })
    .then((response) => response.json())
    .then((updatedClient) => {
      mostrarMensaje(
        `Cliente modificado correctamente. Nuevo nombre: ${updatedClient.nombre}, ID: ${updatedClient.id}`
      );
      consultarClientes();
    })
    .catch((error) => mostrarError("Error al modificar cliente:", error));
}
// Path: tiendaOnlineBuena/sneakerFreaks/src/main/resources/static/clientServer.js
