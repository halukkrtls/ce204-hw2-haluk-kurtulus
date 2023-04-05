package WardsAndTeams;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

import Organization.*;

import java.sql.Date;
import java.util.*;

// line 31 "model.ump"
// line 88 "model.ump"
public class PatientTeams extends Patient
{

  public PatientTeams(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName,
			Date aBirthdate, String aGender, String aHomeAddress, String aPhone, String aId, Date aBirthDate2, int aAge,
			Date aAccepted, String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs,  Team aTeam , Ward aWard) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthdate, aGender, aHomeAddress, aPhone, aId, aBirthDate2,
				aAge, aAccepted, aSickness, aPrescriptions, aAllergies, aSpecialReqs);
		// TODO Auto-generated constructor stub
		id = aId;
	    gender = aGender;
	    age = aAge;
	    accepted = aAccepted;
	    sickness = aSickness;
	    prescriptions = aPrescriptions;
	    allergies = aAllergies;
	    specialReqs = aSpecialReqs;
	    boolean didAddTeam = setTeam(aTeam);
	    if (!didAddTeam)
	    {
	      throw new RuntimeException("Unable to create patientTeam due to team. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
	    }
	    boolean didAddWard = setWard(aWard);
	    if (!didAddWard)
	    {
	      throw new RuntimeException("Unable to create patientTeam due to ward. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
	    }
	    doctorTeams = new ArrayList<DoctorTeams>();
	}


//------------------------
  // MEMBER VARIABLES
  //------------------------

  //PatientTeams Attributes
  private String id;
  private String gender;
  private int age;
  private Date accepted;
  private String sickness;
  private String prescriptions;
  private String allergies;
  private String specialReqs;

  //PatientTeams Associations
  private Team team;
  private Ward ward;
  private List<DoctorTeams> doctorTeams;

  //------------------------
  // CONSTRUCTOR
  //------------------------

 

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

  public boolean setGender(String aGender)
  {
    boolean wasSet = false;
    gender = aGender;
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

  public String getGender()
  {
    return gender;
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
  /* Code from template association_GetOne */
  public Team getTeam()
  {
    return team;
  }
  /* Code from template association_GetOne */
  public Ward getWard()
  {
    return ward;
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
  /* Code from template association_GetOne_relatedSpecialization */
  public ConsultantDoctor getConsultantDoctor_OneConsultantDoctor()
  {
    return (ConsultantDoctor)ConsultantDoctor.get();
  } 
  /* Code from template association_SetOneToMany */
  public boolean setTeam(Team aTeam)
  {
    boolean wasSet = false;
    if (aTeam == null)
    {
      return wasSet;
    }

    Team existingTeam = team;
    team = aTeam;
    if (existingTeam != null && !existingTeam.equals(aTeam))
    {
      existingTeam.removePatientTeam(this);
    }
    team.addPatientTeam(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setWard(Ward aWard)
  {
    boolean wasSet = false;
    if (aWard == null)
    {
      return wasSet;
    }

    Ward existingWard = ward;
    ward = aWard;
    if (existingWard != null && !existingWard.equals(aWard))
    {
      existingWard.removePatientTeam(this);
    }
    ward.addPatientTeam(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDoctorTeams()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addDoctorTeam(DoctorTeams aDoctorTeam)
  {
    boolean wasAdded = false;
    if (doctorTeams.contains(aDoctorTeam)) { return false; }
    doctorTeams.add(aDoctorTeam);
    if (aDoctorTeam.indexOfPatientTeam(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDoctorTeam.addPatientTeam(this);
      if (!wasAdded)
      {
        doctorTeams.remove(aDoctorTeam);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeDoctorTeam(DoctorTeams aDoctorTeam)
  {
    boolean wasRemoved = false;
    if (!doctorTeams.contains(aDoctorTeam))
    {
      return wasRemoved;
    }

    int oldIndex = doctorTeams.indexOf(aDoctorTeam);
    doctorTeams.remove(oldIndex);
    if (aDoctorTeam.indexOfPatientTeam(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDoctorTeam.removePatientTeam(this);
      if (!wasRemoved)
      {
        doctorTeams.add(oldIndex,aDoctorTeam);
      }
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
  /* Code from template association_set_specialization_reqCommonCode */  /* Code from template association_SetOneToMany_relatedSpecialization */
  
  public void delete()
  {
    Team placeholderTeam = team;
    this.team = null;
    if(placeholderTeam != null)
    {
      placeholderTeam.removePatientTeam(this);
    }
    Ward placeholderWard = ward;
    this.ward = null;
    if(placeholderWard != null)
    {
      placeholderWard.removePatientTeam(this);
    }
    ArrayList<DoctorTeams> copyOfDoctorTeams = new ArrayList<DoctorTeams>(doctorTeams);
    doctorTeams.clear();
    for(DoctorTeams aDoctorTeam : copyOfDoctorTeams)
    {
      aDoctorTeam.removePatientTeam(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "gender" + ":" + getGender()+ "," +
            "age" + ":" + getAge()+ "," +
            "accepted" + ":" + getAccepted()+ "," +
            "sickness" + ":" + getSickness()+ "," +
            "prescriptions" + ":" + getPrescriptions()+ "," +
            "allergies" + ":" + getAllergies()+ "," +
            "specialReqs" + ":" + getSpecialReqs()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "team = "+(getTeam()!=null?Integer.toHexString(System.identityHashCode(getTeam())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "ward = "+(getWard()!=null?Integer.toHexString(System.identityHashCode(getWard())):"null") + System.getProperties().getProperty("line.separator") ;
  
  }
}