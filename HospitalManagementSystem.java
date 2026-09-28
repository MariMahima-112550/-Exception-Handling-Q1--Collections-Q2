/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospitalmanagementsystem;
import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagementSystem {

    // User-defined exceptions
    static class InvalidPatientDetailsException extends Exception {
        InvalidPatientDetailsException(String msg) {
            super(msg);
        }
    }

    static class InvalidAgeException extends Exception {
        InvalidAgeException(String msg) {
            super(msg);
        }
    }

    static class InvalidDoctorException extends Exception {
        InvalidDoctorException(String msg) {
            super(msg);
        }
    }

    static class AppointmentUnavailableException extends Exception {
        AppointmentUnavailableException(String msg) {
            super(msg);
        }
    }

    static class DuplicateAppointmentException extends Exception {
        DuplicateAppointmentException(String msg) {
            super(msg);
        }
    }

    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> appointments = new ArrayList<>();

    static void bookAppointment(String name, int age, int doctor)
            throws Exception {

        if (name.trim().isEmpty()) {
            throw new InvalidPatientDetailsException(
                    "Patient name cannot be empty.");
        }

        if (age <= 0 || age > 120) {
            throw new InvalidAgeException(
                    "Invalid patient age.");
        }

        if (doctor < 1 || doctor > 3) {
            throw new InvalidDoctorException(
                    "Invalid doctor ID.");
        }

        if (appointments.size() >= 5) {
            throw new AppointmentUnavailableException(
                    "No appointment slots available.");
        }

        String appointment = name + "-D" + doctor;

        if (appointments.contains(appointment)) {
            throw new DuplicateAppointmentException(
                    "Duplicate appointment booking.");
        }

        appointments.add(appointment);

        System.out.println("Appointment booked successfully!");
    }

    static void viewAppointments() {

        if (appointments.isEmpty()) {
            System.out.println("No appointments available.");
        } else {
            System.out.println("\n--- Appointments ---");

            for (String a : appointments) {
                System.out.println(a);
            }
        }
    }

    public static void main(String[] args) {

        int choice = 0;

        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {

                    try {
                        System.out.print("Enter patient name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter patient age: ");
                        int age = sc.nextInt();

                        System.out.println("\nDoctors:");
                        System.out.println("1. Dr. Kumar");
                        System.out.println("2. Dr. Priya");
                        System.out.println("3. Dr. Arun");

                        System.out.print("Enter doctor ID: ");
                        int doctor = sc.nextInt();

                        bookAppointment(name, age, doctor);

                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());

                    } finally {
                        System.out.println(
                                "Appointment process completed.");
                    }

                } else if (choice == 2) {

                    viewAppointments();

                } else if (choice == 3) {

                    System.out.println("Thank you. Exiting...");

                } else {

                    throw new Exception("Invalid menu choice.");
                }

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());

                if (choice != 3) {
                    sc.nextLine();
                }
            }

        } while (choice != 3);

        sc.close();
    }
}
