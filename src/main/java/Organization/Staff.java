package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;
import java.util.*;

// line 44 "model.ump"
// line 140 "model.ump"
public class Staff extends Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Staff Attributes
  private Date joined;
  private String education;
  private String certification;
  private String languages;

  //Staff Associations
  private Department department;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Staff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName, Date aBirthdate, String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification, String aLanguages, Department aDepartment)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthdate, aGender, aHomeAddress, aPhone);
    joined = aJoined;
    education = aEducation;
    certification = aCertification;
    languages = aLanguages;
    boolean didAddDepartment = setDepartment(aDepartment);
    if (!didAddDepartment)
    {
      throw new RuntimeException("Unable to create staff due to department. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setJoined(Date aJoined)
  {
    boolean wasSet = false;
    joined = aJoined;
    wasSet = true;
    return wasSet;
  }

  public boolean setEducation(String aEducation)
  {
    boolean wasSet = false;
    education = aEducation;
    wasSet = true;
    return wasSet;
  }

  public boolean setCertification(String aCertification)
  {
    boolean wasSet = false;
    certification = aCertification;
    wasSet = true;
    return wasSet;
  }

  public boolean setLanguages(String aLanguages)
  {
    boolean wasSet = false;
    languages = aLanguages;
    wasSet = true;
    return wasSet;
  }

  public Date getJoined()
  {
    return joined;
  }

  public String getEducation()
  {
    return education;
  }

  public String getCertification()
  {
    return certification;
  }

  public String getLanguages()
  {
    return languages;
  }
  /* Code from template association_GetOne */
  public Department getDepartment()
  {
    return department;
  }
  /* Code from template association_SetOneToMany */
  public boolean setDepartment(Department aDepartment)
  {
    boolean wasSet = false;
    if (aDepartment == null)
    {
      return wasSet;
    }

    Department existingDepartment = department;
    department = aDepartment;
    if (existingDepartment != null && !existingDepartment.equals(aDepartment))
    {
      existingDepartment.removeStaff(this);
    }
    department.addStaff(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Department placeholderDepartment = department;
    this.department = null;
    if(placeholderDepartment != null)
    {
      placeholderDepartment.removeStaff(this);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "education" + ":" + getEducation()+ "," +
            "certification" + ":" + getCertification()+ "," +
            "languages" + ":" + getLanguages()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "joined" + "=" + (getJoined() != null ? !getJoined().equals(this)  ? getJoined().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "department = "+(getDepartment()!=null?Integer.toHexString(System.identityHashCode(getDepartment())):"null");
  }
}