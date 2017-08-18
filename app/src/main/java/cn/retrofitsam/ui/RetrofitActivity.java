package cn.retrofitsam.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import cn.retrofitsam.R;
import cn.retrofitsam.bean.NewsEntity;
import cn.retrofitsam.httpUtils.HttpContantValue;
import cn.retrofitsam.httpUtils.HttpService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.schedulers.Schedulers;

/**
 *
 */
public class RetrofitActivity extends AppCompatActivity {

    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl(HttpContantValue.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        HttpService service = retrofit.create(HttpService.class);
        Observable<NewsEntity> call = service.getNews("top", "91bcbb395068b4c74ffdf6649c5b10f5");

        call.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Observer<NewsEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewsEntity newsEntity) {

                    }
                });
//        call.enqueue(new Callback<NewsEntity>() {
//            @Override
//            public void onResponse(Call<NewsEntity> call, Response<NewsEntity> response) {
//                NewsEntity newsEntity = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<NewsEntity> call, Throwable t) {
//                Log.i("error", "request default");
//            }
//        });

//        try {
//            Response<ResponseBody> response = call.execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
