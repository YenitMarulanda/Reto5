/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.repository.crud.InterfaceReservaciones;
import co.usa.ciclo3.ciclo3.model.custom.CountCliente;
import co.usa.ciclo3.ciclo3.model.Cliente;
import co.usa.ciclo3.ciclo3.model.Reservaciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioReservaciones {
       @Autowired
    private InterfaceReservaciones crud4;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud4.findAll();
    }
    public Optional<Reservaciones> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservaciones save(Reservaciones reservation){
        return crud4.save(reservation);
    }
    public void delete(Reservaciones reservation){
        crud4.delete(reservation);
    }
    
    public List<Reservaciones> getReservacionesByScore(String score){
        return crud4.findAllByStatus(score);
    }
    
    public List<Reservaciones> getReservacionesByStatus(String status){
        return crud4.findAllByStatus(status);
    } 
    
    public List<Reservaciones> getReservacionesPeriod(Date dateOne, Date dateTwo){
        return crud4.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    
    public List<CountCliente> getTopClientes(){
        List<CountCliente> res=new ArrayList<>();

        List<Object[]> report=crud4.countTotalReservationsByClient();
        for(int i=0;i<report.size();i++){
            /*
            Categoria cat=(Categoria) report.get(i)[0];
            Integer cantidad=(Integer) report.get(i)[1];
            CountCategoria cc=new CountCategoria(cantidad,cat);
            res.add(cc);
            */
            res.add(new CountCliente((Long) report.get(i)[1],(Cliente)report.get(i)[0] ));
        }
        
        return res;
    }    
}
