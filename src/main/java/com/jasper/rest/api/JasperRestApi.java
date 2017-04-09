package com.jasper.rest.api;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JasperRestApi {

    /**
     * Devices Resource
     */
    @Headers({
            "Accept: application/json"
    })
    @GET("devices")
    Call<Devices> searchDevices(@Header("Authorization: Basic ") String authorization,
                                @Query("accountId") Long accountId, @Query("modifiedSince") Date modifiedSince,
                                @Query("pageSize") Integer pageSize, @Query("pageNumber") Integer pageNumber);

    @Headers({
            "Accept: application/json"
    })
    @GET("devices/{iccid}")
    Call<DeviceDetails> getDeviceDetails(@Header("Authorization: Basic ") String authorization, @Path("iccid") String iccid);

    @Headers({
            "Accept: application/json"
    })
    @PUT("devices/{iccid}")
    Call<Iccid> editDeviceDetails(@Header("Authorization: Basic ") String authorization, @Body EditDetailsRequest editDetailsRequest);

    /**
     * Get Session Details
     */
    @Headers({
            "Accept: application/json"
    })
    @GET("devices/{iccid}/sessionInfo")
    Call<SessionDetails> getSessionDetails(@Header("Authorization: Basic ") String authorization, @Path("iccid") String iccid);

    /**
     * SMS Message Resources
     */
    @Headers({
            "Accept: application/json"
    })
    @POST("smsMessages")
    Call<SentSmsId> sendSms(@Header("Authorization: Basic ") String authorization, @Body Sms sms);

    @Headers({
            "Accept: application/json"
    })
    @GET("smsMessages/{smsMsgId}")
    Call<SmsDetails> getSmsDetails(@Header("Authorization: Basic ") String authorization, @Path("smsMsgId") String smsMsgId,
                                   @Query("messageEncoding") String messageEncoding);

    @Headers({
            "Accept: application/json"
    })
    @GET("smsMessages")
    Call<SmsMessageIds> searchSms(@Header("Authorization: Basic ") String authorization, @Query("accountId") Long accountId,
                                  @Query("iccid") String iccid, @Query("fromDate") Date fromDate, @Query("toDate") Date toDate,
                                  @Query("pageSize") Integer pageSize, @Query("pageNumber") Integer pageNumber);

    /**
     * Usage Resource
     */
    @Headers({
            "Accept: application/json"
    })
    @GET("devices/{iccid}/ctdUsages")
    Call<DeviceUsage> getDeviceUsage(@Header("Authorization: Basic ") String authorization, @Path("iccid") String iccid);

    @Headers({
            "Accept: application/json"
    })
    @GET("devices/{iccid}/usageInZone")
    Call<DeviceUsageByZone> getDeviceUsageByNow(@Header("Authorization: Basic ") String authorization, @Path("iccid") String iccid,
                                                @Query("cycleStartDate") Date cycleStartDate, @Query("ratePlan") String ratePlan,
                                                @Query("zone") String zone);

    /**
     * Echo
     */
    @Headers({
            "Accept: application/json"
    })
    @GET("echo/{param}")
    Call<EchoResponse> echo(@Header("Authorization: Basic ") String authorization, @Path("param") String param);
}
