package com.example.datacitedoi.controller;

import com.example.datacitedoi.model.Client;
import com.example.datacitedoi.model.Provider;
import com.example.datacitedoi.model.response.DoiResponse;
import com.example.datacitedoi.service.DoiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DefaultController {

    private final DoiService doiService;

    public DefaultController(DoiService doiService) {
        this.doiService = doiService;
    }

    @GetMapping("/client/{clientId}")
    private ResponseEntity<DoiResponse> clientDOI(@PathVariable String clientId) {
        return ResponseEntity.ok(doiService.fetchClientTotalDoi(clientId));
    }

    @GetMapping("/consortium/{consortiumId}/providers")
    private ResponseEntity<List<Provider>> consortiumProviders(@PathVariable String consortiumId, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        List<Provider> providers = doiService.fetchProviders(consortiumId, page, size);
        return ResponseEntity.ok(providers);
    }

    @GetMapping("/provider/{providerId}/clients")
    private ResponseEntity<List<Client>> providerClients(@PathVariable String providerId, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        List<Client> clients = doiService.fetchClients(providerId, page, size);
        return ResponseEntity.ok(clients);
    }
}
