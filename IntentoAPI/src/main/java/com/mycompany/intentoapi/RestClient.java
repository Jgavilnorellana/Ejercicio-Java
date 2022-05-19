/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.intentoapi;

import com.mycompany.intentoapi.DTO.AccionesNombres;
import java.awt.List;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author javit
 */
public class RestClient {
    
    static AccionesNombres lista = new AccionesNombres();
    
    /**
     *
     * @param URL
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public List<AccionesNombres> getNombres(String URL) throws IOException, InterruptedException{

        List<AccionesNombres> lista = null;
      
        String urlGet = "https://stockmarketunab.azurewebsites.net/api/GetStock";

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlGet)).build();

        HttpClient cliente = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

        HttpResponse<String> respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        
        String jsonResponse = respuesta.body();
        
        System.out.println(jsonResponse);
        
        List<AccionesNombres> lista = new ObjectMapper().readValue(jsonResponse, new TypeReference<List<AccionesNombres>>(){});
        
        return lista;
                     
        }
}
