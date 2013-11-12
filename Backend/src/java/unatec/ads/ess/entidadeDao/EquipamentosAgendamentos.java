package unatec.ads.ess.entidadeDao;
// Generated 29/10/2013 20:49:06 by Hibernate Tools 3.2.1.GA

import javax.xml.bind.annotation.XmlRootElement;




/**
 * EquipamentosAgendamentos generated by hbm2java
 */
@XmlRootElement
public class EquipamentosAgendamentos  implements java.io.Serializable {


     private EquipamentosAgendamentosId id;
     private Equipamentos equipamentos;
     private Agendamentos agendamentos;
     private Integer equipamentoAgendamentoQtde;

    public EquipamentosAgendamentos() {
    }

	
    public EquipamentosAgendamentos(EquipamentosAgendamentosId id, Equipamentos equipamentos, Agendamentos agendamentos) {
        this.id = id;
        this.equipamentos = equipamentos;
        this.agendamentos = agendamentos;
    }
    public EquipamentosAgendamentos(EquipamentosAgendamentosId id, Equipamentos equipamentos, Agendamentos agendamentos, Integer equipamentoAgendamentoQtde) {
       this.id = id;
       this.equipamentos = equipamentos;
       this.agendamentos = agendamentos;
       this.equipamentoAgendamentoQtde = equipamentoAgendamentoQtde;
    }
   
    public EquipamentosAgendamentosId getId() {
        return this.id;
    }
    
    public void setId(EquipamentosAgendamentosId id) {
        this.id = id;
    }
    public Equipamentos getEquipamentos() {
        return this.equipamentos;
    }
    
    public void setEquipamentos(Equipamentos equipamentos) {
        this.equipamentos = equipamentos;
    }
    public Agendamentos getAgendamentos() {
        return this.agendamentos;
    }
    
    public void setAgendamentos(Agendamentos agendamentos) {
        this.agendamentos = agendamentos;
    }
    public Integer getEquipamentoAgendamentoQtde() {
        return this.equipamentoAgendamentoQtde;
    }
    
    public void setEquipamentoAgendamentoQtde(Integer equipamentoAgendamentoQtde) {
        this.equipamentoAgendamentoQtde = equipamentoAgendamentoQtde;
    }




}


