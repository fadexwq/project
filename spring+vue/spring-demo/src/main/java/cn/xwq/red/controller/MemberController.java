package cn.xwq.red.controller;

import cn.xwq.red.dto.ExecuteDTO;
import cn.xwq.red.dto.PageQueryParamDTO;
import cn.xwq.red.dto.PageResultDTO;
import cn.xwq.red.mapper.MemberMapper;
import cn.xwq.red.pojo.Member;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberMapper mapper;

    @GetMapping("get/{id}")
    public Member get(@PathVariable Integer id){
        return mapper.selectById(id);
    }

    @PostMapping("save")
    public ExecuteDTO save(@RequestBody Member entity){
        if (entity.getDate() == null){
            entity.setDate(new Date());
        }
        mapper.insert(entity);
        return new ExecuteDTO(true,"保存成功",entity.getId());
    }

    @PostMapping("loadPage")
    public PageResultDTO loadPage(@RequestBody PageQueryParamDTO params){
        Page<Member> page = new Page<>(params.getPage(),params.getSize());
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        if (params.getQuery() != null){
            wrapper.like("name",params.getQuery());
        }else {
            wrapper = null;
        }
        IPage<Member> iPage = mapper.selectPage(page, wrapper);
        System.out.println("当前页数"+params.getPage()+"每页容量"+params.getSize());
        return new PageResultDTO(iPage.getTotal(),iPage.getRecords());

    }


    @GetMapping("remove/{id}")
    public ExecuteDTO remove(@PathVariable Integer id) {
        mapper.deleteById(id);
        return new ExecuteDTO(true, "删除成功", id);
    }

}
