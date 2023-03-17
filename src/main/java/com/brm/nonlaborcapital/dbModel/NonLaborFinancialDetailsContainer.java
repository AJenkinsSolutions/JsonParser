package com.brm.nonlaborcapital.dbModel;

import java.util.List;

/**
 * this class represents the outer object of sample input json file
 */
public class NonLaborFinancialDetailsContainer {

    //This will be a list of NonL
    private List<NonLaborResource> NonLaborFinancialDetails;

    // Getter and setter
    public List<NonLaborResource> getNonLaborFinancialDetails() {
        return NonLaborFinancialDetails;
    }

    public void setNonLaborFinancialDetails(List<NonLaborResource> nonLaborFinancialDetails) {
        NonLaborFinancialDetails = nonLaborFinancialDetails;
    }
}
