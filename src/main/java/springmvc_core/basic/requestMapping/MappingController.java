package springmvc_core.basic.requestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    public String helloBasic() {
        logger.info("hello-basic");
        return "OK";
    }

    @GetMapping("/mapping/{userId}")
    public String hello(@PathVariable("userId") String userId) {
        logger.info("mappingPath userId ={}", userId);
        return "OK";
    }

    @GetMapping(value = "/mapping-header", headers = "debug")
    public String mappingHeader() {
        logger.debug("mappingHeader");
        return "OK";
    }

}
