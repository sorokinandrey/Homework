package servlets;

import desktop.p3.First;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BasicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String var1 = request.getParameter("var1");
        String var2 = request.getParameter("var2");
        String operation = request.getParameter("operation");
        System.out.println(var1 + var2);
        if (var1 != null) {
            if (var1.equals("random")) {
                int rand = First.random(100);
                response.getWriter().println(rand);
            } else if (var1.equals("closer")) {
                String mStr = request.getParameter("m");
                String nStr = request.getParameter("n");
                int m = Integer.parseInt(mStr);
                int n = Integer.parseInt(nStr);
                int result = Math.abs(m - 10) < Math.abs(n - 10) ? m : n;
                response.getWriter().println(result);

            } else if (var1.equals("roots")) {
                int a = Integer.parseInt(request.getParameter("a"));
                int b = Integer.parseInt(request.getParameter("b"));
                int c = Integer.parseInt(request.getParameter("c"));
                int D = b * b - 4 * a * c;
                System.out.println("Got" + a + b + c);
                if (D > 0) {
                    double x1, x2;
                    x1 = (-b - Math.sqrt(D)) / (2 * a);
                    x2 = (-b + Math.sqrt(D)) / (2 * a);
                    response.getWriter().println("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);
                } else if (D == 0) {
                    double x;
                    x = -b / (2 * a);
                    response.getWriter().println("Уравнение имеет единственный корень: x = " + x);
                } else {
                    response.getWriter().println("Уравнение не имеет действительных корней!");
                }

            } else if (var1.equals("table")) {
                response.setContentType("application/json");
                JSONArray rows = new JSONArray();
                for (int i = 0; i < 8; i++) {
                    JSONArray col = new JSONArray();
                    for (int j = 0; j < 5; j++) {
                        col.put((int) (Math.random() * 90 + 10));
                    }
                    rows.put(col);
                }
                response.getWriter().print(rows.toString());

            } else if (var1.equals("tableMax")) {
                response.setContentType("application/json");
                JSONArray rows = new JSONArray();
                JSONArray maximums = new JSONArray();
                JSONObject result = new JSONObject();
                int tmpVal;
                int max;

                for (int i = 0; i < 5; i++) {
                    JSONArray col = new JSONArray();
                    max = Integer.MIN_VALUE;
                    for (int j = 0; j < 8; j++) {
                        tmpVal = (int) (Math.random() * 200 - 100);
                        if (tmpVal > max) {
                            max = tmpVal;
                        }
                        col.put(tmpVal);
                    }
                    rows.put(col);
                    maximums.put(max);
                }
                result.put("table", rows);
                result.put("maximums", maximums);
                response.getWriter().print(result.toString());

            } else if (operation != null && !operation.isEmpty()) {

                int i1 = Integer.parseInt(var1);

                int i2 = Integer.parseInt(var2);

                int result;
                if (operation.equals("0")) {
                    result = i1 + i2;
                } else if (operation.equals("1")) {
                    result = i1 - i2;
                } else if (operation.equals("2")) {
                    result = i1 * i2;
                } else {
                    result = i1 / i2;
                }
                response.getWriter().println(result);

            }
        } else {
            response.getWriter().println("Hello world");
        }
    }
}
