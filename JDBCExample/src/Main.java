import java.beans.PropertyDescriptor;

import com.epam.jdbc.dao.StudentDAO;

public class Main {
public static class MyDummy {
    private String payload;

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
public static void main(String[] args) {
    /*System.out.println("JAVA: " + System.getProperty("java.version") + " (" + System.getProperty("java.vm.name") + ")");
    MyDummy d = new MyDummy();
    d.setPayload("init");
    System.out.println("Value before: " + d.getPayload());

    try {
        PropertyDescriptor pd = new PropertyDescriptor("payload", MyDummy.class);
        pd.getWriteMethod().invoke(d, "hello introspection");
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println("Value after: " + d.getPayload());*/
	//System.out.println(StudentDAO.transaction());
	System.out.println(StudentDAO.getAllStudent());

}
}