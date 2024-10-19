import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.StringRefAddr;
import java.util.Hashtable;

public class JNDIDemo {
    public static void main(String[] args) {
        try {
            // Set up the JNDI environment
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
            env.put(Context.PROVIDER_URL, "file:///C:/temp/jndi");  // Ensure this directory exists

            // Create the initial context
            Context ctx = new InitialContext(env);

            // Create a Reference object to bind a string
            String dbName = "myDatabase";
            Reference ref = new Reference("java.lang.String", new StringRefAddr("URL", "jdbc:mysql://localhost:3306/mydb"));

            // Use rebind to overwrite if the name already exists
            ctx.rebind(dbName, ref);

            // Look up the resource
            Reference dbCtx = (Reference) ctx.lookup(dbName);
            System.out.println("Database Context: " + dbCtx.get("URL").getContent());

        } catch (NamingException e) {
            System.out.println("JNDI Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
