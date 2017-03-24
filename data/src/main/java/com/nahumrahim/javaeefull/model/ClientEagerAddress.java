package com.nahumrahim.javaeefull.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Nahum Rahim
 */
@Entity
@Table(name = "CLIENT_ADDRESS")
public class ClientEagerAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String address;

    @JoinColumn(name="ID_CLIENT", referencedColumnName = "ID")
    @ManyToOne (fetch = FetchType.EAGER)
    ClientEager client;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClientEager getClient() {
        return client;
    }

    public void setClient(ClientEager client) {
        this.client = client;
    }
    
}
