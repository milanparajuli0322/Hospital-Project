import java.util.ArrayList;
import java.util.Comparator;

public class DoctorManager {
    final private ArrayList<Doctor> doctors;

    public DoctorManager()
    {
        doctors=new ArrayList<>();
    }


    public void addDoctor(Doctor doctor)
    {
        if(doctor==null)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            for(Doctor existing:doctors)
            {
                if(existing.getDoctorId()==doctor.getDoctorId())
                {
                    throw new IllegalArgumentException("Doctor Id already exists");
                }
            }
            doctors.add(doctor);
        }
    }


    public ArrayList<Doctor> getAllDoctors()
    {
        return new ArrayList<>(doctors);
    }


    public Doctor findDoctorById(int doctorId)
    {
        if(doctorId<=0)
        {
            throw new IllegalArgumentException("Doctor id search cannot be empty");
        }
        for(Doctor doctor:doctors)
        {
            if(doctor.getDoctorId()==doctorId)
            {
                return doctor;
            }        
        }
        return null;
    }


    public boolean removeDoctorId(int doctorId)
    {
        if(doctorId<=0)
        {
            throw new IllegalArgumentException("Doctor id remove cannot be empty");
        }
        else
        {
            for(Doctor doctor:doctors)
            {
                if(doctor.getDoctorId()==doctorId)
                {
                    doctors.remove(doctor);
                    return true;
                }
            }
            return false;
        }
    }


    public boolean updateDoctorPhone(int doctorId,String newPhone)
    {
        if(newPhone==null)
        {
            throw new IllegalArgumentException("Phone update cannot be empty");
        }
        else
        {
            for(Doctor doctor:doctors)
            {
                if(doctor.getDoctorId()==doctorId)
                {
                    doctor.setPhone(newPhone);
                    return true;
                }
            }
            return false;
        }
    }


    public boolean updateDoctorEmail(int doctorId,String newEmail)
    {
        if(newEmail==null)
        {
            throw new IllegalArgumentException("Email update cannot be empty");
        }
        else
        {
            for(Doctor doctor:doctors)
            {
                if(doctor.getDoctorId()==doctorId)
                {
                    doctor.setEmail(newEmail);
                    return true;
                }
            }
            return false;
        }
    }


    public ArrayList<Doctor> findDoctorByName(String name)
    {
        ArrayList<Doctor> results=new ArrayList<>();
        if(name==null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException("Doctor name search cannot be empty");
        }
        else
        {
            for(Doctor doctor:doctors)
            {
                if(doctor.getName().toLowerCase().contains(name.toLowerCase()))
                {
                    results.add(doctor);
                }
            }
            return results;
        }
    }


    public ArrayList<Doctor> findDoctorBySpecialization(Doctor.Specialization specialization)
    {
        ArrayList<Doctor>results=new ArrayList<>();
        if(specialization==null)
        {
            throw new IllegalArgumentException("Doctor specialization search cannot be empty");
        }
        else
        {
            for(Doctor doctor:doctors)
            {
                if(doctor.getSpecialization()==specialization)
                {
                    results.add(doctor);
                }
            }
            return results;
        }
    }


    public ArrayList<Doctor> sortDoctorByName()
    {
        ArrayList<Doctor> results=new ArrayList<>(doctors);
        results.sort(Comparator.comparing(Doctor::getName,String.CASE_INSENSITIVE_ORDER));
        return results;
    }


    public ArrayList<Doctor> sortDoctorById()
    {
        ArrayList<Doctor> results=new ArrayList<>(doctors);
        results.sort(Comparator.comparingInt(Doctor::getDoctorId));
        return results;
    }
}
