/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nahumrahim.javaeefull.resource;

import com.nahumrahim.javaeefull.dao.UsuarioDao;
import com.nahumrahim.javaeefull.model.Usuario;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Nahum Rahim
 */
@Path("usuarios")
@Stateless
public class UsuarioResource {

    @Inject
    UsuarioDao usuarioDao;

    @GET
    @Produces({"application/json"})
    public Response findAll() {        
        return Response.ok().entity(usuarioDao.finAll()).build();
    }
    
    @GET
    @Path("/{id}")
    public Response deVuelveUsuario(@PathParam("id") Integer id)
    {
        Usuario miUsuario;
        
        miUsuario = usuarioDao.findUsuario(id);
        if(miUsuario != null)
            return Response.ok(miUsuario.getNombre()).build();
        else
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
    }
}
