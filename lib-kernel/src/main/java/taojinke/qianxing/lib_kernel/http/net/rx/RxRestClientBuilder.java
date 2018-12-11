package taojinke.qianxing.lib_kernel.http.net.rx;


import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RxRestClientBuilder {
    private HashMap<String, Object> mParams;
    private String mUrl;
    private RequestBody mBody;

    private File mFile;

    public RxRestClientBuilder() {
    }

    public final RxRestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RxRestClientBuilder params(HashMap<String, Object> params) {
        this.mParams = params;
        return this;
    }

    public final RxRestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(
                MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    //上传
    public final RxRestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    public final RxRestClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }

    public final RxRestClient build() {
        return new RxRestClient(mParams, mUrl, mBody, mFile);
    }
}
