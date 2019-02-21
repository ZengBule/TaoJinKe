package taojinke.qianxing.core;

import org.apache.commons.codec.binary.Base64;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * Created by Administrator on 2018/4/12.
 */

public class DESUtil {
    //算法名称
    public static final String KEY_ALGORITHM = "DES";
    //算法名称/加密模式/填充方式
    //DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
    //public static final String CIPHER_ALGORITHM = "DES/ECB/NoPadding";
    public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";
    //KEY
    //public static final String KEY = "A1B2C3D4E5F60708";
    public static final String KEY = "3c9ac8463dfa11e888ce000c29751769";

    /**
     * 加密数据
     *
     * @param data 待加密数据
     * @param key  密钥
     * @return 加密后的数据
     */
    /*public static String encrypt(String data, String key) throws Exception {
        Key deskey = keyGenerator(key);*/
    public static String encrypt(String data) throws Exception {
        Key deskey = keyGenerator(DESUtil.KEY);
        // 实例化Cipher对象，它用于完成实际的加密操作
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        SecureRandom random = new SecureRandom();
        // 初始化Cipher对象，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, deskey, random);
        byte[] results = cipher.doFinal(data.getBytes("utf-8"));
        // 执行加密操作。加密后的结果通常都会用Base64编码进行传输
        return new String(org.java_websocket.util.Base64.encodeBytes(results));
    }

    /**
     * 解密数据
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return 解密后的数据
     */
    /*public static String decrypt(String data, String key) throws Exception {
        Key deskey = keyGenerator(key);*/
    public static String decrypt(String data) throws Exception {
        Key deskey = keyGenerator(DESUtil.KEY);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        //初始化Cipher对象，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, deskey);
        // 执行解密操作
        return new String(cipher.doFinal(Base64.decodeBase64(data.getBytes())));
    }

    /**
     * 生成密钥key对象
     * @throws Exception
     */
    private static SecretKey keyGenerator(String keyStr) throws Exception {
        //byte input[] = hexString2Bytes(keyStr);
        byte input[] = keyStr.getBytes();
        DESKeySpec desKey = new DESKeySpec(input);
        //创建一个密匙工厂，然后用它把DESKeySpec转换成SecretKey
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(desKey);
        return securekey;
    }

    // 从十六进制字符串到字节数组转换
    public static byte[] hexString2Bytes(String hexstr) {
        byte[] b = new byte[hexstr.length() / 2];
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            char c0 = hexstr.charAt(j++);
            char c1 = hexstr.charAt(j++);
            b[i] = (byte) ((parse(c0) << 4) | parse(c1));
        }
        return b;
    }

    private static int parse(char c) {
        if (c >= 'a') return (c - 'a' + 10) & 0x0f;
        if (c >= 'A') return (c - 'A' + 10) & 0x0f;
        return (c - '0') & 0x0f;
    }

    public static String parsePassword(String password) {
        String signature = null;
        try {
         signature = DESUtil.encrypt(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return signature;
    }
}
