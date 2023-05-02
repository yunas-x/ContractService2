package org.example.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Repository
public class ContractRepo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContractRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addSales(CreateNewContract sales) throws JsonProcessingException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        var query =
                String.format("INSERT INTO public.contract(\n" +
                        "\tid, " +
                        "date_start, " +
                        "date_end, " +
                        "date_send, " +
                        "contract_number, " +
                        "contract_name, " +
                        "client_api, " +
                        "contractual_parties)\n" +
                        "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?);",
                        sales.id,
                        sales.dateStart,
                        sales.dateEnd,
                        sales.dateSend,
                        sales.contractNumber,
                        sales.contractName,
                        sales.clientAPI,
                        sales.contractualParties.jsonify());
        return jdbcTemplate.update(query);
    }
}
