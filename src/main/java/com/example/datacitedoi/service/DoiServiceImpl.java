package com.example.datacitedoi.service;

import com.example.datacitedoi.model.Client;
import com.example.datacitedoi.model.Provider;
import com.example.datacitedoi.model.response.DoiResponse;
import com.example.datacitedoi.repository.DoiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoiServiceImpl implements DoiService {
    private final DoiRepository doiRepository;

    public DoiServiceImpl(DoiRepository doiRepository) {
        this.doiRepository = doiRepository;
    }

    @Override
    public List<Provider> fetchProviders(String consortiumId, int page, int size) {
        return doiRepository.findProvidersByConsortiumId(consortiumId, page, size);
    }

    @Override
    public List<Client> fetchClients(String providerId, int page, int size) {
        return doiRepository.findClientsByProviderId(providerId, page, size);
    }

    @Override
    public DoiResponse fetchClientTotalDoi(String clientId) {
        return new DoiResponse(doiRepository.countDoiByClientId(clientId));
    }
}
