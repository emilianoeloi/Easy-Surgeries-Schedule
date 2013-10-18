/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gay.teste;

import javax.ws.rs.GET;
import javax.ws.rs.Path;



/**
 *
 * @author USER
 */
@Path("/teste")
public class teste {
       
    @GET
    @Path("/")
    public String testeServico(){
        
        return "servico funcionando";
    }
}
