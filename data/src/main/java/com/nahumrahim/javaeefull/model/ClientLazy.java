package com.nahumrahim.javaeefull.model;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "CLIENT")
public class ClientLazy implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    String aliasCode;
    
    String name;
    
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    List <ClientLazyAddress> addresses;

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
    public List<ClientLazyAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<ClientLazyAddress> addresses) {
        this.addresses = addresses;
    }
    
}
