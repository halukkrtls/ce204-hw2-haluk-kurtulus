package WardsAndTeams;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 11 "model.ump"
// line 71 "model.ump"
public class Team
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Team Attributes
  private String name;

  //Team Associations
  private List<DoctorTeams> doctorTeams;
  private HospitalTeams hospitalTeams;
  private List<PatientTeams> patientTeams;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Team(String aName, HospitalTeams aHospitalTeams)
  {
    name = aName;
    doctorTeams = new ArrayList<DoctorTeams>();
    boolean didAddHospitalTeams = setHospitalTeams(aHospitalTeams);
    if (!didAddHospitalTeams)
    {
      throw new RuntimeException("Unable to create team due to hospitalTeams. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetMany */
  public DoctorTeams getDoctorTeam(int index)
  {
    DoctorTeams aDoctorTeam = doctorTeams.get(index);
    return aDoctorTeam;
  }

  public List<DoctorTeams> getDoctorTeams()
  {
    List<DoctorTeams> newDoctorTeams = Collections.unmodifiableList(doctorTeams);
    return newDoctorTeams;
  }

  public int numberOfDoctorTeams()
  {
    int number = doctorTeams.size();
    return number;
  }

  public boolean hasDoctorTeams()
  {
    boolean has = doctorTeams.size() > 0;
    return has;
  }

  public int indexOfDoctorTeam(DoctorTeams aDoctorTeam)
  {
    int index = doctorTeams.indexOf(aDoctorTeam);
    return index;
  }
  /* Code from template association_GetMany_clear */
  protected void clear_doctorTeams()
  {
    doctorTeams.clear();
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
  /* Code from template association_GetOne_relatedSpecialization */
  public ConsultantDoctor getConsultantDoctor_OneConsultantDoctor()
  {
    return (ConsultantDoctor)ConsultantDoctor.get();
  } 
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDoctorTeams()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addDoctorTeam(DoctorTeams aDoctorTeam)
  {
    boolean wasAdded = false;
    if (doctorTeams.contains(aDoctorTeam)) { return false; }
    Team existingTeam = aDoctorTeam.getTeam();
    if (existingTeam == null)
    {
      aDoctorTeam.setTeam(this);
    }
    else if (!this.equals(existingTeam))
    {
      existingTeam.removeDoctorTeam(aDoctorTeam);
      addDoctorTeam(aDoctorTeam);
    }
    else
    {
      doctorTeams.add(aDoctorTeam);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDoctorTeam(DoctorTeams aDoctorTeam)
  {
    boolean wasRemoved = false;
    if (doctorTeams.contains(aDoctorTeam))
    {
      doctorTeams.remove(aDoctorTeam);
      aDoctorTeam.setTeam(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDoctorTeamAt(DoctorTeams aDoctorTeam, int index)
  {  
    boolean wasAdded = false;
    if(addDoctorTeam(aDoctorTeam))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctorTeams()) { index = numberOfDoctorTeams() - 1; }
      doctorTeams.remove(aDoctorTeam);
      doctorTeams.add(index, aDoctorTeam);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDoctorTeamAt(DoctorTeams aDoctorTeam, int index)
  {
    boolean wasAdded = false;
    if(doctorTeams.contains(aDoctorTeam))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctorTeams()) { index = numberOfDoctorTeams() - 1; }
      doctorTeams.remove(aDoctorTeam);
      doctorTeams.add(index, aDoctorTeam);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDoctorTeamAt(aDoctorTeam, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setHospitalTeams(HospitalTeams aHospitalTeams)
  {
    boolean wasSet = false;
    //Must provide hospitalTeams to team
    if (aHospitalTeams == null)
    {
      return wasSet;
    }

    if (hospitalTeams != null && hospitalTeams.numberOfTeams() <= HospitalTeams.minimumNumberOfTeams())
    {
      return wasSet;
    }

    HospitalTeams existingHospitalTeams = hospitalTeams;
    hospitalTeams = aHospitalTeams;
    if (existingHospitalTeams != null && !existingHospitalTeams.equals(aHospitalTeams))
    {
      boolean didRemove = existingHospitalTeams.removeTeam(this);
      if (!didRemove)
      {
        hospitalTeams = existingHospitalTeams;
        return wasSet;
      }
    }
    hospitalTeams.addTeam(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatientTeams()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public PatientTeams addPatientTeam(String aId, String aGender, int aAge, String aAccepted, String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs, Ward aWard)
  {
    return new PatientTeams(aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, null, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, null, aAge, null, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, null, aWard);
  }

  public boolean addPatientTeam(PatientTeams aPatientTeam)
  {
    boolean wasAdded = false;
    if (patientTeams.contains(aPatientTeam)) { return false; }
    Team existingTeam = aPatientTeam.getTeam();
    boolean isNewTeam = existingTeam != null && !this.equals(existingTeam);
    if (isNewTeam)
    {
      aPatientTeam.setTeam(this);
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
    //Unable to remove aPatientTeam, as it must always have a team
    if (!this.equals(aPatientTeam.getTeam()))
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
  /* Code from template association_set_specialization_reqCommonCode */  /* Code from template association_SetOneToOptionalOne_relatedSpecialization */
 
  /* Code from template association_GetPrivate */
  private void setTeam(ConsultantDoctor aConsultantDoctor, Team aTeam)
  {
    try
    {
      java.lang.reflect.Field mentorField = aConsultantDoctor.getClass().getDeclaredField("team");
      mentorField.setAccessible(true);
      mentorField.set(aConsultantDoctor, aTeam);
    }
    catch (Exception e)
    {
      throw new RuntimeException("Issue internally setting aTeam to aConsultantDoctor", e);
    }
  }

  public void delete()
  {
    while (doctorTeams.size() > 0)
    {
      DoctorTeams aDoctorTeam = doctorTeams.get(doctorTeams.size() - 1);
      aDoctorTeam.delete();
      doctorTeams.remove(aDoctorTeam);
    }
    
    HospitalTeams placeholderHospitalTeams = hospitalTeams;
    this.hospitalTeams = null;
    if(placeholderHospitalTeams != null)
    {
      placeholderHospitalTeams.removeTeam(this);
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
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hospitalTeams = "+(getHospitalTeams()!=null?Integer.toHexString(System.identityHashCode(getHospitalTeams())):"null") + System.getProperties().getProperty("line.separator") ;
           
  }
}