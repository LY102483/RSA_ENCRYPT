package com.demo.controller;

import com.demo.entity.Account;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import org.json.JSONObject;

/**
 * Create by LiuYang on 2022/5/20 13:54
 */
@Path(value = "/login", viewPath = "/login")
public class LoginController extends Controller {

    public void index() {
        render("login.jsp");
    }


    //登陆方法
    public void login() {
        boolean flag = false;
        String msg = "";
        JSONObject json = new JSONObject();
        String name = getPara("name");//获取表单数据，这里的参数就是页面表单中的name属性值
        String password = getPara("password");
        Account item = Account.dao.findFirst("select * from account where username=?", name);//根据用户名查询数据库中的用户
        if (item != null) {
            if (password.equals(item.getStr("password"))) {//判断数据库中的密码与用户输入的密码是否一致
                flag = true;
                setSessionAttr("nickname", item.getStr("username"));//设置session，保存登陆用户的昵称
            } else {
                msg = "密码不正确";
            }
        } else {
            msg = "账号不存在";
        }
        json.put("flag", flag);
        json.put("msg", msg);
        renderJson(json);
    }

    //登陆成功后的跳转方法(重定向)
    public void manage() {
        redirect("/");
    }
}
