Para el Dia1 como utilizarlo(desde la terminal)

Crear un Cliente:
curl -X POST http://localhost:8080/clientes -H "Content-Type: application/json" -d '{"nombre": "Juan", "email": "juan@example.com"}'

Obtener Todos los Clientes:
curl http://localhost:8080/clientes

Actualizar un Cliente:
curl -X PUT http://localhost:8080/clientes/1 -H "Content-Type: application/json" -d '{"nombre": "Juan Pérez", "email": "juanperez@example.com"}'

Eliminar un Cliente:
curl -X DELETE http://localhost:8080/clientes/1
