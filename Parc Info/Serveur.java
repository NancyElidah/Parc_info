package serveur;
import java.io.*;
import java.net.*;
import java.util.Vector;
import interfaces.*;
public class Serveur {
    int mdp ;
    File file;
    public void set_mdp (int m)throws Exception{
        if (m < 0 ){
            Exception exe = new Exception ("Valeur negative ");
            throw exe ;
        }else{
            this.mdp=m;
        }
    }
    public void set_file(File f){
        this.file= f;
    }
    public int get_mdp (){
        return this.mdp;
    }
    public File get_file(){
        return this.file;
    }
    public Serveur (int m ,File f) throws Exception{
        try{
                this.set_mdp(m);
                this.set_file(f);
                Fenetre fenetre = new Fenetre();
                this.get_file().delete();
                while(1!=0){
                    ServerSocket server=new ServerSocket(this.get_mdp());
                    Socket s=server.accept();
                    DataInputStream dout=new DataInputStream(s.getInputStream());
                    String data = dout.readUTF();
                    System.out.println(data);
                    write_inFile(data);
                    
                    fenetre = new Fenetre(this.completeColomun(),this.getAll());
                    this.ouvrirFenetre(fenetre);
                    dout.close();
                    s.close();
                    server.close();
                    Thread.sleep(2000);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
    }
    public void write_inFile(String data)throws Exception {
        FileOutputStream file_mapiditra=new FileOutputStream(this.get_file().getName(),true);
        file_mapiditra.write(data.getBytes());
        file_mapiditra.close();
   }
   public void ouvrirFenetre(Fenetre f){
        f.setVisible(true);
   }
   public String[][] getAll()throws Exception {
        FileInputStream file_mapiditra=new FileInputStream(this.get_file().getName());
            char text='a';
            String retour=" ";
            int i=file_mapiditra.read();
            String[] text_obtenu=new String[50];
            while(i!=-1){
                text=(char)i;
                retour=retour+text;
                i=file_mapiditra.read();
            }
            text_obtenu=retour.split("#");
            String[][] farany=new String[text_obtenu.length][5];
            for(int j=0;j<text_obtenu.length;j++){
                farany[j]=text_obtenu[j].split("//");

            }
            return farany;
   }
   public String[] completeColomun(){
        String[] colomun = new String[6];
        colomun[0]="user.home";
        colomun[1]="os";
        colomun[2]= "java.version";
        colomun[3] = "user.name";
        colomun[4] = "RAM.total";
        colomun[5]="RAM.maxMemory";
        return colomun;
   }
   public void test (){
    if(this.get_file().delete()){
        System.out.println("maty");
    }else{
        System.out.println("tsia");
    }
   }
}