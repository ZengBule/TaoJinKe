package taojinke.qianxing.mine.modle;

/**
 * Created by cc on 2018/5/28.
 */

public class UserBean {

    /**
     * nick : 方法反反复复
     * realNameAuth : NotAuth
     * workState : Yes
     * introduction :
     * head : http://t.itaojintest.cn/static/thumb/customer/head/(60).png
     */

    private String nick;
    private String realNameAuth;
    private String workState;
    private String introduction;
    private String head;
    private String id;
    private String realName;
    private String sex;
    private String email;
    private String idCardNumber;
    private String cancelState;
    private long tjkNumber;

    public long getTjkNumber() {
        return tjkNumber;
    }

    public void setTjkNumber(long tjkNumber) {
        this.tjkNumber = tjkNumber;
    }

    public String getCancelState() {
        return cancelState;
    }

    public void setCancelState(String cancelState) {
        this.cancelState = cancelState;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getRealNameAuth() {
        return realNameAuth;
    }

    public void setRealNameAuth(String realNameAuth) {
        this.realNameAuth = realNameAuth;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
