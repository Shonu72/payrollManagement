import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class dashboard extends JFrame implements ActionListener {

    dashboard()
    {
        setSize(1000,600);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/payroll.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        add(l1);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        //-----------MASTER----------------------
        JMenu m1= new JMenu("Menu");
        m1.setForeground(Color.blue);


        JMenuItem t1=new JMenuItem("New Employee");
        t1.setForeground(Color.blue);
        t1.setFont(new Font("monospaced",Font.PLAIN,12));
        t1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icons/New.png")));

        JMenuItem t3=new JMenuItem("Salary");

        t3.setForeground(Color.blue);
        t3.setFont(new Font("monospaced",Font.PLAIN,12));
        t3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/schedreport.PNG")));

        JMenuItem t4=new JMenuItem("List Employee");

        t4.setForeground(Color.blue);
        t4.setFont(new Font("monospaced",Font.PLAIN,12));
        t4.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/newinvoice.png")));

        m1.add(t1);
        m1.add(t3);
        m1.add(t4);
        mb.add(m1);

        t1.addActionListener(this);
        t3.addActionListener(this);
        t4.addActionListener(this);

        //-----------------UPDATE----------------------
        JMenu edit= new JMenu("Update");
        edit.setForeground(Color.BLUE);
        mb.add(edit);

        JMenuItem s1=new JMenuItem("Update Salary");

        s1.setForeground(Color.blue);
        s1.setFont(new Font("monospaced",Font.PLAIN,12));
        s1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Icons/EditOpen.png")));

        JMenuItem s2=new JMenuItem("Update Employee");

        s2.setForeground(Color.blue);
        s2.setFont(new Font("monospaced",Font.PLAIN,12));
        s2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));

        JMenuItem s3=new JMenuItem("Take Attendance");

        s3.setForeground(Color.blue);
        s3.setFont(new Font("monospaced",Font.PLAIN,12));
        s3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/EXPENSE.png")));

        edit.add(s1);
        edit.add(s2);
        edit.add(s3);

        s1.addActionListener(this);
        s3.addActionListener(this);
        s2.addActionListener(this);

        //-----------------REPORTS----------------------
        JMenu rep= new JMenu("Reports");
        rep.setForeground(Color.BLUE);
        mb.add(rep);

        JMenuItem p1=new JMenuItem("Generate payslip");

        p1.setForeground(Color.blue);
        p1.setFont(new Font("monospaced",Font.PLAIN,12));
        p1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/payments.png")));

        rep.add(p1);

        p1.addActionListener(this);


        //-----------------EXIT----------------------
        JMenu m8= new JMenu("Exit");
        m8.setForeground(Color.RED);
        mb.add(m8);

        JMenuItem m8i1=new JMenuItem("Exit");

        m8i1.setForeground(Color.BLUE);
        m8i1.setFont(new Font("monospaced",Font.PLAIN,12));
        m8i1.setMnemonic('X');
        m8i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.png")));
        m8i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        m8.add(m8i1);

        m8i1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String msg = ae.getActionCommand();

        if(msg.equals("New Employee"))
            new New_Employee().setVisible(true);
        else if(msg.equals("List Employee"))
            new List_Employee().setVisible(true);
        else if(msg.equals("Update Employee"))
            new Update_Employee().setVisible(true);
        else if(msg.equals("Salary"))
            new Salary().setVisible(true);
        else if(msg.equals("Update Salary"))
            new Update_salary().setVisible(true);
        else if(msg.equals("Take Attendance"))
            new TakeAttendance().setVisible(true);
        else if(msg.equals("Exit"))
            dispose();
        else if(msg.equals("Generate payslip"))
            new pay_slip().setVisible(true);
//        else if(msg.equals("List Attendance"))
//            new List_Attendance().setVisible(true);
    }
    public static void main(String[] args) {
        new dashboard().setVisible(true);
    }
}
