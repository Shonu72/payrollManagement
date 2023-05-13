import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class Update_salary extends JFrame implements ActionListener,ItemListener{

    JLabel l1,l3,l4,l5,l6;
    JTextField t1,t3,t4,t5,t6;
    JButton b1,b2;
    Choice c2;

    Update_salary()
    {
        super("Update salary");
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
        catch(Exception e) {
            e.printStackTrace();
        }

        JLabel emp=new JLabel("Select Emp no");
        emp.setBounds(40, 40, 100, 20);
        add(emp);
        add(c2);

        l1=new JLabel("HRA");
        t1=new JTextField(15);
        l1.setBounds(40, 90, 100, 25);
        t1.setBounds(160, 90, 200, 25);
        add(l1);
        add(t1);

        l3=new JLabel("DA");
        t3=new JTextField(15);
        l3.setBounds(40, 140, 100, 25);
        t3.setBounds(160, 140, 200, 25);
        add(l3);
        add(t3);

        l4=new JLabel("MED");
        t4=new JTextField(15);
        l4.setBounds(40, 190, 100, 25);
        t4.setBounds(160, 190, 200, 25);
        add(l4);
        add(t4);

        l5=new JLabel("PF");
        t5=new JTextField(15);
        l5.setBounds(40, 240, 100, 25);
        t5.setBounds(160, 240, 200, 25);
        add(l5);
        add(t5);

        l6=new JLabel("Basic Salary");
        t6=new JTextField(15);
        l6.setBounds(40, 290, 100, 25);
        t6.setBounds(160, 290, 200, 25);
        add(l6);
        add(t6);


        b1=new JButton("Update");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.WHITE);

        b2=new JButton("Delete");
        b2.setBackground(Color.red);
        b2.setForeground(Color.WHITE);

        b1.setBounds(70, 360, 100, 30);
        b2.setBounds(230, 360, 100, 30);
        add(b1);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        c2.addItemListener(this);

        setSize(450,550);
        setLocation(500,200);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String hra=t1.getText();
            String id=c2.getSelectedItem();
            String da=t3.getText();
            String med=t4.getText();
            String pf=t5.getText();
            String basic=t6.getText();
            String qry = "update salary set hra="+hra+",da="+da+",med="+med+",pf="+pf+",basic="+basic+" where id="+c2.getSelectedItem();
            try
            {
                Conn c1= new Conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null, "Salary Updated");
                this.setVisible(false);
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
        if(ae.getSource()==b2) {
            String hra = t1.getText();
            String id = c2.getSelectedItem();
            String da = t3.getText();
            String med = t4.getText();
            String pf = t5.getText();
            String basic = t6.getText();
            if (hra.equals("") || id.equals("") || da.equals("") || med.equals("") || pf.equals("") || basic.equals("") ) {
                JOptionPane.showMessageDialog(null, "OOPS! You haven't selected employee details ");
            } else {
                try {
                    Conn c1 = new Conn();
                    String delqry = "delete from salary where id=" + c2.getSelectedItem();
                    c1.s.executeUpdate(delqry);
                    JOptionPane.showMessageDialog(null, "Salary Deleted");
                    this.setVisible(false);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        }
    }
    public void itemStateChanged(ItemEvent ie)
    {
        try
        {
            Conn c1= new Conn();
            ResultSet rs=c1.s.executeQuery("select * from salary where id="+c2.getSelectedItem());
            if(rs.next())
            {
                t1.setText(rs.getString("hra"));
                t3.setText(rs.getString("da"));
                t4.setText(rs.getString("med"));
                t5.setText(rs.getString("pf"));
                t6.setText(rs.getString("basic"));
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Update_salary();
    }

}
