package springmvc_core.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/log-test")
    public String logTest() {
        String spring = "Spring";
        System.out.println("spring = " + spring);
        logger.trace("trace{}", spring);
        logger.debug("trace{}", spring);
        logger.info("trace{}", spring);
        logger.warn("trace{}", spring);
        logger.error("trace{}", spring);
        logger.info(spring);
        return "OK";

    }
}
