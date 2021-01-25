/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customerMonitorClient.demo.controllers;

import com.customerMonitorClient.demo.cliente.RestQueueClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author pj
 */
@Controller("/")
public class QueueController {

    @Autowired
    RestQueueClient restCont;

    @GetMapping(value = "/")
    public String queque(Model model) {
        model.addAttribute("colas", restCont.getQueue());        
        return "index";
    }
}
