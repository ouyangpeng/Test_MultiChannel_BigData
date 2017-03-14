# Test_MultiChannel_BigData
使用美团方案的Android Signature V2 Scheme签名下的新一代渠道包打包神器  配合友盟动态设置渠道名

>关于美团方案的Android Signature V2 Scheme签名下的新一代渠道包打包神器，可以参考： https://github.com/Meituan-Dianping/walle
>关于友盟统计动态设置渠道名可以参考链接：http://dev.umeng.com/analytics/android-doc/integration#2 


使用脚本来运行多渠道打包
```
gradlew clean assembleReleaseChannels
```
生成完后，生成的多渠道包如下所示：
![多渠道包打包结果](https://github.com/ouyangpeng/Test_MultiChannel_BigData/blob/master/pictures/m1.png)

安装生成的多渠道包后，过段时间查看友盟统计，是否正常统计了刚才打包出来的多渠道包

![友盟统计](https://github.com/ouyangpeng/Test_MultiChannel_BigData/blob/master/pictures/m2.png)