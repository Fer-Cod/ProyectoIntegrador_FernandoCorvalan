/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.ferco.Controller;

import com.portfolio.ferco.Dto.dtoExperiencia;
import com.portfolio.ferco.Entity.ExperienciaLaboral;
import com.portfolio.ferco.Security.Controller.Mensaje;
import com.portfolio.ferco.Service.SExperienciaLab;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FerCod
 */
@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    
    @Autowired
    SExperienciaLab sExperienciaLab;
    
    @GetMapping("/lista")
    public ResponseEntity <List<ExperienciaLaboral>> list(){
        List <ExperienciaLaboral> list = sExperienciaLab.list();
        return new ResponseEntity (list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaLaboral> getById(@PathVariable("id") int id){
        if(!sExperienciaLab.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ExperienciaLaboral experiencia = sExperienciaLab.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }   
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp){
        if(StringUtils.isBlank(dtoExp.getNombreExpLab())){
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }    
        if(sExperienciaLab.existByNombre(dtoExp.getNombreExpLab())){
            return new ResponseEntity(new Mensaje("Esa Experiencia existe"), HttpStatus.BAD_REQUEST);
        }
        ExperienciaLaboral experiencia = new ExperienciaLaboral(dtoExp.getNombreExpLab(), dtoExp.getDescripcionExpLab());
        sExperienciaLab.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia cargada a porfolio"), HttpStatus.OK);
    }
    
    @PutMapping("/update/(id)")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoExp){
         //validar si existe ID
         if(!sExperienciaLab.existById(id) ){
             return new ResponseEntity(new Mensaje("El ID de experiencia no existe"), HttpStatus.BAD_REQUEST);
         }
         
         if(!sExperienciaLab.existByNombre(dtoExp.getNombreExpLab()) && sExperienciaLab.getByNombreE(dtoExp.getNombreExpLab()).get().getId() != id ){
             return new ResponseEntity(new Mensaje("La Experiencia ya está cargada"), HttpStatus.BAD_REQUEST);
         }
         
         if(StringUtils.isBlank(dtoExp.getNombreExpLab())){
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }    
        
        ExperienciaLaboral experiencia = sExperienciaLab.getOne(id).get();
        experiencia.setNombreExpLab(dtoExp.getNombreExpLab());
        experiencia.setDescripcionExpLab(dtoExp.getDescripcionExpLab());
        
        sExperienciaLab.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada en porfolio"), HttpStatus.OK);
    }    
     
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sExperienciaLab.existById(id) ){
             return new ResponseEntity(new Mensaje("El ID de experiencia no existe en porfolio"), HttpStatus.BAD_REQUEST);
        } else {
            sExperienciaLab.delete(id);
            return new ResponseEntity(new Mensaje("Experiencia eliminada de porfolio"), HttpStatus.OK);
        }
        
    } 
}
