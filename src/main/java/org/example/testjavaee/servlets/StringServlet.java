package org.example.testjavaee.servlets;


import org.example.testjavaee.service.StringService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = "/first")
public class StringServlet extends HttpServlet {
    private StringService service = new StringService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");

        System.out.println(text);
        if (text != null) {
            String map2 = service.answer(text);
            String map3 = service.reductionToNumber(text);
            req.setAttribute("name", map2);
            req.setAttribute("num", map3);
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
