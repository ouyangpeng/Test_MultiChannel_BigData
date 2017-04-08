# Test_MultiChannel_BigData
使用美团方案的Android Signature V2 Scheme签名下的新一代渠道包打包神器  配合友盟动态设置渠道名

>关于美团方案的[Android Signature V2 Scheme签名下的新一代渠道包打包神器](https://github.com/Meituan-Dianping/walle)，可以参考： https://github.com/Meituan-Dianping/walle

>关于美团方案的原理，可以移步[美团Android新一代渠道包生成工具](http://tech.meituan.com/android-apk-v2-signature-scheme.html)进行了解：http://tech.meituan.com/android-apk-v2-signature-scheme.html

>关于[友盟统计动态设置渠道名](http://dev.umeng.com/analytics/android-doc/integration#2 )可以参考链接：http://dev.umeng.com/analytics/android-doc/integration#2 



官方文档

    官方关于v2签名的详细介绍：

    https://source.android.com/security/apksigning/v2.html

    官方关于gradle禁用v2签名的方法：

    https://developer.android.google.cn/about/versions/nougat/android-7.0.html

    官方APK再签名或者校验签名工具apksigner介绍：

    https://developer.android.com/studio/command-line/apksigner.html

    官方APK再签名或者校验签名工具apksigner源码：

    https://android.googlesource.com/platform/tools/apksig

个人博客

    一款基于Java环境的V2签名校验工具的介绍

    http://blog.bihe0832.com/android-v2-signature.html

    获取Android应用基本信息的工具集源码

    https://github.com/bihe0832/AndroidGetAPKInfo

    一个关于APK Signature Scheme v2签名的神奇bug定位经历

    http://blog.bihe0832.com/android-v2-issue.html

    Android签名校验机制（数字证书）

    http://blog.bihe0832.com/android_signature.html

第三方内容

    新一代开源Android渠道包生成工具Walle

    http://tech.meituan.com/android-apk-v2-signature-scheme.html






使用脚本来运行多渠道打包
```
gradlew clean assembleReleaseChannels
```

开始打包
![多渠道包打包开始](https://github.com/ouyangpeng/Test_MultiChannel_BigData/blob/master/pictures/m3.png)

打包完成，打包44个渠道包总共耗时18.543 secs，速度飞快

![多渠道包打包结束](https://github.com/ouyangpeng/Test_MultiChannel_BigData/blob/master/pictures/m4.png)


生成完后，生成的多渠道包如下所示：
![多渠道包打包结果](https://github.com/ouyangpeng/Test_MultiChannel_BigData/blob/master/pictures/m1.png)

安装生成的多渠道包后，过段时间查看友盟统计，是否正常统计了刚才打包出来的多渠道包

![友盟统计](https://github.com/ouyangpeng/Test_MultiChannel_BigData/blob/master/pictures/m2.png)
