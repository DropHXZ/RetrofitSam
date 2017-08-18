package cn.retrofitsam.httpUtils;

import java.util.Map;

import cn.retrofitsam.bean.NewsEntity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 注：接口中的每个方法的参数都需要使用注解标注，否则会报错
 * 返回类型为Call<*>，*是接收数据的类
 * Created by huxz on 2017/8/16.
 */

public interface HttpService {

    @GET("/")
    Call<ResponseBody> getNull();

    @GET("toutiao/index?")
    Observable<NewsEntity> getNews(@Query("type") String type, @Query("key") String key);

    @POST("/form")
    @FormUrlEncoded
    Call<ResponseBody> getNewsPost(@Field("type") String type, @Field("key") String key);

    @POST("/form")
    @FormUrlEncoded
    Call<ResponseBody> getDemo1(@FieldMap Map<String, Object> map);
}
