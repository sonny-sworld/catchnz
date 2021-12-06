package nz.co.adriley.catchdesgintest.util.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sgao on 6/12/2021 16:06
 */

public class GeneralCommsBase {

    private static GeneralCommsInterface generalCommsInterface;

    public static GeneralCommsInterface getInstance() {
        if (generalCommsInterface == null) {
            synchronized (GeneralCommsInterface.class) {
                if (generalCommsInterface == null) {
                    Gson gson = new GsonBuilder().create();
                    // For logging retrofit information for debugging purposes.
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                    //Setup for parallel requests
                    Dispatcher dispatcher = new Dispatcher();
                    dispatcher.setMaxRequests(5);
                    String baseUrl = "https://raw.githubusercontent.com/catchnz/android-test/master/data/";

                    OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor)
                            .dispatcher(dispatcher)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS).build();
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .build();
                    generalCommsInterface = retrofit.create(GeneralCommsInterface.class);
                }
            }
        }
        return generalCommsInterface;
    }


}
