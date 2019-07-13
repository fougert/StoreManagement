package com.rehoshi.controller;

import com.rehoshi.dto.PageData;
import com.rehoshi.model.User;
import com.rehoshi.service.UserService;
import com.rehoshi.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user",produces = "application/json; charset=utf-8" )
public class UserController {

    @Autowired
    UserService userService ;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public String listInPage(@RequestParam("page") int pageIndex, @RequestParam("limit") int pageSize){
        PageData<User> pageDataRespData = userService.usersInPage("", pageIndex, pageSize);
        return JsonUtil.toJson(pageDataRespData);
    }

}
