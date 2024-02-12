function consultarPedidos() {
  fetch("/orders/getAll")
    .then((response) => response.json())
    .then((data) => {
      const resultDiv = document.getElementById("consultarPedidosResult");
      resultDiv.innerHTML =
        '<h2 class="text-xl font-semibold mb-4">Pedidos</h2>';
      if (data.length === 0) {
        resultDiv.innerHTML += "<p>No se encontraron pedidos.</p>";
      } else {
        const orderList = document.createElement("ul");
        orderList.classList.add("list-disc", "list-inside");
        data.forEach((order) => {
          const listItem = document.createElement("li");
          listItem.textContent = `${order.id}: Cliente ID - ${order.clientId}, Total - ${order.total}, Estado - ${order.estado}`;
          orderList.appendChild(listItem);
        });
        resultDiv.appendChild(orderList);
      }
    })
    .catch((error) => console.error("Error:", error));
}

function crearPedido() {
  const clienteId = parseInt(document.getElementById("clienteId").value);
  const total = parseFloat(document.getElementById("total").value);
  const estado = document.getElementById("estado").value;

  const pedido = {
    clientId: clienteId,
    total: total,
    estado: estado,
  };

  fetch("/orders/create", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(pedido),
  })
    .then((response) => response.json())
    .then((data) => {
      const resultDiv = document.getElementById("consultarPedidosResult");
      resultDiv.innerHTML = `
                <h2 class="text-xl font-semibold mb-4">Pedido Creado</h2>
                <p>ID: ${data.id}</p>
                <p>Cliente ID: ${data.clientId}</p>
                <p>Total: ${data.total}</p>
                <p>Estado: ${data.estado}</p>
            `;
    })
    .catch((error) => console.error("Error:", error));
}

function consultarPedidoPorId() {
  const id = document.getElementById("idConsulta").value;
  fetch(`/orders/${id}`)
    .then((response) => response.json())
    .then((data) => {
      const resultDiv = document.getElementById("consultarPedidoPorIdResult");
      if (!data) {
        resultDiv.innerHTML = "<p>No se encontró ningún pedido con ese ID.</p>";
      } else {
        resultDiv.innerHTML = `
                    <h2 class="text-xl font-semibold mb-4">Pedido</h2>
                    <p>ID: ${data.id}</p>
                    <p>Cliente ID: ${data.clientId}</p>
                    <p>Total: ${data.total}</p>
                    <p>Estado: ${data.estado}</p>
                `;
      }
    })
    .catch((error) => console.error("Error:", error));
}

function eliminarPedido() {
  const id = document.getElementById("idEliminar").value;
  fetch(`/orders/delete/${id}`, {
    method: "DELETE",
  })
    .then((response) => {
      const resultDiv = document.getElementById("eliminarPedidoResult");
      if (response.status === 204) {
        resultDiv.innerHTML = "<p>Pedido eliminado correctamente.</p>";
      } else {
        resultDiv.innerHTML =
          "<p>No se pudo eliminar el pedido. Asegúrate de proporcionar un ID válido.</p>";
      }
    })
    .catch((error) => console.error("Error:", error));
}
