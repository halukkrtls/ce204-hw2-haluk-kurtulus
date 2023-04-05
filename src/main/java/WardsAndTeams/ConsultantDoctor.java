package WardsAndTeams;

import java.sql.Date;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

import Organization.Department;

// line 45 "model.ump"
// line 95 "model.ump"
public class ConsultantDoctor extends DoctorTeams
{

  public ConsultantDoctor(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, String aName,
			Date aBirthdate, String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation,
			String aCertification, String aLanguages, Department aDepartment, String aSpecialty, String aLocations) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aName, aBirthdate, aGender, aHomeAddress, aPhone, aJoined,
				aEducation, aCertification, aLanguages, aDepartment, aSpecialty, aLocations);
		// TODO Auto-generated constructor stub
	}
//------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

 
  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne_specialization */
  public Team getTeam_OneTeam()
  {
    return super.getTeam();
  }
  /* Code from template association_GetMany_specialization */
  public PatientTeams getPatientTeam_PatientTeams(int index)
  {
    PatientTeams aPatientTeam = (PatientTeams)super.getPatientTeam(index);
    return aPatientTeam;
  }

  /* required for Java 7. */
  @SuppressWarnings("unchecked")
  public List<PatientTeams> getPatientTeams_PatientTeams()
  {
    List<? extends PatientTeams> newPatientTeams = super.getPatientTeams();
    return (List<PatientTeams>)newPatientTeams;
  }
  /* Code from template association_set_specialization_reqSuperCode */  /* Code from template association_set_specialization_reqSuperCode */  /* Code from template association_MinimumNumberOfMethod_specialization */
  public static int minimumNumberOfPatientTeams_PatientTeams()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne_specialization */

  public void delete()
  {
    Team existingTeam = getTeam();
    super.clear_team();
    if (existingTeam != null)
    {
      existingTeam.delete();
    }
    super.delete();
  }
  public static ConsultantDoctor get() {
	    // TODO Auto-generated method stub
	    return null;
	}

}