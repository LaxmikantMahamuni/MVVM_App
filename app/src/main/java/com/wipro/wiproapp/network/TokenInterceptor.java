package com.wipro.wiproapp.network;

import com.wipro.wiproapp.utils.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * This interceptor takes care of authorization of the API source/endpoint
 */
public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
   
       //rewrite the request to add bearer token
        Request newRequest=chain.request().newBuilder()
                .header("Authorization","Bearer "+ Constants.INSTANCE.getACCESS_TOKEN())
                .build();

        return chain.proceed(newRequest);
    }
}