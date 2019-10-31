package org.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supermarket.pojo.*;
import org.supermarket.serviceImpl.UserServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @PostMapping("/login")
    public String login(TbUser user, HttpSession session){
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());

        int status=userService.loginUser(user);
        if(status==1) {
            System.out.println(">>>>>>>>>>>>>>>>>login");
            session.setAttribute("username",user.getUsername());
            return "redirect:/dashboard/todashboard";
        }else{
            return "index";
        }
    }

    @GetMapping("/toregister")
    public String toRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(TbUser user,String token,Model model){
        if(!token.equals("ligengnan")){
            System.out.println(token);
            model.addAttribute("error","请输入正确的注册令牌");
            return "error";
        }else{
            Integer status = userService.registerUser(user);
            if(status==1){
                return "redirect:/";
            }else{
                return "register";
            }
        }
    }
}
