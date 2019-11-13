package cn.ego.rest.service;

import cn.ego.base.vo.ItemMenu;

public interface ItemCatService {

    /**
     * 构建一个菜单树
     * @return
     */
    ItemMenu initItemMenu();
}
