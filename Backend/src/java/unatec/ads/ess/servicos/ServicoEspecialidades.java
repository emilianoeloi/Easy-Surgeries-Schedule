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
import unatec.ads.ess.entidadeDao.Especialidades;

/**
 *
 * @author user
 */

@Path("/especialidades")
public class ServicoEspecialidades{
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Especialidades inserir(@FormParam("descricao")String descricao,@FormParam("nome")String nome){
        
        Especialidades especialidades = new Especialidades(nome, descricao, null);
        
        ConexaoUtil.inserir(especialidades);
        
        return especialidades;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Especialidades updateEspecialidades(@FormParam("id")int id,
                                           @FormParam("descricao")String descricao,
                                               @FormParam("nome")String nome){
         
        
        Especialidades especialidades = (Especialidades)ConexaoUtil.selecionar(Especialidades.class, id);
        especialidades.setEspecialidadeDescricao(descricao);
        especialidades.setEspecialidadeNome(nome);
        ConexaoUtil.atualizar(especialidades);
        return especialidades;
    }
    
    @DELETE
    public void deleteEspecialidades(@FormParam("id")int id){
        Especialidades especialidades = (Especialidades)ConexaoUtil.selecionar(Especialidades.class, id);
        ConexaoUtil.excluir(especialidades);
    }
    
    @GET
    @Path("/{_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Especialidades get(@PathParam("_id") int id){
         
        return (Especialidades)ConexaoUtil.selecionar(Especialidades.class, id);
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Especialidades> lista(){
        List lista = ConexaoUtil.listar(Especialidades.class);
        return lista;
    }
}
