import java.time.LocalDateTime;

public class Appointment {
    public enum Status
    {
        SCHEDULED,
        CANCELLED,
        COMPLETED
    }

    private final int appointmentId;
    private final Patient patient;
    private final Doctor doctor;
    private LocalDateTime dateTime;
    private Status status;

    public Appointment(int appointmentId,Patient patient,Doctor doctor,LocalDateTime dateTime)
    {
        if (appointmentId <= 0)
        {
            throw new IllegalArgumentException("Appointment ID must be positive");
        }
        this.appointmentId = appointmentId;

        if (patient == null)
        {
            throw new IllegalArgumentException("Patients cannot be null");
        }
        this.patient = patient;

        if (doctor == null)
        {
            throw new IllegalArgumentException("Doctor cannot be null");
        }
        this.doctor = doctor;

        if (dateTime == null)
        {
            throw new IllegalArgumentException("Appointment date and time cannot be null");
        }
        this.dateTime = dateTime;

        this.status = Status.SCHEDULED;
    }

    public int getAppointmentId()
    {
        return appointmentId;
    }

    public Patient getPatient()
    {
        return patient;
    }

    public Doctor getDoctor()
    {
        return doctor;
    }

    public LocalDateTime getDateTime()
    {
        return dateTime;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setDateTime(LocalDateTime dateTime)
    {
        if (dateTime == null)
        {
            throw new IllegalArgumentException("Appointment date and time cannot be null");
        }

        this.dateTime = dateTime;
    }

    public void setStatus(Status status)
    {
        if (status == null)
        {
            throw new IllegalArgumentException("Appointment status cannot be null");
        }

        this.status = status;
    }
}
