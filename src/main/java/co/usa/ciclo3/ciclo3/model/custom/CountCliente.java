/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.model.custom;

import co.usa.ciclo3.ciclo3.model.Cliente;

/**
 *
 * @author USUARIO
 */
public class CountCliente {
    
    private Long total;
    private Cliente cliente;

    public CountCliente(Long total, Cliente cliente) {
        this.total = total;
        this.cliente = cliente;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

        
    
    
    
}
