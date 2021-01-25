/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customerMonitorClient.demo.cliente;

import com.customerMonitorClient.demo.beans.Queue;
import com.customerMonitorClient.demo.beans.ResponseQueue;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Service;

/**
 *
 * @author pj
 */
@Service
public class RestQueueClient {

    public ResponseQueue getQueue() {
        ResponseQueue respuestaCola = new ResponseQueue();
        List<Queue> colas = null;
        try {
            Client cliente = ClientBuilder.newBuilder().build();

            Response respuesta = cliente.target("http://localhost:8888/queues")
                    .request(MediaType.APPLICATION_JSON)
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .get();

            if (respuesta.getStatus() == 200) {
                colas = respuesta.readEntity(new GenericType<List<Queue>>() {
                });
                respuestaCola.setQueues(colas);
            } else {
                respuestaCola.setCode(respuesta.getStatus());
            }
        } catch (Exception e) {
            respuestaCola.setCode(0);
        }

        return respuestaCola;
    }

}
