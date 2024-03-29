package cn.ego.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/index")
    public String showPage(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable("page")String page){
        return page;
    }

}
