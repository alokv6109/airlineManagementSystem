package com.alokcodesback.AirlineManagemtnSystem.entities;

public class CompanyDetails {

    private int id;

    private String companyName;

    private String registrationId;


    public  CompanyDetails(int id, String name){
        this.id = id;
        this.companyName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
}
