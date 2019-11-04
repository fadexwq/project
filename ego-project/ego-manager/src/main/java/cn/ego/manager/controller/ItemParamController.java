package cn.ego.manager.controller;


import cn.ego.base.vo.EgoResult;
import cn.ego.manager.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item/param/")
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;


    /**
     * 通过类目编号查询对应的规格模板
     * @param itemCatId
     * @return
     */
    @GetMapping(value = "/query/itemcatid/{itemCatId}")
    public EgoResult findItemParamByItemCatId(@PathVariable Long itemCatId){

        return itemParamService.findItemParamByItemCatId(itemCatId);
    }
}
