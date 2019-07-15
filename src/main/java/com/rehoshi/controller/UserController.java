package com.rehoshi.controller;

import com.rehoshi.model.User;
import com.rehoshi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/user",produces = "application/json; charset=utf-8" )
public class UserController extends BaseController{

    @Autowired
    UserService userService ;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public String login(User user){
        return $(userService.login(user)) ;
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public String listInPage(@RequestParam("page") int pageIndex, @RequestParam("limit") int pageSize){
        return $(userService.usersInPage("", pageIndex, pageSize));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(User user){
        return $(userService.save(user)) ;
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public String update(User user){
        return $(userService.update(user)) ;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable String id){
        return $(userService.deleteById(id)) ;
    }

    @RequestMapping(value = "deleteAll/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteAll(@PathVariable String ids){
        String[] split = ids.split(",");
        List<String> idList = Arrays.asList(split);
        return $(userService.deleteInIds(idList)) ;
    }

}
