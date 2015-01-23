package com.example.neele.myapplication;

/**
 * Created by Neele on 1/22/2015.
 */
public class contactInfo {
    private String contactName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    //private String contactPhoto;
    public contactInfo(){}
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public void setFirstName(String name){
        this.firstName = name;
    }
    public void setLastName(String name){
        this.lastName = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
/*	public String getContactPhoto() {
		return contactPhoto;
	}
	public void setContactPhoto(String contactPhoto) {
		this.contactPhoto = contactPhoto;
	}*/

}
