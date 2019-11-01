package cn.ego.manager.service.impl;

import cn.ego.base.mapper.ItemMapper;
import cn.ego.base.pojo.Item;
import cn.ego.manager.service.ItemService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper,Item> implements ItemService {
}
