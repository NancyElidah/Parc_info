package affichage;
import client.Client;
public class MainClient{
    public static void main (String[] args){
        try{
            Client client= new Client("localhost",3333);
        }catch(Exception exe){
            System.out.println(exe.getMessage());
        }
    }
}