package com.nahumrahim.javaeefull.auth;

import com.nahumrahim.javaeefull.dao.UsuarioDao;
import java.io.IOException;
import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Nahum Rahim
 */


@Provider
@Priority(Priorities.AUTHENTICATION)
public class AutorizationFilter implements ContainerRequestFilter, ContainerResponseFilter {

    //@Inject no funciona dentro de ContainerRequestFilter, hasta JAXRS 2
    //@EJB funciona solamente en resteasy
    //Asi que lo mas reliable es utilizar un javax.servlet.Filter
    
    @EJB(mappedName="java:module/UsuarioDao")
    UsuarioDao usuarioDao;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        //System.out.println( requestContext.getUriInfo().getAbsolutePath() );
        System.out.println(usuarioDao.findUsuario(2).getNombre() );
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }
    
}

/*
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
    UsuarioDao usuarioDao;

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
*/