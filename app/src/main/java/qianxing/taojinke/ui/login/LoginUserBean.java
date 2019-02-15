package qianxing.taojinke.ui.login;

import java.util.List;

/**
 * Created by cc on 2018/7/26.
 */

public class LoginUserBean {

    /**
     * user : {"account_type":"","introduction":"","city":"","county":"","school":"","user_status":"100251","register_time":1.525330824E12,"applyStatus":0,"expected_service_type_list":["0"],"ownership_sign":1,"isInBlacklist":1,"sexStr":"男","nick":"哎呦","real_name":"云雨随","agent":2,"email":"","login_name":"15198124513","paymentAccountId":"18059548","serviceType":200201,"byChannel":"招聘网站","expected_service_type":"0","realnameAuth":3,"login_phone":"15198124513","cash_account":"","sex":"1","birthday":"1993年1月1日","education":"100087","province":"","platformauth":"100241","is_print_test":"","is_qq_group":"","languages":"方法广告广告","occupation":"","head":"http://o8uhyuamh.bkt.clouddn.com/2018-06/image-543571cf5d174333b629b321c77a706f.png","id":115033,"currPage":1,"perItems":10,"start":0,"offset":10}
     * token : d0633d2ef56c4e18a010cf722247205d
     */

    private UserBean user;
    private String token;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class UserBean {
        /**
         * account_type :
         * introduction :
         * city :
         * county :
         * school :
         * user_status : 100251
         * register_time : 1.525330824E12
         * applyStatus : 0.0
         * expected_service_type_list : ["0"]
         * ownership_sign : 1.0
         * isInBlacklist : 1.0
         * sexStr : 男
         * nick : 哎呦
         * real_name : 云雨随
         * agent : 2.0
         * email :
         * login_name : 15198124513
         * paymentAccountId : 18059548
         * serviceType : 200201.0
         * byChannel : 招聘网站
         * expected_service_type : 0
         * realnameAuth : 3.0
         * login_phone : 15198124513
         * cash_account :
         * sex : 1
         * birthday : 1993年1月1日
         * education : 100087
         * province :
         * platformauth : 100241
         * is_print_test :
         * is_qq_group :
         * languages : 方法广告广告
         * occupation :
         * head : http://o8uhyuamh.bkt.clouddn.com/2018-06/image-543571cf5d174333b629b321c77a706f.png
         * id : 115033.0
         * currPage : 1.0
         * perItems : 10.0
         * start : 0.0
         * offset : 10.0
         */

        private String account_type;
        private String introduction;
        private String city;
        private String county;
        private String school;
        private String user_status;
        private long register_time;
        private int applyStatus;
        private int ownership_sign;
        private int isInBlacklist;
        private String sexStr;
        private String nick;
        private String real_name;
        private int agent;
        private String email;
        private String login_name;
        private String paymentAccountId;
        private int serviceType;
        private String byChannel;
        private String expected_service_type;
        private double realnameAuth;
        private String login_phone;
        private String cash_account;
        private String sex;
        private String birthday;
        private String education;
        private String province;
        private String platformauth;
        private String is_print_test;
        private String is_qq_group;
        private String languages;
        private String occupation;
        private String head;
        private int id;
        private double currPage;
        private double perItems;
        private double start;
        private double offset;
        private List<String> expected_service_type_list;

        public String getAccount_type() {
            return account_type;
        }

        public void setAccount_type(String account_type) {
            this.account_type = account_type;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getUser_status() {
            return user_status;
        }

        public void setUser_status(String user_status) {
            this.user_status = user_status;
        }

        public long getRegister_time() {
            return register_time;
        }

        public void setRegister_time(long register_time) {
            this.register_time = register_time;
        }

        public int getApplyStatus() {
            return applyStatus;
        }

        public void setApplyStatus(int applyStatus) {
            this.applyStatus = applyStatus;
        }

        public int getOwnership_sign() {
            return ownership_sign;
        }

        public void setOwnership_sign(int ownership_sign) {
            this.ownership_sign = ownership_sign;
        }

        public int getIsInBlacklist() {
            return isInBlacklist;
        }

        public void setIsInBlacklist(int isInBlacklist) {
            this.isInBlacklist = isInBlacklist;
        }

        public String getSexStr() {
            return sexStr;
        }

        public void setSexStr(String sexStr) {
            this.sexStr = sexStr;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public int getAgent() {
            return agent;
        }

        public void setAgent(int agent) {
            this.agent = agent;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLogin_name() {
            return login_name;
        }

        public void setLogin_name(String login_name) {
            this.login_name = login_name;
        }

        public String getPaymentAccountId() {
            return paymentAccountId;
        }

        public void setPaymentAccountId(String paymentAccountId) {
            this.paymentAccountId = paymentAccountId;
        }

        public int getServiceType() {
            return serviceType;
        }

        public void setServiceType(int serviceType) {
            this.serviceType = serviceType;
        }

        public String getByChannel() {
            return byChannel;
        }

        public void setByChannel(String byChannel) {
            this.byChannel = byChannel;
        }

        public String getExpected_service_type() {
            return expected_service_type;
        }

        public void setExpected_service_type(String expected_service_type) {
            this.expected_service_type = expected_service_type;
        }

        public double getRealnameAuth() {
            return realnameAuth;
        }

        public void setRealnameAuth(double realnameAuth) {
            this.realnameAuth = realnameAuth;
        }

        public String getLogin_phone() {
            return login_phone;
        }

        public void setLogin_phone(String login_phone) {
            this.login_phone = login_phone;
        }

        public String getCash_account() {
            return cash_account;
        }

        public void setCash_account(String cash_account) {
            this.cash_account = cash_account;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getPlatformauth() {
            return platformauth;
        }

        public void setPlatformauth(String platformauth) {
            this.platformauth = platformauth;
        }

        public String getIs_print_test() {
            return is_print_test;
        }

        public void setIs_print_test(String is_print_test) {
            this.is_print_test = is_print_test;
        }

        public String getIs_qq_group() {
            return is_qq_group;
        }

        public void setIs_qq_group(String is_qq_group) {
            this.is_qq_group = is_qq_group;
        }

        public String getLanguages() {
            return languages;
        }

        public void setLanguages(String languages) {
            this.languages = languages;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getCurrPage() {
            return currPage;
        }

        public void setCurrPage(double currPage) {
            this.currPage = currPage;
        }

        public double getPerItems() {
            return perItems;
        }

        public void setPerItems(double perItems) {
            this.perItems = perItems;
        }

        public double getStart() {
            return start;
        }

        public void setStart(double start) {
            this.start = start;
        }

        public double getOffset() {
            return offset;
        }

        public void setOffset(double offset) {
            this.offset = offset;
        }

        public List<String> getExpected_service_type_list() {
            return expected_service_type_list;
        }

        public void setExpected_service_type_list(List<String> expected_service_type_list) {
            this.expected_service_type_list = expected_service_type_list;
        }
    }
}
