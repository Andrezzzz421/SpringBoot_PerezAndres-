package com.JPA.RestaurantManager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "platos")
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_platos")
    private int idPlatos;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private boolean disponibilidad;

    // Getters y Setters

    public int getIdPlatos() {
        return idPlatos;
    }

    public void setIdPlatos(int idPlatos) {
        this.idPlatos = idPlatos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
