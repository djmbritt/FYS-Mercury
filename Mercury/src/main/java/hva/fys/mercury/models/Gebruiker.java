/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.models;

/**
 *
 * @author GG
 */
public class Gebruiker {

    private int EmployeeID;
    private String Initials;
    private String FirstName;
    private String MiddleName;
    private String SurName;
    private String BirthDate;
    private String StartEmploymentDate;
    private String WorkEmail;
    private String WorkingLocation;
    private String StatusEmployment;
    private String EndDateEmployment;
    private String PersonalEmail;
    private String MobilePhoneNumber;
    private String PostalCode;
    private String DepartmentEmployment;
    private String HomeAdress;

    public Gebruiker() {
    }

    public Gebruiker(int EmployeeID, String Initials, String FirstName, String MiddleName, String SurName, String BirthDate, String StartEmploymentDate, String WorkEmail, String WorkingLocation, String StatusEmployment, String EndDateEmployment, String PersonalEmail, String MobilePhoneNumber, String PostalCode, String DepartmentEmployment, String HomeAdress) {
        this.EmployeeID = EmployeeID;
        this.Initials = Initials;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.SurName = SurName;
        this.BirthDate = BirthDate;
        this.StartEmploymentDate = StartEmploymentDate;
        this.WorkEmail = WorkEmail;
        this.WorkingLocation = WorkingLocation;
        this.StatusEmployment = StatusEmployment;
        this.EndDateEmployment = EndDateEmployment;
        this.PersonalEmail = PersonalEmail;
        this.MobilePhoneNumber = MobilePhoneNumber;
        this.PostalCode = PostalCode;
        this.DepartmentEmployment = DepartmentEmployment;
        this.HomeAdress = HomeAdress;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getInitials() {
        return Initials;
    }

    public void setInitials(String Initials) {
        this.Initials = Initials;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String SurName) {
        this.SurName = SurName;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getStartEmploymentDate() {
        return StartEmploymentDate;
    }

    public void setStartEmploymentDate(String StartEmploymentDate) {
        this.StartEmploymentDate = StartEmploymentDate;
    }

    public String getWorkEmail() {
        return WorkEmail;
    }

    public void setWorkEmail(String WorkEmail) {
        this.WorkEmail = WorkEmail;
    }

    public String getWorkingLocation() {
        return WorkingLocation;
    }

    public void setWorkingLocation(String WorkingLocation) {
        this.WorkingLocation = WorkingLocation;
    }

    public String getStatusEmployment() {
        return StatusEmployment;
    }

    public void setStatusEmployment(String StatusEmployment) {
        this.StatusEmployment = StatusEmployment;
    }

    public String getEndDateEmployment() {
        return EndDateEmployment;
    }

    public void setEndDateEmployment(String EndDateEmployment) {
        this.EndDateEmployment = EndDateEmployment;
    }

    public String getPersonalEmail() {
        return PersonalEmail;
    }

    public void setPersonalEmail(String PersonalEmail) {
        this.PersonalEmail = PersonalEmail;
    }

    public String getMobilePhoneNumber() {
        return MobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String MobilePhoneNumber) {
        this.MobilePhoneNumber = MobilePhoneNumber;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setHomePhoneNumber(String HomePhoneNumber) {
        this.PostalCode = PostalCode;
    }

    public String getDepartmentEmployment() {
        return DepartmentEmployment;
    }

    public void setDepartmentEmployment(String DepartmentEmployment) {
        this.DepartmentEmployment = DepartmentEmployment;
    }

    public String getHomeAdress() {
        return HomeAdress;
    }

    public void setHomeAdress(String HomeAdress) {
        this.HomeAdress = HomeAdress;
    }

}
