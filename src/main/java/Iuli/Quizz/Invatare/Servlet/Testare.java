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
 * Created by User on 07.08.2017.
 */
@WebServlet("/testezurl")
public class Testare extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) {

        JSONObject json = new JSONObject();

        AccesDB db = new AccesDB();
        json.put("listaRaspunsuriJson", db.listaRaspunsuri());

        String result = json.toString();
        System.out.println("result list" + result);
        returnJsonResponse(response, result);
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
