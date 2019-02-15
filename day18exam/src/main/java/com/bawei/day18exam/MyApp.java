package com.bawei.day18exam;

import android.app.Application;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.common.QueuedWork;


public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();


        UMConfigure.init(this,"5c35f32cb465f54785001350","umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        UMShareAPI.get(this);

        QueuedWork.isUseThreadPool =false;
        UMShareConfig umShareConfig = new UMShareConfig();
        umShareConfig.isNeedAuthOnGetUserInfo(true);
        UMShareAPI.get(this).setShareConfig(umShareConfig);

        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //豆瓣RENREN平台目前只能在服务器端配置
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad","http://sns.whalecloud.com");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
}
