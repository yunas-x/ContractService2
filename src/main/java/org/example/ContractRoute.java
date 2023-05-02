package org.example;

import lombok.Getter;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.example.data.CreateNewContract;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static org.apache.camel.LoggingLevel.ERROR;
import static org.example.CamelConfiguration.RABBIT_URI;

@Component
public class ContractRoute extends RouteBuilder {

    @Getter
    ArrayList<CreateNewContract> createNewContracts = new ArrayList<>();

    @Override
    public void configure() throws Exception {
        // No idea actually how to end this
    }

    private void getDTO(Exchange exchange) {
        CreateNewContract dto = exchange.getMessage().getBody(CreateNewContract.class);
    }
}
