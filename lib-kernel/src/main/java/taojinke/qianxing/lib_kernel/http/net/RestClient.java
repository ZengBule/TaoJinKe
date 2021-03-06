package taojinke.qianxing.lib_kernel.http.net;


import java.io.File;
import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import taojinke.qianxing.lib_kernel.http.net.callback.IError;
import taojinke.qianxing.lib_kernel.http.net.callback.IFailure;
import taojinke.qianxing.lib_kernel.http.net.callback.IRequest;
import taojinke.qianxing.lib_kernel.http.net.callback.ISuccess;
import taojinke.qianxing.lib_kernel.http.net.callback.RequestCallBacks;
import taojinke.qianxing.lib_kernel.http.net.download.DownloadHandler;

public class RestClient {

    private final HashMap<String, Object> PARAMS;
    private final String URL;
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;
    //上传下载
    private final File FILE;

    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String FILENAME;

    public RestClient(HashMap<String, Object> params,
                      String url,
                      IRequest request,
                      ISuccess success,
                      IFailure failure,
                      IError error,
                      RequestBody body,
                      File file, String downloadDir, String extension, String filename) {
        this.PARAMS = params;
        this.URL = url;
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;

        this.FILE = file;
        this.DOWNLOAD_DIR = downloadDir;
        this.EXTENSION = extension;
        this.FILENAME = filename;
    }

    public static RestClientBuilder create() {
        return new RestClientBuilder();
    }

    /**
     * 开始实现真实的网络操作
     */
    private void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;
        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }
        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody = RequestBody.create(MultipartBody.FORM, FILE);
                final MultipartBody.Part body = MultipartBody.Part.createFormData(
                        "file", FILE.getName(), requestBody);
                call = service.upload(URL, body);
                break;
            default:
                break;
        }
        if (call != null) {
            call.enqueue(getReqeustCallback());
        }
    }

    private Callback<String> getReqeustCallback() {
        return new RequestCallBacks(REQUEST, SUCCESS, FAILURE, ERROR);
    }

    //各种请求
    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }

    public final void upload() {
        request(HttpMethod.UPLOAD);
    }

    public final void download() {
        new DownloadHandler(PARAMS, URL, REQUEST,
                SUCCESS, FAILURE, ERROR, DOWNLOAD_DIR,
                EXTENSION, FILENAME)
                .handleDownload();
    }
}
