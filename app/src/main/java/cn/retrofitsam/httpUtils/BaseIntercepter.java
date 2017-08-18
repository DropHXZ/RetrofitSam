package cn.retrofitsam.httpUtils;


import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 构建基础拦截器
 * Created by huxz on 2017/8/18.
 */

public class BaseIntercepter implements Interceptor {

    private Map<String, String> headers;

    public BaseIntercepter(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request()
                .newBuilder();
        if (headers != null && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            for (String headerKey : keys) {
                builder.addHeader(headerKey,      headers.get(headerKey)).build();
            }
        }
        return chain.proceed(builder.build());
    }
}
