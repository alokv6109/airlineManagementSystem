package com.alokcodesback.AirlineManagemtnSystem.payloads;

import java.time.LocalDate;

public class FlightSearchConditionDto {
    private String startPoint;
    private String endPoint;

    private String companyName;

    private LocalDate travellingDate;



    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getTravellingDate() {
        return travellingDate;
    }

    public void setTravellingDate(LocalDate travellingDate) {
        this.travellingDate = travellingDate;
    }
}
