package cn.ego.manager.controller;

import cn.ego.base.pojo.Item;
import cn.ego.base.vo.EUDataGridResult;
import cn.ego.base.vo.EgoResult;
import cn.ego.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/save")
    public EgoResult save(Item item, String desc, String itemParams){

        EgoResult result = null;
        try {
            return itemService.save(item, desc, itemParams);
        } catch (Exception e) {
            e.printStackTrace();
            return EgoResult.build(400,"保存失败");
        }
    }










}






