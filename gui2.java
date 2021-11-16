// Progarm checks input against set values;
//   user:     "USER";
//   password: "PASSOWRD".



import java.util.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui2 implements ActionListener {

    private static JLabel userlabel;
    private static JTextField txtfld1;
    private static JLabel pwlabel;
    private static JPasswordField txtfld2;
    private static JButton buton;
    private static JLabel msg;

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setSize(300, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("LOG IN");
        frame.add(panel);

        panel.setLayout(null);

        userlabel = new JLabel("USER");
        userlabel.setBounds(10, 20, 80, 25);
        panel.add(userlabel);

        txtfld1 = new JTextField(20);
        txtfld1.setBounds(100, 20, 165, 25);
        panel.add(txtfld1);

        pwlabel = new JLabel("PASSWORD");
        pwlabel.setBounds(10, 60, 80, 25);
        panel.add(pwlabel);

        txtfld2 = new JPasswordField(20);
        txtfld2.setBounds(100, 60, 165, 25);
        panel.add(txtfld2);

        buton = new JButton("LOG IN");
        buton.setBounds(100, 100, 80, 25);
        buton.addActionListener(new gui2());
        panel.add(buton);

        msg = new JLabel("");
        msg.setBounds(80, 140, 300, 25);
        panel.add(msg);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        char[] setPassword = {'P','A','S','S','W','O','R','D'};

        String user = txtfld1.getText();
        char[] password = txtfld2.getPassword();

        boolean check = Arrays.equals(password, setPassword);


        if (user.equals("USER") && check) {
            msg.setText("LOG IN SUCCESSFUL");
        }
    }

}
