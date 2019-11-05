package cn.ego.manager.service;

import cn.ego.base.pojo.ItemParam;
import cn.ego.base.vo.EUDataGridResult;
import cn.ego.base.vo.EgoResult;
import com.baomidou.mybatisplus.service.IService;


public interface ItemParamService extends IService<ItemParam> {

    /**
     * 通过类目编号查询对应的参数模板记录
     * @param itemCatId
     * @return
     */
    EgoResult findItemParamByItemCatId(Long itemCatId);

    /**
     * 保存规格模板
     * @param catId
     * @param paramData
     * @return
     */
    EgoResult save(Long catId,String paramData);

    /**
     * 分页查询规格模板的列表
     * @param curPage
     * @param pageSize
     * @return
     */
    EUDataGridResult listAndPage(int curPage, int pageSize);

}
