/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ferco.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author FerCod
 */
public class dtoExperiencia {
    @NotBlank
    private String nombreExpLab;
    @NotBlank
    private String descripcionExpLab;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreExpLab, String descripcionExpLab) {
        this.nombreExpLab = nombreExpLab;
        this.descripcionExpLab = descripcionExpLab;
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
