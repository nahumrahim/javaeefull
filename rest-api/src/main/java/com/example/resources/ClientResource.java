package com.example.resources;

import com.dto.ClientDto;
import com.dto.NestedAddressDto;
import com.example.entities.ClientEager;
import com.example.entities.ClientEagerAddress;
import com.example.entities.ClientLazy;
import com.example.entities.ClientLazyAddress;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Nahum Rahim
 */
@Path("clients")
@Stateless
public class ClientResource {

    @PersistenceContext(unitName = "proyect1")
    EntityManager em;
    
    @GET
    @Path("eager/default")
    @Produces({"application/json"})
    public Response findAllEagerDefault() {        
        return Response.ok().entity (
            em.createQuery("SELECT c FROM ClientEager c", ClientEager.class).getResultList()
        ).build();
    }

    @GET
    @Path("eager/fetch")
    @Produces({"application/json"})
    public Response findAllEagerFetch() {        
        List<ClientEager> clients = em.createQuery("SELECT DISTINCT c FROM ClientEager c LEFT JOIN FETCH c.addresses", ClientEager.class)
                .getResultList();
        
        List<ClientDto> dtos = new ArrayList<>();
        for (ClientEager client: clients) {
            ClientDto dto = new ClientDto();
            dto.setId( client.getId() );
            dto.setAliasCode( client.getAliasCode() );
            dto.setName( client.getName() );

            dto.setAddresses( new ArrayList<>() );
            client.getAddresses().stream().map((address) -> {
                NestedAddressDto addressDto = new NestedAddressDto();
                addressDto.setId(address.getId());
                addressDto.setAddress(address.getAddress());
                //addressDto.setClient(dto);
                return addressDto;
            }).forEach((addressDto) -> {
                //This shouldnt be set
                dto.getAddresses().add(addressDto);
            });
            dtos.add(dto);
        }
        
        return Response.ok().entity (dtos).build();
    }

    
    /*LAZY*/
    @GET
    @Path("lazy/default")
    @Produces({"application/json"})
    public Response findAllLazyDefault() {        
        return Response.ok().entity (
                em.createQuery("SELECT c FROM ClientLazy c", ClientLazy.class).getResultList()
        ).build();
    }

    @GET
    @Path("lazy/fetch")
    @Produces({"application/json"})
    public Response findAlllazyFetch() {        
        List<ClientLazy> clients = em.createQuery("SELECT DISTINCT c FROM ClientLazy c LEFT JOIN FETCH c.addresses ", ClientLazy.class)
                .getResultList();
                
        List<ClientDto> dtos = new ArrayList<>();
        for (ClientLazy client: clients) {
            ClientDto dto = new ClientDto();
            dto.setId( client.getId() );
            dto.setAliasCode( client.getAliasCode() );
            dto.setName( client.getName() );

            dto.setAddresses( new ArrayList<>() );
            client.getAddresses().stream().map((address) -> {
                NestedAddressDto addressDto = new NestedAddressDto();
                addressDto.setId(address.getId());
                addressDto.setAddress(address.getAddress());
                //addressDto.setClient(dto);
                return addressDto;
            }).forEach((addressDto) -> {
                //This shouldnt be set
                dto.getAddresses().add(addressDto);
            });
            dtos.add(dto);
        }

        return Response.ok().entity (dtos).build();
    }
    
    
}
