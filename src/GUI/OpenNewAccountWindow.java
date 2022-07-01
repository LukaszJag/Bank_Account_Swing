package GUI;

import configurations.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenNewAccountWindow {

    JTextField nameTextField;
    JTextField lastNameTextField;
    JTextField euroTextField;
    JTextField dollarsTextFiled;
    JTextField zlotyTextField;

    JButton acceptButton;
    JFrame openAccount = new JFrame();
    public OpenNewAccountWindow(){

        JPanel openAccountMainPanel = new JPanel();

        JLabel nameLabel = new JLabel("Name:");
        JLabel lastNameLabel = new JLabel("Last name:");
        JLabel euroLabel = new JLabel("Euro:");
        JLabel dollarsLabel = new JLabel("Dollars:");
        JLabel zlotyLabel = new JLabel("Zloty:");


        nameTextField = new JTextField(Config.OPEN_ACCOUNT_TEXT_FIELD_SIZE);
        lastNameTextField = new JTextField(Config.OPEN_ACCOUNT_TEXT_FIELD_SIZE);
        euroTextField = new JTextField(Config.OPEN_ACCOUNT_TEXT_FIELD_SIZE);
        dollarsTextFiled = new JTextField(Config.OPEN_ACCOUNT_TEXT_FIELD_SIZE);
        zlotyTextField = new JTextField(Config.OPEN_ACCOUNT_TEXT_FIELD_SIZE);

        acceptButton = new JButton("Accept");

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
        acceptButton.addActionListener(new OpenNewAccountButtonActionListener());

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

    private class OpenNewAccountButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == acceptButton) {
                String[] openAccountInput = new String[5];
                String name = "";
                String lastName = "";
                String euro = "";
                String dollars = "";
                String zloty = "";

                name = nameTextField.getText();
                lastName = lastNameTextField.getText();
                euro = euroTextField.getText();
                dollars = dollarsTextFiled.getText();
                zloty = zlotyTextField.getText();

                openAccountInput[0] = name;
                openAccountInput[1] = lastName;
                openAccountInput[2] = euro;
                openAccountInput[3] = dollars;
                openAccountInput[4] = zloty;

                nameTextField.setText("");
                lastNameTextField.setText("");
                euroTextField.setText("");
                dollarsTextFiled.setText("");
                zlotyTextField.setText("");

                double euroDouble = 0;
                double dollarsDouble = 0;
                double zlotyDouble = 0;

                boolean passTest = true;

                    try {

                        Double.parseDouble(euro);

                    } catch (Exception ParseToDoubleException) {
                        JOptionPane.showMessageDialog(null, "Wrong input in euro text field.");
                       passTest = false;
                    }

                    try {

                        Double.parseDouble(dollars);

                    } catch (Exception ParseToDoubleException) {
                        JOptionPane.showMessageDialog(null, "Wrong input in dollars text field.");
                        passTest = false;
                    }

                    try {

                        Double.parseDouble(zloty);

                    } catch (Exception ParseToDoubleException) {
                        JOptionPane.showMessageDialog(null, "Wrong input in zloty text field.");
                        passTest = false;
                    }

                    if(passTest == true){
                        JOptionPane.showMessageDialog(null, "Open new account: " + " Name: " +name + " Last Name: " +lastName);
                        openAccount.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Wrong input. Open account operation fail.");
                        openAccount.dispose();
                    }


                for (int i = 0; i < openAccountInput.length; i++) {
                    System.out.println(i + " " + openAccountInput[i]);
                }
            }
        }
    }
}
