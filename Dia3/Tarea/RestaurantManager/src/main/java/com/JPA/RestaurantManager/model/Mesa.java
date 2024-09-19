package com.JPA.RestaurantManager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mesas") 
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesas") 
    private int idMesas;

    @Column(name = "numero_mesa", unique = true, nullable = false)
    private int numeroMesa;

    @Column(nullable = false)
    private boolean ocupada;

    // Getters y Setters

    public int getIdMesas() {
        return idMesas;
    }

    public void setIdMesas(int idMesas) {
        this.idMesas = idMesas;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}