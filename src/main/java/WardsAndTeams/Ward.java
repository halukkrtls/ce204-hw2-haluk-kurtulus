package WardsAndTeams;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 17 "model.ump"
// line 77 "model.ump"
public class Ward
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ward Attributes
  private String name;
  private String patientsGender;
  private int capacity;

  //Ward Associations
  private HospitalTeams hospitalTeams;
  private List<PatientTeams> patientTeams;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ward(String aName, String aPatientsGender, int aCapacity, HospitalTeams aHospitalTeams)
  {
    name = aName;
    patientsGender = aPatientsGender;
    capacity = aCapacity;
    boolean didAddHospitalTeams = setHospitalTeams(aHospitalTeams);
    if (!didAddHospitalTeams)
    {
      throw new RuntimeException("Unable to create ward due to hospitalTeams. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    patientTeams = new ArrayList<PatientTeams>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPatientsGender(String aPatientsGender)
  {
    boolean wasSet = false;
    patientsGender = aPatientsGender;
    wasSet = true;
    return wasSet;
  }

  public boolean setCapacity(int aCapacity)
  {
    boolean wasSet = false;
    capacity = aCapacity;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getPatientsGender()
  {
    return patientsGender;
  }

  public int getCapacity()
  {
    return capacity;
  }
  /* Code from template association_GetOne */
  public HospitalTeams getHospitalTeams()
  {
    return hospitalTeams;
  }
  /* Code from template association_GetMany */
  public PatientTeams getPatientTeam(int index)
  {
    PatientTeams aPatientTeam = patientTeams.get(index);
    return aPatientTeam;
  }

  public List<PatientTeams> getPatientTeams()
  {
    List<PatientTeams> newPatientTeams = Collections.unmodifiableList(patientTeams);
    return newPatientTeams;
  }

  public int numberOfPatientTeams()
  {
    int number = patientTeams.size();
    return number;
  }

  public boolean hasPatientTeams()
  {
    boolean has = patientTeams.size() > 0;
    return has;
  }

  public int indexOfPatientTeam(PatientTeams aPatientTeam)
  {
    int index = patientTeams.indexOf(aPatientTeam);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setHospitalTeams(HospitalTeams aHospitalTeams)
  {
    boolean wasSet = false;
    if (aHospitalTeams == null)
    {
      return wasSet;
    }

    HospitalTeams existingHospitalTeams = hospitalTeams;
    hospitalTeams = aHospitalTeams;
    if (existingHospitalTeams != null && !existingHospitalTeams.equals(aHospitalTeams))
    {
      existingHospitalTeams.removeWard(this);
    }
    hospitalTeams.addWard(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatientTeams()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public PatientTeams addPatientTeam(String aId, String aGender, int aAge, Date aAccepted, String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs, Team aTeam, Ward aWard)
  {
    return new PatientTeams(aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, null, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, null, aAge, null, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, aTeam, aWard);
  }

  public boolean addPatientTeam(PatientTeams aPatientTeam)
  {
    boolean wasAdded = false;
    if (patientTeams.contains(aPatientTeam)) { return false; }
    Ward existingWard = aPatientTeam.getWard();
    boolean isNewWard = existingWard != null && !this.equals(existingWard);
    if (isNewWard)
    {
      aPatientTeam.setWard(this);
    }
    else
    {
      patientTeams.add(aPatientTeam);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePatientTeam(PatientTeams aPatientTeam)
  {
    boolean wasRemoved = false;
    //Unable to remove aPatientTeam, as it must always have a ward
    if (!this.equals(aPatientTeam.getWard()))
    {
      patientTeams.remove(aPatientTeam);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPatientTeamAt(PatientTeams aPatientTeam, int index)
  {  
    boolean wasAdded = false;
    if(addPatientTeam(aPatientTeam))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatientTeams()) { index = numberOfPatientTeams() - 1; }
      patientTeams.remove(aPatientTeam);
      patientTeams.add(index, aPatientTeam);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePatientTeamAt(PatientTeams aPatientTeam, int index)
  {
    boolean wasAdded = false;
    if(patientTeams.contains(aPatientTeam))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatientTeams()) { index = numberOfPatientTeams() - 1; }
      patientTeams.remove(aPatientTeam);
      patientTeams.add(index, aPatientTeam);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPatientTeamAt(aPatientTeam, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    HospitalTeams placeholderHospitalTeams = hospitalTeams;
    this.hospitalTeams = null;
    if(placeholderHospitalTeams != null)
    {
      placeholderHospitalTeams.removeWard(this);
    }
    for(int i=patientTeams.size(); i > 0; i--)
    {
      PatientTeams aPatientTeam = patientTeams.get(i - 1);
      aPatientTeam.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "patientsGender" + ":" + getPatientsGender()+ "," +
            "capacity" + ":" + getCapacity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hospitalTeams = "+(getHospitalTeams()!=null?Integer.toHexString(System.identityHashCode(getHospitalTeams())):"null");
  }
}