package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 70 "model.ump"
// line 161 "model.ump"
public class Doctor extends OperationsStaff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Doctor Attributes
  private String specialty;
  private String lecations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Doctor(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName, Date aBirthdate, String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification, String aLanguages, Department aDepartment, String aSpecialty, String aLecations)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthdate, aGender, aHomeAddress, aPhone, aJoined, aEducation, aCertification, aLanguages, aDepartment);
    specialty = aSpecialty;
    lecations = aLecations;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSpecialty(String aSpecialty)
  {
    boolean wasSet = false;
    specialty = aSpecialty;
    wasSet = true;
    return wasSet;
  }

  public boolean setLecations(String aLecations)
  {
    boolean wasSet = false;
    lecations = aLecations;
    wasSet = true;
    return wasSet;
  }

  public String getSpecialty()
  {
    return specialty;
  }

  public String getLecations()
  {
    return lecations;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "specialty" + ":" + getSpecialty()+ "," +
            "lecations" + ":" + getLecations()+ "]";
  }
}