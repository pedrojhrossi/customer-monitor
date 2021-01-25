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
public class ResponseQueue {

    private int code;
    private List<Queue> queues;

    public ResponseQueue() {
        this.code = 200;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Queue> getQueues() {
        return queues;
    }

    public void setQueues(List<Queue> queues) {
        this.queues = queues;
    }

}
