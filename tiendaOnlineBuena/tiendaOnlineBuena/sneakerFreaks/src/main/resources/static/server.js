// Función para consultar y mostrar la lista de clientes en una tabla
function consultarClientes() {
  fetch("http://localhost:8080/clients/getAll")
    .then((response) => response.json())
    .then((data) => {
      if (data.length > 0) {
        const keys = Object.keys(data[0]);

        // Crear la tabla
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
        data.forEach((item) => {
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
            td.textContent = item[key];
            row.appendChild(td);
          });
          tbody.appendChild(row);
        });
        table.appendChild(tbody);

        // Añadir la tabla al div
        const resultDiv = document.getElementById("consultarClientesResult");
        resultDiv.innerHTML = "";
        resultDiv.appendChild(table);
      } else {
        document.getElementById("consultarClientesResult").innerHTML =
          "No hay datos disponibles.";
      }
    })
    .catch((error) => console.error("Error:", error));
}

// Función para crear un nuevo producto
//Está dentro del front end

function consultarProductoPorId() {
  const idConsulta = document.getElementById("idConsulta").value;
  fetch(`http://localhost:8080/products/${idConsulta}`)
    .then((response) => response.json())
    .then((data) => {
      if (data) {
        // Crear un mensaje informativo
        const mensaje = `Producto encontrado: ${data.name}, ID: ${data.id}`;
        document.getElementById("consultarProductoPorIdResult").innerHTML =
          mensaje;
      } else {
        document.getElementById("consultarProductoPorIdResult").innerHTML =
          "No se encontró el producto.";
      }
    })
    .catch((error) => console.error("Error:", error));
}

function eliminarProducto() {
  const idEliminar = document.getElementById("idEliminar").value;
  fetch(`http://localhost:8080/products/delete/${idEliminar}`, {
    method: "DELETE",
  })
    .then((response) => {
      if (response.ok) {
        document.getElementById("eliminarProductoResult").innerHTML =
          "Producto eliminado correctamente.";
      } else {
        document.getElementById("eliminarProductoResult").innerHTML =
          "Error al eliminar el producto.";
      }
    })
    .catch((error) => console.error("Error:", error));
}

function modificarProducto() {
  const idModificar = document.getElementById("idModificar").value;
  const name = document.getElementById("nuevoNombre").value;
  const shortDescription = document.getElementById("nuevaDescripcion").value;
  const price = parseFloat(document.getElementById("nuevoPrecio").value);
  const stock = parseFloat(document.getElementById("nuevoStock").value);
  const image_url = document.getElementById("nuevaImageUrl").value;

  const product = {
    name: name,
    shortDescription: shortDescription,
    price: price,
    stock: stock,
    image_url: image_url,
  };

  fetch(`http://localhost:8080/products/update/${idModificar}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(product),
  })
    .then((response) => response.json())
    .then((data) => {
      if (data.id) {
        // Mensaje de éxito
        const mensaje = `Producto modificado correctamente. Nuevo nombre: ${data.name}, ID: ${data.id}`;
        document.getElementById("modificarProductoResult").innerHTML = mensaje;
      } else {
        // Mensaje de error
        document.getElementById("modificarProductoResult").innerHTML =
          "Error al modificar el producto. Asegúrate de proporcionar un ID válido.";
      }
    })
    .catch((error) => console.error("Error:", error));
}
