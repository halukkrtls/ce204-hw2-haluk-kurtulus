package ce204_lib_test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import Organization.*;

public class Organization_test {

	@Test
	public void testNumberOfStaffs() {
	  Department department = new Department(new Hospital(null, null, null));
	  Staff staff1 = department.addStaff("Mr", "John", "", "Doe", "John Doe", new Date(1910), "Male", "123 Main St", "555-1234", new Date(2002), "Bachelor's", "Certified", "English");
	  Staff staff2 = department.addStaff("Ms", "Jane", "", "Smith", "Jane Smith", new Date(1990), "Female", "456 Elm St", "555-5678", new Date(1453), "Master's", "Certified", "English, French");
	  assertEquals(2, department.numberOfStaffs());
	}
	@Test
	public void testAddStaff() {
	  Department department = new Department(new Hospital(null, null, null));
	  Staff staff = department.addStaff("Mr", "John", "", "Doe", "John Doe", new Date(1453), "Male", "123 Main St", "555-1234", new Date(1865), "Bachelor's", "Certified", "English");
	  assertTrue(department.hasStaffs());
	  assertEquals(1, department.numberOfStaffs());
	  assertEquals(staff, department.getStaff(0));
	}
	Hospital hospital;

	  @Before
	  public void setUp() throws Exception {
	    hospital = new Hospital("Example Hospital", "123 Main St", "555-555-5555");
	  }

	  @Test
	  public void testSetName() {
	    boolean wasSet = hospital.setName("New Hospital Name");
	    assertEquals(true, wasSet);
	    assertEquals("New Hospital Name", hospital.name);
	  }
	  @Test
	  public void testSetAddress() {
	    boolean wasSet = hospital.setAddress("456 Second St");
	    assertEquals(true, wasSet);
	    assertEquals("456 Second St", hospital.address);
	  }

	  @Test
	  public void testSetPhone() {
	    boolean wasSet = hospital.setPhone("777-777-7777");
	    assertEquals(true, wasSet);
	    assertEquals("777-777-7777", hospital.phone);
	  }
	  public void testSetJoined() {
		    Staff staff = new Staff("Ms.", "Jane", "A.", "Doe", "Jane A. Doe", new Date(2000, 1, 1), "female", "123 Main St.", "555-1234", new Date(0), "Bachelor's degree", "ExampleCertification", "English, Spanish", new Department(null));

		    Date newJoined = new Date(0);
		    boolean result = staff.setJoined(newJoined);

		    assertTrue(result);
		    assertEquals(newJoined, staff.getJoined());
		  } 
	  @Test
	  public void testAddHospital() {
	    Person person = new Person("John", "Doe", "123 Main St.", "555-1234", null, null, null, null, null);
	    Hospital hospital1 = new Hospital("Hospital 1", "123 Main St.", "555-5678");
	    Hospital hospital2 = new Hospital("Hospital 2", "456 Elm St.", "555-9012");

	    boolean result1 = person.addHospital(hospital1);
	    assertTrue(result1);
	    assertEquals(1, person.numberOfHospitals());
	  
	    assertEquals(person, hospital1.getPerson(0));

	    boolean result2 = person.addHospital(hospital2);
	    assertTrue(result2);
	    assertEquals(2, person.numberOfHospitals());
	   
	    assertEquals(person, hospital2.getPerson(0));

	    boolean result3 = person.addHospital(hospital1);
	    assertFalse(result3);
	    assertEquals(2, person.numberOfHospitals());
	  }
	  @Test
	  public void testHospital() {
	    Person person = new Person("John", "Doe", null, null, null, null, null, null, null);
	    Hospital hospital1 = new Hospital("Hospital 1", "123 Main St.", "555-1234");
	    Hospital hospital2 = new Hospital("Hospital 2", "456 Elm St.", "555-5678");

	    boolean result1 = person.addHospital(hospital1);
	    assertTrue(result1);
	    assertTrue(hospital1.getPersons().contains(person));
	    assertTrue(person.getHospitals().contains(hospital1));

	    boolean result2 = person.addHospital(hospital2);
	    assertTrue(result2);
	    assertTrue(hospital2.getPersons().contains(person));
	    assertTrue(person.getHospitals().contains(hospital2));

	    boolean result3 = person.addHospital(hospital1);
	    assertFalse(result3);
	    assertEquals(2, person.getHospitals().size());
	  }
	  @Test
	  public void testConstructor() {
	    
	    Hospital hospital = new Hospital(null, null, null);
	    
	    
	    Department department = new Department(hospital);
	    
	   
	    assertEquals(hospital, department.getHospital());
	    
	    
	    assertTrue(department.getStaffs().isEmpty());
	  }
	  @Test
	  public void testConstructor2() {
	   
	    Hospital hospital = new Hospital(null, null, null);
	    
	   
	    Department department = new Department(hospital);
	    
	   
	    assertEquals(hospital, department.getHospital());
	    
	    
	    assertEquals(0, department.numberOfStaffs());
	  }
	  @Test
	  public void testGetPatient() {
	
	    OperationsStaff os = new OperationsStaff("Mr.", "John", "", "Doe", "John Doe", new Date(0), "Male", "123 Main St.", "555-1234", new Date(0), "Bachelor's Degree", "Certified", "English, Spanish", new Department(hospital));

	 
	    Patient p1 = new Patient("Ms.", "Jane", "", "Smith", "Jane Smith", new Date(0), "Female", "456 Oak St.", "555-5678", null, new Date(0), 0, null, "Medical History", null, null, null);

	  
	    os.addPatient(p1);

	   
	    Patient retrievedPatient = os.getPatient(0);
	    assertEquals(retrievedPatient, p1);
	  }
	  @Before
	    public void setUp2() {
	        hospital = new Hospital(null, null, null);
	    }

	    @Test
	    public void testAddDepartment() {
	        Department department = hospital.addDepartment();
	        assertNotNull(department);
	        assertTrue(hospital.getDepartments().contains(department));
	    }
	    @Test
	    public void testConstructors() {
	      String title = "Dr.";
	      String givenName = "John";
	      String middleName = "A";
	      String familyName = "Doe";
	      String name = "John A. Doe";
	      Date birthdate = new Date(1990, 1, 1);
	      String gender = "Male";
	      String homeAddress = "123 Main St";
	      String phone = "123-456-7890";
	      Date joined = new Date(2020, 1, 1);
	      String education = "MD";
	      String certification = "Surgeon";
	      String languages = "English";
	      Department department = new Department(hospital);
	      String specialty = "Cardiothoracic Surgery";
	      String locations = "Hospital A, Hospital B";
	      
	      Surgeon surgeon = new Surgeon(title, givenName, middleName, familyName, name, birthdate, gender, homeAddress, phone, joined, education, certification, languages, department, specialty, locations);
	      
	      assertEquals(title, surgeon.getTitle());
	      assertEquals(givenName, surgeon.getGivenName());
	      assertEquals(middleName, surgeon.getMiddleName());
	      assertEquals(familyName, surgeon.getFamilyName());
	      assertEquals(name, surgeon.getName());
	      assertEquals(birthdate, surgeon.getBirthdate());
	      assertEquals(gender, surgeon.getGender());
	      assertEquals(homeAddress, surgeon.getHomeAddress());
	      assertEquals(phone, surgeon.getPhone());
	      assertEquals(joined, surgeon.getJoined());
	      assertEquals(education, surgeon.getEducation());
	      assertEquals(certification, surgeon.getCertification());
	      assertEquals(languages, surgeon.getLanguages());
	      assertEquals(department, surgeon.getDepartment());
	      assertEquals(specialty, surgeon.getSpecialty());
	    
	    }
	    @Test
	    public void testRemoveHospital() {
	       Person person = new Person(null, null, null, null, null, null, null, null, null);
	       Hospital hospital = new Hospital(null, null, null);
	       hospital.addPerson(person);
	       boolean result = person.removeHospital(hospital);

	       assertTrue(result);
	       assertFalse(hospital.getPersons().contains(person));
	    }
	    @Test
	    public void testRemoveNonExistentHospital() {
	       Person person = new Person(null, null, null, null, null, null, null, null, null);
	       Hospital hospital = new Hospital(null, null, null);
	       boolean result = person.removeHospital(hospital);

	       assertFalse(result);
	       assertFalse(hospital.getPersons().contains(person));
	    }
	    @Test
	    public void testRemoveHospitalWithOtherPerson() {
	       Person person1 = new Person(null, null, null, null, null, null, null, null, null);
	       Person person2 = new Person(null, null, null, null, null, null, null, null, null);
	       Hospital hospital = new Hospital(null, null, null);
	       hospital.addPerson(person1);
	       hospital.addPerson(person2);
	       boolean result = person1.removeHospital(hospital);

	       assertTrue(result);
	       assertFalse(hospital.getPersons().contains(person1));
	       assertTrue(hospital.getPersons().contains(person2));
	    }

	    @Test
	    public void testAddHospitalAt() {
	       Person person = new Person(null, null, null, null, null, null, null, null, null);
	       Hospital hospital1 = new Hospital(null, null, null);
	       Hospital hospital2 = new Hospital(null, null, null);
	       person.addHospital(hospital1);

	       boolean result = person.addHospitalAt(hospital2, 0);

	       assertTrue(result);
	       assertEquals(hospital2, person.getHospital(0));
	    }
	    @Test
	    public void testAddHospitalAtWithInvalidIndex() {
	       Person person = new Person(null, null, null, null, null, null, null, null, null);
	       Hospital hospital1 = new Hospital(null, null, null);
	       Hospital hospital2 = new Hospital(null, null, null);
	       person.addHospital(hospital1);

	       boolean result = person.addHospitalAt(hospital2, -1);

	       assertTrue(result);
	       assertEquals(hospital2, person.getHospital(0));
	    }
	    @Test
	    public void testReceptionistConstructor() {
	      Hospital hospital = new Hospital(null, null, null);
	    	String title = "Ms.";
	       String givenName = "Jane";
	       String middleName = "";
	       String familyName = "Doe";
	       String name = "Jane Doe";
	       Date birthdate = new Date(2000, 1, 1);
	       String gender = "female";
	       String homeAddress = "123 Main St";
	       String phone = "555-1234";
	       Date joined = new Date(2020, 1, 1);
	       String education = "Bachelor's degree in Hospitality Management";
	       String certification = "Certified Receptionist";
	       String languages = "English, French";
	       Department department = new Department(hospital);

	       Receptionist receptionist = new Receptionist(title, givenName, middleName, familyName, name, birthdate, gender, homeAddress, phone, joined, education, certification, languages, department);

	       assertEquals(title, receptionist.getTitle());
	       assertEquals(givenName, receptionist.getGivenName());
	       assertEquals(middleName, receptionist.getMiddleName());
	       assertEquals(familyName, receptionist.getFamilyName());
	       assertEquals(name, receptionist.getName());
	       assertEquals(birthdate, receptionist.getBirthdate());
	       assertEquals(gender, receptionist.getGender());
	       assertEquals(homeAddress, receptionist.getHomeAddress());
	       assertEquals(phone, receptionist.getPhone());
	       assertEquals(joined, receptionist.getJoined());
	       assertEquals(education, receptionist.getEducation());
	       assertEquals(certification, receptionist.getCertification());
	       assertEquals(languages, receptionist.getLanguages());
	       assertEquals(department, receptionist.getDepartment());
	    }
	    @Test
	    public void testTechnicalStaffConstructor() {
	    	Hospital hospital = new Hospital(null, null, null);
	      String title = "Mr.";
	      String givenName = "John";
	      String middleName = "Adam";
	      String familyName = "Doe";
	      String name = "John Doe";
	      Date birthdate = new Date(0);
	      String gender = "Male";
	      String homeAddress = "123 Main Street";
	      String phone = "555-1234";
	      Date joined = new Date(0);
	      String education = "Bachelor's Degree";
	      String certification = "Certified in Technical Support";
	      String languages = "English, Spanish";
	      Department department = new Department(hospital);
	      
	      TechnicalStaff technicalStaff = new TechnicalStaff(title, givenName, middleName, familyName, name, birthdate, gender, homeAddress, phone, joined, education, certification, languages, department);
	      
	      assertEquals(title, technicalStaff.getTitle());
	      assertEquals(givenName, technicalStaff.getGivenName());
	      assertEquals(middleName, technicalStaff.getMiddleName());
	      assertEquals(familyName, technicalStaff.getFamilyName());
	      assertEquals(name, technicalStaff.getName());
	      assertEquals(birthdate, technicalStaff.getBirthdate());
	      assertEquals(gender, technicalStaff.getGender());
	      assertEquals(homeAddress, technicalStaff.getHomeAddress());
	      assertEquals(phone, technicalStaff.getPhone());
	      assertEquals(joined, technicalStaff.getJoined());
	      assertEquals(education, technicalStaff.getEducation());
	      assertEquals(certification, technicalStaff.getCertification());
	      assertEquals(languages, technicalStaff.getLanguages());
	      assertEquals(department, technicalStaff.getDepartment());
	    }
	    @Test
	    public void testTechnicianConstructor() {
	      String title = "Mr.";
	      String givenName = "John";
	      String middleName = "Adam";
	      String familyName = "Doe";
	      String name = "John Doe";
	      Date birthdate = new Date(0);
	      String gender = "Male";
	      String homeAddress = "123 Main Street";
	      String phone = "555-1234";
	      Date joined = new Date(0);
	      String education = "Associate's Degree";
	      String certification = "Certified Technician";
	      String languages = "English";
	      Department department = new Department(hospital);
	      
	      Technician technician = new Technician(title, givenName, middleName, familyName, name, birthdate, gender, homeAddress, phone, joined, education, certification, languages, department);
	      
	      assertEquals(title, technician.getTitle());
	      assertEquals(givenName, technician.getGivenName());
	      assertEquals(middleName, technician.getMiddleName());
	      assertEquals(familyName, technician.getFamilyName());
	      assertEquals(name, technician.getName());
	      assertEquals(birthdate, technician.getBirthdate());
	      assertEquals(gender, technician.getGender());
	      assertEquals(homeAddress, technician.getHomeAddress());
	      assertEquals(phone, technician.getPhone());
	      assertEquals(joined, technician.getJoined());
	      assertEquals(education, technician.getEducation());
	      assertEquals(certification, technician.getCertification());
	      assertEquals(languages, technician.getLanguages());
	      assertEquals(department, technician.getDepartment());
	    }
	    @Test
	    public void testDelete() {
	        // setup
	        Department department = new Department(hospital);
	        Staff staff = new Staff("Dr.", "John", "M.", "Doe", "Dr. John M. Doe", new Date(0), "Male", "123 Main St", "555-1234", new Date(0), "MD", "Cardiology", "English", department);
	   
	        staff.delete();
	        
	 
	        assertNull(staff.getDepartment());
	       
	    }
	    @Test
	    public void testFrontDeskStaffConstructor() {
	     
	      FrontDeskStaff staff = new FrontDeskStaff("Mr.", "John", "Doe", "Smith", "John Smith", new Date(0), "Male", "123 Main St.", "555-1234", new Date(0), "Bachelor's Degree", "Certified Front Desk Staff", "English, Spanish", new Department(hospital));

	
	      assertNotNull(staff);
	    }

	    @Test
	    public void testFrontDeskStaffGetDepartment() {
	   
	      FrontDeskStaff staff = new FrontDeskStaff("Mrs.", "Jane", "", "Doe", "Jane Doe", new Date(0), "Female", "456 Main St.", "555-5678", new Date(0), "Associate's Degree", "Certified Front Desk Staff", "English, French", new Department(hospital));

	   
	     
	    }
	    @Test
	    public void testFrontDeskStaffGetCertification() {
	   
	      FrontDeskStaff staff = new FrontDeskStaff("Ms.", "Sarah", "Anne", "Smith", "Sarah Smith", new Date(0), "Female", "789 Main St.", "555-9012", new Date(0), "Bachelor's Degree", "Certified Front Desk Staff", "English", new Department(hospital));

	
	      assertEquals("Certified Front Desk Staff", staff.getCertification());
	    }

	    @Test
	    public void testFrontDeskStaffGetLanguages() {
	   
	      FrontDeskStaff staff = new FrontDeskStaff("Mr.", "David", "", "Lee", "David Lee", new Date(0), "Male", "321 Main St.", "555-3456", new Date(0), "Bachelor's Degree", "Certified Front Desk Staff", "English, Chinese", new Department(hospital));

	  
	      assertEquals("English, Chinese", staff.getLanguages());
	    }
	    @Test
	    public void testAddOrMoveDepartmentAt() {
	   
	      Department dept1 = new Department(hospital);
	      
	      
	      Hospital company = new Hospital(null, null, null);
	      
	      
	      company.addDepartment(dept1);
	      
	    
	      Department dept2 = new Department(hospital);
	      
	     
	      company.addDepartment(dept2);
	      
	    
	      boolean result = company.addOrMoveDepartmentAt(dept2, 0);
	      
	      
	      assertTrue(result);
	      assertEquals(dept2, company.getDepartment(0));
	      
	    
	      result = company.addOrMoveDepartmentAt(dept1, 1);
	      
	     
	      assertTrue(result);
	      assertEquals(dept1, company.getDepartment(1));
	      
	     
	      Department dept3 = new Department(hospital);
	      result = company.addOrMoveDepartmentAt(dept3, 2);
	      
	    
	      assertTrue(result);
	      assertEquals(dept3, company.getDepartment(2));
	    }
	    
}
