package org.example.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.data.ClientAPIs;
import org.example.data.ContractualPartyInnerRepresentation;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNewContract {

    LocalDateTime dateSend;
    ClientAPIs clientAPI;
    int id;
    Date dateStart;
    Date dateEnd;
    int contractNumber;
    String contractName;
    ContractualPartiesInnerRepresentation contractualParties;

}
