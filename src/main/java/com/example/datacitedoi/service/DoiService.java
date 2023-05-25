package com.example.datacitedoi.service;

import com.example.datacitedoi.model.Client;
import com.example.datacitedoi.model.Provider;
import com.example.datacitedoi.model.response.DoiResponse;

import java.util.List;


public interface DoiService {
    List<Provider> fetchProviders(String consortiumId, int page, int size);

    List<Client> fetchClients(String providerId, int page, int size);

    DoiResponse fetchClientTotalDoi(String clientId);
}
