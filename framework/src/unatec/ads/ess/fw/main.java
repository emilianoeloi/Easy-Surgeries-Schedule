/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unatec.ads.ess.fw;

/**
 *
 * @author USER
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Hash h = new Hash();
        String hash = h.fazer("Mensagem de texto");
        System.out.print(hash);
    }
}
