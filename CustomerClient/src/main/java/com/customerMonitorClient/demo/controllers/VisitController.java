/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customerMonitorClient.demo.controllers;

import com.customerMonitorClient.demo.beans.ResponseVisit;
import com.customerMonitorClient.demo.beans.Visit;
import com.customerMonitorClient.demo.cliente.RestVisitClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author pj
 */
@Controller
public class VisitController {

    @Autowired
    RestVisitClient restVisit;

    @GetMapping("/visit/{id}/{serviceLevel}")
    public String visit(@PathVariable(name = "id") String id,
            @PathVariable(name = "serviceLevel") String serviceLevel, Model model) {

        ResponseVisit visit = restVisit.getVisit(id);
        if (visit.getCode() == 200) {
            for (Visit v : visit.getVisits()) {
                v.calcular(Integer.parseInt(serviceLevel));
            }
        }
        model.addAttribute("visitas", visit);
        return "visitas";
    }
}
