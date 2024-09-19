package com.JPA.RestaurantManager.controller;

import com.JPA.RestaurantManager.model.Plato;
import com.JPA.RestaurantManager.model.Mesa;
import com.JPA.RestaurantManager.service.RestaurantManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantManager restaurantManager;

    @PostMapping("/plato")
    public ResponseEntity<Void> addPlato(@RequestBody Plato plato) {
        restaurantManager.addPlato(plato);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/platos")
    public List<Plato> getPlatos() {
        return restaurantManager.listPlatosDisponibles(); // Obtener lista de platos
    }

    @PutMapping("/plato/{id}")
    public ResponseEntity<Void> updatePlato(@PathVariable int id, @RequestBody Plato plato) {
        restaurantManager.updatePlato(id, plato);
        return ResponseEntity.ok().build(); // Respuesta 200 OK
    }

    @DeleteMapping("/plato/{id}")
    public ResponseEntity<Void> deletePlato(@PathVariable int id) {
        restaurantManager.deletePlato(id);
        return ResponseEntity.ok().build(); // Respuesta 200 OK
    }

    @PostMapping("/mesa")
    public ResponseEntity<Void> addMesa(@RequestBody Mesa mesa) {
        restaurantManager.addMesa(mesa);
        return ResponseEntity.ok().build(); // Respuesta 200 OK
    }

    @GetMapping("/mesas")
    public List<Mesa> getMesas() {
        return restaurantManager.listEstadoMesas(); // Obtener lista de mesas
    }

    @PutMapping("/mesa/{id}")
    public ResponseEntity<Void> updateMesa(@PathVariable int id, @RequestBody Mesa mesa) {
        restaurantManager.updateMesaEstado(id, mesa.isOcupada());
        return ResponseEntity.ok().build(); // Respuesta 200 OK
    }

    @DeleteMapping("/mesa/{id}")
    public ResponseEntity<Void> deleteMesa(@PathVariable int id) {
        restaurantManager.deleteMesa(id);
        return ResponseEntity.ok().build(); // Respuesta 200 OK
    }
}