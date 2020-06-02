package cn.fyzzz.quickstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fyzzz
 * 2020/06/01 10:00
 */
@MapperScan("cn.fyzzz.quickstart.mapper")
@SpringBootApplication
public class QuickStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickStartApplication.class, args);
    }

}
