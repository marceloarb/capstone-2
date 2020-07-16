package com.teksystems.tekcamp;

import com.teksystems.tekcamp.controller.Controller;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller();

        JFrame frame = new JFrame();
        frame.setTitle(Controller.getTitle());
        frame.add(controller);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        controller.start();
    }

}
