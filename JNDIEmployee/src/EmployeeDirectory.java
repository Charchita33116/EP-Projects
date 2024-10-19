import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import java.util.Hashtable;

public class EmployeeDirectory {
    private Context ctx;

    public EmployeeDirectory() {
        try {
            // Properties will be loaded from jndi.properties
            ctx = new InitialContext();
            if (ctx == null) {
                throw new NamingException("Failed to create InitialContext");
            }
        } catch (NamingException e) {
            System.out.println("JNDI Error: " + e.getMessage());
        }
    }

    public void addEmployee(Employee employee) {
        if (ctx == null) {
            System.out.println("Context is not initialized. Cannot add employee.");
            return;
        }
        try {
            ctx.bind(employee.getName(), employee.getReference());  // Use the referenceable object
            System.out.println("Employee added: " + employee.getName());
        } catch (NamingException e) {
            System.out.println("JNDI Error: " + e.getMessage());
        }
    }

    public Employee searchEmployee(String name) {
        if (ctx == null) {
            System.out.println("Context is not initialized. Cannot search for employee.");
            return null;
        }
        try {
            Object obj = ctx.lookup(name);
            if (obj instanceof Employee) {
                return (Employee) obj;
            }
            System.out.println("Employee not found.");
            return null;
        } catch (NamingException e) {
            System.out.println("JNDI Error: " + e.getMessage());
            return null;
        }
    }

    public void updateEmployee(Employee employee) {
        if (ctx == null) {
            System.out.println("Context is not initialized. Cannot update employee.");
            return;
        }
        try {
            ctx.rebind(employee.getName(), employee.getReference());  // Use reference for rebind
            System.out.println("Employee updated: " + employee.getName());
        } catch (NamingException e) {
            System.out.println("JNDI Error: " + e.getMessage());
        }
    }

    public void deleteEmployee(String name) {
        if (ctx == null) {
            System.out.println("Context is not initialized. Cannot delete employee.");
            return;
        }
        try {
            ctx.unbind(name);
            System.out.println("Employee deleted: " + name);
        } catch (NamingException e) {
            System.out.println("JNDI Error: " + e.getMessage());
        }
    }
}
