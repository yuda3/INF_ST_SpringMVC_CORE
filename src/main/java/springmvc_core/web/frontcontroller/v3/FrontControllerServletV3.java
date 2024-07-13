package springmvc_core.web.frontcontroller.v3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import springmvc_core.web.frontcontroller.ModelView;
import springmvc_core.web.frontcontroller.MyView;
import springmvc_core.web.frontcontroller.v3.controller.MemberFormControllerV3;
import springmvc_core.web.frontcontroller.v3.controller.MemberListControllerV3;
import springmvc_core.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {
    private final Map<String, ControllerV3> controllerV3Map = new HashMap<>();

    public FrontControllerServletV3(Map<String, ControllerV3> controllerV3Map) {
        controllerV3Map.put("/front-controller/v2/members/new-form", new MemberFormControllerV3());
        controllerV3Map.put("/front-controller/v2/members/save", new MemberSaveControllerV3());
        controllerV3Map.put("/front-controller/v2/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV3 controllerV3 = controllerV3Map.get(requestURI);

        if (controllerV3 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controllerV3.process(paramMap);

        String viewName = mv.getViewName();
        MyView myView =viewResolver(viewName);
        myView.render(mv.getModel(),request, response);
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
