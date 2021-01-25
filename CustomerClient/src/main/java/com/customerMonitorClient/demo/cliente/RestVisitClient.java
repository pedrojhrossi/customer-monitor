/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customerMonitorClient.demo.cliente;

import com.customerMonitorClient.demo.beans.ResponseVisit;
import com.customerMonitorClient.demo.beans.Visit;
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
public class RestVisitClient {

    public ResponseVisit getVisit(String queueId) {
        ResponseVisit respuestaVisit = new ResponseVisit();
        List<Visit> visitas = null;
        try {
            Client cliente = ClientBuilder.newBuilder().build();
            Response respuesta = cliente.target("http://localhost:8888/queues/" + queueId + "/visits")
                    .request(MediaType.APPLICATION_JSON)
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .get();

            if (respuesta.getStatus() == 200) {
                visitas = respuesta.readEntity(new GenericType<List<Visit>>() {
                });
                respuestaVisit.setVisits(visitas);
            } else {
                respuestaVisit.setCode(respuesta.getStatus());
            }

        } catch (Exception e) {
            respuestaVisit.setCode(0);
        }

        return respuestaVisit;
    }
}
