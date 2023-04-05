package WardsAndTeams;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

import Organization.*;

import java.sql.Date;
import java.util.*;

// line 24 "model.ump"
// line 82 "model.ump"
public class DoctorTeams extends Doctor
{

  public DoctorTeams(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName,
			Date aBirthdate, String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation,
			String aCertification, String aLanguages, Department aDepartment, String aSpecialty, String aLocations) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthdate, aGender, aHomeAddress, aPhone, aJoined,
				aEducation, aCertification, aLanguages, aDepartment, aSpecialty, aLocations);
		// TODO Auto-generated constructor stub
		specialty = aSpecialty;
	    locations = aLocations;
	    patientTeams = new ArrayList<PatientTeams>();
	}


//------------------------
  // MEMBER VARIABLES
  //------------------------

  //DoctorTeams Attributes
  private String specialty;
  private String locations;

  //DoctorTeams Associations
  private List<PatientTeams> patientTeams;
  private Team team;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  
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

  public boolean setLocations(String aLocations)
  {
    boolean wasSet = false;
    locations = aLocations;
    wasSet = true;
    return wasSet;
  }

  public String getSpecialty()
  {
    return specialty;
  }

  public String getLocations()
  {
    return locations;
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
  /* Code from template association_GetMany_clear */
  protected void clear_patientTeams()
  {
    patientTeams.clear();
  }
  /* Code from template association_GetOne */
  public Team getTeam()
  {
    return team;
  }

  public boolean hasTeam()
  {
    boolean has = team != null;
    return has;
  }
  /* Code from template association_GetOne_clear */
  protected void clear_team()
  {
    team = null;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatientTeams()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPatientTeam(PatientTeams aPatientTeam)
  {
    boolean wasAdded = false;
    if (patientTeams.contains(aPatientTeam)) { return false; }
    patientTeams.add(aPatientTeam);
    if (aPatientTeam.indexOfDoctorTeam(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPatientTeam.addDoctorTeam(this);
      if (!wasAdded)
      {
        patientTeams.remove(aPatientTeam);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePatientTeam(PatientTeams aPatientTeam)
  {
    boolean wasRemoved = false;
    if (!patientTeams.contains(aPatientTeam))
    {
      return wasRemoved;
    }

    int oldIndex = patientTeams.indexOf(aPatientTeam);
    patientTeams.remove(oldIndex);
    if (aPatientTeam.indexOfDoctorTeam(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPatientTeam.removeDoctorTeam(this);
      if (!wasRemoved)
      {
        patientTeams.add(oldIndex,aPatientTeam);
      }
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
  /* Code from template association_SetOptionalOneToMany */
  public boolean setTeam(Team aTeam)
  {
    boolean wasSet = false;
    Team existingTeam = team;
    team = aTeam;
    if (existingTeam != null && !existingTeam.equals(aTeam))
    {
      existingTeam.removeDoctorTeam(this);
    }
    if (aTeam != null)
    {
      aTeam.addDoctorTeam(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<PatientTeams> copyOfPatientTeams = new ArrayList<PatientTeams>(patientTeams);
    patientTeams.clear();
    for(PatientTeams aPatientTeam : copyOfPatientTeams)
    {
      aPatientTeam.removeDoctorTeam(this);
    }
    if (team != null)
    {
      Team placeholderTeam = team;
      this.team = null;
      placeholderTeam.removeDoctorTeam(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "specialty" + ":" + getSpecialty()+ "," +
            "locations" + ":" + getLocations()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "team = "+(getTeam()!=null?Integer.toHexString(System.identityHashCode(getTeam())):"null");
  }
}