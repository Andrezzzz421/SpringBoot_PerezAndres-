package com.example.controller;

import com.example.model.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductoController implements CommandLineRunner {

    @Autowired
    private ProductoService productoService;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Gestión de Productos");
            System.out.println("1. Listar productos");
            System.out.println("2. Añadir producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (option) {
                case 1:
                    System.out.println("Lista de productos:");
                    productoService.getAllProductos().forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio del producto: ");
                    Double precio = scanner.nextDouble();
                    productoService.addProducto(nombre, precio);
                    System.out.println("Producto añadido.");
                    break;

                case 3:
                    System.out.print("ID del producto a actualizar: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine(); // Consumir nueva línea
                    System.out.print("Nuevo nombre del producto: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo precio del producto: ");
                    Double nuevoPrecio = scanner.nextDouble();
                    if (productoService.updateProducto(id, nuevoNombre, nuevoPrecio)) {
                        System.out.println("Producto actualizado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("ID del producto a eliminar: ");
                    Long idEliminar = scanner.nextLong();
                    if (productoService.deleteProducto(idEliminar)) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
