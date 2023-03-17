package com.brm.nonlaborcapital.dbModel;

import java.util.Arrays;

/**
 * This class is mapped to the non labor resource, financial details
 */
public class FinancialDetails {

    private String financialYear;
    private String monthlyCost;


    public FinancialDetails(String financialYear, String monthlyCost) {
        this.financialYear = financialYear;
        this.monthlyCost = monthlyCost;
    }

    public double[] getMonthlyCostArray() {
        //split by , delimiter
        String[] monthlyCostStrings = monthlyCost.split(",");

        double[] monthlyCostArray = new double[monthlyCostStrings.length];


        //while i is less than len of
        for (int i = 0; i < monthlyCostStrings.length; i++) {
            if (monthlyCostStrings[i].isEmpty()) {
                monthlyCostArray[i] = 0;
            } else {
                try {
                    //
                    monthlyCostArray[i] = Double.parseDouble(monthlyCostStrings[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid number format in monthlyCost string.");
                    System.out.println("invalid value is" + monthlyCostArray[i]);
                }
            }
        }

        return monthlyCostArray;
    }

    public double[] getQuarterlyTotal() {
        double[] monthlyCostArray = getMonthlyCostArray();
        double[] quarterlyTotal = new double[4];

        for (int i = 0; i < 4; i++) {
            int startIndex = i * 3;
            int endIndex = startIndex + 3;
            double total = 0;

            for (int j = startIndex; j < endIndex; j++) {
                if (j < monthlyCostArray.length) {
                    total += monthlyCostArray[j];
                }
            }

            quarterlyTotal[i] = total;
        }

        return quarterlyTotal;
    }

    public double getFinancialYearTotal() {
        double[] monthlyCostArray = getMonthlyCostArray();
        return Arrays.stream(monthlyCostArray).sum();
    }


    public String getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(String financialYear) {
        this.financialYear = financialYear;
    }

    public String getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(String monthlyCost) {
        this.monthlyCost = monthlyCost;
    }
}

