/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unatec.ads.ess.servicos.equipamento;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import unatec.ads.ess.controle.ConexaoUtil;
import unatec.ads.ess.entidadeDao.Equipamentos;

/**
 *
 * @author user
 */

@Path("/equipamento")
public class ServicoEquipamento {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Equipamentos inserir(@FormParam("descricao")String descricao,@FormParam("qtd")int qtd){
        
        Equipamentos equipamentos = new Equipamentos(descricao, qtd, null);
        
        ConexaoUtil.inserir(equipamentos);
        
        return equipamentos;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Equipamentos updateEquipamentos(@FormParam("id")int id,
                                           @FormParam("descricao")String descricao,
                                           @FormParam("qtd")int qtd){
         
        
        Equipamentos equipamentos = (Equipamentos)ConexaoUtil.selecionar(Equipamentos.class, id);
        equipamentos.setEquipamentoDescricao(descricao);
        equipamentos.setEquipamentoQtdeDisponivel(qtd);
        
        ConexaoUtil.atualizar(equipamentos);
        
        return equipamentos;
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Equipamentos deleteEquipamentos(@FormParam("id")int id){
         
        
        Equipamentos equipamentos = (Equipamentos)ConexaoUtil.selecionar(Equipamentos.class, id);
        
        
        ConexaoUtil.excluir(equipamentos);
        
        return equipamentos;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Equipamentos> listEquipamentos(@FormParam("id")int id){
         
        List lista = ConexaoUtil.listar(Equipamentos.class);
        
        return lista;
    }
}
