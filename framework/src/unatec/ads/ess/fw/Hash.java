/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unatec.ads.ess.fw;

/**
 *
 * @author USER
 */
public class Hash {
    
    public String fazer(String mensagem){
        String r="";
        
        int cont = 0;
        int letra = 0;
        for(cont=0;cont<mensagem.length();cont++){
            letra = letra^mensagem.charAt(cont);
        }
        System.out.println((char)letra);
        Object o = new Object();
        //r.charAt(letra);
        return r;
    }
    
}
