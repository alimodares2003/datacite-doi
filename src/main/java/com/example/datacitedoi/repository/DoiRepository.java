package com.example.datacitedoi.repository;

import com.example.datacitedoi.model.Client;
import com.example.datacitedoi.model.Provider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoiRepository {
    List<Provider> findProvidersByConsortiumId(String consortiumId, int limit, int size);

    List<Client> findClientsByProviderId(String providerId, int limit, int size);

    Long countDoiByClientId(String clientId);
}
