package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;
import java.util.*;

// line 2 "model.ump"
// line 117 "model.ump"
public class Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String title;
  private String givenName;
  private String middleName;
  private String familyName;
  private String name;
  private Date birthdate;
  private String gender;
  private String homeAddress;
  private String phone;

  //Person Associations
  private List<Hospital> hospitals;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName, Date aBirthdate, String aGender, String aHomeAddress, String aPhone)
  {
    title = aTitle;
    givenName = aGivenName;
    middleName = aMiddleName;
    familyName = aFamilyName;
    name = aName;
    birthdate = aBirthdate;
    gender = aGender;
    homeAddress = aHomeAddress;
    phone = aPhone;
    hospitals = new ArrayList<Hospital>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTitle(String aTitle)
  {
    boolean wasSet = false;
    title = aTitle;
    wasSet = true;
    return wasSet;
  }

  public boolean setGivenName(String aGivenName)
  {
    boolean wasSet = false;
    givenName = aGivenName;
    wasSet = true;
    return wasSet;
  }

  public boolean setMiddleName(String aMiddleName)
  {
    boolean wasSet = false;
    middleName = aMiddleName;
    wasSet = true;
    return wasSet;
  }

  public boolean setFamilyName(String aFamilyName)
  {
    boolean wasSet = false;
    familyName = aFamilyName;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setBirthdate(Date aBirthdate)
  {
    boolean wasSet = false;
    birthdate = aBirthdate;
    wasSet = true;
    return wasSet;
  }

  public boolean setGender(String aGender)
  {
    boolean wasSet = false;
    gender = aGender;
    wasSet = true;
    return wasSet;
  }

  public boolean setHomeAddress(String aHomeAddress)
  {
    boolean wasSet = false;
    homeAddress = aHomeAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhone(String aPhone)
  {
    boolean wasSet = false;
    phone = aPhone;
    wasSet = true;
    return wasSet;
  }

  public String getTitle()
  {
    return title;
  }

  public String getGivenName()
  {
    return givenName;
  }

  public String getMiddleName()
  {
    return middleName;
  }

  public String getFamilyName()
  {
    return familyName;
  }

  public String getName()
  {
    return name;
  }

  public Date getBirthdate()
  {
    return birthdate;
  }

  public String getGender()
  {
    return gender;
  }

  public String getHomeAddress()
  {
    return homeAddress;
  }

  public String getPhone()
  {
    return phone;
  }
  /* Code from template association_GetMany */
  public Hospital getHospital(int index)
  {
    Hospital aHospital = hospitals.get(index);
    return aHospital;
  }

  public List<Hospital> getHospitals()
  {
    List<Hospital> newHospitals = Collections.unmodifiableList(hospitals);
    return newHospitals;
  }

  public int numberOfHospitals()
  {
    int number = hospitals.size();
    return number;
  }

  public boolean hasHospitals()
  {
    boolean has = hospitals.size() > 0;
    return has;
  }

  public int indexOfHospital(Hospital aHospital)
  {
    int index = hospitals.indexOf(aHospital);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfHospitals()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addHospital(Hospital aHospital)
  {
    boolean wasAdded = false;
    if (hospitals.contains(aHospital)) { return false; }
    hospitals.add(aHospital);
    if (aHospital.indexOfPerson(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aHospital.addPerson(this);
      if (!wasAdded)
      {
        hospitals.remove(aHospital);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeHospital(Hospital aHospital)
  {
    boolean wasRemoved = false;
    if (!hospitals.contains(aHospital))
    {
      return wasRemoved;
    }

    int oldIndex = hospitals.indexOf(aHospital);
    hospitals.remove(oldIndex);
    if (aHospital.indexOfPerson(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aHospital.removePerson(this);
      if (!wasRemoved)
      {
        hospitals.add(oldIndex,aHospital);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addHospitalAt(Hospital aHospital, int index)
  {  
    boolean wasAdded = false;
    if(addHospital(aHospital))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHospitals()) { index = numberOfHospitals() - 1; }
      hospitals.remove(aHospital);
      hospitals.add(index, aHospital);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveHospitalAt(Hospital aHospital, int index)
  {
    boolean wasAdded = false;
    if(hospitals.contains(aHospital))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHospitals()) { index = numberOfHospitals() - 1; }
      hospitals.remove(aHospital);
      hospitals.add(index, aHospital);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addHospitalAt(aHospital, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Hospital> copyOfHospitals = new ArrayList<Hospital>(hospitals);
    hospitals.clear();
    for(Hospital aHospital : copyOfHospitals)
    {
      aHospital.removePerson(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "title" + ":" + getTitle()+ "," +
            "givenName" + ":" + getGivenName()+ "," +
            "middleName" + ":" + getMiddleName()+ "," +
            "familyName" + ":" + getFamilyName()+ "," +
            "name" + ":" + getName()+ "," +
            "gender" + ":" + getGender()+ "," +
            "homeAddress" + ":" + getHomeAddress()+ "," +
            "phone" + ":" + getPhone()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "birthdate" + "=" + (getBirthdate() != null ? !getBirthdate().equals(this)  ? getBirthdate().toString().replaceAll("  ","    ") : "this" : "null");
  }
}