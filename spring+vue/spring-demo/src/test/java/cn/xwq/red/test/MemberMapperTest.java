package cn.xwq.red.test;

import cn.xwq.red.mapper.MemberMapper;
import cn.xwq.red.pojo.Member;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;


    @Test
    public void selectPage(){
        Page<Member> page = new Page<>(1,7);
//        QueryWrapper<Member> wrapper = new QueryWrapper<>();
//        wrapper.like("","");
        IPage<Member> iPage = memberMapper.selectPage(page, null);
        System.out.println("总条数"+iPage.getTotal()+"总页数"+iPage.getPages());
        List<Member> records = iPage.getRecords();
        for (Member record : records) {
            System.out.println(record.getName());
        }
    }
    /*@Test
    public void insert() {

        Member member = new Member();
        member.setName("sss");
        member.setAge(23);
        member.setPassword("123");
        memberMapper.insert(member);
    }

    @Test
    public void delete(){
        memberMapper.deleteByPrimaryKey(11L);
    }*/


}