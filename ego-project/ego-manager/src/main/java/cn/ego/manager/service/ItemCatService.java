package cn.ego.manager.service;

import cn.ego.base.pojo.ItemCat;
import cn.ego.base.vo.EUTreeNode;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

public interface ItemCatService extends IService<ItemCat> {

    List<EUTreeNode> getByParentId(Long parentId);
}
