/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domaci.DZ13.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author ana
 */
@Entity
public class Ispit {
    @Id
    @GeneratedValue
    private long ispit_id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String course;

    @ManyToMany(mappedBy = "ispiti")
    private Set<User> users = new HashSet<User>();

    public Ispit() {
    }

    public long getIspit_id() {
        return ispit_id;
    }

    public void setIspit_id(long ispit_id) {
        this.ispit_id = ispit_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Ispit{" + "ispit_id=" + ispit_id + ", name=" + name + ", course=" + course + ", users=" + users + '}';
    }
    
    
}
