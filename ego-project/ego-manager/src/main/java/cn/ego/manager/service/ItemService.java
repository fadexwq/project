package cn.ego.manager.service;

import cn.ego.base.pojo.Item;
import cn.ego.base.vo.EUDataGridResult;
import com.baomidou.mybatisplus.service.IService;

public interface ItemService extends IService<Item> {

    /**
     *
     * @param curPage 当前索引
     * @param rows 每页记录数
     * @return 返回EasyUI的vo类型
     */
    EUDataGridResult listAndPage(int curPage,int rows);
}
