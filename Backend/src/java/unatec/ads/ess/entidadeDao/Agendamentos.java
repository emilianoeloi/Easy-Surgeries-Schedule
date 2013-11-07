package unatec.ads.ess.entidadeDao;
// Generated 29/10/2013 20:49:06 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Agendamentos generated by hbm2java
 */
@XmlRootElement
public class Agendamentos  implements java.io.Serializable {


     private Integer agendamentoId;
     private Pacientes pacientes;
     private Salas salas;
     private Medicos medicos;
     private Date agendamentoDataInicio;
     private Date agendamentoDataFim;
     private Set equipamentosAgendamentoses = new HashSet(0);
     private Set procedimentoses = new HashSet(0);
     private Set materiaisAgendamentoses = new HashSet(0);

    public Agendamentos() {
    }

	
    public Agendamentos(Pacientes pacientes, Salas salas, Medicos medicos) {
        this.pacientes = pacientes;
        this.salas = salas;
        this.medicos = medicos;
    }
    public Agendamentos(Pacientes pacientes, Salas salas, Medicos medicos, Date agendamentoDataInicio, Date agendamentoDataFim, Set equipamentosAgendamentoses, Set procedimentoses, Set materiaisAgendamentoses) {
       this.pacientes = pacientes;
       this.salas = salas;
       this.medicos = medicos;
       this.agendamentoDataInicio = agendamentoDataInicio;
       this.agendamentoDataFim = agendamentoDataFim;
       this.equipamentosAgendamentoses = equipamentosAgendamentoses;
       this.procedimentoses = procedimentoses;
       this.materiaisAgendamentoses = materiaisAgendamentoses;
    }
   
    public Integer getAgendamentoId() {
        return this.agendamentoId;
    }
    
    public void setAgendamentoId(Integer agendamentoId) {
        this.agendamentoId = agendamentoId;
    }
    public Pacientes getPacientes() {
        return this.pacientes;
    }
    
    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }
    public Salas getSalas() {
        return this.salas;
    }
    
    public void setSalas(Salas salas) {
        this.salas = salas;
    }
    public Medicos getMedicos() {
        return this.medicos;
    }
    
    public void setMedicos(Medicos medicos) {
        this.medicos = medicos;
    }
    public Date getAgendamentoDataInicio() {
        return this.agendamentoDataInicio;
    }
    
    public void setAgendamentoDataInicio(Date agendamentoDataInicio) {
        this.agendamentoDataInicio = agendamentoDataInicio;
    }
    public Date getAgendamentoDataFim() {
        return this.agendamentoDataFim;
    }
    
    public void setAgendamentoDataFim(Date agendamentoDataFim) {
        this.agendamentoDataFim = agendamentoDataFim;
    }
    public Set getEquipamentosAgendamentoses() {
        return this.equipamentosAgendamentoses;
    }
    
    public void setEquipamentosAgendamentoses(Set equipamentosAgendamentoses) {
        this.equipamentosAgendamentoses = equipamentosAgendamentoses;
    }
    public Set getProcedimentoses() {
        return this.procedimentoses;
    }
    
    public void setProcedimentoses(Set procedimentoses) {
        this.procedimentoses = procedimentoses;
    }
    public Set getMateriaisAgendamentoses() {
        return this.materiaisAgendamentoses;
    }
    
    public void setMateriaisAgendamentoses(Set materiaisAgendamentoses) {
        this.materiaisAgendamentoses = materiaisAgendamentoses;
    }




}


