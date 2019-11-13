package cn.xwq.red;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedApplication.class, args);
    }

}
