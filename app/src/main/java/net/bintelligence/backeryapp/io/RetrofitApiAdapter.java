package net.bintelligence.backeryapp.io;

//import net.bintelligence.preventistaapp.BuildConfig;

import net.bintelligence.backeryapp.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiAdapter {

    private static RetrofitApiService API_SERVICE;

    public static RetrofitApiService getApiService() {

        // Creamos un interceptor y le indicamos el log level a usar
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Asociamos el interceptor a las peticiones
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG)
            httpClient.addInterceptor(logging);

//        String baseUrl = "http://66.97.38.48:3000";
        String baseUrl = "http://bintelligence.net:3003";

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // <-- usamos el log level
                    .build();
            API_SERVICE = retrofit.create(RetrofitApiService.class);
        }

        return API_SERVICE;
    }
}
