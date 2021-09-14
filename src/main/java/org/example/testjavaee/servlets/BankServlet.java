package org.example.testjavaee.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.testjavaee.dto.PaymentsRequest;
import org.example.testjavaee.entities.Payment;
import org.example.testjavaee.entities.Result;
import org.example.testjavaee.exception.RequestProcessingException;
import org.example.testjavaee.service.BankService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BankService", urlPatterns = "/bank")
public class BankServlet extends HttpServlet {

    private BankService bankService = new BankService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String xml = req.getParameter("payments");


        if (xml.isEmpty()){
            throw new RequestProcessingException("Запрос отсутствует");
        }

        ObjectMapper objectMapper = new XmlMapper();
        PaymentsRequest paymentsRequest = objectMapper.readValue(xml, PaymentsRequest.class);

        for (Payment payment : paymentsRequest.getPayments()) {
            Boolean a = checkForNull(payment);
            if (!a){
                throw new RequestProcessingException("Заполните все поля формы.");
            }else {
                bankService.add(payment);
            }
        }

        Result result = bankService.result();

        resp.setHeader("Content-Type", "application/xml");
        resp.getWriter().write(objectMapper.writeValueAsString(result));
    }

    private Boolean checkForNull(Payment payment) {
        if (payment.getName() == null || payment.getSupplyDate() == null || payment.getState() == null || payment.getPart() == null || payment.getValue() == null) {
            return false;
        }
        return true;
    }
}
