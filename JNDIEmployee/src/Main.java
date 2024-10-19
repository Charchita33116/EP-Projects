public class Main {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        if (directory == null) {
            System.out.println("Failed to create EmployeeDirectory.");
            return;
        }

        Employee employee = new Employee("John Doe", "johndoe@example.com", "123-456-7890");
        directory.addEmployee(employee);

        Employee foundEmployee = directory.searchEmployee("John Doe");
        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmployee.getName());
        } else {
            System.out.println("Employee not found.");
        }

        employee.setEmail("johndoe2@example.com");
        directory.updateEmployee(employee);

        directory.deleteEmployee("John Doe");
    }
}
