package ce204_lib_test;

import static org.junit.Assert.*;

import java.sql.Date;
import WardsAndTeams.PatientTeams;
import org.junit.Before;
import org.junit.Test;
import Organization.Department;
import WardsAndTeams.ConsultantDoctor;
import WardsAndTeams.HospitalTeams;
import WardsAndTeams.Team;
import WardsAndTeams.Ward;
import WardsAndTeams.JuniorDoctor;
import WardsAndTeams.DoctorTeams;
public class WardsAndTeams_test {

	
	public void test() {
		fail("Not yet implemented");
	}
	private HospitalTeams hospitalTeams;

	  @Before
	  public void setUp() throws Exception {
	    hospitalTeams = new HospitalTeams("Test Hospital", "123 Main St", "555-555-1234");
	  }

	  @Test
	  public void testConstructor() {
	    assertEquals("Test Hospital", hospitalTeams.getName());
	    assertEquals("123 Main St", hospitalTeams.getAddress());
	    assertEquals("555-555-1234", hospitalTeams.getPhone());
	    assertEquals(0, hospitalTeams.getWards().size());
	    assertEquals(0, hospitalTeams.getTeams().size());
	  }
	  private ConsultantDoctor consultantDoctor;

	  @Before
	  public void setUp2() throws Exception {
	    Department department = new Department(hospitalTeams);
	    consultantDoctor = new ConsultantDoctor("Dr.", "John", "A.", "Doe", "Dr. John A. Doe",
	        new Date(1980, 1, 1), "Male", "123 Main St", "555-555-1234", new Date(2000, 1, 1), "MD",
	        "Board Certified", "English", department, "Cardiology", "Test Location");
	  }

	  @Test
	  public void testConstructor2() {
	    assertEquals("Dr.", consultantDoctor.getTitle());
	    assertEquals("John", consultantDoctor.getGivenName());
	    assertEquals("A.", consultantDoctor.getMiddleName());
	    assertEquals("Doe", consultantDoctor.getFamilyName());
	    assertEquals("Dr. John A. Doe", consultantDoctor.getName());
	    assertEquals(new Date(1980, 1, 1), consultantDoctor.getBirthdate());
	    assertEquals("Male", consultantDoctor.getGender());
	    assertEquals("123 Main St", consultantDoctor.getHomeAddress());
	    assertEquals("555-555-1234", consultantDoctor.getPhone());
	    assertEquals(new Date(2000, 1, 1), consultantDoctor.getJoined());
	    assertEquals("MD", consultantDoctor.getEducation());
	    assertEquals("Board Certified", consultantDoctor.getCertification());
	    assertEquals("English", consultantDoctor.getLanguages());
	    assertEquals("Cardiology", consultantDoctor.getSpecialty());
	    assertEquals("Test Location", consultantDoctor.getLocations());
	  }
	  @Test
	  public void testSetSpecialty() {
	      // Create a DoctorTeams object
	      DoctorTeams doctor = new DoctorTeams("Dr.", "John", "Doe", "Smith", "John Doe Smith",
	              new Date(1990, 1, 1), "Male", "123 Main St", "555-5555", new Date(2020, 1, 1),
	              "MD", "Board Certified", "English", new Department(hospitalTeams), "Heart", "Hospital A");
	      
	    
	      boolean result = doctor.setSpecialty("Brain");
	      
	 
	      assertEquals("Brain", doctor.getSpecialty());
	      
	   
	      assertTrue(result);
	  }
	  @Test
	  public void testConstructor3() {
	    HospitalTeams hospitalTeams = new HospitalTeams(null, null, null);
	    Team team = new Team("Test Team", hospitalTeams);
	    
	    assertEquals("Test Team", team.getName());
	    assertNotNull(team.getDoctorTeams());
	    assertNotNull(team.getPatientTeams());
	    assertTrue(team.getDoctorTeams().isEmpty());
	    assertTrue(team.getPatientTeams().isEmpty());
	    assertSame(hospitalTeams, team.getHospitalTeams());
	  }
	  @Test
	  public void testConstructor4() {
	    String teamName = "Cardiology";
	    HospitalTeams hospitalTeams = new HospitalTeams(teamName, teamName, teamName);
	    Team team = new Team(teamName, hospitalTeams);
	    assertEquals(teamName, team.getName());
	    assertEquals(hospitalTeams, team.getHospitalTeams());
	    assertTrue(team.getDoctorTeams().isEmpty());
	    assertTrue(team.getPatientTeams().isEmpty());
	  }
	  @Test
	  public void testConstructor5() {
	    String wardName = "Cardiology Ward";
	    String patientsGender = "Female";
	    int capacity = 10;
	    HospitalTeams hospitalTeams = new HospitalTeams(patientsGender, patientsGender, patientsGender);
	    Ward ward = new Ward(wardName, patientsGender, capacity, hospitalTeams);
	    assertEquals(wardName, ward.getName());
	    assertEquals(patientsGender, ward.getPatientsGender());
	    assertEquals(capacity, ward.getCapacity());
	    assertEquals(hospitalTeams, ward.getHospitalTeams());
	    assertTrue(ward.getPatientTeams().isEmpty());
	  }
	  @Test
	  public void testConstructor6() {
	    String title = "Mr.";
	    String givenName = "John";
	    String middleName = "M";
	    String familyName = "Doe";
	    String name = "John M Doe";
	    Date birthdate = new Date(1990, 1, 1);
	    String gender = "male";
	    String homeAddress = "123 Main St";
	    String phone = "555-1234";
	    String id = "123456";
	    Date birthDate2 = new Date(1990, 1, 1);
	    int age = 33;
	    Date accepted = new Date(2023, 4, 5);
	    String sickness = "Flu";
	    String prescriptions = "Ibuprofen";
	    String allergies = "None";
	    String specialReqs = "None";
	    Team team = new Team("Cardiology", new HospitalTeams(specialReqs, specialReqs, specialReqs));
	    Ward ward = new Ward("Cardiac Ward", "male", 20, new HospitalTeams(specialReqs, specialReqs, specialReqs));
	    PatientTeams patient = new PatientTeams(title, givenName, middleName, familyName, name, birthdate, gender, homeAddress, phone,
	        id, birthDate2, age, accepted, sickness, prescriptions, allergies, specialReqs, team, ward);
	    assertEquals(title, patient.getTitle());
	    assertEquals(givenName, patient.getGivenName());
	    assertEquals(middleName, patient.getMiddleName());
	    assertEquals(familyName, patient.getFamilyName());
	    assertEquals(name, patient.getName());
	    assertEquals(birthdate, patient.getBirthdate());
	    assertEquals(gender, patient.getGender());
	    assertEquals(homeAddress, patient.getHomeAddress());
	    assertEquals(phone, patient.getPhone());
	    assertEquals(id, patient.getId());
	    
	    assertEquals(age, patient.getAge());
	    assertEquals(accepted, patient.getAccepted());
	    assertEquals(sickness, patient.getSickness());
	    assertEquals(prescriptions, patient.getPrescriptions());
	    assertEquals(allergies, patient.getAllergies());
	    assertEquals(specialReqs, patient.getSpecialReqs());
	    assertEquals(team, patient.getTeam());
	    assertEquals(ward, patient.getWard());
	    assertTrue(patient.getDoctorTeams().isEmpty());
	  }
	  @Test
	  public void testConstructor7() {
	    String title = "Dr.";
	    String givenName = "John";
	    String middleName = "";
	    String familyName = "Doe";
	    String name = "Dr. John Doe";
	    Date birthdate = new Date(2000, 1, 1);
	    String gender = "Male";
	    String homeAddress = "123 Main St";
	    String phone = "555-1234";
	    Date joined = new Date(2020, 1, 1);
	    String education = "MD";
	    String certification = "ABIM";
	    String languages = "English, Spanish";
	    Department department = new Department(hospitalTeams);
	    String specialty = "Interventional Cardiology";
	    String locations = "Hospital A, Clinic B";
	    
	    JuniorDoctor doctor = new JuniorDoctor(title, givenName, middleName, familyName, name, birthdate, gender, homeAddress, phone, joined, education, certification, languages, department, specialty, locations);
	    
	    assertEquals(title, doctor.getTitle());
	    assertEquals(givenName, doctor.getGivenName());
	    assertEquals(middleName, doctor.getMiddleName());
	    assertEquals(familyName, doctor.getFamilyName());
	    assertEquals(name, doctor.getName());
	    assertEquals(birthdate, doctor.getBirthdate());
	    assertEquals(gender, doctor.getGender());
	    assertEquals(homeAddress, doctor.getHomeAddress());
	    assertEquals(phone, doctor.getPhone());
	    assertEquals(joined, doctor.getJoined());
	    assertEquals(education, doctor.getEducation());
	    assertEquals(certification, doctor.getCertification());
	    assertEquals(languages, doctor.getLanguages());
	    assertEquals(department, doctor.getDepartment());
	    assertEquals(specialty, doctor.getSpecialty());
	    assertEquals(locations, doctor.getLocations());
	  }
}
