package com.crud.demo.repository;

import com.crud.demo.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();
    private long nextId = 1;

    public List<Cliente> findAll() {
        return new ArrayList<>(clientes);
    }

    public Optional<Cliente> findById(Long id) {
        return clientes.stream().filter(cliente -> cliente.getId().equals(id)).findFirst();
    }

    public Cliente save(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente.setId(nextId++);
        }
        clientes.removeIf(c -> c.getId().equals(cliente.getId()));
        clientes.add(cliente);
        return cliente;
    }

    public void deleteById(Long id) {
        clientes.removeIf(cliente -> cliente.getId().equals(id));
    }
}
