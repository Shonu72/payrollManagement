import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class view_attendance extends JFrame implements ActionListener{

    JTable j1;
    JButton b1;
    String[] h ={"Employee id","Date Time","First Half","Second Half"};
    String[][] d =new String[15][4];
    int i=0,j=0;

    view_attendance()
    {
        super("View Employee Attendance");
        setSize(800,300);
        setLocation(450,200);

        try
        {
            Conn c= new Conn();
            ResultSet rs=c.s.executeQuery("select * from attendance");

            while(rs.next())
            {
                d[i][j++]=rs.getString("id");
                d[i][j++]=rs.getString("date");
                d[i][j++]=rs.getString("first");
                d[i][j++]=rs.getString("second");
                i++;
                j=0;
            }
            j1=new JTable(d,h);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane s1= new JScrollPane(j1);
        add(s1);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        try{
            j1.print();
        }catch(Exception ignored){}
    }
    public static void main(String[] args) {

        new view_attendance();
    }


}
