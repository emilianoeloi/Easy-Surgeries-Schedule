package unatec.ads.ess.entidadeDao;
// Generated 29/10/2013 20:49:06 by Hibernate Tools 3.2.1.GA

import javax.xml.bind.annotation.XmlRootElement;




/**
 * Administradores generated by hbm2java
 */
@XmlRootElement
public class Administradores  implements java.io.Serializable {


     private Integer administradorId;
     private Pessoas pessoas;

    public Administradores() {
    }

    public Administradores(Pessoas pessoas) {
       this.pessoas = pessoas;
    }
   
    public Integer getAdministradorId() {
        return this.administradorId;
    }
    
    public void setAdministradorId(Integer administradorId) {
        this.administradorId = administradorId;
    }
    public Pessoas getPessoas() {
        return this.pessoas;
    }
    
    public void setPessoas(Pessoas pessoas) {
        this.pessoas = pessoas;
    }




}


