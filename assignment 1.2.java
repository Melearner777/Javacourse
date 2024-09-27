import java.util.Scanner;

class Main {
    // Define constants for regular and overtime hour limits
    private static final int REGULAR_HOURS = 160;
    private static final double OVERTIME_RATE = 1.5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of employees
        //System.out.print("Enter the number of employees: ");
        int numEmployees = scanner.nextInt();
       // scanner.nextLine(); // Consume newline left-over

        // Arrays to store employee details
        String[] names = new String[numEmployees];
        double[] hourlyWages = new double[numEmployees];
        int[] hoursWorked = new int[numEmployees];

        // Input details for each employee
        for (int i = 0; i < numEmployees; i++) {
           // System.out.println("\nEnter details for employee #" + (i + 1));
            
            // Input employee name
           // System.out.print("Name: ");
            names[i] = scanner.nextLine();
           scanner.nextLine();
            // Input hourly wage
           // System.out.print("Hourly Wage: ");
            hourlyWages[i] = scanner.nextDouble();
            //scanner.nextLine();
            // Input hours worked
            //System.out.print("Hours Worked: ");
            hoursWorked[i] = scanner.nextInt();
           //scanner.nextLine(); // Consume newline
        }

        // Process and display the payroll for each employee
        for (int i = 0; i < numEmployees; i++) {
            double totalSalary = calculateSalary(hourlyWages[i], hoursWorked[i]);
            System.out.printf("Total Salary: %.2f\n",totalSalary);
        }

        scanner.close();
    }

    // Method to calculate total salary including overtime pay
    public static double calculateSalary(double hourlyWage, int hoursWorked) {
        double regularPay, overtimePay = 0.0;

        // If employee worked more than regular hours, calculate overtime
        if (hoursWorked > REGULAR_HOURS) {
            regularPay = REGULAR_HOURS * hourlyWage;
            int overtimeHours = hoursWorked - REGULAR_HOURS;
            overtimePay = overtimeHours * hourlyWage * OVERTIME_RATE;
        } else {
            regularPay = hoursWorked * hourlyWage;
        }

        return regularPay + overtimePay;
    }
}
