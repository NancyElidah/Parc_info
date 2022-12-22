package affichage;
import serveur.Serveur;
import java.io.*;
public class MainServeur{
    public static void main (String[] args){
        try{
            String fileName = "donnees.txt";
            File file = new File(fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
            Serveur serveur= new Serveur(3333,file);
        }catch(Exception exe){
            System.out.println(exe.getMessage());
        }
    }
}