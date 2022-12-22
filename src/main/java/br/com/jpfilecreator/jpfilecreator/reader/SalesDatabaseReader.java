package br.com.jpfilecreator.jpfilecreator.reader;

import br.com.jpfilecreator.jpfilecreator.constants.QueriesConstants;
import br.com.jpfilecreator.jpfilecreator.mapper.SaleRowMapper;
import br.com.jpfilecreator.jpfilecreator.model.Sale;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SalesDatabaseReader {

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcPagingItemReader<Sale> jdbcPagingItemReader(){
        JdbcPagingItemReader<Sale> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(this.dataSource);
        reader.setFetchSize(10);
        reader.setRowMapper(new SaleRowMapper());

        Map<String, Order> sort = new HashMap<>();
        sort.put("sale_id", Order.DESCENDING);

        MySqlPagingQueryProvider mySqlPagingQueryProvider = new MySqlPagingQueryProvider();
        mySqlPagingQueryProvider.setSelectClause(QueriesConstants.SALE_SELECT);
        mySqlPagingQueryProvider.setFromClause(QueriesConstants.SALE_FROM);
        mySqlPagingQueryProvider.setSortKeys(sort);

        reader.setQueryProvider(mySqlPagingQueryProvider);

        return reader;

    }
}
