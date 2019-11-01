package cn.ego.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping(value = "{page}")
    public String showPage(@PathVariable String page){
        System.out.println("--跳转到--");
        return page;
    }
}
