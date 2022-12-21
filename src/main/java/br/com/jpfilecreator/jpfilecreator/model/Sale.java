package br.com.jpfilecreator.jpfilecreator.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
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
