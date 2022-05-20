package com.demo.controller;

import com.demo.entity.Account;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import org.json.JSONObject;

@Path(value = "/register", viewPath = "/register")
public class RegisterController extends Controller {

    public void index() {
        render("register.jsp");
    }


    //注册
    public void register() {
        boolean flag = false;
        String msg = "";
        JSONObject json = new JSONObject();
        String username = getPara("username");//获取表单数据，这里的参数就是页面表单中的name属性值
        String password = getPara("password");

        Account item = Account.dao.findFirst("select * from account where username=?", username);//根据用户名查询数据库中的用户
        if (item != null) {
            msg = "账号已存在";
        } else {
            Record rd = new Record().set("password", password).set("username",username);
            boolean res=false;//用来判断注册是否成功
            try {
                res=Db.save("account", rd);
            }catch (Exception e){

            }
            if(res){
                setSessionAttr("nickname", username);//设置session，保存登陆用户的昵称
                flag=true;
            }else{
                msg = "注册失败";
            }
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
