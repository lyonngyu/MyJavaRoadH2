package Baccara;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Log extends JFrame{
    public static Color[] colors = new Color[10];

    private JPanel logTitlePanel = new JPanel(new BorderLayout());
    private JPanel logPanel1 = new JPanel(new BorderLayout());
    private JPanel logPanel2 = new JPanel(new BorderLayout());
    private JPanel logPanel3 = new JPanel(new BorderLayout());
    private JPanel logPanel4 = new JPanel(new BorderLayout());
    private JPanel logPanel5 = new JPanel(new BorderLayout());
    private JPanel logPanel6 = new JPanel(new BorderLayout());
    private JPanel logPanel7 = new JPanel(new BorderLayout());
    private JPanel logPanel8 = new JPanel(new BorderLayout());
    private JPanel logPanel9 = new JPanel(new BorderLayout());
    private JPanel logPanel10 = new JPanel(new BorderLayout());

    private JLabel lbLogTitle = new JLabel("최근 10개의 내역", JLabel.CENTER);
    public static JLabel lbLog1 = new JLabel(" ", JLabel.CENTER);
    public static JLabel lbLog2 = new JLabel(" ", JLabel.CENTER);
    public static JLabel lbLog3 = new JLabel(" ", JLabel.CENTER);
    public static JLabel lbLog4 = new JLabel(" ", JLabel.CENTER);
    public static JLabel lbLog5 = new JLabel(" ", JLabel.CENTER);
    public static JLabel lbLog6 = new JLabel(" ", JLabel.CENTER);
    public static JLabel lbLog7 = new JLabel(" ", JLabel.CENTER);
    public static JLabel lbLog8 = new JLabel(" ", JLabel.CENTER);
    public static JLabel lbLog9 = new JLabel(" ", JLabel.CENTER);
    public static JLabel lbLog10 = new JLabel(" ", JLabel.CENTER);

    private void setFrame() {
        setTitle("LOG");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(11,1));
        setResizable(false);
        setVisible(true);
    }
    public Log() {
        setFrame();
        setLog();
        setColors();
    }
    public static void setColors() {
        lbLog1.setForeground(colors[0]);
        lbLog2.setForeground(colors[1]);
        lbLog3.setForeground(colors[2]);
        lbLog4.setForeground(colors[3]);
        lbLog5.setForeground(colors[4]);
        lbLog6.setForeground(colors[5]);
        lbLog7.setForeground(colors[6]);
        lbLog8.setForeground(colors[7]);
        lbLog9.setForeground(colors[8]);
        lbLog10.setForeground(colors[9]);
    }
    public void setLog() {
        logTitlePanel.setBackground(new Color(0, 75, 10));
        logPanel1.setBackground(new Color(178, 178, 178));
        logPanel2.setBackground(new Color(205, 205, 205));
        logPanel3.setBackground(new Color(178, 178, 178));
        logPanel4.setBackground(new Color(205, 205, 205));
        logPanel5.setBackground(new Color(178, 178, 178));
        logPanel6.setBackground(new Color(205, 205, 205));
        logPanel7.setBackground(new Color(178, 178, 178));
        logPanel8.setBackground(new Color(205, 205, 205));
        logPanel9.setBackground(new Color(178, 178, 178));
        logPanel10.setBackground(new Color(205, 205, 205));

        lbLogTitle.setFont(new Font("돋움",Font.BOLD, 16));
        lbLog1.setFont(new Font("돋움",Font.BOLD, 12));
        lbLog2.setFont(new Font("돋움",Font.BOLD, 12));
        lbLog3.setFont(new Font("돋움",Font.BOLD, 12));
        lbLog4.setFont(new Font("돋움",Font.BOLD, 12));
        lbLog5.setFont(new Font("돋움",Font.BOLD, 12));
        lbLog6.setFont(new Font("돋움",Font.BOLD, 12));
        lbLog7.setFont(new Font("돋움",Font.BOLD, 12));
        lbLog8.setFont(new Font("돋움",Font.BOLD, 12));
        lbLog9.setFont(new Font("돋움",Font.BOLD, 12));
        lbLog10.setFont(new Font("돋움",Font.BOLD, 12));
        lbLogTitle.setForeground(Color.white);

        lbLog1.setText(InGame.inLog[0]);
        lbLog2.setText(InGame.inLog[1]);
        lbLog3.setText(InGame.inLog[2]);
        lbLog4.setText(InGame.inLog[3]);
        lbLog5.setText(InGame.inLog[4]);
        lbLog6.setText(InGame.inLog[5]);
        lbLog7.setText(InGame.inLog[6]);
        lbLog8.setText(InGame.inLog[7]);
        lbLog9.setText(InGame.inLog[8]);
        lbLog10.setText(InGame.inLog[9]);

        logTitlePanel.add(lbLogTitle);
        logPanel1.add(lbLog1);
        logPanel2.add(lbLog2);
        logPanel3.add(lbLog3);
        logPanel4.add(lbLog4);
        logPanel5.add(lbLog5);
        logPanel6.add(lbLog6);
        logPanel7.add(lbLog7);
        logPanel8.add(lbLog8);
        logPanel9.add(lbLog9);
        logPanel10.add(lbLog10);

        add(logTitlePanel);
        add(logPanel1);
        add(logPanel2);
        add(logPanel3);
        add(logPanel4);
        add(logPanel5);
        add(logPanel6);
        add(logPanel7);
        add(logPanel8);
        add(logPanel9);
        add(logPanel10);
    }
}
