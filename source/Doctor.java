
public class Doctor
{
    private int doctorId;
    private String name;
    private String phone;
    private String email;
    private Specialization specialization;
    private Status status=Status.AVAILABLE;

    public enum Specialization
    {
        CARDIOLOGY,
        DERMATOLOGY,
        NEUROLOGY,
        PEDIATRICS,
        ORTHOPEDICS,
        GENERAL_MEDICINE,
        SURGERY
    }


    public enum Status
    {
        AVAILABLE,
        UNAVAILABLE
    }


    public Doctor(int doctorId, String name,Specialization specialization,String phone, String email)
    {
        if (doctorId <= 0)
        {
            throw new IllegalArgumentException("Doctor ID must be positive");
        }
        this.doctorId = doctorId;

        if (name == null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();

        if (specialization == null)
        {
            throw new IllegalArgumentException("Specialization cannot be null");
        }
        this.specialization = specialization;

        if (phone == null || !phone.matches("\\d{10}"))
        {
            throw new IllegalArgumentException("Phone must contain 10 digits");
        }
        this.phone = phone;

        if (email == null || !email.trim().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"))
        {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email.trim();
    }

    public int getDoctorId()
    {
        return doctorId;
    }

    public String getName()
    {
        return name;
    }

    public Specialization getSpecialization()
    {
        return specialization;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setPhone(String phone)
    {
        if(phone==null || phone.trim().isEmpty() || !phone.matches("\\d{10}"))
        {
            throw new IllegalArgumentException("Phone update cannot be empty");
        }
        this.phone=phone;
    }

    public void setEmail(String email)
    {
        if(email==null || email.trim().isEmpty() || !email.trim().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"))
        {
            throw new IllegalArgumentException("Email update cannot be empty");
        }
        this.email=email;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        if(status==null)
        {
            throw new IllegalArgumentException("Doctor status cannot be empty");
        }
        this.status=status;
    }
}
