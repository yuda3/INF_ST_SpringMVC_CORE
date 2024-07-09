package springmvc_core.web.frontcontroller.v2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import springmvc_core.web.frontcontroller.MyView;
import springmvc_core.web.frontcontroller.v2.controller.MemberFormControllerV2;
import springmvc_core.web.frontcontroller.v2.controller.MemberListControllerV2;
import springmvc_core.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {
    private final Map<String, ControllerV2> controllerV2Map = new HashMap<>();

    public FrontControllerServletV2(Map<String, ControllerV2> controllerV2Map) {
        controllerV2Map.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerV2Map.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerV2Map.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV2 controllerV2 = controllerV2Map.get(requestURI);
        if (controllerV2 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        MyView process = controllerV2.process(request, response);
        process.render(request, response);
    }
}
