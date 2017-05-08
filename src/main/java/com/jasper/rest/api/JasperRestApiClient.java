package com.jasper.rest.api;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class JasperRestApiClient {
    private final JasperRestApi api;

    public static JasperRestApiClient create(String url) {
        return new JasperRestApiClient(url);
    }

    protected JasperRestApiClient(String apiUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        this.api = retrofit.create(JasperRestApi.class);
    }

    public Call<SessionDetails> getSessionDetails(String authorization, String iccid) {
        return this.api.getSessionDetails(authorization, iccid);
    }

    public Call<SentSmsId> sendSms(String authorization, Sms sms) {
        return this.api.sendSms(authorization, sms);
    }
}