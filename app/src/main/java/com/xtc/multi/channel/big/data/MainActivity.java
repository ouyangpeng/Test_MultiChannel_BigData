package com.xtc.multi.channel.big.data;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.umeng.analytics.MobclickAgent;

public class MainActivity extends Activity {
    private Context mContext;
    private final String mPageName = "MainActivity";

    TextView tvMultiChannelInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        tvMultiChannelInfo = (TextView) findViewById(R.id.tv_multi_channel_info);

        MobclickAgent.setDebugMode(true);
        MobclickAgent.openActivityDurationTrack(false);

        //打印渠道信息 和版本信息
        Log.i("oyp", "渠道信息如下所示, ChannelName: " + MultiChannelUtil.getChannelName(this) + " ExtraInfo :"+ MultiChannelUtil.getChannelExtraInfo(this));
        Log.i("oyp", "版本号信息如下所示, VersionName：" + MultiChannelUtil.getVersionName(this) + " VersionCode :"+ MultiChannelUtil.getVersionCode(this));

        tvMultiChannelInfo.setText("请认真查看友盟平台是否统计正常。\n\n渠道信息如下所示,\nChannelName: " + MultiChannelUtil.getChannelName(this)
                + "\nExtraInfo :"+ MultiChannelUtil.getChannelExtraInfo(this)
                +  "\n\n版本号信息如下所示, \nVersionName：" + MultiChannelUtil.getVersionName(this)
                + " \nVersionCode :"+ MultiChannelUtil.getVersionCode(this));
        //渠道号
        String channelId = MultiChannelUtil.getChannelName(this).replace("{}", ""); //去掉默认的{}号
        //官方申请的AppKey
        String appKey = "58c7a78b5312dd70e40014ce";
        MobclickAgent.UMAnalyticsConfig config = new MobclickAgent.UMAnalyticsConfig(this, appKey, channelId);
        MobclickAgent.startWithConfigure(config);
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(mPageName);
        MobclickAgent.onResume(mContext);
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(mPageName);
        MobclickAgent.onPause(mContext);
    }
}
