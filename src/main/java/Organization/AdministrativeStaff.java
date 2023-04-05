package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/
/**

@brief Constructor for creating an administrative staff member
Creates an administrative staff member with the given information
@param aTitle the title of the staff member
@param aGivenName the given name of the staff member
@param aMiddleName the middle name of the staff member
@param aFamilyName the family name of the staff member
@param aName the full name of the staff member
@param aBirthdate the birthdate of the staff member
@param aGender the gender of the staff member
@param aHomeAddress the home address of the staff member
@param aPhone the phone number of the staff member
@param aJoined the date the staff member joined the organization
@param aEducation the education level of the staff member
@param aCertification the certifications held by the staff member
@param aLanguages the languages spoken by the staff member
@param aDepartment the department the staff member works in
*/
/**

@brief Constructor for creating an administrative staff member
Creates an administrative staff member with the given information
@param aTitle the title of the staff member
@param aGivenName the given name of the staff member
@param aMiddleName the middle name of the staff member
@param aFamilyName the family name of the staff member
@param aName the full name of the staff member
@param aBirthdate the birthdate of the staff member
@param aGender the gender of the staff member
@param aHomeAddress the home address of the staff member
@param aPhone the phone number of the staff member
@param aJoined the date the staff member joined the organization
@param aEducation the education level of the staff member
@param aCertification the certifications held by the staff member
@param aLanguages the languages spoken by the staff member
@param aDepartment the department the staff member works in
*/
import java.sql.Date;
import java.util.*;

// line 60 "model.ump"
// line 151 "model.ump"
/**

@brief Constructor for creating an administrative staff member
Creates an administrative staff member with the given information
@param aTitle the title of the staff member
@param aGivenName the given name of the staff member
@param aMiddleName the middle name of the staff member
@param aFamilyName the family name of the staff member
@param aName the full name of the staff member
@param aBirthdate the birthdate of the staff member
@param aGender the gender of the staff member
@param aHomeAddress the home address of the staff member
@param aPhone the phone number of the staff member
@param aJoined the date the staff member joined the organization
@param aEducation the education level of the staff member
@param aCertification the certifications held by the staff member
@param aLanguages the languages spoken by the staff member
@param aDepartment the department the staff member works in
*/
public class AdministrativeStaff extends Staff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AdministrativeStaff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName, Date aBirthdate, String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification, String aLanguages, Department aDepartment)
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