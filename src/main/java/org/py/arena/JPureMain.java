package org.py.arena;

import org.py.arena.controller.IndexController;
import org.py.jpure.context.WebRootResolver;
import org.py.jpure.core.model.JPureMap;
import org.py.jpure.support.controller.Controller;
import org.py.jpure.web.AbstractHttpApi;

/**
 * @author pythagoras
 * @version 0.1
 * 2019
 * 系统入口程序
 *      设置系统配置文件，配置系统参数
 *      注册自定义3大组件
 *      在DispatcherServlet中插入自定义代码
 *      设置拦截器
 * 本类会在系统启动前初始化
 * */
public class JPureMain extends AbstractHttpApi {
    /**
     * @param webRootResolver 用于注册HttpServlet 3大组件
     * 注册自定义 HttpServlet 组件
     * listener, servlet, filter
     * */
    @Override
    public void startup(WebRootResolver webRootResolver) {

    }

    /**
     * 初始化配置文件
     * */
    @Override
    public void initialize() {

    }

    /**
     * 注册控制器
     * */
    @Override
    public JPureMap<String, Class<? extends Controller>> controllerMap() {
        controllerMap.put("/index", IndexController.class);
        return super.controllerMap();
    }

    /**
     * 在DispatcherServlet中执行自定义操作
     * */
    @Override
    public void body() {
        System.out.println("body in JPureMain.");
    }
}
