package br.com.jpfilecreator.jpfilecreator.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "sales_details")
@ToString
@Builder
public class Sale {

    @Id
    @Column(name = "sale_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "transaction_value")
    private BigDecimal transactionValue;

    @Column(name = "transaction_description")
    private String transactionDescription;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "local_type")
    private Integer localType;
}
