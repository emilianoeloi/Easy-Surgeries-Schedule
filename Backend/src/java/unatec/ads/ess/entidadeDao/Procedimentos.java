package unatec.ads.ess.entidadeDao;
// Generated 29/10/2013 20:49:06 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Procedimentos generated by hbm2java
 */
@XmlRootElement
public class Procedimentos  implements java.io.Serializable {


     private Integer procedimentoId;
     private String procedimentoDescricao;
     private Set agendamentoses = new HashSet(0);

    public Procedimentos() {
    }

    public Procedimentos(String procedimentoDescricao, Set agendamentoses) {
       this.procedimentoDescricao = procedimentoDescricao;
       this.agendamentoses = agendamentoses;
    }
   
    public Integer getProcedimentoId() {
        return this.procedimentoId;
    }
    
    public void setProcedimentoId(Integer procedimentoId) {
        this.procedimentoId = procedimentoId;
    }
    public String getProcedimentoDescricao() {
        return this.procedimentoDescricao;
    }
    
    public void setProcedimentoDescricao(String procedimentoDescricao) {
        this.procedimentoDescricao = procedimentoDescricao;
    }
    public Set getAgendamentoses() {
        return this.agendamentoses;
    }
    
    public void setAgendamentoses(Set agendamentoses) {
        this.agendamentoses = agendamentoses;
    }




}


