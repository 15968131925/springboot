package com.cql.springbootwebrestfulcurd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    @RequestMapping("/success")
    public String success(HttpServletResponse httpServletResponse, Map map) {
        map.put("hello","<h1>hi</h1>");
        map.put("users","me");
        return "success";
    }
  /*  @RequestMapping({"/","/login.html"})
    public String index() {
        return "index";
    }*/

}

