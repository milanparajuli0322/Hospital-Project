import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;


public class AppointmentManager {
    
    private final ArrayList<Appointment> appointments;

    public AppointmentManager()
    {
        appointments=new ArrayList<>();
    }

    public ArrayList<Appointment> getAllAppointments()
    {
        return new ArrayList<>(appointments);
    }

    public void addAppointment(Appointment appointment)
    {
        if(appointment==null)
        {
            throw new IllegalArgumentException("Appointment cannot be empty");
        }
        else
        {
            for(Appointment val:appointments)
            {
                if(val.getAppointmentId()==appointment.getAppointmentId())
                {
                    throw new IllegalArgumentException("Appointment Id already taken");
                }
                if(val.getDoctor().getDoctorId()==appointment.getDoctor().getDoctorId() && val.getDateTime().equals(appointment.getDateTime()) && val.getStatus()==Appointment.Status.SCHEDULED)
                {
                    throw new IllegalArgumentException("Appointment date already scheduled for this doctor");
                }
            }
            appointments.add(appointment);
        }
    }


    public ArrayList<Appointment> findAppointmentById(int appointmentId)
    {
        if(appointmentId<=0)
        {
            throw new IllegalArgumentException("Appointment Id cannot be empty");
        }
        for(Appointment val:appointments)
        {
            if(val.getAppointmentId()==appointmentId)
            {
                return appointments;
            }
        }
        return null;
    }


    public boolean cancelAppointment(Appointment appointment)
    {
        if(appointment==null)
        {
            throw new IllegalArgumentException("Appointment cannot be empty");
        }
        for(Appointment val:appointments)
        {
            if(val.getAppointmentId()==appointment.getAppointmentId())
            {
                appointment.setStatus(Appointment.Status.CANCELLED);
                return true;
            }
        }
        return false;
    }


    public boolean rescheduleAppointment(int appointmentId,LocalDateTime newdDateTime)
    {
        while(appointmentId<=0 || newdDateTime==null)
        {
            throw new IllegalArgumentException("Appointment Id or scheduled date is invalid");
        }
        for(Appointment appointment:appointments)
        {
            if(appointment.getAppointmentId()==appointmentId)
            {
                if(appointment.getStatus()==Appointment.Status.CANCELLED)
                {
                    return false;
                }
                appointment.setDateTime(newdDateTime);
                return true;
            }
        }
        return false;
    }


    public ArrayList<Appointment> findAppointmentByPatient(int patientId)
    {
        ArrayList<Appointment> results=new ArrayList<>();
        if(patientId<=0)
        {
            throw new IllegalArgumentException("Patient Id is invalid");
        }
        for(Appointment appointment:appointments)
        {
            if(appointment.getPatient().getPatientId()==patientId)
                results.add(appointment);
        }
        return results;
    }


    public ArrayList<Appointment> findAppointmentByDoctor(int doctorId)
    {
        ArrayList<Appointment>results=new ArrayList<>();
        if(doctorId<=0)
        {
            throw new IllegalArgumentException("Invalid doctor Id");
        }
        for(Appointment appointment:appointments)
        {
            if(appointment.getDoctor().getDoctorId()==doctorId)
            {
                results.add(appointment);
            }
        }
        return results;
    }


    public ArrayList<Appointment> filterAppointmentByDate(LocalDate newDate)
    {
        if(newDate==null)
        {
            throw new IllegalArgumentException("Date time filter cannot be empty");
        }
        ArrayList<Appointment> results=new ArrayList<>();
        for(Appointment appointment:appointments)
        {
            if(appointment.getDateTime().toLocalDate().equals(newDate))
            {
                results.add(appointment);
            }
        }
        return results;
    }


    public ArrayList<Appointment> findAppointmentByStatus(Appointment.Status newStatus)
    {
        ArrayList<Appointment>results=new ArrayList<>();
        if(newStatus==null)
        {
            throw new IllegalArgumentException("Status cannot be empty");
        }
        for(Appointment records:appointments)
        {
            if(records.getStatus()==newStatus)
            {
                results.add(records);
            }
        }
        return results;
    }


    public ArrayList<Appointment>sortAppointmentByDate()
    {
        ArrayList<Appointment>results=new ArrayList<>(appointments);
        results.sort(Comparator.comparing(Appointment::getDateTime));
        return results;
    }
}
