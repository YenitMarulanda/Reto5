
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.repository.RepositorioCalificacion;
import co.usa.ciclo3.ciclo3.model.Calificacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCalificacion {
    
    @Autowired
    private RepositorioCalificacion metodosCrud;

    public List<Calificacion> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Calificacion> getScore(int scoreId) {
        return metodosCrud.getScore(scoreId);
    }

    public Calificacion save(Calificacion score){
        if(score.getIdScore()==null){
            return metodosCrud.save(score);
        }else{
            Optional<Calificacion> e= metodosCrud.getScore(score.getIdScore());
            if(e.isEmpty()){
                return metodosCrud.save(score);
            }else{
                return score;
            }
        }
    }

    public Calificacion update(Calificacion calificacion){
        if(calificacion.getIdScore()!=null){
            Optional<Calificacion>g=metodosCrud.getScore(calificacion.getIdScore());
            if(!g.isEmpty()){
                if(calificacion.getMessageText()!=null){
                    g.get().setMessageText(calificacion.getMessageText());
                }
                if(calificacion.getStars()!=null){
                    g.get().setStars(calificacion.getStars());
                }
                return metodosCrud.save(g.get());
            }
        }
        return calificacion;
    }

    public boolean deleteScore(int scoreId) {
        Boolean aBoolean = getScore(scoreId).map(score -> {
            metodosCrud.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
