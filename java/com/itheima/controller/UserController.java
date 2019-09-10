package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.daomin.User;
import com.itheima.daomin.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/user")

public class UserController {

    // 请求地址  http://localhost:8080/user/quick
    @RequestMapping(value = "/quick", method = RequestMethod.GET)  // 请求映射  method  请求方式
    public String save() {
        System.out.println("Controller save running....");
        return "success";   //前面加斜杠 代表在 wepapp 下找资源
    }


    @RequestMapping(value = "/quick2")  // 请求映射  method  请求方式
    public ModelAndView save2() {
        /*Model  :模型用于封装数据
         * View   :视图 作用展示数据
         * */
        ModelAndView modelAndView = new ModelAndView();
        // 设置视图名称
        modelAndView.setViewName("success");
        // 设置模型数据
        modelAndView.addObject("username", "itcast");
        return modelAndView;
    }

    @RequestMapping(value = "/quick3")  // 请求映射  method  请求方式
    public ModelAndView save3(ModelAndView modelAndView) {
        /*Model  :模型用于封装数据
         * View   :视图 作用展示数据
         * */
        // 设置视图名称
        modelAndView.setViewName("success");
        // 设置模型数据
        modelAndView.addObject("username", "我是你爸爸");
        return modelAndView;
    }

    @RequestMapping(value = "/quick4")  // 请求映射  method  请求方式
    public String save4(Model model) {
        /*Model  :模型用于封装数据
         * View   :视图 作用展示数据
         * */
        // 设置视图名称
        // 设置模型数据
        model.addAttribute("username", "你是我儿子");
        return "success";
    }

    // 不常用
    @RequestMapping(value = "/quick5")  // 请求映射  method  请求方式
    public String save5(HttpServletRequest request) {
        /*Model  :模型用于封装数据
         * View   :视图 作用展示数据
         * */
        // 设置视图名称
        // 设置模型数据
        request.setAttribute("username", "胡八一");
        return "success";

    }

    @RequestMapping(value = "/quick6")  // 请求映射  method  请求方式
    public void save6(HttpServletResponse response) throws IOException {
        /*Model  :模型用于封装数据
         * View   :视图 作用展示数据
         * */
        // 设置视图名称
        // 设置模型数据
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("大傻逼");
    }

    @RequestMapping(value = "/quick7")  // 请求映射  method  请求方式
    @ResponseBody
    // 告诉spring不要进行跳转  直接回显
    public String save7() throws IOException {
        /*Model  :模型用于封装数据
         * View   :视图 作用展示数据
         * */
        // 设置视图名称
        // 设置模型数据
        // 跳转 /jsp/sdfsdfsadgf.jsp   错误
        // 显示 字符 告诉Spring
        return "sdfsdfsadgf";
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() {
        return "{\"username\":\"张三\",\"age\":18}";
    }

    @RequestMapping(value = "/quick9", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String save9() throws Exception {
        User user = new User();
        user.setAge(18);
        user.setUsername("王祖贤");
        // 使用json 的转换工具  到坐标
        // 讲对象转换为字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);
        return s;
    }

    @RequestMapping(value = "/quick11", produces = "application/json; charset=utf-8")
    @ResponseBody
    // 不进行页面跳转
    public void save11(User user) throws Exception {
        user.setUsername("zhangsan");
        user.setAge(18);
        System.out.println(user);
    }

    @RequestMapping(value = "/quick13", produces = "application/json; charset=utf-8")
    @ResponseBody
    // 不进行页面跳转
    public void save13( String[] strings) throws Exception {
        System.out.println(Arrays.asList(strings));
    }

    @RequestMapping(value ="/quick14")
    @ResponseBody
    // 不进行页面跳转
    public void save14(VO vo) throws Exception {
        System.out.println(vo);

    }

    @RequestMapping(value ="/quick15",produces =  "application/json; charset=utf-8")
    @ResponseBody
    // 不进行页面跳转
    //RequestBody 请求体
    public void save15(@RequestBody List<User> userList) throws Exception {
        System.out.println(userList);

    }

    @RequestMapping(value ="/quick16")
    @ResponseBody
    // 不进行页面跳转
    public void save16(@RequestParam(value = "name",required = false,defaultValue = "大傻逼") String username) throws Exception {
        System.out.println(username);

    }
    @RequestMapping(value ="/quick17")
    @ResponseBody
    // 不进行页面跳转
    public void save17(@RequestHeader(value = "User-Agent",required = false) String jessionis) throws Exception {
        System.out.println(jessionis);

    }

    @RequestMapping(value ="/quick18")
    @ResponseBody
    // 不进行页面跳转
    public void save18(@CookieValue(value = "JSESSIONID",required = false) String jessionis) throws Exception {
        System.out.println(jessionis);

    }

    @RequestMapping(value ="/quick22")
    @ResponseBody
    // 不进行页面跳转
    public void save22(String username, MultipartFile[] multipartFile) throws Exception {

        System.out.println(username);
        // 获取原文件名
        for (MultipartFile file : multipartFile) {
            String originalFilename = file.getOriginalFilename();
            file.transferTo(new File("E:\\transferTo\\"+originalFilename));
        }

        //


    }
}
