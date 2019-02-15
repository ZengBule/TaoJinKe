package qianxing.taojinke.ui.launcher;

/**
 * ***********************************************
 * 包路径：qianxing.taojinke.ui.launcher
 * 类描述：
 *
 * @author：曾小浪[PHONE：18613223863] 创建时间：2019/2/15+14:59
 * 修改人：
 * 修改时间：2019/2/15+14:59
 * 修改备注：
 * ***********************************************
 */
public class CheckTokenInfo<T> {

    private T data;
    private boolean status;
    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
