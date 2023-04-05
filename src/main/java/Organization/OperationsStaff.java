package Organization;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Date;

// line 54 "model.ump"
// line 145 "model.ump"
public class OperationsStaff extends Staff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OperationsStaff Associations
  private List<Patient> patients;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OperationsStaff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName, Date aBirthdate, String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification, String aLanguages, Department aDepartment)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthdate, aGender, aHomeAddress, aPhone, aJoined, aEducation, aCertification, aLanguages, aDepartment);
    patients = new ArrayList<Patient>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Patient getPatient(int index)
  {
    Patient aPatient = patients.get(index);
    return aPatient;
  }

  public List<Patient> getPatients()
  {
    List<Patient> newPatients = Collections.unmodifiableList(patients);
    return newPatients;
  }

  public int numberOfPatients()
  {
    int number = patients.size();
    return number;
  }

  public boolean hasPatients()
  {
    boolean has = patients.size() > 0;
    return has;
  }

  public int indexOfPatient(Patient aPatient)
  {
    int index = patients.indexOf(aPatient);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatients()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPatient(Patient aPatient)
  {
    boolean wasAdded = false;
    if (patients.contains(aPatient)) { return false; }
    patients.add(aPatient);
    if (aPatient.indexOfOperationsStaff(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPatient.addOperationsStaff(this);
      if (!wasAdded)
      {
        patients.remove(aPatient);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePatient(Patient aPatient)
  {
    boolean wasRemoved = false;
    if (!patients.contains(aPatient))
    {
      return wasRemoved;
    }

    int oldIndex = patients.indexOf(aPatient);
    patients.remove(oldIndex);
    if (aPatient.indexOfOperationsStaff(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPatient.removeOperationsStaff(this);
      if (!wasRemoved)
      {
        patients.add(oldIndex,aPatient);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPatientAt(Patient aPatient, int index)
  {  
    boolean wasAdded = false;
    if(addPatient(aPatient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatients()) { index = numberOfPatients() - 1; }
      patients.remove(aPatient);
      patients.add(index, aPatient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePatientAt(Patient aPatient, int index)
  {
    boolean wasAdded = false;
    if(patients.contains(aPatient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatients()) { index = numberOfPatients() - 1; }
      patients.remove(aPatient);
      patients.add(index, aPatient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPatientAt(aPatient, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Patient> copyOfPatients = new ArrayList<Patient>(patients);
    patients.clear();
    for(Patient aPatient : copyOfPatients)
    {
      aPatient.removeOperationsStaff(this);
    }
    super.delete();
  }

public boolean contains(OperationsStaff operationsStaff) {
	// TODO Auto-generated method stub
	return false;
}

public Object get(int i) {
	// TODO Auto-generated method stub
	return null;
}

}