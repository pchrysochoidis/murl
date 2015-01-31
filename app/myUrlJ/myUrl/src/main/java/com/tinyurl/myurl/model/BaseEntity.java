/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tinyurl.myurl.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author ntinaki2f
 */
@javax.persistence.MappedSuperclass
public abstract class BaseEntity implements java.io.Serializable {

    private static final long serialVersionUID = 8316065198315021613L;

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @Column
    private Long id;

    public Long getId() {
        return id;
    }

    /**
     *
     * @param newVal
     */
    public void setId(Long newVal) {
        id = newVal;
    }

    @Override
    public String toString() {
        return "Entity Id " + this.id;
    }
}
