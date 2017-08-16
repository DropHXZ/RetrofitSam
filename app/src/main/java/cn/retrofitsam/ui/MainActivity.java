package cn.retrofitsam.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.retrofitsam.R;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.AsyncSubject;

public class MainActivity extends AppCompatActivity {

    private Observer receiver;
    private Observable sender;
    private List<String> list;
    private TextView tv_hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv_hello = (TextView) findViewById(R.id.tv_hello);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        tv_hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RetrofitActivity.class));
            }
        });
        list = new ArrayList<>();
        list.add("item0");
        list.add("item1");
        list.add("item2");
        packageSend();
        packageReceiver();
        packageAsync();
        schedulers();
        sender.subscribe(receiver);
    }

    private void packageSend() {
//        sender = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("first");
//                subscriber.onCompleted();
//            }
//        })
//        .subscribeOn(Schedulers.io());

//        sender = Observable.just("first", "second");

        //Map：最常用且最实用的操作符之一，将对象转换成另一个对象发射出去，
        // 应用范围非常广，如数据的转换，数据的预处理等。
        sender = Observable.from(list)
        .map(new Func1<String,String>() {
            @Override
            public String call(String o) {
                return o.toUpperCase();
            }
        });

    }

    private void packageReceiver() {
        receiver = new Observer() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                Log.e("observer", o.toString());
            }
        };
    }

    private void schedulers() {
        Schedulers.computation();
    }

    private void packageAsync() {
        AsyncSubject<String> asyncSubject = AsyncSubject.create();
        asyncSubject.onNext("second");
        asyncSubject.onCompleted();
        asyncSubject.subscribe(asyncSubject);
        asyncSubject.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e("observer", s.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public interface fun<T> extends fun1<Subscriber<? super T>>{

    }

    public interface fun1<T> extends ListAdapter{
        void call(T t);
    }
}
