package org.example.testjavaee.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.testjavaee.dto.PaymentsRequest;
import org.example.testjavaee.entities.Payment;
import org.example.testjavaee.entities.Result;
import org.example.testjavaee.service.BankService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BankService",urlPatterns = "/bank")
public class BankServlet extends HttpServlet {

    private BankService bankService = new BankService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String xml = req.getParameter("payments");
        ObjectMapper objectMapper = new XmlMapper();
        PaymentsRequest paymentsRequest = objectMapper.readValue(xml, PaymentsRequest.class);

        for (Payment payment : paymentsRequest.getPayments()) {
            bankService.add(payment);
        }

        Result result = bankService.result();

        resp.setHeader("Content-Type", "application/xml");
        resp.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
