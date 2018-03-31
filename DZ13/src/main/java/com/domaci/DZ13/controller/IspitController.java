/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domaci.DZ13.controller;

import com.domaci.DZ13.model.Ispit;
import com.domaci.DZ13.model.User;
import com.domaci.DZ13.service.IspitService;
import com.domaci.DZ13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ana
 */
@Controller
@RequestMapping("/ispiti")
public class IspitController {
    @Autowired
    IspitService ispitService;

    @Autowired
    UserService userService;
    
    @RequestMapping("/")
    public String ispiti(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User user = userService.findUserByEmail(email);
        
        Iterable<Ispit> sviIspiti = ispitService.findAllByOrderByNameDesc();
        model.addAttribute("ispiti", sviIspiti);
        model.addAttribute("user", user);
        return "ispiti";
    }

    @RequestMapping("/mojiIspiti")
    public String myArticles(Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userService.findUserByEmail(email);
        Iterable<Ispit> ispiti = user.getIspiti();
        int brIspita = 0;
        for (Ispit ispit : ispiti){
            brIspita++;
        }
        model.addAttribute("ispiti", ispiti);
        model.addAttribute("brojIspita", brIspita);
        model.addAttribute("user", user);
        return "mojiIspiti";
    }
       
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String prijavljen(@PathVariable(value = "id") long id, Model model, RedirectAttributes redirectAttributes){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User user = userService.findUserByEmail(email);
        Ispit ispit = ispitService.findById(id);
        user.getIspiti().add(ispit);
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("ispitPrijavljen", true);
        return "redirect:/ispiti/";
    }
}
