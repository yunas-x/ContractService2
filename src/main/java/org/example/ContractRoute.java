package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.example.data.ContractRepo;
import org.example.data.CreateNewContract;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static org.apache.camel.LoggingLevel.ERROR;
import static org.example.CamelConfiguration.RABBIT_URI;

@Component
public class ContractRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        fromF(RABBIT_URI, "contract.create", "contract.create")
                .unmarshal()
                .json(JsonLibrary.Jackson)
                .process(this::getDTO)
                .to("jdbc:postgresql://localhost:5432/messages");
    }

    private void getDTO(Exchange exchange) throws JsonProcessingException {
        CreateNewContract dto = exchange.getMessage().getBody(CreateNewContract.class);
        exchange.getMessage().setBody(ContractRepo.addSalesQuery(dto));
    }
}
