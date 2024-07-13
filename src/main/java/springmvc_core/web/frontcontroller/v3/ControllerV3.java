package springmvc_core.web.frontcontroller.v3;

import springmvc_core.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
