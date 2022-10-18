/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ferco.Service;

import com.portfolio.ferco.Entity.ExperienciaLaboral;
import com.portfolio.ferco.Repository.RExperienciaLaboral;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FerCod
 */
@Service
@Transactional
public class SExperienciaLab {
    @Autowired
    RExperienciaLaboral rExperiencia;
    
    public List<ExperienciaLaboral> list(){
        return rExperiencia.findAll();
    }
    
    public Optional <ExperienciaLaboral> getOne(int id){
        return rExperiencia.findById(id);
    }
    
    public Optional <ExperienciaLaboral> getByNombreE(String nombreE){
        return rExperiencia.findBynombreExpLab(nombreE);
    }
    
    public void save(ExperienciaLaboral expe){
        rExperiencia.save(expe);
    }
    
    public void delete(int id){
        rExperiencia.deleteById(id);
    }
    
    public boolean existById (int id){
        return rExperiencia.existsById(id);
    }
    
    public boolean existByNombre (String nombreExp){
        return rExperiencia.existsByNombreExpLab(nombreExp);
    }
    
    
}
