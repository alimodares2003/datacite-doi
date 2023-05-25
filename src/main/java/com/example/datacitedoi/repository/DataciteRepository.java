package com.example.datacitedoi.repository;

import com.example.datacitedoi.model.Client;
import com.example.datacitedoi.model.Provider;
import com.example.datacitedoi.util.HttpHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class DataciteRepository implements DoiRepository {

    @Value("${datacite.base-url}")
    private String url;

    @Override
    public List<Provider> findProvidersByConsortiumId(String consortiumId, int page, int size) {
//        https://api.datacite.org/providers?consortium-id=daraco&page[size]=10&page[number]=2
        String path = String.format(
                "/providers?consortium-id=%s&page[number]=%d&page[size]=%d",
                consortiumId, page, size);
        String response = HttpHelper.getCall(url + path);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode data = mapper.readTree(response).get("data");
            return StreamSupport.stream(data.spliterator(), false).map(jsonNode -> new Provider(
                            jsonNode.get("id").asText(),
                            jsonNode.get("type").asText(),
                            jsonNode.get("attributes").get("name").asText(),
                            jsonNode.get("attributes").get("created").asText()
                    ))
                    .collect(Collectors.toList());
        } catch (JsonProcessingException e) {
            return List.of();
        }
    }

    @Override
    public List<Client> findClientsByProviderId(String providerId, int page, int size) {
//        https://api.datacite.org/clients?provider-id=jjuz&page\[number\]=1&page\[size\]=10
        String path = String.format(
                "/clients?provider-id=%s&page[number]=%d&page[size]=%d",
                providerId, page, size);
        String response = HttpHelper.getCall(url + path);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode data = mapper.readTree(response).get("data");
            return StreamSupport.stream(data.spliterator(), false).map(jsonNode -> new Client(
                            jsonNode.get("id").asText(),
                            jsonNode.get("type").asText(),
                            jsonNode.get("attributes").get("name").asText(),
                            jsonNode.get("attributes").get("created").asText(),
                            StreamSupport.stream(
                                            jsonNode.get("relationships").get("prefixes").get("data")
                                                    .spliterator(), false)
                                    .map(d -> {
                                        return d.get("id").asText();
                                    })
                                    .collect(Collectors.toList())
                    ))
                    .collect(Collectors.toList());
        } catch (JsonProcessingException e) {
            return List.of();
        }
    }

    @Override
    public Long countDoiByClientId(String clientId) {
//        https://api.datacite.org/dois?client-id=gesis.ahri
        String path = String.format("/dois?client-id=%s", clientId);
        String response = HttpHelper.getCall(url + path);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(response).get("meta").get("total").asLong();
        } catch (JsonProcessingException e) {
            return 0L;
        }
    }
}
