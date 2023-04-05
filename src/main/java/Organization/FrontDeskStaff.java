package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;
import java.util.*;

// line 82 "model.ump"
// line 171 "model.ump"
/**
 * @brief The FrontDeskStaff class represents the staff working at the front desk in the hospital.
 * 
 * The FrontDeskStaff class is a subclass of AdministrativeStaff class, and inherits its attributes and methods. 
 * It doesn't have any additional attributes or methods of its own.
 */

/**
 * @brief Constructor for FrontDeskStaff class.
 * 
 * This constructor creates a new FrontDeskStaff object with the given parameters and initializes its attributes. 
 * It calls the constructor of its superclass, AdministrativeStaff, to initialize its inherited attributes.
 * 
 * @param aTitle The title of the staff member.
 * @param aGivenName The given name of the staff member.
 * @param aMiddleName The middle name of the staff member.
 * @param aFamilyName The family name of the staff member.
 * @param aName The name of the staff member.
 * @param aBirthdate The birthdate of the staff member.
 * @param aGender The gender of the staff member.
 * @param aHomeAddress The home address of the staff member.
 * @param aPhone The phone number of the staff member.
 * @param aJoined The date the staff member joined the hospital.
 * @param aEducation The education level of the staff member.
 * @param aCertification The certification level of the staff member.
 * @param aLanguages The languages the staff member can speak.
 * @param aDepartment The department the staff member works in.
 */
public class FrontDeskStaff extends AdministrativeStaff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FrontDeskStaff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName, Date aBirthdate, String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification, String aLanguages, Department aDepartment)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthdate, aGender, aHomeAddress, aPhone, aJoined, aEducation, aCertification, aLanguages, aDepartment);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}