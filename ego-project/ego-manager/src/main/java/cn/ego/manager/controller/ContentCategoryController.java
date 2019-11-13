package cn.ego.manager.controller;

import cn.ego.base.vo.EUTreeNode;
import cn.ego.manager.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @GetMapping(value = "/list")
    public List<EUTreeNode> selectByParentId(@RequestParam(name = "id",defaultValue = "0")Long parentId){
        return contentCategoryService.selectByParentId(parentId);
    }
}















