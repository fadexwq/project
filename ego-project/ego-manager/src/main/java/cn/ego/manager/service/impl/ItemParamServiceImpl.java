package cn.ego.manager.service.impl;

import cn.ego.base.mapper.ItemParamMapper;
import cn.ego.base.pojo.ItemParam;
import cn.ego.base.vo.EgoResult;
import cn.ego.manager.service.ItemParamService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemParamServiceImpl extends ServiceImpl<ItemParamMapper, ItemParam> implements ItemParamService {


    @Override
    public EgoResult findItemParamByItemCatId(Long itemCatId) {
        //第一：获得数据
        EntityWrapper<ItemParam> wrapper = new EntityWrapper<>();
        wrapper.eq("item_cat_id",itemCatId);
        List<ItemParam> itemParams = this.selectList(wrapper);

        if (itemParams!=null && itemParams.size()>0){
            //第二：封装数据
            return EgoResult.ok(itemParams);
        }else {
            return EgoResult.build(400,"查询不到规格项模板数据");
        }

    }
}
