/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unatec.ads.ess.servicos.equipamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author user
 */
@Path("/logar")
public class ServicosLogin {
    
    @Context
    HttpServletRequest request;
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response logar (@FormParam("email")String email,@FormParam("password") long password){
    
            HttpSession session = request.getSession();
            session.setAttribute("email", this);
            
        
         return Response.ok().build();

    }
    
                           
                          
}
