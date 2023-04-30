import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class TakeAttendance extends JFrame implements ActionListener{

    JLabel l1,l2;
    JButton b1,b2;
    Choice c2,fh,sh;

    TakeAttendance()
    {
        super("Take Attendance");
        setLayout(null);
        c2=new Choice();
        c2.setBounds(160, 40, 200, 25);
        try
        {
            Conn c= new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");

            while(rs.next())
            {
                c2.add(rs.getString("id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JLabel emp = new JLabel("Select Emp no");
        emp.setBounds(40, 40, 100, 20);
        add(emp);
        add(c2);

        l1=new JLabel("First Half");
        l1.setBounds(40, 80, 100, 25);

        fh=new Choice();
        fh.setBounds(160, 80, 200, 25);
        fh.add("Present");
        fh.add("Absent");
        fh.add("Leave");
        add(l1);
        add(fh);

        l2=new JLabel("Second Half");
        l2.setBounds(40, 120, 100, 25);
        sh=new Choice();
        sh.setBounds(160, 120, 200, 25);

        sh.add("Present");
        sh.add("Absent");
        sh.add("Leave");
        add(l2);
        add(sh);
        b1=new JButton("Submit");
        b2=new JButton("Cancel");
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b1.setBackground(Color.blue);
        b1.setForeground(Color.WHITE);

        b2.addActionListener(this);
        b2.setBackground(Color.red);
        b2.setForeground(Color.WHITE);

        b1.setBounds(50, 200, 100, 30);
        b2.setBounds(250, 200, 100, 30);
        setSize(450,450);
        setLocation(500,200);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1) {
            String f = fh.getSelectedItem();
            String s = sh.getSelectedItem();
            String dt = new java.util.Date().toString();
            String id = c2.getSelectedItem();
            String qry = "insert into attendance values(" + id + ",'" + dt + "','" + f + "','" + s + "')";
            try {
                Conn c1 = new Conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null, "Attendance Confirmed");
                this.setVisible(false);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if(ae.getSource()==b2)
        {
            try {
                dispose();
                this.setVisible(false);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        new TakeAttendance();
    }
}

