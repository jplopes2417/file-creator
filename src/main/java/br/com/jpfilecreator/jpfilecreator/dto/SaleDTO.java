package br.com.jpfilecreator.jpfilecreator.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class SaleDTO {

    private String username;
    private String transactionDate;
    private String transactionValue;
    private String transactionDescription;
    private String transactionType;
    private String localType;

}
