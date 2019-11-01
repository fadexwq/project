package cn.ego.manager.controller;

import cn.ego.base.pojo.Item;
import cn.ego.base.vo.EUDataGridResult;
import cn.ego.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/{id}")
    public Item getById(@PathVariable("id")Long id){
        Item item = itemService.selectById(id);
        return item;
    }

    @GetMapping(value = "/list")
    public EUDataGridResult list(int page,int rows){
        try {
            return itemService.listAndPage(page, rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
        EUDataGridResult result = new EUDataGridResult();
        result.setTotal(0);
        result.setRows(null);
        return result;
    }
}






