
import java.util.Iterator;
import java.util.List;
import unatec.ads.ess.controle.ConexaoUtil;
import unatec.ads.ess.entidadeDao.Equipamentos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        List lista = ConexaoUtil.listar(Equipamentos.class);
        
        for (Iterator it = lista.iterator(); it.hasNext();) {
            Equipamentos eq = (Equipamentos) it.next();
            System.out.println(eq.getEquipamentoId() +" " +eq.getEquipamentoDescricao() +" " +eq.getEquipamentoQtdeDisponivel());
        }
        
        
        
        }
    
    }

