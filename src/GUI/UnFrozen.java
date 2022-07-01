package GUI;

import configurations.Config;
import textFiles.AccountFileHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnFrozen {
    JFrame unfrozenAccount = new JFrame();

    JTextField nameTextField = new JTextField(Config.DEPOSIT_TEXT_FIELD_SIZE);
    JTextField lastNameTextField = new JTextField(Config.DEPOSIT_TEXT_FIELD_SIZE);

    JLabel nameLabel = new JLabel("Name: ");
    JLabel lastNameLabel = new JLabel("Last name: ");

    JButton acceptButton = new JButton("Accept");

    public UnFrozen(){
        unfrozenAccount.setSize(Config.WITHDRAW_MONEY_WINDOW_WIDTH, Config.WITHDRAW_MONEY_WINDOW_HEIGHT);
        unfrozenAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        unfrozenAccount.setResizable(false);
        unfrozenAccount.setLocale(null);

        buildPanels();

        unfrozenAccount.setVisible(true);
    }

    private void buildPanels() {
        JPanel closePanelNorth = new JPanel();
        JPanel closePanelWest = new JPanel();
        JPanel closePanelMain = new JPanel();
        JPanel closePanelEast = new JPanel();
        JPanel closePanelSouth = new JPanel();

        closePanelNorth.setPreferredSize(new Dimension(Config.CLOSE_PANEL_NORTH_SIZE, Config.CLOSE_PANEL_NORTH_SIZE));
        closePanelWest.setPreferredSize(new Dimension(Config.CLOSE_PANEL_WEST_SIZE, Config.CLOSE_PANEL_WEST_SIZE));

        closePanelMain.setPreferredSize(new Dimension(Config.CLOSE_PANEL_MAIN_SIZE, Config.CLOSE_PANEL_MAIN_SIZE));

        closePanelEast.setPreferredSize(new Dimension(Config.CLOSE_PANEL_EAST_SIZE, Config.WITHDRAW_PANEL_EAST_SIZE));
        closePanelSouth.setPreferredSize(new Dimension(Config.CLOSE_PANEL_SOUTH_SIZE, Config.CLOSE_PANEL_SOUTH_SIZE));

        closePanelMain.add(nameLabel);
        closePanelMain.add(nameTextField);

        closePanelMain.add(lastNameLabel);
        closePanelMain.add(lastNameTextField);

        closePanelSouth.add(acceptButton);

        unfrozenAccount.add(closePanelNorth, BorderLayout.NORTH);
        unfrozenAccount.add(closePanelWest, BorderLayout.WEST);
        unfrozenAccount.add(closePanelMain, BorderLayout.CENTER);
        unfrozenAccount.add(closePanelEast, BorderLayout.EAST);
        unfrozenAccount.add(closePanelSouth, BorderLayout.SOUTH);
    }

    private class CloseAccount implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!AccountFileHandler.searchUser(nameTextField.getText(), lastNameTextField.getText())){
                JOptionPane.showMessageDialog(null, "Account doesn't exist");
                unfrozenAccount.dispose();
            }else {
                AccountFileHandler.unfrozenAccount(nameTextField.getText(),lastNameTextField.getText());
                unfrozenAccount.dispose();
            }
        }
    }

}

