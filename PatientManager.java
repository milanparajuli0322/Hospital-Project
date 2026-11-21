import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;


public class PatientManager {
    final private ArrayList<Patient> patients;

    
    public PatientManager()
    {
        patients=new ArrayList<>();
    }


    public void addPatient(Patient patient)
    {
        if(patient==null)
        {
            throw new IllegalArgumentException("Patient cannot be null");
        }
        for (Patient existingPatient:patients)
        {
            if(patient.getPatientId()==existingPatient.getPatientId())
            {
                throw new IllegalArgumentException("Patient Id already exists");
            }
        }
        patients.add(patient);
    }


    public Patient findPatientById(int patientId)
    {
        if(patientId<=0)
        {
            throw new IllegalArgumentException("Invalid patient Id to find");
        }
        
        for(Patient patient:patients)
        {
            if(patient.getPatientId()==patientId)
            {
                return patient;
            }
        }
        return null;
    }


    public ArrayList<Patient> getAllPatients()
    {
        return new ArrayList<>(patients);
    }


    public boolean removePatientById(int patientId)
    {
        for(Patient patient:patients)
        {
            if(patient.getPatientId()==patientId)
            {
                patients.remove(patient);
                return true;
            }
        }
        return false;
    }


    public boolean updatePatientPhone(int patientId,String newPhone)
    {
        Patient patient=findPatientById(patientId);
        if(patient==null)
        {
            return false;
        }
        else
        {
            patient.setPhone(newPhone);
            return true;
        }
    }


    public boolean updatePatientEmail(int patientId,String newEmail)
    {
        Patient patient=findPatientById(patientId);
        if(patient==null)
        {
            return false;
        }
        else
        {
            patient.setEmail(newEmail);
            return true;
        }
    }


    public boolean updatePatientAddress(int patientId,String newAddress)
    {
        Patient patient=findPatientById(patientId);
        if(patient==null)
        {
            return false;
        }
        else
        {
            patient.setAddress(newAddress);
            return true;
        }
    }


    public boolean updatePatientEmergencycontact(int patientId,String newEmergencyContactName,String newEmergencyContactPhone)
    {
        Patient patient=findPatientById(patientId);
        if(patient==null)
        {
            return false;
        }
        else
        {
            patient.setEmergencyContact(newEmergencyContactName, newEmergencyContactPhone);
            return true;
        }
    }


    public ArrayList<Patient> findPatientByName(String name)
    {
        ArrayList<Patient> results=new ArrayList<>();
        if(name==null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException("Search name cannot be empty");
        }
        else
        {
            for(Patient patient:patients)
            {
                if((patient.getName().toLowerCase()).contains(name.toLowerCase().trim()))
                {
                    results.add(patient);
                }
            }
            return results;
        }
    }


    public ArrayList<Patient> findPatientByPhone(String phone)
    {
        ArrayList<Patient> results=new ArrayList<>();
        if(phone==null || phone.trim().isEmpty())
        {
            throw new IllegalArgumentException("Search phone cannot be empty");
        }
        else
        {
            for(Patient patient:patients)
            {
                if(patient.getPhone().contains(phone.trim()))
                {
                    results.add(patient);
                }
            }
            return results;
        }
    }


    public ArrayList<Patient> findPatientByEmail(String email)
    {
        ArrayList<Patient> results=new ArrayList<>();
        if(email==null || email.trim().isEmpty())
        {
            throw new IllegalArgumentException("Search email cannot be empty");
        }
        else
        {
            for(Patient patient:patients)
            {
                if(patient.getEmail().contains(email.trim()))
                {
                    results.add(patient);
                }
            }
            return results;
        }
    }


    public ArrayList<Patient> findPatientByBloodgroup(String bloodgroup)
    {
        ArrayList<Patient> results=new ArrayList<>();
        if(bloodgroup==null || bloodgroup.trim().isEmpty())
        {
            throw new IllegalArgumentException("Blood group cannot be empty");
        }
        bloodgroup=bloodgroup.trim();
        for(Patient patient:patients)
        {
            if(patient.getBloodGroup().trim().contains(bloodgroup))
                results.add(patient);
        }
        return results;
    }


    public ArrayList<Patient> filterByStatus(Patient.Status status)
    {
        ArrayList<Patient> results=new ArrayList<>();
        if(status==null)
        {
            throw new IllegalArgumentException("Status cannot be empty");
        }
        else
        {
            for(Patient patient:patients)
            {
                if(patient.getStatus()==status)
                {
                    results.add(patient);
                }
            }
            return results;
        }
    }


    public int countPatientByStatus(Patient.Status status)
    {
        int count=0;
        if(status==null)
        {
            throw new IllegalArgumentException("Status cannot be empty");
        }
        else
        {
            for(Patient patient:patients)
            {
                if(patient.getStatus()==status)
                {
                    count++;
                }
            }
            return count;
        }
    }


    public int countRegisteredPatients()
    {
        return patients.size();
    }


    public ArrayList<Patient> filterPatientByGender(Patient.Gender gender)
    {
        ArrayList<Patient> results =new ArrayList<>();
        if(gender==null)
        {
            throw new IllegalArgumentException("Gender cannot be empty");
        }
        else
        {
            for(Patient patient:patients)
            {
                if(patient.getGender()==gender)
                {
                    results.add(patient);
                }
            }
            return results;
        }
    }


    public ArrayList<Patient> findPatientByRegistrationdate(LocalDate date)
    {
        ArrayList<Patient> results=new ArrayList<>();
        if(date==null)
        {
            throw new IllegalArgumentException("Registration date cannot be empty");
        }
        else
        {
            for(Patient patient:patients)
            {
                if(patient.getRegistrationDate().equals(date))
                {
                    results.add(patient);
                }
            }
            return results;
        }
    }

    
    public ArrayList<Patient> sortPatientByName()
    {
        ArrayList<Patient> results=getAllPatients();
        results.sort(Comparator.comparing(Patient::getName,String.CASE_INSENSITIVE_ORDER));
        return results;
    }


    public ArrayList<Patient> sortPatientById()
    {
        ArrayList<Patient> results=getAllPatients();
        results.sort(Comparator.comparingInt(Patient::getPatientId));
        return results;
    }


    public ArrayList<Patient> filterPatentByAge(int minAge,int maxAge)
    {
        if(minAge<0 || maxAge<0)
        {
            throw new IllegalArgumentException("Invalid age range");
        }

        if(minAge>maxAge)
        {
            throw new IllegalArgumentException("Minimun age cannot be larger than maximum age");
        }

        ArrayList<Patient> results=new ArrayList<>();
        for(Patient patient:patients)
        {
            if(patient.getAge()<=maxAge && patient.getAge()>=minAge)
            {
                results.add(patient);
            }
        }
        return results;
    }


    public ArrayList<Patient> findPatientByMedicalconditions(String condition)
    {
        ArrayList<Patient> results=new ArrayList<>();
        if(condition==null || condition.trim().isEmpty())
        {
            throw new IllegalArgumentException("Medical condition search cannot be empty");
        }
        condition=condition.toUpperCase();
        for(Patient patient:patients)
        {
            if(patient.getMedicalConditions().contains(condition))
            {
                results.add(patient);
            }
        }
        return results;
    }


    public  int countPatientByBloodgroup(String bloodgroup)
    {
        if(bloodgroup==null || bloodgroup.trim().isEmpty())
        {
            throw new IllegalArgumentException("Blood group count search cannot be empty");
        }
        bloodgroup=bloodgroup.trim().toUpperCase();
        int count=0;
        for(Patient patient:patients)
        {
            if(patient.getBloodGroup().equalsIgnoreCase(bloodgroup))
            {
                count++;
            }
        }
        return count;
    }


    public int countPatientByGender(Patient.Gender gender)
    {
        if(gender==null)
        {
            throw new IllegalArgumentException("Gender count search cannot be empty");
        }
        int count=0;
        for(Patient patient:patients)
        {
            if(patient.getGender()==gender)
            {
                count++;
            }
        }
        return count;
    }


    public int countPatientsByStatus(Patient.Status status)
    {
        if (status == null)
        {
            throw new IllegalArgumentException("Status cannot be null");
        }
        int count = 0;
        for (Patient patient : patients)
        {
            if (patient.getStatus() == status)
            {
                count++;
            }
        }
        return count;
    }
}
