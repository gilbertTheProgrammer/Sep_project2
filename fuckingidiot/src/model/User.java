package model;

public class User
{
  private String firstName;
  private String lastName;
  private String deliveryAddress;
  private String emailAddress;
  private String phoneNumber;
  private String password;


  public User(String firstName, String lastName, String deliveryAddress, String emailAddress,String phoneNumber, String password){
    this.firstName=firstName;
    this.lastName=lastName;
    this.deliveryAddress=deliveryAddress;
    this.emailAddress=emailAddress;
    this.phoneNumber=phoneNumber;
    this.password=password;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }



  public String getEmailAddress() {
    return emailAddress;
  }



  public String getDeliveryAddress() {
    return deliveryAddress;
  }



  public String getLastName() {
    return lastName;
  }



  public String getFirstName() {
    return firstName;
  }


}
