package br.com.jpfilecreator.jpfilecreator.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QueriesConstants {

    public static final String SALE_SELECT = "SELECT sale_id, username, transaction_date, transaction_value, transaction_description, transaction_type, local_type";
    public static final String SALE_FROM = "FROM sales_details";
    public static final String SALE_DEBIT_WHERE = "Where 1=1 AND transaction_type = 'D'";
    public static final String SALE_CREDIT_WHERE = "Where 1=1 AND transaction_type = 'C'";

}
