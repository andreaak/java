package _04_Other.router;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface OutputChannel extends Remote{
    public void sendMessage(Message message) throws RemoteException;
}