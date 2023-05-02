package org.example.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.List;

@Data
public class ContractualPartiesInnerRepresentation {

    List<ContractualPartyInnerRepresentation> contractualParties;

    public String jsonify() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(contractualParties);
    }
}
