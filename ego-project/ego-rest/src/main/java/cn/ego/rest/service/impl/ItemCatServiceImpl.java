package cn.ego.rest.service.impl;

import cn.ego.base.mapper.ItemCatMapper;
import cn.ego.base.pojo.ItemCat;
import cn.ego.base.vo.ItemMenu;
import cn.ego.base.vo.MenuNode;
import cn.ego.rest.service.ItemCatService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public ItemMenu initItemMenu() {
        ItemMenu menu = new ItemMenu();
        List nodes = this.getNodesByParentId(0L);
        menu.setData(nodes);
        return menu;
    }

    /**
     * 通过递归算法，实现将商品类目表，全部数据遍历，形成一个树结构的集合。
     * @param parentId
     * @return
     */
    private List getNodesByParentId(long parentId){
        //第一步：构建返回对象
        List nodes=new ArrayList();

        //第二步：构建结合的数据（递归获得树状数据）

        EntityWrapper<ItemCat> wrapper=new EntityWrapper<>();
        wrapper.eq("parent_id", parentId);
        List<ItemCat> itemCats = itemCatMapper.selectList(wrapper); //

        for (ItemCat itemCat : itemCats) {
            MenuNode node=new MenuNode();
            node.setU("/products/"+itemCat.getId()+".html");
            node.setN(itemCat.getName());
            if (itemCat.getIsParent()==1){
                //注意事项：方法调用本身，当次方法结束了吗？
                //答：都没有执行到return关键字，所以并没结束。计算内存里面。只是使用同样的逻辑，在内存完成其他的操作而已。
                List i = this.getNodesByParentId(itemCat.getId());
                node.setI(i);
                nodes.add(node);
            }else {
                nodes.add("/products/"+itemCat.getId()+".html|"+itemCat.getName());
            }
        }
        //返回结果
        return nodes;
    }
}


















