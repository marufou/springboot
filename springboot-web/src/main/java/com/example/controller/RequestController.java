package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("message","成功了");
        request.setAttribute("code",200);
        return "forward:/success";
    }
    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest request){
        Object msg1 = request.getAttribute("msg");
        Map<String,Object>map = new HashMap();
        map.put("requestMethod_msg",msg1);
        map.put("annotation",msg);
        return  map;
    }
//    /cars/sell;low=34;brand=byd,audi,yd"
//    2.SpringBoot默认是禁用了矩阵变量的功能
//    手动开启
//
    @GetMapping("/cars/sell")
    public Map carsSell(@MatrixVariable("low") Integer low, @MatrixVariable("brand") List<String> brand){
        Map<String,Object> map = new HashMap();
        map.put("low",low);
        map.put("brand",brand);
        return map;
    }
}
