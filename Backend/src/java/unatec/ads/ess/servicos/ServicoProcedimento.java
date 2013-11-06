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

/**
 *
 * @author user
 */

@Path("/procedimentos")
public class ServicoProcedimento {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Procedimentos inserir(@FormParam("descricao")String descricao){
        
        Procedimentos procedimentos = new Procedimentos(descricao, null);
        
        ConexaoUtil.inserir(procedimentos);
        
        return procedimentos;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Procedimentos updateEquipamentos(@FormParam("id")int id,
                                           @FormParam("descricao")String descricao){
         
        
        Procedimentos procedimentos = (Procedimentos)ConexaoUtil.selecionar(Procedimentos.class, id);
        procedimentos.setProcedimentoDescricao(descricao);
        
        
        ConexaoUtil.atualizar(procedimentos);
        
        return procedimentos;
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Procedimentos deleteEquipamentos(@FormParam("id")int id){
         
        
        Procedimentos procedimentos = (Procedimentos)ConexaoUtil.selecionar(Procedimentos.class, id);
        
        
        ConexaoUtil.excluir(procedimentos);
        
        return procedimentos;
    }
    
    @GET
    @Path("/{_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Procedimentos get(@PathParam("_id") int id){
         
        return (Procedimentos)ConexaoUtil.selecionar(Procedimentos.class, id);
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Procedimentos> lista(){
         
        List lista = ConexaoUtil.listar(Procedimentos.class);
        
        return lista;
    }
}
