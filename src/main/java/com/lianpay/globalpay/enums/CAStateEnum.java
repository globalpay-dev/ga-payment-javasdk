package com.lianpay.globalpay.enums;

public enum CAStateEnum {
    AB("Alberta"),
    BC("British Columbia"),
    MB("Manitoba"),
    NB("New Brunswick"),
    NL("Newfoundland and Labrador"),
    NT("Northwest Territories"),
    NS("Nova Scotia"),
    NU("Nunavut"),
    ON("Ontario"),
    PE("Prince Edward Island"),
    QC("Quebec"),
    SK("Saskatchewan"),
    YT("Yukon");
    
    private final String description;

    CAStateEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
