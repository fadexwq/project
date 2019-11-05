package cn.ego.manager.service;

import cn.ego.base.pojo.Item;
import cn.ego.base.vo.EUDataGridResult;
import cn.ego.base.vo.EgoResult;
import com.baomidou.mybatisplus.service.IService;

public interface ItemService extends IService<Item> {

    /**
     * 分页查询，返回结果
     * @param curPage 当前索引
     * @param rows 每页记录数
     * @return 返回EasyUI的vo类型
     */
    EUDataGridResult listAndPage(int curPage,int rows);

    /**
     * 保存商品数据
     * @param item
     * @param desc
     * @param paramData
     * @return
     */
    EgoResult save(Item item, String desc, String paramData);
}
