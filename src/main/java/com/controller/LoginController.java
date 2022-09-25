package com.controller;

import javax.servlet.http.HttpSession;

import com.bean.Admin;
import com.bean.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bean.User;
import com.service.LoginService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 用户控制器类
 */
@Controller
public class LoginController {
    // 依赖注入
    @Autowired
    private LoginService loginService;

    /**
     * 用户登录test
     */
    @RequestMapping(value = "/loginTest.action", method = RequestMethod.POST)
    public String loginTest(String username, String password, String user_role, Model model, RedirectAttributes attr,
                        HttpSession session) {
        if (user_role.equals("个人")) {
            // 通过账号和密码查询用户
            User user = loginService.findUser(username, password);
            if (user != null) {
                // 将用户对象添加到Session
                session.setAttribute("USER_SESSION", 1);
                // 跳转到主页面
                return "redirect:company/mainTest.action";
            } else {
                System.out.println("登录失败");
                model.addAttribute("msg", "账号或密码错误，请重新输入！");
                // 返回到登录页面
                return "login-test";
            }
        } else if (user_role.equals("企业")) {
            Enterprise enterprise = loginService.findEn(username, password);
            if (enterprise != null) {
                // 将用户对象添加到Session
                session.setAttribute("USER_SESSION", 1);
                // 跳转到主页面
                return "redirect:company/mainTest.action";
            } else {
                System.out.println("登录失败");
                model.addAttribute("msg", "账号或密码错误，请重新输入！");
                // 返回到登录页面
                return "login-test";
            }
        } else {
            Admin admin = loginService.findAd(username, password);
            if (admin != null) {
                // 将用户对象添加到Session
                session.setAttribute("USER_SESSION", 1);
                // 跳转到主页面
                return "redirect:company/mainTest.action";
            } else {
                System.out.println("登录失败");
                model.addAttribute("msg", "账号或密码错误，请重新输入！");
                // 返回到登录页面
                return "login-test";
            }
        }
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String login(String username, String password, String user_role, Model model, RedirectAttributes attr,
                        HttpSession session) {
        if (user_role.equals("个人")) {
            // 通过账号和密码查询用户
            User user = loginService.findUser(username, password);
            if (user != null) {
                // 将用户对象添加到Session
                session.setAttribute("USER_SESSION", 1);
                //获取user_id并传值
                int user_id = user.getUser_id();
                attr.addAttribute("user_id", user_id);
                // 跳转到主页面
                return "redirect:company/userList.action";
            } else {
                System.out.println("登录失败");
                model.addAttribute("msg", "账号或密码错误，请重新输入！");
                // 返回到登录页面
                return "login-test";
            }
        } else if (user_role.equals("企业")) {
            Enterprise enterprise = loginService.findEn(username, password);
            if (enterprise != null) {
                // 将用户对象添加到Session
                session.setAttribute("USER_SESSION", 1);
                attr.addAttribute("en_id", enterprise.getEn_id());
                // 跳转到主页面
                return "redirect:company/enterpriseList.action";
            } else {
                System.out.println("登录失败");
                model.addAttribute("msg", "账号或密码错误，请重新输入！");
                // 返回到登录页面
                return "login-test";
            }
        } else {
            Admin admin = loginService.findAd(username, password);
            if (admin != null) {
                // 将用户对象添加到Session
                session.setAttribute("USER_SESSION", 1);
                // 跳转到主页面
                return "redirect:company/adminList.action";
            } else {
                System.out.println("登录失败");
                model.addAttribute("msg", "账号或密码错误，请重新输入！");
                // 返回到登录页面
                return "login-test";
            }
        }
    }

    /**
     * 用户注册
     */
    @RequestMapping(value = "/register.action", method = RequestMethod.POST)
    public String register(String username, String password, String user_role, Model model) {
        if (user_role.equals("个人")) {
            // 通过账号和密码查询用户
            User user = loginService.findUser(username, password);
            if (user == null) {
                loginService.addUser(username, password);
                model.addAttribute("msg", "注册成功！");
                //返回登录页面
                return "login-test";
            } else {
                model.addAttribute("msg", "用户已注册！");
                //返回注册页面
                return "register";
            }
        } else {
            // 通过账号和密码查询用户
            Enterprise enterprise = loginService.findEn(username, password);
            if (enterprise == null) {
                loginService.addEn(username, password);
                model.addAttribute("msg", "注册成功！");
                //返回登录页面
                return "login-test";
            } else {
                model.addAttribute("msg", "用户已注册！");
                //返回注册页面
                return "register";
            }
        }
    }

    /**
     * 模拟其他类中跳转到客户管理页面的方法
     */
    @RequestMapping(value = "/toCompany.action")
    public String toCompany() {
        return "admin";
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session) {
        // 清除Session
        session.invalidate();
        // 重定向到登录页面的跳转方法
        return "redirect:login.action";
    }

    /**
     * 向用户登陆页面跳转
     */
    @RequestMapping(value = "/login.action", method = RequestMethod.GET)
    public String toLogin() {
        return "login-test";
    }

}
