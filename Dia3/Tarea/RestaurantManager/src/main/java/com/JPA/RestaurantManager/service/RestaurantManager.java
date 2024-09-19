package com.JPA.RestaurantManager.service;

import com.JPA.RestaurantManager.model.Plato;
import com.JPA.RestaurantManager.repository.PlatoRepository;
import com.JPA.RestaurantManager.model.Mesa;
import com.JPA.RestaurantManager.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RestaurantManager {

    @Autowired
    private PlatoRepository platoRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @Transactional
    public void addPlato(Plato plato) {
        platoRepository.save(plato); // Guardar un nuevo plato
    }

    @Transactional
    public void addMesa(Mesa mesa) {
        mesaRepository.save(mesa); // Guardar una nueva mesa
    }

    public List<Plato> listPlatosDisponibles() {
        return platoRepository.findAll(); // Listar todos los platos
    }

    public List<Mesa> listEstadoMesas() {
        return mesaRepository.findAll(); // Listar todas las mesas
    }

    @Transactional
    public void updatePlato(int idPlato, Plato platoActualizado) {
        Plato plato = platoRepository.findById(idPlato).orElse(null);
        if (plato != null) {
            plato.setNombre(platoActualizado.getNombre());
            plato.setPrecio(platoActualizado.getPrecio());
            plato.setDisponibilidad(platoActualizado.isDisponibilidad());
            platoRepository.save(plato); // Guardar los cambios
        }
    }

    @Transactional
    public void updateMesaEstado(int idMesa, boolean ocupada) {
        Mesa mesa = mesaRepository.findById(idMesa).orElse(null);
        if (mesa != null) {
            mesa.setOcupada(ocupada);
            mesaRepository.save(mesa); // Guardar los cambios
        }
    }

    @Transactional
    public void deletePlato(int idPlato) {
        platoRepository.deleteById(idPlato); // Eliminar un plato
    }

    @Transactional
    public void deleteMesa(int idMesa) {
        mesaRepository.deleteById(idMesa); // Eliminar una mesa
    }
}
