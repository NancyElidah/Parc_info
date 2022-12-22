package interfaces;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JScrollPane;
public class Fenetre extends JFrame{
    String[] colomun ;
    String[][] rowData;
    public void set_colomun(String[] c){
        this.colomun = c ;
    }
    public void set_rowData(String[][] r){
        this.rowData = r;
    }
    public String[] get_colomun(){
        return this.colomun;
    }
    public String[][] get_rowData(){
        return this.rowData;
    }
    public Fenetre(){}
    public Fenetre(String[] colonne , String[][] ligne)throws Exception{
        try{
            this.set_colomun(colonne);
            this.set_rowData(ligne);
            
            JPanel jp = new JPanel();
            jp.setLayout(new GridLayout(2,1));
            
            
            JTable jt = new JTable(this.get_rowData(),this.get_colomun());
            this.setTitle("Parc Informatique");
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JScrollPane js = new JScrollPane(jt);
            jp.add(js);

            this.setSize(1000,500);
            this.setLocationRelativeTo(null);
            this.add(jp);

            this.setVisible(false);
        }catch(Exception exe){
            System.out.println(exe.getMessage());
        }
    }
}