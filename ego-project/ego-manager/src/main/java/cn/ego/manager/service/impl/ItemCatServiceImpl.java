package cn.ego.manager.service.impl;

import cn.ego.base.mapper.ItemCatMapper;
import cn.ego.base.pojo.ItemCat;
import cn.ego.base.vo.EUTreeNode;
import cn.ego.manager.service.ItemCatService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl extends ServiceImpl<ItemCatMapper, ItemCat> implements ItemCatService {


    @Override
    public List<EUTreeNode> getByParentId(Long parentId) {

        List<EUTreeNode> nodes = new ArrayList<>();
        EntityWrapper<ItemCat> wrapper = new EntityWrapper<>();
        wrapper.eq("parent_id",parentId);
        List<ItemCat> itemCats = this.selectList(wrapper);
        for (ItemCat itemCat : itemCats) {
            EUTreeNode node = new EUTreeNode();
            node.setId(itemCat.getId());
            node.setText(itemCat.getName());
            if (itemCat.getIsParent()==1){
                node.setState("closed");
            }else {
                node.setState("open");
            }
            nodes.add(node);
        }
        return nodes;
    }
}
