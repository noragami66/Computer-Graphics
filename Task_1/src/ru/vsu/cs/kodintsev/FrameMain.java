package ru.vsu.cs.kodintsev;

import javax.swing.*;

public class FrameMain extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel paintAreaPanel;

    public FrameMain() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        DrawPanel dp = new DrawPanel();
        paintAreaPanel.add(dp);
    }

    public static void main(String[] args) {
        FrameMain dialog = new FrameMain();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
