package cn.ego.manager.service;

import cn.ego.base.pojo.ItemParam;
import cn.ego.base.vo.EgoResult;
import com.baomidou.mybatisplus.service.IService;


public interface ItemParamService extends IService<ItemParam> {

    EgoResult findItemParamByItemCatId(Long itemCatId);

}
