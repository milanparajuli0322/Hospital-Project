import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Hospital_manager {
    public static void main(String[] args) {

        // First patient object
        Patient patient=new Patient("milan",12345,"9849966002","kathmandu",LocalDate.of(2005,5,15),"milanparajuli0322@gmail.com","O-","megha","9843733855");

        // Second patient object
        Patient patient2 = new Patient("Ram",12341,"9811111111","Pokhara",LocalDate.of(2005, 3, 10),"ram@gmail.com","A+","raju","1234567899");
        
        System.out.println("---Hospital manager---"); 

        System.out.println("Patient Id :"+patient.getPatientId());
        System.out.println("Patient Name :"+patient.getName());
        patient.makeGenderMale();
        System.out.println("Patient Gender :"+patient.getGender());
        System.out.println("Patient Contact :"+patient.getPhone());
        System.out.println("Patient Address :"+patient.getAddress());
        System.out.println("Patient Dateofbirth :"+patient.getDateOfBirth());
        System.out.println("Patient Age :"+patient.getAge());
        System.out.println("Patient Email :"+patient.getEmail());
        System.out.println("Patient Bloodgroup :"+patient.getBloodGroup());
        System.out.println("Patient Registrationdate :"+patient.getRegistrationDate());
        System.out.println("Patient Status :"+patient.getStatus());
        patient.discharge();
        System.out.println("Patient Status :"+patient.getStatus());
        patient.activate();
        System.out.println("Patient Status :"+patient.getStatus());
        patient.addMedicalConditions("asthma");
        patient.addMedicalConditions("jaundice");
        System.out.println("Patient Medicalconditions :"+patient.getMedicalConditions());
        patient.removeMedicalConditions("ASthma");
        System.out.println("Patient Medicalconditions :"+patient.getMedicalConditions());
        patient.setEmergencyContact("manju", "9802302345");
        System.out.print("Patient Emergencycontact :"+patient.getEmergencyContactName());
        System.out.println("-"+patient.getEmergencyContactPhone());


        // Patient adding
        PatientManager patientmanager=new PatientManager();
        patientmanager.addPatient(patient);
        patientmanager.addPatient(patient2);
        System.out.println("Patient registered sucessfully");
        

        // Patient searching
        Patient foundPatient=patientmanager.findPatientById(12345);
        if(foundPatient==null)
        {
            System.out.println("Patient not found");
        }
        else
        {
            System.out.println("Patient found :"+foundPatient.getName());
        }


        // Patients showing
        ArrayList<Patient>AllPatients=patientmanager.getAllPatients();
        System.out.println("Total patients :"+AllPatients.size());
        for(Patient patients:AllPatients)
        {
            System.out.println(patients.getName()+"-"+patients.getPatientId());
        }


        // Patient removing
        boolean removed=patientmanager.removePatientById(12341);
        if(removed==true)
        {
            System.out.println("Patient removed sucessfully");
        }
        else
        {
            System.out.println("Unable to remove patient");
        }


        // Patient phone updating
        boolean updatedPhone=patientmanager.updatePatientPhone(12345, "9802159918");
        if(updatedPhone==true)
        {
            System.out.println("Phone number updated sucessfully");
        }
        else
        {
            System.out.println("Patient not found");
        }


        // Patient email updating
        boolean updatedEmail=patientmanager.updatePatientEmail(12345, "xyz@gmail.com");
        if(updatedEmail==true)
        {
            System.out.println("Email updated sucessfully");
        }
        else
        {
            System.out.println("Patient not found");
        }


        // Patient address updating
        boolean updatedAddress=patientmanager.updatePatientAddress(12345, "bhaktapur");
        if(updatedAddress==true)
        {
            System.out.println("Address updated sucessfully");
        }
        else
        {
            System.out.println("Patient not found");
        }


        // Patient emergency contact updating
        boolean updatedEmergencyContact=patientmanager.updatePatientEmergencycontact(12345,"lila","9812121212");
        if(updatedEmergencyContact==true)
        {
            System.out.println("Emergency contact updated sucessfully");
        }
        else
        {
            System.out.println("Patient not found");
        }


        // Patient name searching
        ArrayList<Patient> resultName=patientmanager.findPatientByName("mil");
        for(Patient patients:resultName)
        {
            System.out.println(patients.getPatientId()+"-"+patients.getName());
        }


        // Patient phone seaching
        ArrayList<Patient> resultPhone=patientmanager.findPatientByPhone("98021");
        for(Patient patients:resultPhone)
        {
            System.out.println(patients.getPatientId()+"-"+patients.getName());
        }


        // Patient email searching
        ArrayList<Patient> resultEmail=patientmanager.findPatientByEmail("xyz@gmail.com");
        for(Patient patients:resultEmail)
        {
            System.out.println(patients.getPatientId()+"-"+patient.getName());
        }


        // Patient bloodgroup searching
        ArrayList<Patient> resultBloodgroup=patientmanager.findPatientByBloodgroup("O-");
        for(Patient patients:resultBloodgroup)
        {
            System.out.println(patients.getPatientId()+"-"+patients.getName());
        }


        // Patient status filtering
        ArrayList<Patient>resultFilterByStatus=patientmanager.filterByStatus(Patient.Status.ACTIVE);
        for(Patient patients:resultFilterByStatus)
        {
            System.out.println(patients.getPatientId()+"-"+patients.getName());
        }


        // Patient counting by status
        int activeCount=patientmanager.countPatientByStatus(Patient.Status.ACTIVE);
        System.out.println("Active patients :"+activeCount);


        // Patient counting by registered
        System.out.println("Total registered patients :"+patientmanager.countRegisteredPatients());


        // Patient gender filtering
        ArrayList<Patient> resultFilterByGender=patientmanager.filterPatientByGender(Patient.Gender.MALE);
        for(Patient patients:resultFilterByGender)
        {
            System.out.println(patients.getPatientId()+"-"+patients.getName());
        }


        // Patient searching by registration date
        ArrayList<Patient> resultRegistrationdate=patientmanager.findPatientByRegistrationdate(LocalDate.of(2007,02,03));
        for(Patient patients:resultRegistrationdate)
        {
            System.out.println(patients.getPatientId()+"-"+patients.getName());
        }


        // Patient sorting by name
        ArrayList<Patient> resultSortedPatientByName=patientmanager.sortPatientByName();
        for(Patient patients:resultSortedPatientByName)
        {
            System.out.println(patients.getPatientId()+"-"+patients.getName());
        }


        // Patient sorting by id
        ArrayList<Patient> resultSortedPatientById=patientmanager.sortPatientById();
        for(Patient patients:resultSortedPatientById)
        {
            System.out.println(patients.getPatientId()+"-"+patients.getName());
        }


        // Patient filtering by age
        ArrayList<Patient> resultFilterPatientByAge=patientmanager.filterPatentByAge(10, 25);
        for(Patient patients:resultFilterPatientByAge)
        {
            System.out.println(patients.getPatientId()+"-"+patients.getName());
        }


        // Patient searching by medical condition
        ArrayList<Patient> resultFindPatientByMedicalconditions=patientmanager.findPatientByMedicalconditions("vomit");
        for(Patient patients:resultFindPatientByMedicalconditions)
        {
            System.out.println(patients.getPatientId()+"-"+patients.getName());
        }


        // Patient counting by bloodgroup
        System.out.println("o- patients :"+patientmanager.countPatientByBloodgroup("o+"));


        // Patient counting by gender
        System.out.println("Male patients :"+patientmanager.countPatientByGender(Patient.Gender.MALE));


        // Patient counting by status
        System.out.println("Active patients :"+patientmanager.countPatientByStatus(Patient.Status.ACTIVE));


        // First doctor object
        Doctor doctor=new Doctor(1234,"john",Doctor.Specialization.CARDIOLOGY,"9800000000","john@gmail.com");

        System.out.println("Doctor name :"+doctor.getName());
        System.out.println("Doctor Id :"+doctor.getDoctorId());


        // Doctor displaying
        DoctorManager doctormanager=new DoctorManager();
        System.out.println("Total doctors :"+doctormanager.getAllDoctors().size());


        // Doctor adding
        doctormanager.addDoctor(doctor);
        System.out.println("Total doctors :"+doctormanager.getAllDoctors().size());


        // Doctor searching
        Doctor foundDoctor=doctormanager.findDoctorById(1234);
        if(foundDoctor==null)
        {
            System.out.println("No doctor found");
        }
        else
        {
            System.out.println(foundDoctor.getDoctorId()+"-"+foundDoctor.getName());
        }


        // Doctor removing
        boolean removeDoctorById=doctormanager.removeDoctorId(12345);
        if(removeDoctorById==false)
        {
            System.out.println("No doctor found");
        }
        else
        {
            System.out.println("Doctor removed sucessfully");
        }


        // Doctor updating phone
        boolean updateDoctorPhoneByDoctorId=doctormanager.updateDoctorPhone(1234, "9700000000");
        if(updateDoctorPhoneByDoctorId==true)
        {
            System.out.println("Doctor phone updated sucessfully");
        }
        else
        {
            System.out.println("Doctor not found");
        }


        // Doctor updating email
        boolean updateDoctorEmailByDoctorId=doctormanager.updateDoctorEmail(1234, "jonny@gmail.com");
        if(updateDoctorEmailByDoctorId==true)
        {
            System.out.println("Doctor email updated sucessfully");
        }
        else
        {
            System.out.println("Doctor not found");
        }


        // Doctor searching by name
        ArrayList<Doctor> resultDoctorFindByName=doctormanager.findDoctorByName("john");
        for(Doctor doctors:resultDoctorFindByName)
        {
            System.out.println(doctors.getDoctorId()+"-"+doctors.getName());
        }


        // Doctor searching by specialization
        ArrayList<Doctor>resultDoctorFindBySpecialization=doctormanager.findDoctorBySpecialization(Doctor.Specialization.CARDIOLOGY);
        for(Doctor doctors:resultDoctorFindBySpecialization)
        {
            System.out.println(doctors.getDoctorId()+"-"+doctors.getName());
        }


        // Doctor sorting by name
        ArrayList<Doctor> resultDoctorByName=doctormanager.sortDoctorByName();
        for(Doctor doctors:resultDoctorByName)
        {
            System.out.println(doctors.getDoctorId()+"-"+doctors.getName());
        }


        // Doctor sorting by doctor Id
        ArrayList<Doctor> resultDoctorById=doctormanager.sortDoctorById();
        for(Doctor doctors:resultDoctorById)
        {
            System.out.println(doctors.getDoctorId()+"-"+doctors.getName());
        }


        // Doctor availability status
        System.out.println(doctor.getStatus());
        doctor.setStatus(Doctor.Status.UNAVAILABLE);
        System.out.println(doctor.getStatus());


        // Appointment booking
        Appointment appointment=new Appointment(1,patient,doctor,LocalDateTime.of(2027,9,23,10,30));
        System.out.println(appointment.getAppointmentId());


        // Appointment listing
        AppointmentManager appointmentmanager=new AppointmentManager();
        System.out.println(appointmentmanager.getAllAppointments());


        // Appointment adding to list
        appointmentmanager.addAppointment(appointment);
        System.out.println(appointmentmanager.getAllAppointments().size());


        // Appointment searching by appointment Id
        ArrayList<Appointment> resultFindAppointmentByAppointmentId=appointmentmanager.findAppointmentById(1);
        for(Appointment appointments:resultFindAppointmentByAppointmentId)
        {
            System.out.println(appointments.getPatient().getName());
            System.out.println(appointments.getDateTime());
        }


        // Appointment removing from list
        boolean removedAppointment=appointmentmanager.cancelAppointment(appointment);
        if(removedAppointment==true)
        {
            System.out.println("Appointment cancelled");
        }
        else
        {
            System.out.println("Appointment couldn't find");
        }


        // Appointment rescheduling
        boolean scheduleAppointment=appointmentmanager.rescheduleAppointment(1, LocalDateTime.of(2026,9,29,10,30));
        if(scheduleAppointment==true)
        {
            System.out.println("Appointment reschedules to picked date");
            System.out.println(appointment.getDateTime());
        }
        else
        {
            System.out.println("Appointment is not scheduled");
        }


        // Appointments searching by patient
        ArrayList<Appointment> appointmentSearchByPatient=appointmentmanager.findAppointmentByPatient(12345);
        for(Appointment appointments:appointmentSearchByPatient)
        {
            System.out.println(appointments.getAppointmentId()+"-"+appointments.getPatient().getName()+"-"+appointments.getDateTime().toLocalDate());
        }


        // Appointment searching by doctor
        ArrayList<Appointment> appointmentSearchByDoctor=appointmentmanager.findAppointmentByDoctor(1234);
        for(Appointment appointments:appointmentSearchByDoctor)
        {
            System.out.println(appointments.getAppointmentId()+"-"+appointments.getDateTime().toLocalDate());
        }


        // Appointment filtering by date
        ArrayList<Appointment> appointmentFilterByDate=appointmentmanager.filterAppointmentByDate(LocalDate.of(2026,9,23));
        for(Appointment appointments:appointmentFilterByDate)
        {
            System.out.println(appointments.getAppointmentId()+"-"+appointments.getDateTime().toLocalDate());
        }


        // Medical record managing
        MedicalRecordManager medicalrecordmanager=new MedicalRecordManager();
        MedicalRecord record=new MedicalRecord(1,patient,LocalDate.of(2026,9,23));
        medicalrecordmanager.addMedicalRecord(record);
        System.out.println(medicalrecordmanager.getAllMedicalRecords().size());


        // Medical record finding
        ArrayList<MedicalRecord> MedicalRecordById=medicalrecordmanager.findMedicalRecordByPatient(12345);
        for(MedicalRecord val:MedicalRecordById)
        {
            System.out.println(val.getPatient().getPatientId()+"-"+val.getPatient().getName());
        }


        // Filtering scheduled Appointments patients
        ArrayList<Appointment>AppointmentByStatus=appointmentmanager.findAppointmentByStatus(Appointment.Status.SCHEDULED);
        for(Appointment val:AppointmentByStatus)
        {
            System.out.println(val.getPatient().getPatientId()+"-"+val.getPatient().getName());
        }


        // Appointment sorted by datetime
        ArrayList<Appointment>sortAppointmentByDate=appointmentmanager.sortAppointmentByDate();
        for(Appointment appointments:sortAppointmentByDate)
        {
            System.out.println(appointments.getAppointmentId()+"-"+appointments.getPatient().getName()+"-"+appointments.getDateTime());
        }


        System.out.println("upcoming Appointments");
        // Appointment listed by upcoming appointments
        ArrayList<Appointment>resultUpcomingAppointments=appointmentmanager.findUpcomingAppointments();
        for(Appointment value:resultUpcomingAppointments)
        {
            System.out.println(value.getAppointmentId()+"-"+value.getPatient().getName()+"-"+value.getDateTime());
        }


        System.out.println("Todays Appointments");
        // Appointment listed by today appointment
        ArrayList<Appointment>resultFindTodayAppointment=appointmentmanager.findTodayAppointments();
        for(Appointment value:resultFindTodayAppointment)
        {
            System.out.println(value.getAppointmentId()+"-"+value.getPatient().getName());
        }


        // Count Appointment status
        System.out.println("Total number of scheduled appointment "+appointmentmanager.countAppointmentByStatus(Appointment.Status.SCHEDULED));
    

        // Department object creation
        Department department=new Department(1,"Cardiology","DEpartment for heart-related issues");
        System.out.println("Department Id :"+department.getDepartmentId());


        // Department record display
        DepartmentManager departmentmanager=new DepartmentManager();
        System.out.println(departmentmanager.getAllDepartments());
    }
}
