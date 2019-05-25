package usecabeca29;

import java.rmi.*;
import java.rmi.server.*;

public class MyRemoteImpl {
    public String sayHello(){
        return "Server says,'Hey";
    }
    
    public MyRemoteImpl() throws RemoteException{}
    
    public static void main(String[] args) {
        try {
            MyRemote service = (MyRemote) new MyRemoteImpl();
            Naming.rebind("Remote Hello", service);
        } catch (Exception ex) { ex.printStackTrace(); }
    }
    
}
