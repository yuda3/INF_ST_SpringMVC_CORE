package springmvc_core.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(HttpMethod httpMethod, Locale locale,
                          @RequestHeader MultiValueMap<String, String> headers,
                          @CookieValue(value = "myCookie", required = false) String cookie) {
        log.info("headers: {}", headers);
        log.info("cookie: {}", cookie);
        log.info("httpMethod: {}", httpMethod);
        log.info("locale: {}", locale);
        log.info("method: {}", httpMethod);
        return "OK";

    }

}
