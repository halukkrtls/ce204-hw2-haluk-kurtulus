package Treatment;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 31 "model.ump"
// line 78 "model.ump"
public class Prescription
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Prescription Associations
  public List<Therapy> therapies;
  public PatientTreatment patientTreatment;
  public List<DoctorTreatment> doctorTreatments;
  public List<Diagnosis> diagnosis;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Prescription(PatientTreatment aPatientTreatment)
  {
    therapies = new ArrayList<Therapy>();
    boolean didAddPatientTreatment = setPatientTreatment(aPatientTreatment);
    if (!didAddPatientTreatment)
    {
      throw new RuntimeException("Unable to create prescription due to patientTreatment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    doctorTreatments = new ArrayList<DoctorTreatment>();
    diagnosis = new ArrayList<Diagnosis>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Therapy getTherapy(int index)
  {
    Therapy aTherapy = therapies.get(index);
    return aTherapy;
  }

  public List<Therapy> getTherapies()
  {
    List<Therapy> newTherapies = Collections.unmodifiableList(therapies);
    return newTherapies;
  }

  public int numberOfTherapies()
  {
    int number = therapies.size();
    return number;
  }

  public boolean hasTherapies()
  {
    boolean has = therapies.size() > 0;
    return has;
  }

  public int indexOfTherapy(Therapy aTherapy)
  {
    int index = therapies.indexOf(aTherapy);
    return index;
  }
  /* Code from template association_GetOne */
  public PatientTreatment getPatientTreatment()
  {
    return patientTreatment;
  }
  /* Code from template association_GetMany */
  public DoctorTreatment getDoctorTreatment(int index)
  {
    DoctorTreatment aDoctorTreatment = doctorTreatments.get(index);
    return aDoctorTreatment;
  }

  public List<DoctorTreatment> getDoctorTreatments()
  {
    List<DoctorTreatment> newDoctorTreatments = Collections.unmodifiableList(doctorTreatments);
    return newDoctorTreatments;
  }

  public int numberOfDoctorTreatments()
  {
    int number = doctorTreatments.size();
    return number;
  }

  public boolean hasDoctorTreatments()
  {
    boolean has = doctorTreatments.size() > 0;
    return has;
  }

  public int indexOfDoctorTreatment(DoctorTreatment aDoctorTreatment)
  {
    int index = doctorTreatments.indexOf(aDoctorTreatment);
    return index;
  }
  /* Code from template association_GetMany */
  public Diagnosis getDiagnosi(int index)
  {
    Diagnosis aDiagnosi = diagnosis.get(index);
    return aDiagnosi;
  }

  public List<Diagnosis> getDiagnosis()
  {
    List<Diagnosis> newDiagnosis = Collections.unmodifiableList(diagnosis);
    return newDiagnosis;
  }

  public int numberOfDiagnosis()
  {
    int number = diagnosis.size();
    return number;
  }

  public boolean hasDiagnosis()
  {
    boolean has = diagnosis.size() > 0;
    return has;
  }

  public int indexOfDiagnosi(Diagnosis aDiagnosi)
  {
    int index = diagnosis.indexOf(aDiagnosi);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTherapies()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Therapy addTherapy(PatientTreatment aPatientTreatment)
  {
    return new Therapy(aPatientTreatment, this);
  }

  public boolean addTherapy(Therapy aTherapy)
  {
    boolean wasAdded = false;
    if (therapies.contains(aTherapy)) { return false; }
    Prescription existingPrescription = aTherapy.getPrescription();
    boolean isNewPrescription = existingPrescription != null && !this.equals(existingPrescription);
    if (isNewPrescription)
    {
      aTherapy.setPrescription(this);
    }
    else
    {
      therapies.add(aTherapy);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTherapy(Therapy aTherapy)
  {
    boolean wasRemoved = false;
    //Unable to remove aTherapy, as it must always have a prescription
    if (!this.equals(aTherapy.getPrescription()))
    {
      therapies.remove(aTherapy);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTherapyAt(Therapy aTherapy, int index)
  {  
    boolean wasAdded = false;
    if(addTherapy(aTherapy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTherapies()) { index = numberOfTherapies() - 1; }
      therapies.remove(aTherapy);
      therapies.add(index, aTherapy);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTherapyAt(Therapy aTherapy, int index)
  {
    boolean wasAdded = false;
    if(therapies.contains(aTherapy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTherapies()) { index = numberOfTherapies() - 1; }
      therapies.remove(aTherapy);
      therapies.add(index, aTherapy);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTherapyAt(aTherapy, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPatientTreatment(PatientTreatment aPatientTreatment)
  {
    boolean wasSet = false;
    if (aPatientTreatment == null)
    {
      return wasSet;
    }

    PatientTreatment existingPatientTreatment = patientTreatment;
    patientTreatment = aPatientTreatment;
    if (existingPatientTreatment != null && !existingPatientTreatment.equals(aPatientTreatment))
    {
      existingPatientTreatment.removePrescription(this);
    }
    patientTreatment.addPrescription(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDoctorTreatments()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addDoctorTreatment(DoctorTreatment aDoctorTreatment)
  {
    boolean wasAdded = false;
    if (doctorTreatments.contains(aDoctorTreatment)) { return false; }
    doctorTreatments.add(aDoctorTreatment);
    if (aDoctorTreatment.indexOfPrescription(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDoctorTreatment.addPrescription(this);
      if (!wasAdded)
      {
        doctorTreatments.remove(aDoctorTreatment);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeDoctorTreatment(DoctorTreatment aDoctorTreatment)
  {
    boolean wasRemoved = false;
    if (!doctorTreatments.contains(aDoctorTreatment))
    {
      return wasRemoved;
    }

    int oldIndex = doctorTreatments.indexOf(aDoctorTreatment);
    doctorTreatments.remove(oldIndex);
    if (aDoctorTreatment.indexOfPrescription(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDoctorTreatment.removePrescription(this);
      if (!wasRemoved)
      {
        doctorTreatments.add(oldIndex,aDoctorTreatment);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDoctorTreatmentAt(DoctorTreatment aDoctorTreatment, int index)
  {  
    boolean wasAdded = false;
    if(addDoctorTreatment(aDoctorTreatment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctorTreatments()) { index = numberOfDoctorTreatments() - 1; }
      doctorTreatments.remove(aDoctorTreatment);
      doctorTreatments.add(index, aDoctorTreatment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDoctorTreatmentAt(DoctorTreatment aDoctorTreatment, int index)
  {
    boolean wasAdded = false;
    if(doctorTreatments.contains(aDoctorTreatment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctorTreatments()) { index = numberOfDoctorTreatments() - 1; }
      doctorTreatments.remove(aDoctorTreatment);
      doctorTreatments.add(index, aDoctorTreatment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDoctorTreatmentAt(aDoctorTreatment, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDiagnosis()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addDiagnosi(Diagnosis aDiagnosi)
  {
    boolean wasAdded = false;
    if (diagnosis.contains(aDiagnosi)) { return false; }
    diagnosis.add(aDiagnosi);
    if (aDiagnosi.indexOfPrescription(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDiagnosi.addPrescription(this);
      if (!wasAdded)
      {
        diagnosis.remove(aDiagnosi);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeDiagnosi(Diagnosis aDiagnosi)
  {
    boolean wasRemoved = false;
    if (!diagnosis.contains(aDiagnosi))
    {
      return wasRemoved;
    }

    int oldIndex = diagnosis.indexOf(aDiagnosi);
    diagnosis.remove(oldIndex);
    if (aDiagnosi.indexOfPrescription(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDiagnosi.removePrescription(this);
      if (!wasRemoved)
      {
        diagnosis.add(oldIndex,aDiagnosi);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDiagnosiAt(Diagnosis aDiagnosi, int index)
  {  
    boolean wasAdded = false;
    if(addDiagnosi(aDiagnosi))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDiagnosis()) { index = numberOfDiagnosis() - 1; }
      diagnosis.remove(aDiagnosi);
      diagnosis.add(index, aDiagnosi);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDiagnosiAt(Diagnosis aDiagnosi, int index)
  {
    boolean wasAdded = false;
    if(diagnosis.contains(aDiagnosi))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDiagnosis()) { index = numberOfDiagnosis() - 1; }
      diagnosis.remove(aDiagnosi);
      diagnosis.add(index, aDiagnosi);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDiagnosiAt(aDiagnosi, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=therapies.size(); i > 0; i--)
    {
      Therapy aTherapy = therapies.get(i - 1);
      aTherapy.delete();
    }
    PatientTreatment placeholderPatientTreatment = patientTreatment;
    this.patientTreatment = null;
    if(placeholderPatientTreatment != null)
    {
      placeholderPatientTreatment.removePrescription(this);
    }
    ArrayList<DoctorTreatment> copyOfDoctorTreatments = new ArrayList<DoctorTreatment>(doctorTreatments);
    doctorTreatments.clear();
    for(DoctorTreatment aDoctorTreatment : copyOfDoctorTreatments)
    {
      aDoctorTreatment.removePrescription(this);
    }
    ArrayList<Diagnosis> copyOfDiagnosis = new ArrayList<Diagnosis>(diagnosis);
    diagnosis.clear();
    for(Diagnosis aDiagnosi : copyOfDiagnosis)
    {
      aDiagnosi.removePrescription(this);
    }
  }

}