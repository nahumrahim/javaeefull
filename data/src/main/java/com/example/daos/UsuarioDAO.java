/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.daos;

import com.example.entities.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nahum Rahim
 */
public class UsuarioDAO {
    
    @PersistenceContext(unitName = "proyect1")
    EntityManager conexion;
    
    public List<Usuario> finAll()
    {
        return conexion.createQuery("Select u from Usuario u ",Usuario.class).getResultList();
    }
    
    public Usuario findUsuario(Integer id)
    {
        Usuario miUsuario = null;
        
        try {
            miUsuario = conexion.find(Usuario.class, id);
        }
        catch(NoResultException nre) {
            //
        }
        
        return miUsuario;
    }

    public Usuario findByUsername(String usuario)
    {
        Usuario miUsuario = null;        
        try {
            miUsuario = conexion.createQuery("Select u from Usuario u " +
                    "where u.nombre = :pusuario ",Usuario.class)
                    .setParameter("pusuario", usuario)
                    .getSingleResult();
        }
        catch(NoResultException nre) {
            //
        }        
        return miUsuario;
    }
    
}
