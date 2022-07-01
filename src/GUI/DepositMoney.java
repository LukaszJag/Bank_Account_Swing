package GUI;

import configurations.Config;

import javax.swing.*;
import java.awt.*;

public class DepositMoney {

    JFrame depositFrame = new JFrame();
    JTextField nameTextField = new JTextField(Config.DEPOSIT_TEXT_FIELD_SIZE);
    JTextField lastNameTextField = new JTextField(Config.DEPOSIT_TEXT_FIELD_SIZE);
    JTextField moneyTextField = new JTextField(Config.DEPOSIT_TEXT_FIELD_SIZE);

    JComboBox moneyComboBox = new JComboBox(Config.money);

    JLabel nameLabel = new JLabel("Name: ");
    JLabel lastNameLabel = new JLabel("Last name: ");
    JLabel moneyLabel = new JLabel("Money: ");

    JButton acceptButton = new JButton("Accept");

    public DepositMoney() {
        depositFrame.setSize(Config.DEPOSIT_WINDOWS_WIDTH, Config.DEPOSIT_WINDOWS_HEIGHT);
        depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        depositFrame.setResizable(false);
        depositFrame.setLocale(null);

        buildPanels();


        depositFrame.setVisible(true);
    }

    private void buildPanels() {

        JPanel depositPanelNorth = new JPanel();

        JPanel depositPanelWest = new JPanel();

        JPanel depositPanelMain = new JPanel();

        JPanel depositPanelEast = new JPanel();

        JPanel depositPanelSouth = new JPanel();

        depositPanelNorth.setPreferredSize(new Dimension(Config.DEPOSIT_PANEL_NORTH_SIZE, Config.DEPOSIT_PANEL_NORTH_SIZE));
        depositPanelWest.setPreferredSize(new Dimension(Config.DEPOSIT_PANEL_WEST_SIZE, Config.DEPOSIT_PANEL_WEST_SIZE));

        depositPanelMain.setPreferredSize(new Dimension(Config.DEPOSIT_PANEL_MAIN_SIZE, Config.DEPOSIT_PANEL_MAIN_SIZE));

        depositPanelEast.setPreferredSize(new Dimension(Config.DEPOSIT_PANEL_EAST_SIZE, Config.DEPOSIT_PANEL_EAST_SIZE));
        depositPanelSouth.setPreferredSize(new Dimension(Config.DEPOSIT_PANEL_SOUTH_SIZE, Config.DEPOSIT_PANEL_SOUTH_SIZE));

        depositPanelMain.add(nameLabel);
        depositPanelMain.add(nameTextField);

        depositPanelMain.add(lastNameLabel);
        depositPanelMain.add(lastNameTextField);
        depositPanelMain.add(moneyLabel);
        depositPanelMain.add(moneyTextField);
        depositPanelMain.add(moneyComboBox);

        depositPanelSouth.add(acceptButton);

        depositFrame.add(depositPanelNorth, BorderLayout.NORTH);
        depositFrame.add(depositPanelWest, BorderLayout.WEST);
        depositFrame.add(depositPanelMain, BorderLayout.CENTER);
        depositFrame.add(depositPanelEast, BorderLayout.EAST);
        depositFrame.add(depositPanelSouth, BorderLayout.SOUTH);


    }

}
