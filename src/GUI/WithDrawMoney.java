package GUI;

import configurations.Config;
import textFiles.AccountFileHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.zip.DeflaterInputStream;

public class WithDrawMoney {

    JFrame withdrawWindow = new JFrame();
    JTextField nameTextField = new JTextField(Config.DEPOSIT_TEXT_FIELD_SIZE);
    JTextField lastNameTextField = new JTextField(Config.DEPOSIT_TEXT_FIELD_SIZE);
    JTextField moneyTextField = new JTextField(Config.DEPOSIT_TEXT_FIELD_SIZE);

    JComboBox moneyComboBox = new JComboBox(Config.money);

    JLabel nameLabel = new JLabel("Name: ");
    JLabel lastNameLabel = new JLabel("Last name: ");
    JLabel moneyLabel = new JLabel("Money: ");

    JButton acceptButton = new JButton("Accept");

    public WithDrawMoney(){
        withdrawWindow.setSize(Config.WITHDRAW_MONEY_WINDOW_WIDTH, Config.WITHDRAW_MONEY_WINDOW_HEIGHT);
        withdrawWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        withdrawWindow.setResizable(false);
        withdrawWindow.setLocale(null);

        buildPanels();

       withdrawWindow.setVisible(true);
    }

    private void buildPanels() {

        JPanel withdrawPanelNorth = new JPanel();
        JPanel withdrawPanelWest = new JPanel();
        JPanel withdrawPanelMain = new JPanel();
        JPanel withdrawPanelEast = new JPanel();
        JPanel withdrawPanelSouth = new JPanel();

        JButton acceptButton = new JButton("Accept");

        withdrawPanelNorth.setPreferredSize(new Dimension(Config.WITHDRAW_PANEL_NORTH_SIZE, Config.WITHDRAW_PANEL_NORTH_SIZE));
        withdrawPanelWest.setPreferredSize(new Dimension(Config.WITHDRAW_PANEL_WEST_SIZE, Config.WITHDRAW_PANEL_WEST_SIZE));
        withdrawPanelMain.setPreferredSize(new Dimension(Config.WITHDRAW_PANEL_MAIN_SIZE, Config.WITHDRAW_PANEL_MAIN_SIZE));
        withdrawPanelEast.setPreferredSize(new Dimension(Config.WITHDRAW_PANEL_EAST_SIZE, Config.WITHDRAW_PANEL_EAST_SIZE));
        withdrawPanelSouth.setPreferredSize(new Dimension(Config.DEPOSIT_PANEL_SOUTH_SIZE, Config.WITHDRAW_PANEL_SOUTH_SIZE));

        withdrawPanelMain.add(nameLabel);
        withdrawPanelMain.add(nameTextField);

        withdrawPanelMain.add(lastNameLabel);
        withdrawPanelMain.add(lastNameTextField);

        withdrawPanelMain.add(moneyLabel);
        withdrawPanelMain.add(moneyTextField);

        withdrawPanelMain.add(moneyComboBox);

        acceptButton.addActionListener(new WithdrawMoneyActionListener());
        withdrawPanelSouth.add(acceptButton);

        withdrawWindow.add(withdrawPanelNorth, BorderLayout.NORTH);
        withdrawWindow.add(withdrawPanelEast, BorderLayout.EAST);
        withdrawWindow.add(withdrawPanelMain, BorderLayout.CENTER);
        withdrawWindow.add(withdrawPanelWest, BorderLayout.WEST);
        withdrawWindow.add(withdrawPanelSouth, BorderLayout.SOUTH);

    }

    private class WithdrawMoneyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double money = 0;

            if (AccountFileHandler.searchUser(nameTextField.getText(), lastNameTextField.getText())) {
                try {
                    money = Double.parseDouble(moneyTextField.getText());
                } catch (Exception DoubleParseExceptions) {
                    JOptionPane.showMessageDialog(null, "Wrong input in money text field");

                }
                AccountFileHandler.unBalance(nameTextField.getText(), lastNameTextField.getText(), money
                        , "" + moneyComboBox.getItemAt(moneyComboBox.getSelectedIndex()));
                JOptionPane.showMessageDialog(null,"Money withdraw from: " + nameTextField.getText() + " " + lastNameTextField.getText());
                withdrawWindow.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Account doesn't exist");
                withdrawWindow.dispose();
            }
        }
    }
}
