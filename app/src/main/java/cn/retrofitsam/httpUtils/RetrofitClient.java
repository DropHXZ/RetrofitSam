package cn.retrofitsam.httpUtils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitClient
 * Created by huxz on 2017/8/18.
 */

public class RetrofitClient {

    private static final int DEFAULT_TIMEOUT = 5;
    public static String baseUrl = HttpContantValue.BASE_URL;
    private static RetrofitClient sNewInstance;
    private static Context mContext;
    private OkHttpClient okHttpClient;
    private HttpService api;

    private static class SingletonHolder {
        private static RetrofitClient INSTANCE = new RetrofitClient(
                mContext);
    }

    public static RetrofitClient getInstance(Context context) {
        if (context != null) {
//            Log.v("RetrofitClient", DevUtil.isDebug() + "");
            mContext = context;
        }
        return SingletonHolder.INSTANCE;
    }


    public static RetrofitClient getInstance(Context context, String url) {
        if (context != null) {
            mContext = context;
        }
        sNewInstance = new RetrofitClient(context, url);
        return sNewInstance;
    }

    private RetrofitClient(Context context) {

        this(context, null);
    }

    private RetrofitClient(Context context, String url) {

        if (TextUtils.isEmpty(url)) {
            url = baseUrl;
        }
//        okHttpClient = new OkHttpClient.Builder()
//                .addNetworkInterceptor(
//                        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
//                .cookieJar(new NovateCookieManger(context))
//                .addInterceptor(new BaseInterceptor(mContext))
//                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .build();
//        Retrofit retrofit = new Retrofit.Builder()
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .baseUrl(url)
//                .build();
//        api = retrofit.create(HttpService.class);
    }

}
