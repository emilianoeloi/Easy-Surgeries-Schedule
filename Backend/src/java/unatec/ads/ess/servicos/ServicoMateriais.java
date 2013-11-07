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
import unatec.ads.ess.entidadeDao.Materiais;
import unatec.ads.ess.entidadeDao.Procedimentos;
import unatec.ads.ess.entidadeDao.Salas;


/**
 *
 * @author user
 */

@Path("/materiais")
public class ServicoMateriais {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Materiais inserir(@FormParam("descricao")String descricao,
                             @FormParam("qtd")int qtd){
        
        Materiais materiais = new Materiais(descricao, qtd, null);
        
        ConexaoUtil.inserir(materiais);
        
        return materiais;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Materiais updateMateriais(@FormParam("id")int id,
                                           @FormParam("descricao")String descricao,
                                           @FormParam("qtd")int qtd){
         
        
        Materiais materiais = (Materiais)ConexaoUtil.selecionar(Materiais.class, id);
        materiais.setMaterialDescricao(descricao);
        materiais.setMaterialQtdeDisponivel(qtd);
        
        ConexaoUtil.atualizar(materiais);
        
        return materiais;
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteMateriais(@FormParam("id")int id){
         
        
        Materiais materiais = (Materiais)ConexaoUtil.selecionar(Materiais.class, id);
        
        
        ConexaoUtil.excluir(materiais);
        
        return true;
    }
    
    @GET
    @Path("/{_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Materiais get(@PathParam("_id") int id){
         
        return (Materiais)ConexaoUtil.selecionar(Materiais.class, id);
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Materiais> lista(){
         
        List lista = ConexaoUtil.listar(Materiais.class);
        
        return lista;
    }
}
