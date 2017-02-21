package com.dto;

import com.example.entities.*;
import java.util.List;

/**
 *
 * @author Nahum Rahim
 */
public class ClientDto {
    
    private Integer id;
    String aliasCode;
    String name;        
    List <NestedAddressDto> addresses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAliasCode() {
        return aliasCode;
    }

    public void setAliasCode(String aliasCode) {
        this.aliasCode = aliasCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NestedAddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<NestedAddressDto> addresses) {
        this.addresses = addresses;
    }
    
}
