# HOWTO.md – Hospital Management System (Dynamic Input + Exception Handling)

## Project Description
This project is a Java OOP Hospital Management System that manages:
- Doctors and Patients
- Appointments
- Billing and payments

The system demonstrates OOP concepts (Encapsulation, Inheritance, Abstraction, Polymorphism) and has been enhanced with dynamic user input and exception handling.

## How to Run
1. Compile:
   javac *.java
2. Run:
   java HospitalMain

## Dynamic Input Implemented
The program allows the user to enter:
- Doctor details (ID, name, phone, staff number, department, specialization, consultation fee)
- Patient details (ID, name, phone, illness)
- Appointment details (appointment ID, date)
- Billing details (bill ID, amount, payment amount)
- Option to cancel an appointment

## Exceptions Implemented
The program uses try/catch/finally to handle errors safely and prevent the program from crashing.

### 1) InputMismatchException
- Handles cases where the user enters text instead of a number for fees or amounts.
- The program clears invalid input and asks again.

### 2) Validation for wrong values
- Rejects empty string inputs.
- Prevents negative values for consultation fee, bill amount, and payment amount.

### 3) finally block
- Ensures the Scanner is closed and the program ends safely.
