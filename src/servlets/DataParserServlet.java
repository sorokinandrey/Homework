package servlets;

import desktop.opendata.Database;
import desktop.opendata.Record;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by stran on 25.05.2016.
 */
public class DataParserServlet extends HttpServlet {
    private String[] files = {"restaurants.csv", "districts.csv"};
    private Database data = Database.fromCSV(files);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        JSONObject res = new JSONObject();
        String action = request.getParameter("action");

//        if (action.equals("getPage")) {
//            int page = Integer.parseInt(request.getParameter("page"));
//            int perPage = Integer.parseInt(request.getParameter("perPage"));
//            res.put("restaurants", mapToJson(data.getPage(page, perPage), data.getHeader()));
//            System.out.println("ACTION get-page: " + page + ", " + perPage + " DATA: " + res.toString());
//            res.put("page", page);
//            res.put("perPage", perPage);
//        }

        if (action.equals("getData")) {
            res.put("restaurants", data.getTable("restaurants").toJSON());
            res.put("restaurants_header", data.getHeader("restaurants"));
//            data.joinTablesByColumn("restaurants", "districts", "Район", "название района");
            System.out.println("ACTION getData: " + "DATA: " + res.toString());
        }

        if (action.equals("getDistrictData")) {
            String district = request.getParameter("district");
            Record found = data.getByRecordById("districts", district);
            res.put("name", found.getValue("название района"));
            res.put("okato", found.getValue("ОКАТО"));
            res.put("code", found.getValue("Код района"));
            System.out.println("ACTION getDistrictData: " + "DATA: " + res.toString());
        }
        response.getWriter().write(res.toString());

    }

}

