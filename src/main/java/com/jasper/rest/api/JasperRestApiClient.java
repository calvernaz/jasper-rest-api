package com.jasper.rest.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class JasperRestApiClient {
    private static final Logger LOG = LoggerFactory.getLogger(JasperRestApiClient.class);

    private final JasperRestApi api;

    public static JasperRestApiClient create() {
        return new JasperRestApiClient("https://restapi-telstra.jasper.com/rws/api/v1/");
    }

    public JasperRestApiClient(String apiUrl) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(apiUrl)
                .addConverterFactory(JacksonConverterFactory.create()).build();
        this.api = retrofit.create(JasperRestApi.class);
    }

    public Call<SessionDetails> getSessionDetails(String authorization, String iccid) {
        LOG.info("Get session details for {}", iccid);
        return this.api.getSessionDetails(authorization, iccid);
    }

    public Call<SentSmsId> sendSms(String authorization, Sms sms) {
        return this.api.sendSms(authorization, sms);
    }
}