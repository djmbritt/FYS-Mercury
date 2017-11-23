/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.models;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

/**
 *
 * @author GG
 */
public class Gebruiker {

    private final List<StringProperty> properties;
    private final StringProperty employeeID;
    private final StringProperty initials;
    private final StringProperty firstName;
    private final StringProperty middleName;
    private final StringProperty surName;
    private final StringProperty birthDate;
    private final StringProperty startDateEmployment;
    private final StringProperty workEmail;

    private StringProperty workingLocation;
    private StringProperty statusEmployment;
    private StringProperty endDateEmployment;
    private StringProperty personalEmail;
    private StringProperty mobilePhoneNumber;
    private StringProperty homePhoneNumber;
    private StringProperty departmentEmployment;
    private StringProperty homeAdress;
    private StringProperty salary;
    private StringProperty biography;

    public Gebruiker() {

        employeeID = new SimpleStringProperty(this, "employeeID");
        initials = new SimpleStringProperty(this, "initials");
        firstName = new SimpleStringProperty(this, "firstName");
        middleName = new SimpleStringProperty(this, "middleName");
        surName = new SimpleStringProperty(this, "surName");
        birthDate = new SimpleStringProperty(this, "birthDate");
        startDateEmployment = new SimpleStringProperty(this, "startDateEmployment");
        workEmail = new SimpleStringProperty(this, "workEmail");

        workingLocation = new SimpleStringProperty(this, "workingLocation");
        statusEmployment = new SimpleStringProperty(this, "statusEmployment");
        endDateEmployment = new SimpleStringProperty(this, "endDateEmployement");
        personalEmail = new SimpleStringProperty(this, "personalEmail");
        mobilePhoneNumber = new SimpleStringProperty(this, "mobilePhoneNumber");
        homePhoneNumber = new SimpleStringProperty(this, "homePhoneNumber");
        departmentEmployment = new SimpleStringProperty(this, "departmentEmployment");
        homeAdress = new SimpleStringProperty(this, "homeAdress");
        salary = new SimpleStringProperty(this, "salary");
        biography = new SimpleStringProperty(this, "biography");

        properties = new ArrayList<>();
        addAllToProperties();
    }

    public StringProperty getWorkingLocation() {
        return workingLocation;
    }

    public void setWorkingLocation(StringProperty workingLocation) {
        this.workingLocation = workingLocation;
    }

    public StringProperty getStatusEmployment() {
        return statusEmployment;
    }

    public void setStatusEmployment(StringProperty statusEmployment) {
        this.statusEmployment = statusEmployment;
    }

    public StringProperty getEndDateEmployment() {
        return endDateEmployment;
    }

    public void setEndDateEmployment(StringProperty endDateEmployment) {
        this.endDateEmployment = endDateEmployment;
    }

    public StringProperty getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(StringProperty personalEmail) {
        this.personalEmail = personalEmail;
    }

    public StringProperty getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(StringProperty mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public StringProperty getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(StringProperty homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public StringProperty getDepartmentEmployment() {
        return departmentEmployment;
    }

    public void setDepartmentEmployment(StringProperty departmentEmployment) {
        this.departmentEmployment = departmentEmployment;
    }

    public StringProperty getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(StringProperty homeAdress) {
        this.homeAdress = homeAdress;
    }

    public StringProperty getSalary() {
        return salary;
    }

    public void setSalary(StringProperty salary) {
        this.salary = salary;
    }

    public StringProperty getBiography() {
        return biography;
    }

    public void setBiography(StringProperty biography) {
        this.biography = biography;
    }

    public void setAllProperties(List<TextField> list) {
        for (int x = 0; x < list.size(); x++) {
            for (int y = 0; y < properties.size(); y++) {
                String tempListID = list.get(x).getId();
                String tempPropertiesName = properties.get(y).getName();

                System.out.println(tempListID);
                System.out.println(tempPropertiesName);

                if (tempListID.equalsIgnoreCase(tempPropertiesName)) {
                    properties.get(y).bind(list.get(x).textProperty());
                }
            }
        }

    }

    private void addAllToProperties() {
        properties.add(employeeID);
        properties.add(initials);
        properties.add(firstName);
        properties.add(middleName);
        properties.add(surName);
        properties.add(birthDate);
        properties.add(workingLocation);
        properties.add(statusEmployment);
        properties.add(startDateEmployment);
        properties.add(endDateEmployment);
        properties.add(workEmail);
        properties.add(personalEmail);
        properties.add(mobilePhoneNumber);
        properties.add(homePhoneNumber);
        properties.add(departmentEmployment);
        properties.add(homeAdress);
        properties.add(salary);
        properties.add(biography);
    }

}
