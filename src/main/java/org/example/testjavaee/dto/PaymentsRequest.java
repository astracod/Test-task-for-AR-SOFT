package org.example.testjavaee.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import org.example.testjavaee.entities.Payment;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "root")
public class PaymentsRequest {
    @JacksonXmlElementWrapper(localName = "payments")
    @JacksonXmlProperty(localName = "payment")
    List<Payment> payments;
}
