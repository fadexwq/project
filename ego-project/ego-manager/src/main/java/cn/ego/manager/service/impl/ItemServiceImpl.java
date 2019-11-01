package cn.ego.manager.service.impl;

import cn.ego.base.mapper.ItemMapper;
import cn.ego.base.pojo.Item;
import cn.ego.base.vo.EUDataGridResult;
import cn.ego.manager.service.ItemService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper,Item> implements ItemService {
    @Override
    public EUDataGridResult listAndPage(int curPage, int rows) {

        EUDataGridResult result = new EUDataGridResult();
        Page<Item> page = this.selectPage(new Page<Item>(curPage, rows));
        result.setTotal(page.getTotal());
        result.setRows(page.getRecords());
        return result;
    }
}
