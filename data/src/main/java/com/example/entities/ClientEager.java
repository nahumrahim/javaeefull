package com.example.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nahum Rahim
 */
@Entity
@Table (name = "CLIENT")
public class ClientEager implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    String aliasCode;
    
    String name;    
    
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    List <ClientEagerAddress> addresses;

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

    @XmlTransient
    public List<ClientEagerAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<ClientEagerAddress> addresses) {
        this.addresses = addresses;
    }
    
}
