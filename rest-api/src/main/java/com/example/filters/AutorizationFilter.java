/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.filters;

import com.example.daos.UsuarioDAO;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nahum Rahim
 */

/*
@Provider
public class AutorizationFilter implements ContainerRequestFilter {

    //@Inject no funciona dentro de ContainerRequestFilter, hasta JAXRS 2
    //@EJB funciona solamente en resteasy
    //Asi que lo mas reliable es utilizar un javax.servlet.Filter
    
    //@Inject
    //UsuarioDAO usuarioDao;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        
        //System.out.println( requestContext.getUriInfo().getAbsolutePath() );
        //System.out.println(usuarioDao.findUsuario(2).getNombre() );
                
    }
    
}
*/

@WebFilter(
    filterName = "meinKampf",
    urlPatterns = {"/api/*"},
    initParams = {
        @WebInitParam(name="key", value="value")
    }
)
//@Stateless
public class AutorizationFilter implements Filter {
    
    @Inject
    UsuarioDAO usuarioDao;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        HttpServletRequest req = (HttpServletRequest)request;
        
        System.out.println( req.getRequestURI() );
        System.out.println(usuarioDao.findUsuario(2).getNombre() );
        
        chain.doFilter(request, response);
    }
    
    
}
