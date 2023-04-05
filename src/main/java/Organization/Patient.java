package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;
import java.util.*;

// line 29 "model.ump"
// line 135 "model.ump"
public class Patient extends Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Patient Attributes
  private String id;
  private Date birthDate;
  private int age;
  private Date accepted;
  private String sickness;
  private String prescriptions;
  private String allergies;
  private String specialReqs;

  //Patient Associations
  private List<OperationsStaff> operationsStaffs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Patient(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName, Date aBirthdate, String aGender, String aHomeAddress, String aPhone, String aId, Date aBirthDate, int aAge, Date aAccepted, String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthdate, aGender, aHomeAddress, aPhone);
    id = aId;
    birthDate = aBirthDate;
    age = aAge;
    accepted = aAccepted;
    sickness = aSickness;
    prescriptions = aPrescriptions;
    allergies = aAllergies;
    specialReqs = aSpecialReqs;
    operationsStaffs = new ArrayList<OperationsStaff>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setBirthDate(Date aBirthDate)
  {
    boolean wasSet = false;
    birthDate = aBirthDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setAge(int aAge)
  {
    boolean wasSet = false;
    age = aAge;
    wasSet = true;
    return wasSet;
  }

  public boolean setAccepted(Date aAccepted)
  {
    boolean wasSet = false;
    accepted = aAccepted;
    wasSet = true;
    return wasSet;
  }

  public boolean setSickness(String aSickness)
  {
    boolean wasSet = false;
    sickness = aSickness;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrescriptions(String aPrescriptions)
  {
    boolean wasSet = false;
    prescriptions = aPrescriptions;
    wasSet = true;
    return wasSet;
  }

  public boolean setAllergies(String aAllergies)
  {
    boolean wasSet = false;
    allergies = aAllergies;
    wasSet = true;
    return wasSet;
  }

  public boolean setSpecialReqs(String aSpecialReqs)
  {
    boolean wasSet = false;
    specialReqs = aSpecialReqs;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public Date getBirthDate()
  {
    return birthDate;
  }

  public int getAge()
  {
    return age;
  }

  public Date getAccepted()
  {
    return accepted;
  }

  public String getSickness()
  {
    return sickness;
  }

  public String getPrescriptions()
  {
    return prescriptions;
  }

  public String getAllergies()
  {
    return allergies;
  }

  public String getSpecialReqs()
  {
    return specialReqs;
  }
  /* Code from template association_GetMany */
  public OperationsStaff getOperationsStaff(int index)
  {
    OperationsStaff aOperationsStaff = operationsStaffs.get(index);
    return aOperationsStaff;
  }

  public List<OperationsStaff> getOperationsStaffs()
  {
    List<OperationsStaff> newOperationsStaffs = Collections.unmodifiableList(operationsStaffs);
    return newOperationsStaffs;
  }

  public int numberOfOperationsStaffs()
  {
    int number = operationsStaffs.size();
    return number;
  }

  public boolean hasOperationsStaffs()
  {
    boolean has = operationsStaffs.size() > 0;
    return has;
  }

  public int indexOfOperationsStaff(OperationsStaff aOperationsStaff)
  {
    int index = operationsStaffs.indexOf(aOperationsStaff);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOperationsStaffs()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addOperationsStaff(OperationsStaff aOperationsStaff)
  {
    boolean wasAdded = false;
    if (operationsStaffs.contains(aOperationsStaff)) { return false; }
    operationsStaffs.add(aOperationsStaff);
    if (aOperationsStaff.indexOfPatient(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aOperationsStaff.addPatient(this);
      if (!wasAdded)
      {
        operationsStaffs.remove(aOperationsStaff);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeOperationsStaff(OperationsStaff aOperationsStaff)
  {
    boolean wasRemoved = false;
    if (!operationsStaffs.contains(aOperationsStaff))
    {
      return wasRemoved;
    }

    int oldIndex = operationsStaffs.indexOf(aOperationsStaff);
    operationsStaffs.remove(oldIndex);
    if (aOperationsStaff.indexOfPatient(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aOperationsStaff.removePatient(this);
      if (!wasRemoved)
      {
        operationsStaffs.add(oldIndex,aOperationsStaff);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOperationsStaffAt(OperationsStaff aOperationsStaff, int index)
  {  
    boolean wasAdded = false;
    if(addOperationsStaff(aOperationsStaff))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOperationsStaffs()) { index = numberOfOperationsStaffs() - 1; }
      operationsStaffs.remove(aOperationsStaff);
      operationsStaffs.add(index, aOperationsStaff);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOperationsStaffAt(OperationsStaff aOperationsStaff, int index)
  {
    boolean wasAdded = false;
    if(operationsStaffs.contains(aOperationsStaff))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOperationsStaffs()) { index = numberOfOperationsStaffs() - 1; }
      operationsStaffs.remove(aOperationsStaff);
      operationsStaffs.add(index, aOperationsStaff);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOperationsStaffAt(aOperationsStaff, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<OperationsStaff> copyOfOperationsStaffs = new ArrayList<OperationsStaff>(operationsStaffs);
    operationsStaffs.clear();
    for(OperationsStaff aOperationsStaff : copyOfOperationsStaffs)
    {
      aOperationsStaff.removePatient(this);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "age" + ":" + getAge()+ "," +
            "sickness" + ":" + getSickness()+ "," +
            "prescriptions" + ":" + getPrescriptions()+ "," +
            "allergies" + ":" + getAllergies()+ "," +
            "specialReqs" + ":" + getSpecialReqs()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "birthDate" + "=" + (getBirthDate() != null ? !getBirthDate().equals(this)  ? getBirthDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "accepted" + "=" + (getAccepted() != null ? !getAccepted().equals(this)  ? getAccepted().toString().replaceAll("  ","    ") : "this" : "null");
  }
}