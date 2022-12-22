package client;
import java.io.*;
import java.net.*;
import java.lang.System;
public class Client extends  Thread{
    String host;
    int motDePasse;
    public void set_host(String h){
        this.host=h;
    }
    public void set_motDePasse(int mdp){
        this.motDePasse=mdp;
    }
    public String get_host(){
        return this.host;
    }
    public int get_motDePasse(){
        return this.motDePasse;
    }
    public Client(String h , int mdp) {
        try{	
            this.set_host(h);
            this.set_motDePasse(mdp);

            Socket s=new Socket(this.get_host(),this.get_motDePasse());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            String res = this.getAllInfo();
            dout.writeUTF (res);
            dout.flush();
            dout.close();
            Thread.sleep(5000);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public String getAllInfo(){
        String response = "";
        response = System.getProperty("user.home") ;
        response = response + "//";
        response = response + System.getProperty("os.name");
        response = response + "//";
        response = response + System.getProperty("java.runtime.version");
        response = response + "//";
        response = response + System.getProperty("user.name");
        response = response + "//";
        response = response +  Runtime.getRuntime().totalMemory();
        response = response + "//";
        response = response + Runtime.getRuntime().maxMemory();
        response = response + "#";
        return response ;
    }
}