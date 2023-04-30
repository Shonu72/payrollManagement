import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Update_Employee extends JFrame implements ActionListener, ItemListener {


    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t3, t4, t5, t6, t7;
    JButton b1, b2;
    Choice c1, c2;


    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidMobileNo(String str) {
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher match = ptrn.matcher(str);
        return (match.find() && match.group().equals(str));
    }


    Update_Employee() {

        super("Update Employee");
        setLayout(null);

        c2 = new Choice();
        c2.setBounds(160, 40, 200, 25);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");

            while (rs.next()) {
                c2.add(rs.getString("id"));
            }
        } catch (Exception e) {
        }

        JLabel emp = new JLabel("Select Emp no");
        emp.setBounds(40, 40, 100, 20);
        add(emp);
        add(c2);

        l1 = new JLabel("Name");
        t1 = new JTextField(15);
        l1.setBounds(40, 80, 100, 25);
        t1.setBounds(160, 80, 200, 25);
        add(l1);
        add(t1);

        c1 = new Choice();
        c1.add("Male");
        c1.add("Female");
        c1.add("other");
        l2 = new JLabel("Gender");
        l2.setBounds(40, 120, 100, 25);
        c1.setBounds(160, 120, 200, 25);
        add(l2);
        add(c1);
        l3 = new JLabel("Address");
        t3 = new JTextField(15);
        l3.setBounds(40, 160, 100, 25);
        t3.setBounds(160, 160, 200, 25);
        add(l3);
        add(t3);
        l4 = new JLabel("State");
        t4 = new JTextField(15);
        l4.setBounds(40, 200, 100, 25);
        t4.setBounds(160, 200, 200, 25);
        add(l4);
        add(t4);
        l5 = new JLabel("City");
        t5 = new JTextField(15);
        l5.setBounds(40, 240, 100, 25);
        t5.setBounds(160, 240, 200, 25);
        add(l5);
        add(t5);
        l6 = new JLabel("Email");
        t6 = new JTextField(15);
        l6.setBounds(40, 280, 100, 25);
        t6.setBounds(160, 280, 200, 25);
        add(l6);
        add(t6);

        l7 = new JLabel("Phone");
        t7 = new JTextField(15);
        l7.setBounds(40, 320, 100, 25);
        t7.setBounds(160, 320, 200, 25);
        add(l7);
        add(t7);

        b1 = new JButton("Update");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("Delete");
        b2.setBackground(Color.red);
        b2.setForeground(Color.white);

        b1.setBounds(70, 400, 100, 30);
        b2.setBounds(230, 400, 100, 30);
        add(b1);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        c2.addItemListener(this);

        setSize(450, 550);
        setLocation(500, 200);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String n=t1.getText();
            String g=c1.getSelectedItem();
            String a=t3.getText();
            String s=t4.getText();
            String c=t5.getText();
            String e=t6.getText();
            String p=t7.getText();
            if (n.equals("") || a.equals("") || s.equals("") || c.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all details...");
            } else if (!isValidEmail(e)) {
                JOptionPane.showMessageDialog(null, "Invalid Email ");
            } else if (!isValidMobileNo(p)) {
                JOptionPane.showMessageDialog(null, "Invalid Phone....");
            } else {
                String qry = " update employee set name='" + n + "',gender='" + g + "',address='" + a + "',state='" + s + "',city='" + c + "',email='" + e + "',phone='" + p + "' where id=" + c2.getSelectedItem();
                try {
                    Conn c1 = new Conn();
                    c1.s.executeUpdate(qry);
                    JOptionPane.showMessageDialog(null, "Employee Updated");
                    this.setVisible(false);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        }
        if (ae.getSource() == b2) {
            String n = t1.getText();
            String g = c1.getSelectedItem();
            String a = t3.getText();
            String s = t4.getText();
            String c = t5.getText();
            String e = t6.getText();
            String p = t7.getText();
            if (n.equals("") || a.equals("") || s.equals("") || c.equals("")) {
                JOptionPane.showMessageDialog(null, "OOPS! You haven't selected employee details ");
            } else {
                try {
                    Conn c1 = new Conn();

                    String delqry = "delete from employee where id=" + c2.getSelectedItem();
                    c1.s.executeUpdate(delqry);
                    JOptionPane.showMessageDialog(null, "Employee Deleted");
                    this.setVisible(false);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        }
    }

    public void itemStateChanged(ItemEvent ie) {
        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from employee where id=" + c2.getSelectedItem());
            if (rs.next()) {
                t1.setText(rs.getString("name"));
                t3.setText(rs.getString("address"));
                t4.setText(rs.getString("state"));
                t5.setText(rs.getString("city"));
                t6.setText(rs.getString("email"));
                t7.setText(rs.getString("phone"));
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Update_Employee();
    }

}
