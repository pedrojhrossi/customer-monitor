/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customerMonitorClient.demo.beans;

import java.util.List;

/**
 *
 * @author pj
 */
public class ResponseVisit {

    private int code;
    private List<Visit> visits;

    public ResponseVisit() {
        this.code = 200;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

}
