package com.shubham.elasticsearch.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

@Configuration
public class ElasticSearchConfiguration {

    @Value("${elasticsearchurl}")
    private String elasticSearchUrl;

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        // Create the low-level client
        RestClient restClient = RestClient.builder(
                new HttpHost(elasticSearchUrl, 9243)).build();

// Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

// And create the API client
        ElasticsearchClient client = new ElasticsearchClient(transport);
        return client;
    }
}
