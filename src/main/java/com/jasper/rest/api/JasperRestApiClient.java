package com.jasper.rest.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class JasperRestApiClient {
    private final JasperRestApi api;

    public static JasperRestApiClient create() {
        return new JasperRestApiClient("http://restapi-telstra.jasper.com/rws/api/v1/");
    }

    public JasperRestApiClient(String apiUrl) {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
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