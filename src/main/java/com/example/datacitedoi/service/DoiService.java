package com.example.datacitedoi.service;

import com.example.datacitedoi.model.Client;
import com.example.datacitedoi.model.Provider;
import com.example.datacitedoi.model.response.DoiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoiService {
    List<Provider> fetchProviders(String consortiumId, int limit, int size);

    List<Client> fetchClients(String providerId, int limit, int size);

    DoiResponse fetchClientTotalDoi(String clientId);
}
