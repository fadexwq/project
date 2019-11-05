package cn.ego.manager.controller;


import cn.ego.base.vo.EUDataGridResult;
import cn.ego.base.vo.EgoResult;
import cn.ego.manager.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    /**
     * 保存规格模板
     * @param catId
     * @param paramData
     * @return
     */
    @PostMapping("/save/{catId}")
    public EgoResult save(@PathVariable("catId")Long catId,String paramData){

        try {
            return itemParamService.save(catId,paramData);
        } catch (Exception e) {
            e.printStackTrace();
            return EgoResult.build(400,"保存规格模板失败");
        }
    }


    /**
     * 查询规格模板列表
     * @param page
     * @param rows
     * @return
     */
    public EUDataGridResult listAndPage(Integer page, Integer rows){
        EUDataGridResult result = itemParamService.listAndPage(page, rows);
        return result;
    }







}
