package GUI;

import configurations.Config;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{

    private JLabel askingLabel;
    private JComboBox optionComboBox;
    private JPanel startWindowPanel;
    private JFrame startWindow;
    private JLabel bankInformations;
    private JLabel bankInformationsUsers;
    private JLabel bankInformationsTotalMoney;
    private JButton acctepButton;


    public MainWindow(){
        makeWindow();
    }


    public void makeWindow(){

        JOptionPane.showMessageDialog(this,"Welcome in Bank Application");
        startWindow = new JFrame("Bank Application");
        startWindow.setSize(Config.START_WINDOWS_WIDTH, Config.START_WINDOWS_HEIGHT);

        buildPanel();

        startWindow.add(startWindowPanel);
        startWindow.setLocationRelativeTo(null);
        startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startWindow.setResizable(false);
        startWindow.setVisible(true);

    }

    private void buildPanel() {

        startWindowPanel = new JPanel();

        bankInformations = new JLabel("Bank app manager.");
        bankInformationsUsers = new JLabel("Active users: " + Config.users);
        bankInformationsTotalMoney = new JLabel("Total money in bank: " + Config.totalMoney);
        askingLabel = new JLabel("What action do you want to do?");
        optionComboBox = new JComboBox<>(Config.options);
        acctepButton = new JButton("Ok");

        startWindowPanel.add(bankInformations);
        startWindowPanel.add(bankInformationsUsers);
        startWindowPanel.add(bankInformationsTotalMoney);
        startWindowPanel.add(askingLabel);
        startWindowPanel.add(optionComboBox);
        startWindowPanel.add(acctepButton);

    }
}
