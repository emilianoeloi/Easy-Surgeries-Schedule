/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unatec.ads.ess.services;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author emilianoeloi
 */
@Path("medicos")
public class ServiceMedico {
    
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    String id;
    
    public ServiceMedico(UriInfo uriInfo, Request request, String id){
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }
    
}
