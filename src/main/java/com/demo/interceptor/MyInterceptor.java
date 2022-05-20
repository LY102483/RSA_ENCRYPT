package com.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

import static io.undertow.Handlers.redirect;

public class MyInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        String username = controller.getSessionAttr("nickname");
        // 用户如果没有登录，那么就跳转到登录页面
        if (username == null || username.equals("")) {
            inv.getController().redirect("/login");
        } else {
            inv.invoke();
        }
    }
}