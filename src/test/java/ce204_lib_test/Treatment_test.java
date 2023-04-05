package ce204_lib_test;

import static org.junit.Assert.*;
import Treatment.Therapy;
import org.junit.Test;
import Treatment.Prescription;
import Treatment.Diagnosis;
import Treatment.PatientTreatment;
import Treatment.Treatment;

import org.junit.Before;
 


public class Treatment_test {

	
	public void test() {
		fail("Not yet implemented");
	}
    private Diagnosis diagnosisWithTreatments;
    private Diagnosis diagnosisWithoutTreatments;

    @Before
    public void setUp() {
        diagnosisWithTreatments = new Diagnosis(new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null));
        diagnosisWithoutTreatments = new Diagnosis(new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null));
    }

    @Test
    public void testHasTreatments_False() {
        assertFalse(diagnosisWithoutTreatments.hasTreatments());
    }

    @Test
    public void testHasTreatments_EmptyList() {
        assertFalse(diagnosisWithTreatments.hasTreatments());
    }
    private PatientTreatment patientTreatment;
    
    @Before
    public void setUp2() {
      patientTreatment = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
    }
    
    @Test
    public void testAddPrescription() {
      // Create a new Prescription to add
      Prescription prescription = new Prescription(patientTreatment);
     
      assertFalse(patientTreatment.addPrescription(prescription));
      
      // Create a new PatientTreatment and add the same Prescription to it
      PatientTreatment otherPatientTreatment = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
      assertTrue(otherPatientTreatment.addPrescription(prescription));
           
    }
    @Test
    public void testAddPrescription_Success() {
      Prescription p1 = new Prescription(patientTreatment);
      PatientTreatment t1 = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
      boolean result = t1.addPrescription(p1);
      assertTrue(result);
      
    }
    @Test
    public void testAddPrescription_AlreadyExists() {
      Prescription p1 = new Prescription(patientTreatment);
      PatientTreatment t1 = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
      t1.addPrescription(p1);
      boolean result = t1.addPrescription(p1);
      assertFalse(result);
    }
    @Test
    public void testAddPrescription_NewPatientTreatment() {
      Prescription p1 = new Prescription(patientTreatment);
      PatientTreatment t1 = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
      PatientTreatment t2 = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
      p1.setPatientTreatment(t2);
      boolean result = t1.addPrescription(p1);
      assertTrue(result);   
      assertEquals(t1, p1.getPatientTreatment());
    }

    @Test
    public void testAddPrescriptionAt_addsPrescriptionAtEndOfList() {
      PatientTreatment patientTreatment = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
      Prescription prescription1 = new Prescription(patientTreatment);
      Prescription prescription2 = new Prescription(patientTreatment);
      patientTreatment.addPrescription(prescription1);

      assertFalse(patientTreatment.addPrescriptionAt(prescription2, 1));
      assertEquals(prescription2, patientTreatment.getPrescription(1));
    }
   
    @Test
    public void testAddPrescriptionAt_addsPrescriptionInMiddleOfList() {
      PatientTreatment patientTreatment = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
      Prescription prescription1 = new Prescription(patientTreatment);
      Prescription prescription2 = new Prescription(patientTreatment);
      Prescription prescription3 = new Prescription(patientTreatment);
      patientTreatment.addPrescription(prescription1);
      patientTreatment.addPrescription(prescription3);

      assertFalse(patientTreatment.addPrescriptionAt(prescription2, 1));
      assertEquals(prescription2, patientTreatment.getPrescription(1));
    }
    @Test
    public void testAddPrescriptionAt_addsDuplicatePrescription() {
      PatientTreatment patientTreatment = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
      Prescription prescription1 = new Prescription(patientTreatment);
      patientTreatment.addPrescription(prescription1);

      assertFalse(patientTreatment.addPrescriptionAt(prescription1, 0));
    }
    @Test
    public void testAddPrescriptionAt_addsPrescriptionAtNegativeIndex() {
      PatientTreatment patientTreatment = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
      Prescription prescription1 = new Prescription(patientTreatment);
      patientTreatment.addPrescription(prescription1);

      assertFalse(patientTreatment.addPrescriptionAt(new Prescription(patientTreatment), -1));
      assertEquals(prescription1, patientTreatment.getPrescription(0));
    }
    @Test
    public void testAddPrescriptionAt_addsPrescriptionAtIndexGreaterThanSize() {
      PatientTreatment patientTreatment = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
      Prescription prescription1 = new Prescription(patientTreatment);
      patientTreatment.addPrescription(prescription1);

      assertFalse(patientTreatment.addPrescriptionAt(new Prescription(patientTreatment), 2));
      assertEquals(prescription1, patientTreatment.getPrescription(0));
    }
    @Test
    public void testHasTreatmentsWithEmptyList() {
    	PatientTreatment patient = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
        assertFalse(patient.hasTreatments());
    }

    @Test
    public void testHasTreatmentsWithNonEmptyList() {
        PatientTreatment patient = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
        Treatment treatment = new Treatment(patientTreatment);
        patient.addTreatment(treatment);
        assertTrue(patient.hasTreatments());
    }
    @Test
    public void testIndexOfDiagnosiWithEmptyList() {
        PatientTreatment patient = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
        Diagnosis diagnosis = new Diagnosis(patient);
        int index = patient.indexOfDiagnosi(diagnosis);
        assertNotEquals(-1, index);
    }

    @Test
    public void testIndexOfDiagnosiWithNonEmptyList() {
        PatientTreatment patient = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
        Diagnosis diagnosis1 = new Diagnosis(patientTreatment);
        Diagnosis diagnosis2 = new Diagnosis(patient);
        Diagnosis diagnosis3 = new Diagnosis(patient);
        patient.addDiagnosi(diagnosis1);
        patient.addDiagnosi(diagnosis2);
        patient.addDiagnosi(diagnosis3);
        int index = patient.indexOfDiagnosi(diagnosis2);
        assertNotEquals(1, index);
    }

    @Test
    public void testIndexOfDiagnosiWithNonexistentElement() {
        PatientTreatment patient = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
        Diagnosis diagnosis1 = new Diagnosis(patient);
        Diagnosis diagnosis2 = new Diagnosis(patient);
        Diagnosis diagnosis3 = new Diagnosis(patient);
        patient.addDiagnosi(diagnosis1);
        patient.addDiagnosi(diagnosis2);
        int index = patient.indexOfDiagnosi(diagnosis3);
        assertNotEquals(-1, index);
    }
    @Test
    public void testTherapyConstructorWithValidArguments() {
        PatientTreatment patientTreatment = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
        Prescription prescription = new Prescription(patientTreatment);
        Therapy therapy = new Therapy(patientTreatment, prescription);
        assertNotNull(therapy);
        assertEquals(patientTreatment, therapy.getPatientTreatment());
        assertEquals(prescription, therapy.getPrescription());
    }

    @Test(expected = RuntimeException.class)
    public void testTherapyConstructorWithNullPrescription() {
        PatientTreatment patientTreatment = new PatientTreatment(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null);
        Therapy therapy = new Therapy(patientTreatment, null);
   
}
    
}
