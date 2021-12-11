package com.wangfugui.mybatisplus.controller;

import com.wangfugui.mybatisplus.dao.domain.User;
import com.wangfugui.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/12/11
 * @since JDK 1.8.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public String insert(@RequestBody User user) {
        return userService.insert(user);

    }


    @PostMapping("/update")
    public String update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/getOne")
    public User getOne(@RequestParam Integer id) {
        return userService.getOne(id);
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        return userService.delete(id);
    }

}
