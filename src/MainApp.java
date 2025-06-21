import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeDAO employeeDAO = new EmployeeDAO();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewAllEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.print("Enter hire date (YYYY-MM-DD): ");
        String hireDate = scanner.nextLine();

        Employee employee = new Employee(name, email, department, salary, hireDate);

        try {
            employeeDAO.addEmployee(employee);
            System.out.println("Employee added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    private static void viewAllEmployees() {
        try {
            List<Employee> employees = employeeDAO.getAllEmployees();

            if (employees.isEmpty()) {
                System.out.println("No employees found.");
                return;
            }

            System.out.println("\nEmployee List:");
            for (Employee emp : employees) {
                System.out.println("ID: " + emp.getId() +
                        ", Name: " + emp.getName() +
                        ", Email: " + emp.getEmail() +
                        ", Department: " + emp.getDepartment() +
                        ", Salary: " + emp.getSalary() +
                        ", Hire Date: " + emp.getHireDate());
            }
        } catch (Exception e) {
            System.out.println("Error retrieving employees: " + e.getMessage());
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        try {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new email: ");
            String email = scanner.nextLine();

            System.out.print("Enter new department: ");
            String department = scanner.nextLine();

            System.out.print("Enter new salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            System.out.print("Enter new hire date (YYYY-MM-DD): ");
            String hireDate = scanner.nextLine();

            Employee employee = new Employee(name, email, department, salary, hireDate);
            employee.setId(id);

            employeeDAO.updateEmployee(employee);
            System.out.println("Employee updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        try {
            employeeDAO.deleteEmployee(id);
            System.out.println("Employee deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }
}