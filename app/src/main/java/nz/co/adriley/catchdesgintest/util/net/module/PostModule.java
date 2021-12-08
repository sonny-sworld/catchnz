package nz.co.adriley.catchdesgintest.util.net.module;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nz.co.adriley.catchdesgintest.util.net.GeneralCommsInterface;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sgao on 9/12/2021 11:14
 **/
@Module
public class PostModule {

    @Provides
    OkHttpClient okHttpClient() {
        // For logging retrofit information for debugging purposes.
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //Setup for parallel requests
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(5);

       return new OkHttpClient.Builder().addNetworkInterceptor(interceptor)
                .dispatcher(dispatcher)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build();
    }

    @Singleton
    @Provides
    Retrofit retrofit(OkHttpClient client) {
        String baseUrl = "https://raw.githubusercontent.com/catchnz/android-test/master/data/";
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    @Singleton
    @Provides
    GeneralCommsInterface apiInterface(Retrofit retrofit) {
        return retrofit.create(GeneralCommsInterface.class);
    }

}
