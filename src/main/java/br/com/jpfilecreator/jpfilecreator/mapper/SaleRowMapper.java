package br.com.jpfilecreator.jpfilecreator.mapper;

import br.com.jpfilecreator.jpfilecreator.model.Sale;
import br.com.jpfilecreator.jpfilecreator.utils.TimeUtils;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SaleRowMapper implements RowMapper<Sale> {

    @Override
    public Sale mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Sale
                .builder()
                .id(rs.getLong("sale_id"))
                .username(rs.getString("username"))
//                .transactionDate(LocalDateTime.parse(rs.getString("transaction_date"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .transactionDate(TimeUtils.convertStringToLocalDateTime(rs.getString("transaction_date")))
                .transactionValue(rs.getBigDecimal("transaction_value"))
                .transactionDescription(rs.getString("transaction_description"))
                .transactionType(rs.getString("transaction_type"))
                .localType(rs.getInt("local_type"))
                .build();
    }
}
