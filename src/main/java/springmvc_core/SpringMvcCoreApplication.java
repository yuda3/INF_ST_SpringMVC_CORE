package springmvc_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringMvcCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcCoreApplication.class, args);
    }

}
