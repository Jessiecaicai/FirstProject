package hfutonline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import hfutonline.dto.Result;
import hfutonline.entity.User;
import hfutonline.exception.UserException;
import hfutonline.service.UserService;

/**
 * Created by lenovo on 2017/9/10.
 */
@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;
    /**
     * 登录
     * login:(这里用一句话描述这个方法的作用). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author Jessie
     * @return
     * @since JDK 1.8
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //public Result<String> login(
    public Result<String> login(
            //@ModelAttribute User user){
            //System.out.print(user.getId());
            @RequestBody User user,HttpSession session) {
        try {
            userService.login(user);
        } catch (UserException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            return new Result<String>(false, "登录失败", null);
        }

        logger.info("登录成功：" + user);
        return new Result<String>(true, "登录成功", null);
    }

    /**
     * 登录界面
     * index:(这里用一句话描述这个方法的作用). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author huangting
     * @return
     * @since JDK 1.8
     */
   //@ResponseBody
    @RequestMapping(value = "/")
    public String login() {
        return "/login";
    }

    /**
     * 首页
     * home:(这里用一句话描述这个方法的作用). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author huangting
     * @return
     * @since JDK 1.8
     */

    @RequestMapping(value="/admin-main")
    public String home() {
        return "/admin-main";
    }

    @RequestMapping(value="/admin-left")
    public String admin() {
        return "/admin-left";
    }

    @RequestMapping(value="/index")
    public String index() {
        return "/index";
    }

    @RequestMapping(value="/manage")
    public String manage() {
        return "/manage";
    }

    /**
     * 注册
     * register:(这里用一句话描述这个方法的作用). <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     * TODO(这里描述这个方法的执行流程 – 可选).<br/>
     * TODO(这里描述这个方法的使用方法 – 可选).<br/>
     * TODO(这里描述这个方法的注意事项 – 可选).<br/>
     *
     * @author huangting
     * @param user
     * @return
     * @since JDK 1.8
     */
    @RequestMapping(value = "/user/" + "register", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> register(
            @RequestBody User user) {
//logger.info(user.toString());
        try {
            userService.register(user);
        } catch (UserException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            return new Result<String>(false, e.getMessage(), null);
        }
        logger.info("注册成功", user);
        return new Result<String>(true, "注册成功", null);
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
    @ResponseBody
    public Result<List<User>> list() {
        try {
            List<User> list = userService.listAll();
            logger.info("获取新闻列表成功", list);
            return new Result<List<User>>(true, "获取学生列表成功", list);
        } catch (UserException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            return new Result<List<User>>(false, e.getMessage(), null);
        }
    }
}












