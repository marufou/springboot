package com.example.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求参数
 * @注解
 * @PathVariable @RequestHeader @ModelAttribute @RequestParam @MatrixVariable @CookieValue @RequestBody
 *
 * Servlet API
 */
@RestController
public class ParamsController {
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String ,Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username")  String name,
                                      @PathVariable Map<String,String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String,String>header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam Map<String,String> params,
                                      @CookieValue("_ga") String _ga,
                                      @CookieValue("_ga") Cookie cookie){
        Map<String,Object>  map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        map.put("userAgent",userAgent);
        map.put("headers",header);
        return map ;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer  low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object>map = new HashMap();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }
}
