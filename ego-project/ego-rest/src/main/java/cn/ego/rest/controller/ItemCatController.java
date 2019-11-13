package cn.ego.rest.controller;

import cn.ego.base.vo.ItemMenu;
import cn.ego.base.vo.JsonUtils;
import cn.ego.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "/item/all",produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public String getMenu(String callback){

        ItemMenu menu = new ItemMenu();
        String jsonMenu = JsonUtils.objectToJson(menu);
        String jsMenu = callback+"("+jsonMenu+")";
        return jsMenu;
    }
}



















