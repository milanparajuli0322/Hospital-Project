# Hospital Manager

A Java hospital management system with patients, doctors, appointments, departments and medical records. No external libraries needed.

## Setup

1. Install JDK 8 or newer.

2. Compile all the files: `javac *.java`

3. Run it: `java Hospital_manager`

## Features

- **Patients:** add, find, remove, update contact details, search by name, phone, email, blood group or medical condition, filter by status, gender or age, and sort
- **Doctors:** add, find, remove, update contact details, search by name or specialization, set availability, and sort
- **Appointments:** book, cancel and reschedule, with a check that a doctor can't have two scheduled appointments at the same time. Search by patient, doctor, date or status, and list today's and upcoming appointments
- **Departments:** add, find, remove, search by name and sort
- **Medical records:** add records and find them by patient

## Project Structure

- `Hospital_manager.java`: the main class, a demo that runs every feature with sample data
- `Patient.java`, `Doctor.java`, `Appointment.java`, `Department.java`, `MedicalRecord.java`: the data classes with validation
- `PatientManager.java`, `DoctorManager.java`, `AppointmentManager.java`, `DepartmentManager.java`, `MedicalRecordManager.java`: the classes that store and manage each type

## Notes

- Nothing is saved. All data lives in memory and is lost when the program ends.
- The program doesn't take user input. To try different data, edit `Hospital_manager.java` and recompile.
