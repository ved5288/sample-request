package com.project;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by tanmaigopal on 18/04/16.
 */
public class HasuraTokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response;
        String session = Hasura.getCurrentSessionId();
        String role = Hasura.getCurrentRole();

        if (session == null)  {
            response = chain.proceed(request);
        } else {
            Request newRequest = request.newBuilder()
                    .addHeader("Authorization", "Hasura " + session)
                    .addHeader("X-Hasura-Role", role)
                    .build();
            response = chain.proceed(newRequest);
        }

        return response;
    }
}
