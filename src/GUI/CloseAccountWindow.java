package GUI;

import configurations.Config;

import javax.swing.*;
import java.awt.*;

public class CloseAccountWindow {

    JFrame closeAccount = new JFrame();

    JTextField nameTextField = new JTextField(Config.DEPOSIT_TEXT_FIELD_SIZE);
    JTextField lastNameTextField = new JTextField(Config.DEPOSIT_TEXT_FIELD_SIZE);

    JLabel nameLabel = new JLabel("Name: ");
    JLabel lastNameLabel = new JLabel("Last name: ");

    JButton acceptButton = new JButton("Accept");

    public CloseAccountWindow(){
       closeAccount.setSize(Config.WITHDRAW_MONEY_WINDOW_WIDTH, Config.WITHDRAW_MONEY_WINDOW_HEIGHT);
       closeAccount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       closeAccount.setResizable(false);
       closeAccount.setLocale(null);

       buildPanels();

       closeAccount.setVisible(true);
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

        closeAccount.add(closePanelNorth, BorderLayout.NORTH);
        closeAccount.add(closePanelWest, BorderLayout.WEST);
        closeAccount.add(closePanelMain, BorderLayout.CENTER);
        closeAccount.add(closePanelEast, BorderLayout.EAST);
        closeAccount.add(closePanelSouth, BorderLayout.SOUTH);
    }


}
