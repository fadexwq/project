package cn.ego.manager.service.impl;

import cn.ego.base.mapper.ContentCategoryMapper;
import cn.ego.base.pojo.ContentCategory;
import cn.ego.base.vo.EUTreeNode;
import cn.ego.manager.service.ContentCategoryService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentCategoryServiceImpl extends ServiceImpl<ContentCategoryMapper, ContentCategory> implements ContentCategoryService {


    @Override
    public List<EUTreeNode> selectByParentId(Long parentId) {
        //构建返回对象
        List<EUTreeNode> nodes = new ArrayList<>();

        //获得数据
        EntityWrapper<ContentCategory> wrapper = new EntityWrapper<>();
        wrapper.eq("parent_id",parentId);
        List<ContentCategory> contentCategories = this.selectList(wrapper);

        //封装数据
        for (ContentCategory contentCategory : contentCategories) {
            EUTreeNode node = new EUTreeNode();
            node.setId(contentCategory.getId());
            node.setText(contentCategory.getName());
            if (contentCategory.getIsParent() == 1){
                node.setState("close");
            }else {
                node.setState("open");
            }
            nodes.add(node);
        }
        return nodes;
    }
}
