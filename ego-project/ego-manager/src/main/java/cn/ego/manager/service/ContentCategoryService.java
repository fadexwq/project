package cn.ego.manager.service;

import cn.ego.base.pojo.ContentCategory;
import cn.ego.base.vo.EUTreeNode;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

public interface ContentCategoryService extends IService<ContentCategory> {

    /**
     * 通过父编号，返回异步树的节点数据
     * @param parentId
     * @return
     */
    List<EUTreeNode> selectByParentId(Long parentId);
}
