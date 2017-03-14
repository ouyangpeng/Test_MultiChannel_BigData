package com.xtc.multi.channel.big.data;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;

import com.meituan.android.walle.ChannelInfo;
import com.meituan.android.walle.WalleChannelReader;

import java.util.HashMap;
import java.util.Map;

/**
 * 多渠道打包工具类，统计版本号和渠道名
 * </p>
 * created by OuyangPeng at 2017/3/9 15:36
 */
public class MultiChannelUtil {
    /**
     * 友盟统计的APP Key
     */
    public final static String UMENG_APP_KEY= "54faa929fd98c5b5e90003c2"; //正式小天才的appKey
   //public final static String UMENG_APP_KEY= "58c74bcc82b6353cb800275e"; //申请的测试的appKey

    /**
     * 获取渠道包名
     */
    public static String getChannelName(Context context) {
        ChannelInfo channelInfo = WalleChannelReader.getChannelInfo(context.getApplicationContext());
        String channelName = "";
        if (channelInfo != null) {
            channelName = channelInfo.getChannel();
        }
        return channelName;
    }

    /**
     * 获取渠道包额外信息
     */
    public static Map<String, String> getChannelExtraInfo(Context context) {
        ChannelInfo channelInfo = WalleChannelReader.getChannelInfo(context.getApplicationContext());
        Map<String, String> extraInfo = new HashMap<>();
        if (channelInfo != null) {
            extraInfo = channelInfo.getExtraInfo();
        }
        return extraInfo;
    }


    /**
     * 获取应用的版本名
     */
    public static String getVersionName(Context context) {
        PackageInfo mPackageInfo =  getPackageInfo(context);
        if (mPackageInfo != null){
            return mPackageInfo.versionName;
        }
        return "";
    }

    /**
     * 获取应用的版本号
     */
    public static int getVersionCode(Context context) {
        PackageInfo mPackageInfo =  getPackageInfo(context);
        if (mPackageInfo != null){
            return mPackageInfo.versionCode;
        }
        return -1;
    }

    /**
     * 获取应用版本信息
     */
    @Nullable
    private static PackageInfo getPackageInfo(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            return pm.getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
