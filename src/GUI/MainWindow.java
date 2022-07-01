package GUI;

import configurations.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow extends JFrame{

    private JLabel askingLabel;
    private JComboBox optionComboBox;
    private JPanel startWindowPanel;
    private JFrame startWindow;
    private JLabel bankInformations;
    private JLabel bankInformationsUsers;
    private JLabel bankInformationsTotalMoney;
    private JButton acctepButton;

    private BorderLayout startWindowBorderLayout;

    public MainWindow(){
        makeWindow();
    }

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JPanel panel5 = new JPanel();

    public void makeWindow(){

        JOptionPane.showMessageDialog(this,"Welcome in Bank Application");

        startWindow = new JFrame("Bank Application");
        startWindow.setSize(Config.START_WINDOWS_WIDTH, Config.START_WINDOWS_HEIGHT);
        startWindowBorderLayout = new BorderLayout();
        startWindow.setLayout(startWindowBorderLayout);



        panel1.setBackground(Color.BLACK);
        panel2.setBackground(Color.GRAY);
        panel3.setBackground(Color.DARK_GRAY);
        panel4.setBackground(Color.BLUE);
        panel5.setBackground(Color.WHITE);

        panel1.setPreferredSize(new Dimension(100,40));
        panel2.setPreferredSize(new Dimension(150,100));
        panel3.setPreferredSize(new Dimension(100,100));
        panel4.setPreferredSize(new Dimension(100,100));
        panel5.setPreferredSize(new Dimension(100,25));

        buildPanel();

        startWindow.add(panel1, BorderLayout.NORTH);
        startWindow.add(panel2, BorderLayout.WEST);
        startWindow.add(panel3, BorderLayout.CENTER);
        startWindow.add(panel4, BorderLayout.EAST);
        startWindow.add(panel5, BorderLayout.SOUTH);




        startWindow.setLocationRelativeTo(null);
        startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startWindow.setResizable(false);
        startWindow.setVisible(true);

    }

    private void buildPanel() {

        startWindowPanel = new JPanel();

        Button openAccountButton = new Button("Open new bank acoount");
        openAccountButton.addActionListener(new OpenNewAccout());
        Button depositButton = new Button("Deposit money");
        Button withdrawButton = new Button("Withdraw money");
        Button closeAccountButton = new Button("Close bank account");



        panel2.add(openAccountButton);
        panel2.add(depositButton);
        panel2.add(withdrawButton);
        panel2.add(closeAccountButton);

    }

    private class OpenNewAccout implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            new OpenNewAccountWindow();

        }
    }
}
