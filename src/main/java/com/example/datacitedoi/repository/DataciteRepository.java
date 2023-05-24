package com.example.datacitedoi.repository;

import com.example.datacitedoi.model.Client;
import com.example.datacitedoi.model.Provider;

import java.util.List;

public class DataciteRepository implements DoiRepository {

    @Override
    public List<Provider> findProvidersByConsortiumId(String consortiumId, int limit, int size) {
//        https://api.datacite.org/providers?consortium-id=daraco&page[size]=2&page[number]=6
        //call request
        //map data
        //return value
        return null;
    }

    @Override
    public List<Client> findClientsByProviderId(String providerId, int limit, int size) {
//        https://api.datacite.org/clients?provider-id=jjuz&page\[number\]=1&page\[size\]=10
        return null;
    }

    @Override
    public Long countDoiByClientId(String clientId) {
//        https://api.datacite.org/dois?client-id=gesis.ahri
        return null;
    }
}
