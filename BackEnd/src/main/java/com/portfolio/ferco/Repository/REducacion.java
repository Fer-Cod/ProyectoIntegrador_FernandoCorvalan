/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.ferco.Repository;

import com.portfolio.ferco.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FerCod
 */
@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findBynombreEdu(String nombreEdu);
    public boolean existsByNombreEdu(String nombreEdu);
}
