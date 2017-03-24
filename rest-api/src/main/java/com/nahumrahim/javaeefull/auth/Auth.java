/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nahumrahim.javaeefull.auth;

import com.nahumrahim.javaeefull.dao.UsuarioDao;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Nahum Rahim
 */
@Path("/auth")
public class Auth {
    
    @EJB
    UsuarioDao dao;
    
    @POST
    @Path("/login")
    @Consumes (MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(
            @FormParam("usuario") String pusuario,
            @FormParam("password") String password
            ) {
        
        if ( dao.findByUsername( pusuario ) != null)
            return Response.ok("Login correcto").build();
        else
            return Response.status(404).entity("Crecenciales incorrectas").build();
    }
    
}
