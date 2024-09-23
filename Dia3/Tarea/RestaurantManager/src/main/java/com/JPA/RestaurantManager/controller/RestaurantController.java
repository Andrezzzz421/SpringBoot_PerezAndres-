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

    
    //Crear una plato
    // localhost:8080/restaurant/plato con verbo POST
    //{
    // "nombre":"Andres",
    // "precio":8.99,
    // "disponibilidad":true
    //}
    @PostMapping("/plato")
    public ResponseEntity<Void> addPlato(@RequestBody Plato plato) {
        restaurantManager.addPlato(plato);
        return ResponseEntity.ok().build();
    }
    
    //Obtener todos los platos
    // localhost:8080/restaurant/platos con verbo GET
    @GetMapping("/platos")
    public List<Plato> getPlatos() {
        return restaurantManager.listPlatosDisponibles(); 
    }

    //actualizar a un plato por ID
    // localhost:8080/restaurant/plato/1 con verbo PUT
    //{
    // "nombre":"Andres",
    // "precio":8.99,
    // "disponibilidad":true
    //}
    @PutMapping("/plato/{id}")
    public ResponseEntity<Void> updatePlato(@PathVariable int id, @RequestBody Plato plato) {
        restaurantManager.updatePlato(id, plato);
        return ResponseEntity.ok().build(); 
    }

    //Borra por ID
    @DeleteMapping("/plato/{id}")
    public ResponseEntity<Void> deletePlato(@PathVariable int id) {
        restaurantManager.deletePlato(id);
        return ResponseEntity.ok().build(); 
    }

    //Crear una mesa
    // localhost:8080/restaurant/mesa con verbo POST
    //{
    // "numeroMesa":1,
    // "ocupada":true
    //}
    @PostMapping("/mesa")
    public ResponseEntity<Void> addMesa(@RequestBody Mesa mesa) {
        restaurantManager.addMesa(mesa);
        return ResponseEntity.ok().build(); 
    }

    //Obtener todos los mesas
    // localhost:8080/restaurant/mesas con verbo GET
    @GetMapping("/mesas")
    public List<Mesa> getMesas() {
        return restaurantManager.listEstadoMesas(); 
    }

    //actualizar una mesas por ID
    // localhost:8080/restaurant/mesa/1 con verbo PUT
    //{
    // "numeroMesa":1,
    // "ocupada":true
    //}
    @PutMapping("/mesa/{id}")
    public ResponseEntity<Void> updateMesa(@PathVariable int id, @RequestBody Mesa mesa) {
        restaurantManager.updateMesaEstado(id, mesa.isOcupada());
        return ResponseEntity.ok().build(); 
    }

    //Borra por ID
    @DeleteMapping("/mesa/{id}")
    public ResponseEntity<Void> deleteMesa(@PathVariable int id) {
        restaurantManager.deleteMesa(id);
        return ResponseEntity.ok().build();
    }
}
