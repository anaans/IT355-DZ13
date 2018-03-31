/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domaci.DZ13.repository;

import com.domaci.DZ13.model.Ispit;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ana
 */
public interface IspitRepository extends CrudRepository<Ispit, Long>{
    public Iterable<Ispit> findArticlesByOrderByNameDesc();
}
