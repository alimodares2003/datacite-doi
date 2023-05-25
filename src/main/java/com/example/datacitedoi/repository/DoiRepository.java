package com.example.datacitedoi.repository;

import com.example.datacitedoi.model.Client;
import com.example.datacitedoi.model.Provider;

import java.util.List;

public interface DoiRepository {
    List<Provider> findProvidersByConsortiumId(String consortiumId, int page, int size);

    List<Client> findClientsByProviderId(String providerId, int page, int size);

    Long countDoiByClientId(String clientId);
}
