package unatec.ads.ess.entidadeDao;
// Generated 29/10/2013 20:49:06 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Salas generated by hbm2java
 */
public class Salas  implements java.io.Serializable {


     private Integer salaId;
     private String salaNumero;
     private Set agendamentoses = new HashSet(0);

    public Salas() {
    }

    public Salas(String salaNumero, Set agendamentoses) {
       this.salaNumero = salaNumero;
       this.agendamentoses = agendamentoses;
    }
   
    public Integer getSalaId() {
        return this.salaId;
    }
    
    public void setSalaId(Integer salaId) {
        this.salaId = salaId;
    }
    public String getSalaNumero() {
        return this.salaNumero;
    }
    
    public void setSalaNumero(String salaNumero) {
        this.salaNumero = salaNumero;
    }
    public Set getAgendamentoses() {
        return this.agendamentoses;
    }
    
    public void setAgendamentoses(Set agendamentoses) {
        this.agendamentoses = agendamentoses;
    }




}

