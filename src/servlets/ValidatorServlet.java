package servlets;

import classroom.io.FormException;
import classroom.io.Processor;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by stran on 15.05.2016.
 */
public class ValidatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        JSONObject res = new JSONObject();

        Map formData = request.getParameterMap();

        try {
            Processor.validateForm(formData);
            res.put("success", "true");
            res.put("message", "Success!");
        } catch (FormException e) {
            res.put("errorField", e.getField());
            res.put("message", e.getMessage());
        }

        response.getWriter().print(res.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
