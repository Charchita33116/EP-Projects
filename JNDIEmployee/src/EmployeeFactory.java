import javax.naming.*;
import javax.naming.spi.ObjectFactory;

import java.util.Enumeration;
import java.util.Hashtable;

public class EmployeeFactory implements ObjectFactory {
    public Object getObjectInstance1(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        if (obj instanceof Reference) {
            Reference ref = (Reference) obj;
            String nameAttr = (String) ref.get("name").getContent();
            String emailAttr = (String) ref.get("email").getContent();
            String phoneNumberAttr = (String) ref.get("phoneNumber").getContent();
            return new Employee(nameAttr, emailAttr, phoneNumberAttr);
        }
        return null;
    }

	@Override
	public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
