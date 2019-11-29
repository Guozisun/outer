//package com.trs.web;
//
//import com.taobao.api.ApiException;
//import com.taobao.api.DefaultTaobaoClient;
//import com.taobao.api.TaobaoClient;
//import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
//import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
//
//import java.util.UUID;
//
//public class SmsDemo {
//
//    public static void requestSmsCode(String phone) {
//
////这个只是我项目中的标识，忽略
//
////阿里大鱼URL
//        String url = "http://gw.api.taobao.com/router/rest";
//        String code = UUID.randomUUID().toString().replace("_","").substring(0,4);
////我自己随机生成了六位数验证码，自己去实现
////以下才是重点  三个参数，一个url阿里大鱼的服务地址，其他两个去阿里大鱼后端查看自己的相应的参数
//        TaobaoClient client = new DefaultTaobaoClient(url, "23770908",
//                "d2994ee59ce018f9b3baf68d914855fb");
//        // String json="{\"code\":\"1234\",\"product\":\"某某电子商务验证\"}";
//        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
//        req.setExtend("1");
//        //必须填写normal
//
//        req.setSmsType("normal");
//
////你应用的名字
//        req.setSmsFreeSignName("金华日报社");
//
//        req.setRecNum(phone);
//
////模板
//        req.setSmsTemplateCode("SMS_175539086");
//
////模板中的参数，按照实际情况去
////        req.setSmsParamString("{msg:'" + code + "'}");
//        req.setSmsParamString("{\"code\":\"" + code + "\",\"product\":\"alidayu\"}");
//
//
//        try {
//            AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
//
//        } catch (ApiException e) {
//
//        }
//
//    }
//    public static void main(String[] args){
//        requestSmsCode("13354420923");
//    }
//}