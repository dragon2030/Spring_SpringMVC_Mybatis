package com.bigDragon.controller;

import com.alibaba.fastjson.JSONObject;
import com.bigDragon.model.User;
import com.bigDragon.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bigDragon
 * @create 2021-02-06 10:59
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /**
     * 打开主页面
     * @return
     */
    @RequestMapping(value = "/main")
    public ModelAndView main(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userOperation");
        return modelAndView;
    }


    @RequestMapping(value = "/findById")
    @ResponseBody
    public String findById(@RequestBody String json){
        logger.info("测试ajax中参数contentType请求数据："+json);
        JSONObject jsonObject = JSONObject.parseObject(json);
        int userId = Integer.parseInt(String.valueOf(jsonObject.get("userId")));
        User user = userService.findById(userId);
        logger.info(user.toString());
        return user.toString();
    }

}
