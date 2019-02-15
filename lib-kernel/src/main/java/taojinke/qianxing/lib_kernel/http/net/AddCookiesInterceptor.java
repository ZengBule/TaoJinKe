package taojinke.qianxing.lib_kernel.http.net;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import taojinke.qianxing.lib_kernel.http.BaseBean;
import taojinke.qianxing.lib_kernel.logtofile.LogToFile;

/**
 * ***********************************************
 * 包路径：taojinke.qianxing.lib_kernel.http.net
 * 类描述：
 * 创建人：曾小浪[PHONE：18613223863]
 * 创建时间：2019/1/14+14:45
 * 修改人：
 * 修改时间：2019/1/14+14:45
 * 修改备注：
 * ***********************************************
 */
public class AddCookiesInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        String method = original.method();
        Log.d("TAG", "request method :" + method);
        Log.d("TAG", "request url :" + original.url());
        Response response = chain.proceed(chain.request());
        ResponseBody responseBody = response.body();

        BufferedSource source = responseBody.source();

        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        Charset charset = Charset.forName("UTF-8");
        MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            charset = contentType.charset(charset);
        }
        String bodyString = buffer.clone().readString(charset);

        Log.d("TAG", "request body :" + bodyString);
        BaseBean baseBean = JSON.parseObject(bodyString, BaseBean.class);
        if (!baseBean.isSuccess() && !baseBean.isStatus()) {
            LogToFile.d("TAG", "URL:===========" + original.url().toString() +
                    "request body :" + bodyString);
        }
        //重建新的HttpUrl，修改需要修改的url部分

        return response;
    }
}
