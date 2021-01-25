/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customerMonitorClient.demo.beans;

/**
 *
 * @author pj
 */
public class Visit {

    private String ticketId;
    private String customerName;
    private int waitingTime;
    private boolean flag;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public void calcular(int serviceLevel) {

        this.flag = (serviceLevel * 60) < waitingTime;

    }

    public boolean isFlag() {
        return flag;
    }

}
