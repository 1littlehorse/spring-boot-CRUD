package com.zohar.springboot.controller;



import com.zohar.springboot.entity.User;
import com.zohar.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

// 5、设置控制层
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserRepository userRepository;




    @RequestMapping("") // user列表 分页 从0开始分页
    public ModelAndView userlist(@RequestParam(value = "start",defaultValue = "0") Integer start,
                                 @RequestParam(value = "limit",defaultValue = "4") Integer limit){
        start = start < 0 ? 0 : start;
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(start, limit, sort);
        Page<User> page = userRepository.findAll(pageable);
        ModelAndView mav = new ModelAndView("user/list");
        mav.addObject("page", page);
        return mav;
    }


    // 新增保存方法
    @PostMapping("")
    public String add(User model)  throws Exception{
        userRepository.save(model);
        return "redirect:/user/";
    }

    // 删除
    @PostMapping("/{id}")
    public String del(@PathVariable("id") long id){
        userRepository.deleteById(id);
        return "redirect:";
    }

    // 修改
    @PostMapping("/edit/{id}")
    public String edit(User model, long id){
        model.setId(id);
        userRepository.save(model);
        return "redirect:/user";
    }

    // 查询
    @PostMapping(value = "/q")
    public ModelAndView getUser(String name){
        List<User> users = userRepository.findByName(name);
        ModelAndView mav = new ModelAndView("user/query");
        mav.addObject("user",users);
        return mav;
    }












}
