package com.udea.reglas.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Participant {

    private String name;
    private int age;
    private int creditScore;
    private long annualSalary;
    private long existingDebt;
    private long loanAmount;
    private boolean haveJob;
    private boolean haveJudicialBackground;
    private int quantityDependants;
    private int yearsInCurrentJob; // Mayor estabilidad laboral es premiada con tasas más bajas

}