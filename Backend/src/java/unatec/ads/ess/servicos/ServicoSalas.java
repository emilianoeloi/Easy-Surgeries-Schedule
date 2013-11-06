/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unatec.ads.ess.servicos;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import unatec.ads.ess.controle.ConexaoUtil;
import unatec.ads.ess.entidadeDao.Procedimentos;
import unatec.ads.ess.entidadeDao.Salas;

/**
 *
 * @author user
 */

@Path("/salas")
public class ServicoSalas {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Salas inserir(@FormParam("descricao")String descricao){
        
        Salas salas = new Salas(descricao, null);
        
        ConexaoUtil.inserir(salas);
        
        return salas;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Salas updateSalas(@FormParam("id")int id,
                                           @FormParam("descricao")String descricao){
         
        
        Salas salas = (Salas)ConexaoUtil.selecionar(Salas.class, id);
        salas.setSalaNumero(descricao);
        
        
        ConexaoUtil.atualizar(salas);
        
        return salas;
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Salas deleteSalas(@FormParam("id")int id){
         
        
        Salas salas = (Salas)ConexaoUtil.selecionar(Salas.class, id);
        
        
        ConexaoUtil.excluir(salas);
        
        return salas;
    }
    
    @GET
    @Path("/{_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Salas get(@PathParam("_id") int id){
         
        return (Salas)ConexaoUtil.selecionar(Salas.class, id);
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Procedimentos> lista(){
         
        List lista = ConexaoUtil.listar(Salas.class);
        
        return lista;
    }
}
