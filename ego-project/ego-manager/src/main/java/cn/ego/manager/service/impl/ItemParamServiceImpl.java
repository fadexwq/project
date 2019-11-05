package cn.ego.manager.service.impl;

import cn.ego.base.mapper.ItemParamMapper;
import cn.ego.base.pojo.ItemParam;
import cn.ego.base.vo.EUDataGridResult;
import cn.ego.base.vo.EgoResult;
import cn.ego.manager.service.ItemParamService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItemParamServiceImpl extends ServiceImpl<ItemParamMapper, ItemParam> implements ItemParamService {

    @Autowired
    private ItemParamMapper itemParamMapper;

    @Override
    public EgoResult findItemParamByItemCatId(Long itemCatId) {
        //第一：获得数据
        EntityWrapper<ItemParam> wrapper = new EntityWrapper<>();
        wrapper.eq("item_cat_id",itemCatId);
        List<ItemParam> itemParams = this.selectList(wrapper);

        if (itemParams!=null && itemParams.size()>0){
            //第二：封装数据
            return EgoResult.ok(itemParams.get(0));
        }else {
            return EgoResult.build(400,"查询不到规格项模板数据");
        }

    }

    @Override
    @Transactional//声明事务代理方法，不能捕捉异常
    public EgoResult save(Long catId, String paramData) {
        //第一：封装数据
        ItemParam itemParam = new ItemParam();
        itemParam.setCreated(new Date());
        itemParam.setItemCatId(catId);
        itemParam.setParamData(paramData);
        itemParam.setUpdated(itemParam.getCreated());

        //第二：插入数据
        this.insert(itemParam);
        return EgoResult.ok();
    }

    @Override
    public EUDataGridResult listAndPage(int curPage, int pageSize) {
        //第一步：构建返回对象
        EUDataGridResult result = new EUDataGridResult();
        //获得数据
        int start = (curPage-1) * pageSize;
        List<Map<String, Object>> maps = itemParamMapper.listAndPage(start, pageSize);

        Integer count = itemParamMapper.selectCount(null);
        //封装数据
        result.setRows(maps);
        result.setTotal(count);
        return result;
    }
}
