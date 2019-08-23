package com.qf.service.impl;

import com.qf.Utils.RedisUtils;

import com.qf.service.ISendTextMessageService;
import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;


/**
 * @Author zhengyongqi
 * @Date 2019/8/20 13:08
 */

@Service
public class SendTextMessageService implements ISendTextMessageService {

    @Autowired
    private RedisUtils redisUtils;
    @Override
    public String  register(String phoneNumber) {
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        redisUtils.set(phoneNumber,verifyCode,65);
        //初始化clnt,使用单例方式
        YunpianClient clnt = new YunpianClient("b57d6b0572fa32e0867e342acffd17cd").init();
        //发送短信API
        Map<String, String> param = clnt.newParam(2);
        param.put(YunpianClient.MOBILE, phoneNumber);   //接收人手机号码
        param.put(YunpianClient.TEXT, "【禅意】您的验证码是"+verifyCode+ "，该码有效期为60秒，该码只能使用一次！【短信签名】");
        clnt.sms().single_send(param);
        //释放clnt
        clnt.close();
        return verifyCode;
    }
}