package com.trs.web;

import com.trs.util.ExportExcel1;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 果子
 * Create Time:2019/11/13 17:10
 */
public class XmlController {
    public static void main(String[] args){
        //1.创建SAXBuilder对象
        SAXBuilder saxBuilder = new SAXBuilder();
        //2.创建输入流
        InputStream is = null;
        Document document=null;
        try {
            is = new FileInputStream(new File("D:/jhxml/jhrb/jhrb.xml"));
            document = saxBuilder.build(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3.将输入流加载到build中
        //4.获取根节点 Node
        Element rootElement = document.getRootElement();
        //5.获取子节点
        List<Element> children = rootElement.getChildren();
        System.out.println("rootElementLength:"+children.size());
        //获取Organization
        for (Element child : children) {
            System.out.println("rootElement:"+child.getChildTextTrim("Name"));
            List<Element> organizationList = child.getChildren("Organization");
            for (Element organization : organizationList){
                System.out.println("dasdasx:"+organization.getChildTextTrim("Name"));
                List<Element> usersList = organization.getChildren("Users");
                for (Element users:usersList){
                    if (users.getName().equalsIgnoreCase("Name")){
                        System.out.println("dsadasdada:"+users.getValue());
                    }
                    List<Element> usersChildren = users.getChildren();
                    for (Element child2 : usersChildren) {
                        List<Element> userList = child2.getChildren();
                        Map<String,String> map=new LinkedHashMap<>();
                        for (Element userInfo : userList) {
                            if (userInfo.getName().equalsIgnoreCase("UserName")){
                                map.put("真实姓名",userInfo.getValue());
                            }
                            if (userInfo.getName().equalsIgnoreCase("UserCode")){
                                map.put("邮箱",userInfo.getValue());
                            }
                            if (userInfo.getName().equalsIgnoreCase("HandSetNumber")){
                                if (StringUtils.isEmpty(userInfo.getValue())){
                                    map.put("手机号码","18800000000");
                                }else {
                                    map.put("手机号码", userInfo.getValue());
                                }
                            }

                        }
                        map.put("密码","jhrb!@#123");
                        map.put("部门",organization.getChildTextTrim("Name"));
                        map.put("站点",child.getChildTextTrim("Name"));
                        System.out.println(map.toString());
                        ExportExcel1.excelPort("D:/jhxml/jhrb/jhrb.xls",map);
                    }


                }

            }

//            List<Element> childrenList = child.getChildren();
//            System.out.println("======获取子节点-start======");
//            for (Element o : childrenList) {
//                System.out.println("节点名:"+o.getName()+"---"+"节点值:"+o.getValue());
//            }
//            System.out.println("======获取子节点-end======");
        }

    }
}
