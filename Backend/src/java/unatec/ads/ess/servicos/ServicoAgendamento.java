/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unatec.ads.ess.servicos;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import unatec.ads.ess.controle.ConexaoUtil;
import unatec.ads.ess.entidadeDao.Agendamentos;
import unatec.ads.ess.entidadeDao.Especialidades;
import unatec.ads.ess.entidadeDao.Salas;

/**
 *
 * @author emilianoeloi
 */
@Path("/agendamentos")
public class ServicoAgendamento {
    
@POST
    @Produces(MediaType.APPLICATION_JSON)
    public Agendamentos inserir(@FormParam("descricao")String descricao,
                             @FormParam("qtd")int qtd){
        
        /*Agendamentos agendamentos;
        
        ConexaoUtil.inserir(agendamentos);*/
        
        return new Agendamentos();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Agendamentos updateAgendamentos(@FormParam("id")int id,
                                           @FormParam("descricao")String descricao,
                                           @FormParam("qtd")int qtd){
         
        
        Agendamentos agendamentos = (Agendamentos)ConexaoUtil.selecionar(Agendamentos.class, id);
        
        ConexaoUtil.atualizar(agendamentos);
        
        return agendamentos;
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteAgendamentos(@FormParam("id")int id){
         
        
        Agendamentos agendamentos = (Agendamentos)ConexaoUtil.selecionar(Agendamentos.class, id);
        
        
        ConexaoUtil.excluir(agendamentos);
        
        return true;
    }
    
    @GET
    @Path("/{_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Agendamentos get(@PathParam("_id") int id){
         
        return (Agendamentos)ConexaoUtil.selecionar(Agendamentos.class, id);
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Agendamentos> lista(){
         
        List lista = ConexaoUtil.listar(Agendamentos.class);
        
        return lista;
    }    
    
    @GET
    @Path("/buscarsalas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Salas> buscarSalas(@QueryParam("dataInicio")Date dataInicio, 
                                         @QueryParam("dataTermino")Date dataTermino){
        
        dataInicio = new Date(2013, 11, 22, 8, 00);
        dataTermino = new Date(2013, 11, 22, 9, 00);
        
        List<Salas> s = new LinkedList<Salas>();
         
        List lista = ConexaoUtil.listar(Agendamentos.class);
        
        for (Iterator it = lista.iterator(); it.hasNext();) {
            Agendamentos a = (Agendamentos)it.next();
            if( dataInicio.after(a.getAgendamentoDataInicio()) && dataTermino.before(a.getAgendamentoDataFim()) ){
                //s.add(a.getSalas());
            }else{
                Salas salaDisponivel = new Salas();
                salaDisponivel.setSalaId(a.getSalas().getSalaId());
                salaDisponivel.setSalaNumero(a.getSalas().getSalaNumero());
                s.add(salaDisponivel);
            }
            
        }        
        return s;
    }  
    
}
