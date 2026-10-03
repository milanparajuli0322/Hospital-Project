import java.time.LocalDate;

public class MedicalRecord
{
    private final int recordId;
    private final Patient patient;
    private final LocalDate recordDate;

    public MedicalRecord(
            int recordId,
            Patient patient,
            LocalDate recordDate)
    {
        if (recordId <= 0)
        {
            throw new IllegalArgumentException(
                    "Medical record ID must be positive"
            );
        }
        this.recordId = recordId;

        if (patient == null)
        {
            throw new IllegalArgumentException(
                    "Patient cannot be null"
            );
        }
        this.patient = patient;

        if (recordDate == null)
        {
            throw new IllegalArgumentException(
                    "Record date cannot be null"
            );
        }
        this.recordDate = recordDate;
    }

    public int getRecordId()
    {
        return recordId;
    }

    public Patient getPatient()
    {
        return patient;
    }

    public LocalDate getRecordDate()
    {
        return recordDate;
    }
}
