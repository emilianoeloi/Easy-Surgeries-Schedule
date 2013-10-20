/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unatec.ads.ess.services;

import javax.mail.Session;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import unatec.ads.ess.factory.HibernateUtil;
import unatec.ads.ess.model.Equipamento;


/**
 *
 * @author user
 */

@Path("/equipamento")
public class ServicoEquipamento {
    
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public void addEquipamento(@FormParam("descricao") String descricao, @FormParam("qtd") int qtd){
        
       // Equipamento eq = new Equipamento(null, qtd);
        
       
        
    }
    
    
}
