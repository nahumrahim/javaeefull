package com.nahumrahim.javaeefull.dao;

import com.nahumrahim.javaeefull.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nahum Rahim
 */
@Stateless
public class UsuarioDao {
    
    @PersistenceContext(unitName = "primary")
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
