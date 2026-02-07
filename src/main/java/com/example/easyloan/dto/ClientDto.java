package com.example.easyloan.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientDto {
    public int client_id;
    public String client_name;
    public String adharcard_number;
    public String pancard_number;
    public int loan_amount;
    public boolean loan_status;
    public String client_company_name;
    public String client_company_tier;
    public float client_years_of_experience;
    public long client_salary;
}
