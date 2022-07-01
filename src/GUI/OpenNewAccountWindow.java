package GUI;

import configurations.Config;

import javax.swing.*;
import java.awt.*;

public class OpenNewAccountWindow {

    public OpenNewAccountWindow(){
        JFrame openAccount = new JFrame();
        JPanel openAccountMainPanel = new JPanel();

        JLabel nameLabel = new JLabel("Name:");
        JLabel lastNameLabel = new JLabel("Last name:");
        JLabel euroLabel = new JLabel("Euro:");
        JLabel dollarsLabel = new JLabel("Dollars:");
        JLabel zlotyLabel = new JLabel("Zloty:");


        JTextField nameTextField = new JTextField(Config.OPEN_ACCOUNT_TEXT_FIELD_SIZE);
        JTextField lastNameTextField = new JTextField(Config.OPEN_ACCOUNT_TEXT_FIELD_SIZE);
        JTextField euroTextField = new JTextField(Config.OPEN_ACCOUNT_TEXT_FIELD_SIZE);
        JTextField dollarsTextFiled = new JTextField(Config.OPEN_ACCOUNT_TEXT_FIELD_SIZE);
        JTextField zlotyTextField = new JTextField(Config.OPEN_ACCOUNT_TEXT_FIELD_SIZE);

        JButton acceptButton = new JButton("Accept");

        openAccountMainPanel.setLayout(new GridLayout(5,2));

        //Add components to panel
        openAccountMainPanel.add(nameLabel);
        openAccountMainPanel.add(nameTextField);

        openAccountMainPanel.add(lastNameLabel);
        openAccountMainPanel.add(lastNameTextField);

        openAccountMainPanel.add(euroLabel);
        openAccountMainPanel.add(euroTextField);

        openAccountMainPanel.add(dollarsLabel);
        openAccountMainPanel.add(dollarsTextFiled);

        openAccountMainPanel.add(zlotyLabel);
        openAccountMainPanel.add(zlotyTextField);

        openAccount.setLayout(new BorderLayout());

        JPanel openAccountPanelNorth = new JPanel();
        JPanel openAccountPanelWest = new JPanel();
        JPanel openAccountPanelEast = new JPanel();
        JPanel openAccountPanelSouth = new JPanel();

        openAccountPanelSouth.add(acceptButton);

        openAccount.add(openAccountPanelNorth, BorderLayout.NORTH);
        openAccount.add(openAccountPanelWest, BorderLayout.WEST);
        openAccount.add(openAccountMainPanel, BorderLayout.CENTER);
        openAccount.add(openAccountPanelEast, BorderLayout.EAST);
        openAccount.add(openAccountPanelSouth, BorderLayout.SOUTH);

        openAccountPanelNorth.setPreferredSize(new Dimension(Config.OPEN_ACCOUNT_PANELS_NORTH_SIZE, Config.OPEN_ACCOUNT_PANELS_NORTH_SIZE));
        openAccountPanelEast.setPreferredSize(new Dimension(Config.OPEN_ACCOUNT_PANELS_WEST_EAST_SIZE, Config.OPEN_ACCOUNT_PANELS_WEST_EAST_SIZE));

        openAccountMainPanel.setPreferredSize(new Dimension(Config.OPEN_ACCOUNT_PANELS_CENTER, Config.OPEN_ACCOUNT_PANELS_CENTER));

        openAccountPanelWest.setPreferredSize(new Dimension(Config.OPEN_ACCOUNT_PANELS_WEST_EAST_SIZE, Config.OPEN_ACCOUNT_PANELS_WEST_EAST_SIZE));
        openAccountPanelSouth.setPreferredSize(new Dimension(Config.OPEN_ACCOUNT_PANELS_SOUTH_SIZE, Config.OPEN_ACCOUNT_PANELS_SOUTH_SIZE));

        openAccount.setSize(Config.OPEN_ACCOUNT_WINDOWS_WIDTH , Config.OPEN_ACCOUNT_WINDOWS_HEIGHT);
        openAccount.setResizable(false);
        openAccount.setLocale(null);
        openAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        openAccount.setVisible(true);

    }
}
