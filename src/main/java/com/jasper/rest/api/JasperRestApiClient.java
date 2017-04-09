package com.jasper.rest.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class JasperRestApiClient {
    private static final Logger LOG = LoggerFactory.getLogger(JasperRestApiClient.class);

    private final JasperRestApi api;

    public JasperRestApiClient(String apiUrl) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(apiUrl)
                .addConverterFactory(JacksonConverterFactory.create()).build();
        this.api = retrofit.create(JasperRestApi.class);
    }

}