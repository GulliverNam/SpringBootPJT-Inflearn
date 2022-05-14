package giwon.tutorial.springbootpjt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application Class 가 있는 package 의 하위 package 에서만 Component Scan 이 적용 됨
 */
@SpringBootApplication
public class  SpringBootPjtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPjtApplication.class, args);
    }

}
