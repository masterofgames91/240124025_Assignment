package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfUserName, tfUserText;
    JLabel userMessages;

    public void initialize() {

        /********Form panel *********/

        JLabel lbUserName = new JLabel("UserName");
        lbUserName.setFont(mainFont);

        tfUserName = new JTextField();
        tfUserName.setFont(mainFont);

        JLabel lbUserText = new JLabel("What Message would you like to send");
        lbUserText.setFont(mainFont);
        
        tfUserText = new JTextField();
        tfUserText.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(lbUserName);
        formPanel.add(tfUserName);
        formPanel.add(lbUserText);
        formPanel.add(tfUserText);

        /**********Welcome panel *********/
        userMessages = new JLabel();
        userMessages.setFont(mainFont);

        /*********Button panel ***********/
        JButton btnSend = new JButton("Send");
        btnSend.setFont(mainFont);
        btnSend.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                String UserName = tfUserName.getText();
                String UserText = tfUserText.getText();
                userMessages.setText(UserName + ": " + UserText);
                userMessages = new JLabel();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                tfUserText.setText("");
                userMessages.setText("");
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnSend);
        buttonsPanel.add(btnClear);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128,128,255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(userMessages, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Welcome");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void  main(String[] args){
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }
}
