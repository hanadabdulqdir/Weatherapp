package project.hanad.com.weatherappliction.service;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import project.hanad.com.weatherappliction.constants.ApiList;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hanad on 07/02/2018.
 */

public class ServiceConnection {

    static OkHttpClient okHttpClient;
    static Retrofit retrofit;


    public static IRequestInterface getConnection() {

        retrofit = new Retrofit.Builder()
                .baseUrl(ApiList.Base_URL)
                //Allows to reflate to the recycler view adapter
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //add Gson conversion
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IRequestInterface.class);
    }
}