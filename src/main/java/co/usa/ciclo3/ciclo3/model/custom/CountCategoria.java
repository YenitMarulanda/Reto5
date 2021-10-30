/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.model.custom;

import co.usa.ciclo3.ciclo3.model.Categoria;

/**
 *
 * @author USUARIO
 */
public class CountCategoria {
    
    private Integer total;
    private Categoria categoria;

    public CountCategoria(Integer total, Categoria categoria) {
        this.total = total;
        this.categoria = categoria;
    }
        

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
    
}
