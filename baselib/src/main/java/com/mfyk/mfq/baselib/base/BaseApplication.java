package com.mfyk.mfq.baselib.base;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.mfyk.mfq.baselib.BuildConfig;
import com.mfyk.mfq.baselib.utils.AppUtil;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * @author ys
 * @since 1.0
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // arouter init
        Log.d("BaseApplication", "BuildConfig.DEBUG:" + BuildConfig.DEBUG);
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);

        // bugly init
        String packageName = getPackageName();
        String processName = AppUtil.getProcessName(android.os.Process.myPid());
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(this);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        CrashReport.initCrashReport(getApplicationContext(), BaseContract.BUGLY_APP_ID, BuildConfig.DEBUG, strategy);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }
}
