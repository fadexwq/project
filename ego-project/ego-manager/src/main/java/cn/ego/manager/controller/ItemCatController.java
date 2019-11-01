package cn.ego.manager.controller;

import cn.ego.base.vo.EUTreeNode;
import cn.ego.manager.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @PostMapping(value = "/list")
    public List<EUTreeNode> initTreeByParentId(@RequestParam(defaultValue = "0") Long id){
        return itemCatService.getByParentId(id);
    }


}












