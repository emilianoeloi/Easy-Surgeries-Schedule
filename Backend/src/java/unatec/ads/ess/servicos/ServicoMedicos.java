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
import unatec.ads.ess.entidadeDao.Materiais;
import unatec.ads.ess.entidadeDao.Medicos;
import unatec.ads.ess.entidadeDao.Pessoas;


/**
 *
 * @author user
 */

@Path("/medicos")
public class ServicoMedicos {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Medicos inserir(@FormParam("nome")String nome,
                           @FormParam("email")String email,
                           @FormParam("telefone")String telefone,
                           @FormParam("login")String login,
                           @FormParam("senha")String senha,
                           @FormParam("crm")String crm,
                           @FormParam("id_especialidades")int idEspecialidades){
        
        Pessoas pessoaMedico = new Pessoas(nome, email, telefone, login, senha, null, null, null);
        ConexaoUtil.inserir(pessoaMedico);
                      
        Especialidades especialidade = new Especialidades();
        especialidade.setEspecialidadeId(idEspecialidades);
        
        Medicos medicos = new Medicos(pessoaMedico, especialidade, crm, null);
        ConexaoUtil.inserir(medicos);
        
        return medicos;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Medicos updateMedicos(@FormParam("id")int id,
                                 @FormParam("crm")String crm){
                                          
         
        
        Medicos medicos = (Medicos)ConexaoUtil.selecionar(Medicos.class, id);
        medicos.setMedicoCrm(crm);
        
        
        ConexaoUtil.atualizar(medicos);
        
        return medicos;
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteMedicos(@FormParam("id")int id){
         
        
        Medicos medicos = (Medicos)ConexaoUtil.selecionar(Medicos.class, id);
        
        
        ConexaoUtil.excluir(medicos);
        
        return true;
    }
    
    @GET
    @Path("/{_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Medicos get(@PathParam("_id") int id){
         
        return (Medicos)ConexaoUtil.selecionar(Medicos.class, id);
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medicos> lista(){
         
        List lista = ConexaoUtil.listar(Medicos.class);
        
        return lista;
    }
}
