package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 24 "model.ump"
// line 129 "model.ump"
/**

@file Department.java
@brief This file contains the definition of the Department class.
The Department class represents a department in a hospital. It contains a list of staff
and a reference to the hospital it belongs to. It also provides methods to add and remove
staff, and to get information about the staff and the hospital.
*/
/**

@class Department
@brief Represents a department in a hospital.
*/


// ...
/**

@brief Constructor for the Department class.
@param aHospital A reference to the hospital that this department belongs to.
*/
public class Department
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Department Associations
  public List<Staff> staffs;
  public Hospital hospital;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Department(Hospital aHospital)
  {
    staffs = new ArrayList<Staff>();
    boolean didAddHospital = setHospital(aHospital);
    if (!didAddHospital)
    {
      throw new RuntimeException("Unable to create department due to hospital. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  /**

  @brief Returns the staff at the specified index.
  @param index The index of the staff to retrieve.
  @return The staff at the specified index.
  /**

@brief Returns an unmodifiable list of the staff in this department.
@return An unmodifiable list of the staff in this department.
*/
  
  public Staff getStaff(int index)
  {
    Staff aStaff = staffs.get(index);
    return aStaff;
  }
  /**

  @brief Returns the number of staff in this department.
  @return The number of staff in this department.
  */
  public List<Staff> getStaffs()
  {
    List<Staff> newStaffs = Collections.unmodifiableList(staffs);
    return newStaffs;
  }

  public int numberOfStaffs()
  {
    int number = staffs.size();
    return number;
  }
  /**

  @brief Returns the index of the specified staff member in this department.
  @param aStaff The staff member to search for.
  @return The index of the specified staff member in this department, or -1 if not found.
  */
  public boolean hasStaffs()
  {
    boolean has = staffs.size() > 0;
    return has;
  }
  /**

  @brief Returns true if this department has at least one staff member.
  @return True if this department has at least one staff member, false otherwise.
  */
  public int indexOfStaff(Staff aStaff)
  {
    int index = staffs.indexOf(aStaff);
    return index;
  }
  /**

  @brief Returns the hospital that this department belongs to.
  @return The hospital that this department belongs to.
  */
  /**

  @brief Adds a new staff member to this department.
  @param aTitle The title of the new staff member.
  @param aGivenName The given name of the new staff member.
  @param aMiddleName The middle name of the new staff member.
  @param aFamilyName The family name of the new staff member.
  @param aName The full name of the new staff member.
  @param aBirthdate The birthdate of the new staff member.
  @param aGender The gender of the new staff member.
  @param aHomeAddress The home address of the new staff member.
  @param aPhone The phone number of the new staff member.
  @param aJoined The date the new staff member joined the hospital.
  @param aEducation The education of the new staff member.
  @param aCertification The certification of the new staff member.
  @param aLanguages The languages spoken by the new staff member.
  @return The new staff member that was added.
  */
  /* Code from template association_GetOne */
  public Hospital getHospital()
  {
    return hospital;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStaffs()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Staff addStaff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName, Date aBirthdate, String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification, String aLanguages)
  {
    return new Staff(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthdate, aGender, aHomeAddress, aPhone, aJoined, aEducation, aCertification, aLanguages, this);
  }

  public boolean addStaff(Staff aStaff)
  {
    boolean wasAdded = false;
    if (staffs.contains(aStaff)) { return false; }
    Department existingDepartment = aStaff.getDepartment();
    boolean isNewDepartment = existingDepartment != null && !this.equals(existingDepartment);
    if (isNewDepartment)
    {
      aStaff.setDepartment(this);
    } 
    else
    {
      staffs.add(aStaff);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStaff(Staff aStaff)
  {
    boolean wasRemoved = false;
    //Unable to remove aStaff, as it must always have a department
    if (!this.equals(aStaff.getDepartment()))
    {
      staffs.remove(aStaff);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStaffAt(Staff aStaff, int index)
  {  
    boolean wasAdded = false;
    if(addStaff(aStaff))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStaffs()) { index = numberOfStaffs() - 1; }
      staffs.remove(aStaff);
      staffs.add(index, aStaff);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStaffAt(Staff aStaff, int index)
  {
    boolean wasAdded = false;
    if(staffs.contains(aStaff))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStaffs()) { index = numberOfStaffs() - 1; }
      staffs.remove(aStaff);
      staffs.add(index, aStaff);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStaffAt(aStaff, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setHospital(Hospital aHospital)
  {
    boolean wasSet = false;
    if (aHospital == null)
    {
      return wasSet;
    }

    Hospital existingHospital = hospital;
    hospital = aHospital;
    if (existingHospital != null && !existingHospital.equals(aHospital))
    {
      existingHospital.removeDepartment(this);
    }
    hospital.addDepartment(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while (staffs.size() > 0)
    {
      Staff aStaff = staffs.get(staffs.size() - 1);
      aStaff.delete();
      staffs.remove(aStaff);
    }
    
    Hospital placeholderHospital = hospital;
    this.hospital = null;
    if(placeholderHospital != null)
    {
      placeholderHospital.removeDepartment(this);
    }
  }

}