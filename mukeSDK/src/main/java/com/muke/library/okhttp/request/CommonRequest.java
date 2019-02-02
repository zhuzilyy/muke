package com.muke.library.okhttp.request;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Created by Administrator on 2019/2/1.
 * 为我们生成request对象
 */

public class CommonRequest {
    /**
     * @param url
     * @param params
     * @return 返回一个post请求的request对象
     */
    public static Request createPostRequest(String url,RequestParams params){
        FormBody.Builder mFormBodyBuilder = new FormBody.Builder();
        if (params!=null){
            for (Map.Entry<String,String> entry:params.urlParams.entrySet()){
                mFormBodyBuilder.add(entry.getKey(),entry.getValue());
            }
        }
        FormBody mFormBody = mFormBodyBuilder.build();
        return new Request.Builder().url(url).post(mFormBody).build();
    }
}
