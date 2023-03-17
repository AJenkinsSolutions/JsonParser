package com.brm.nonlaborcapital.dbModel;

import java.util.List;

/**
 * This pojo will be mapped to the non Labor Resource Initiative
 */
public class NonLaborResource {

    private String nonLaborResourceId;
    private List<FinancialDetails> financialDetails;


    public NonLaborResource(String nonLaborResourceId, List<FinancialDetails> financialDetails) {
        this.nonLaborResourceId = nonLaborResourceId;
        this.financialDetails = financialDetails;
    }

    public String getNonLaborResourceId() {
        return nonLaborResourceId;
    }

    public void setNonLaborResourceId(String nonLaborResourceId) {
        this.nonLaborResourceId = nonLaborResourceId;
    }

    public List<FinancialDetails> getFinancialDetails() {
        return financialDetails;
    }

    public void setFinancialDetails(List<FinancialDetails> financialDetails) {
        this.financialDetails = financialDetails;
    }
}

