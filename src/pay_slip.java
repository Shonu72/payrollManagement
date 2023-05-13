import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;

public class pay_slip extends JFrame implements ActionListener {

    Choice c1;
    JButton b1;
    JTable table;

    pay_slip() {
        super("Pay Slip");
        setSize(800, 400);
        setLocation(450, 200);
        setLayout(new BorderLayout());

        // Adding the choice component to select the employee ID
        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");

            while (rs.next()) {
                c1.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Select ID"));
        p1.add(c1);
        add(p1, "North");

        // Creating a table to display the payslip
        table = new JTable();
        table.setBounds(30, 40, 200, 300);
        table.setBackground(Color.lightGray);
        table.setFont(new Font("Arial", Font.PLAIN, 15));
        table.setRowHeight(30);

        JScrollPane sp = new JScrollPane(table);
        add(sp, "Center");

        // Adding the button to generate the payslip
        b1 = new JButton("Generate Pay slip");
        add(b1, "South");

        b1.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee where id=" + c1.getSelectedItem());
            rs.next();
            String name = rs.getString("name");
            rs.close();

            rs = c.s.executeQuery("select * from salary where id=" + c1.getSelectedItem());

            String[] columns = {"Description", "Amount (in Rs.)"};
            String[][] data = new String[7][2];

            double gross;
            double net;
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);

            data[0][0] = "PAY Date : ";
            data[0][1] = String.valueOf(date);
            data[1][0] = "Employee ID ";
            data[1][1] = c1.getSelectedItem();
            data[2][0] = "Employee Name";
            data[2][1] = name;

            if (rs.next()) {
                double hra = rs.getDouble("hra");
                data[3][0] = "HRA";
                data[3][1] = String.valueOf(hra);
                double da = rs.getDouble("da");
                data[4][0] = "DA";
                data[4][1] = String.valueOf(da);
                double med = rs.getDouble("med");
                data[5][0] = "MED";
                data[5][1] = String.valueOf(med);
                double pf = rs.getDouble("pf");
                data[6][0] = "PF";
                data[6][1] = String.valueOf(pf);
                double basic = rs.getDouble("basic");

                gross = hra + da + med + pf + basic;
                net = gross - pf;

                table.setModel(new DefaultTableModel(data, columns));
                table.getColumnModel().getColumn(0).setPreferredWidth(200);
                table.getColumnModel().getColumn(1).setPreferredWidth(200);

            Object[] row = {"Gross Salary", gross};
            ((DefaultTableModel) table.getModel()).addRow(row);
            row = new Object[]{"Net Salary", net};
            ((DefaultTableModel) table.getModel()).addRow(row);
            }else{
                JOptionPane.showMessageDialog(null, "No record found ");
                DefaultTableModel dm = (DefaultTableModel)table.getModel();
                dm.getDataVector().removeAllElements();
                dm.fireTableDataChanged();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new pay_slip().setVisible(true);
    }
}

