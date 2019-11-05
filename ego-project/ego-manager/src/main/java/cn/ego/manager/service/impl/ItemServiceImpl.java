package cn.ego.manager.service.impl;

import cn.ego.base.mapper.ItemDescMapper;
import cn.ego.base.mapper.ItemMapper;
import cn.ego.base.mapper.ItemParamItemMapper;
import cn.ego.base.pojo.Item;
import cn.ego.base.pojo.ItemDesc;
import cn.ego.base.pojo.ItemParamItem;
import cn.ego.base.utils.IDUtils;
import cn.ego.base.vo.EUDataGridResult;
import cn.ego.base.vo.EgoResult;
import cn.ego.manager.service.ItemService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper,Item> implements ItemService {

    @Autowired
    private ItemDescMapper itemDescMapper;

    @Autowired
    private ItemParamItemMapper itemParamItemMapper;


    @Override
    public EUDataGridResult listAndPage(int curPage, int rows) {

        EUDataGridResult result = new EUDataGridResult();
        Page<Item> page = this.selectPage(new Page<Item>(curPage, rows));
        result.setTotal(page.getTotal());
        result.setRows(page.getRecords());
        return result;
    }

    @Transactional
    @Override
    public EgoResult save(Item item, String desc, String paramData) {
        //第一步：补全需要设置的属性
        long itemId = IDUtils.genItemId();
        item.setStatus(1);
        item.setId(itemId);
        item.setCreated(new Date());
        item.setUpdated(item.getCreated());
        this.insert(item);

        //第二步：插入商品详情
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(item.getCreated());
        itemDesc.setUpdated(item.getUpdated());
        itemDescMapper.insert(itemDesc);

        //第三步：插入商品规格值
        ItemParamItem itemParamItem = new ItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(paramData);
        itemParamItem.setCreated(item.getCreated());
        itemParamItem.setUpdated(item.getUpdated());
        itemParamItemMapper.insert(itemParamItem);

        return EgoResult.ok();
    }
}


















