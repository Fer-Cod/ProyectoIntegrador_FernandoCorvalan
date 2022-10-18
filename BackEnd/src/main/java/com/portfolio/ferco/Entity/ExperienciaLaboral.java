/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ferco.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author FerCod
 */
@Entity
public class ExperienciaLaboral {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreExpLab;
    private String descripcionExpLab;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(String nombreExpLab, String descripcionExpLab) {
        this.nombreExpLab = nombreExpLab;
        this.descripcionExpLab = descripcionExpLab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreExpLab() {
        return nombreExpLab;
    }

    public void setNombreExpLab(String nombreExpLab) {
        this.nombreExpLab = nombreExpLab;
    }

    public String getDescripcionExpLab() {
        return descripcionExpLab;
    }

    public void setDescripcionExpLab(String descripcionExpLab) {
        this.descripcionExpLab = descripcionExpLab;
    }
    
    
    
}
