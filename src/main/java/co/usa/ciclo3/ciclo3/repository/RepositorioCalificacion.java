/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.repository.crud.InterfaceCalificacion;
import co.usa.ciclo3.ciclo3.model.Calificacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioCalificacion {
    @Autowired
    private InterfaceCalificacion crud1;

    public List<Calificacion> getAll(){
        return (List<Calificacion>) crud1.findAll();
    }
    
    public Optional<Calificacion> getScore(int id){
        return crud1.findById(id);
    }

    public Calificacion save(Calificacion score){
        return crud1.save(score);
    }
    public void delete(Calificacion score){
        crud1.delete(score);
    }
    
    
}
