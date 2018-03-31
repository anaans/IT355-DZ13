/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domaci.DZ13.service;

import com.domaci.DZ13.model.Ispit;
import com.domaci.DZ13.repository.IspitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ana
 */
@Service
public class IspitService{
    @Autowired
    private IspitRepository ispitRepository;
    
    @Autowired
    public IspitService(IspitRepository ispitRepository){
        this.ispitRepository = ispitRepository;
    }
    
    public Iterable<Ispit> findAllByOrderByNameDesc(){
        return ispitRepository.findArticlesByOrderByNameDesc();
    }

    public void save(Ispit ispit){
        ispitRepository.save(ispit);
    }

    public Ispit findById(long id){
        return ispitRepository.findOne(id);
    }
}
