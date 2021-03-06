package com.cy.store.controller;

import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDuplicateException;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        //调用业务对象执行注册
        userService.reg(user);
        return new JsonResult<Void>(OK);
    }
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        //调用业务对象的方法执行登录，并获取返回值
        User data = userService.login(username,password);
        //将以上返回值和状态码OK封装到响应结果中并返回
        //登陆成功后，将uid和username存入到HttpSession中
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());
        return new JsonResult<User>(OK, data);
    }

//    @RequestMapping("reg")
//    public JsonResult<Void> reg(User user) {
//        JsonResult<Void> result = new JsonResult<Void>();
//        try{
//            //调用业务对象执行注册
//            userService.reg(user);
//            //响应成功
//            result.setState(200);
//        } catch (UsernameDuplicateException e){
//            //用户名已经被占用
//            result.setState(4000);
//            result.setMessage("用户名已经被占用");
//        } catch (InsertException e){
//            //插入数据异常
//            result.setState(5000);
//            result.setMessage("注册失败，请联系管理员");
//        }
//        return result;
//    }
}
