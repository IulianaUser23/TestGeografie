package Iuli.Quizz.Invatare.Servlet;

import Iuli.Quizz.Invatare.AccesDB;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by User on 06.08.2017.
 */
@WebServlet("/invatpurl")
public class InvatarePrt extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) {

        JSONObject json = new JSONObject();

        String query = request.getQueryString();
        System.out.println(query);
        String continent = query.split("=")[1];

        AccesDB db1 = new AccesDB();
        json.put("listaPartialaJson", db1.listaPartiala(Integer.parseInt(continent)));

        String result1 = json.toString();
        System.out.println("result1 list" + result1);
        returnJsonResponse(response, result1);
    }

    private void returnJsonResponse(HttpServletResponse response, String jsonResponse) {
        response.setContentType("application/json");
        PrintWriter pr = null;
        try {
            pr = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert pr != null;
        pr.write(jsonResponse);
        pr.close();
    }
}
