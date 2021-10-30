/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.usa.ciclo3.ciclo3.repository.crud;

import co.usa.ciclo3.ciclo3.model.Reservaciones;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceReservaciones extends CrudRepository<Reservaciones,Integer>{
    
    //JPQL
    //SELECT clientid, COUNT(*) AS total FROM reservacion gruoup by clientid order by desc;
    @Query("SELECT c.client, COUNT(c.client) from Reservaciones AS c group by c.client order by COUNT(c.client) desc")
    public List<Object[]> countTotalReservationsByClient();
    
    //QUERY METHODS!
    //Select * from reservation where startDate > dateOne AND startDate < dateTwo 
    public List<Reservaciones> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);
    
    //Select * from reservation where status like statusAAA
    public List<Reservaciones> findAllByStatus(String status);
}
