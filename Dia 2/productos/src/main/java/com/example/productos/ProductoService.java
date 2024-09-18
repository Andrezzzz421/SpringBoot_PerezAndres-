package com.example.productos;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final List<Producto> productos = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Producto> getAllProductos() {
        return new ArrayList<>(productos);
    }

    public Optional<Producto> getProductoById(Long id) {
        return productos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Producto addProducto(String nombre, Double precio) {
        Producto producto = new Producto(idCounter++, nombre, precio);
        productos.add(producto);
        return producto;
    }

    public boolean updateProducto(Long id, String nombre, Double precio) {
        Optional<Producto> productoOptional = getProductoById(id);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            return true;
        }
        return false;
    }

    public boolean deleteProducto(Long id) {
        return productos.removeIf(p -> p.getId().equals(id));
    }
}
