package com.mfyk.mfq.baselib.base;

/**
 * Created by jacksen on 2017/7/28.
 */

public class BaseContract {

    // base url
    public static final String BASE_URL = "";

    // bugly app id
    public static final String BUGLY_APP_ID = "b607db1263";



    public interface LOGIN {

        String TAG_LOGIN = "tag_login";

        int CODE_LOGIN_SUCCESS = 0x01;

        int CODE_LOGIN_FAILED = 0x02;

        int CODE_LOGIN_CANCEL = 0x03;
    }


    /**
     * login activity的拦截标志
     */
    public static final int EXTRA_INTERCEPTOR_LOGIN = 1;

    /**
     * {@link com.jacksen.baselib.arouter.LoginInterceptor}
     */
    public static final String NAME_LOGIN_INTERCEPTOR = "拦截未登录";
}
