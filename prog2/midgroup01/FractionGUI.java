import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FractionGUI extends JFrame {
    private JPanel displayPanel = new JPanel(new GridLayout(2, 1));
    private JTextArea display = new JTextArea(3,30);
    private JTextField output = new JTextField();
    private BorderLayout brLay = new BorderLayout();
    private GridLayout btnLay = new GridLayout(6, 4, 4, 4);
    private JPanel bgPanel = new JPanel(new BorderLayout());
    private JPanel btnPanel = new JPanel();
    private Color bgColor = new Color(250, 230, 230);
    private Color btnColor = new Color(250, 170, 170);
    private Color fontColor = new Color(140, 70, 80);
    private Color altbtnColor = new Color(200,160,160);
    private Font btnFont = new Font("Arial", Font.PLAIN, 20);
    private Dimension txtDim = new Dimension(430, 100);

    public JTextArea getDisplay(){
        return display;
    }

    public JTextField getOutput(){
        return output;
    }

    public FractionGUI() {
        setTitle("Fraction Calculator");
        setSize(430, 600);
        setLayout(brLay);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bgPanel.setBackground(bgColor);
        btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        btnPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        btnPanel.setLayout(btnLay);

        String[] btnLabel = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "C", "0", "=", "/", "Sf", "Mf", "Dec", "Red", "", "<", ">", ""};
        for (String lbl : btnLabel) {
            RoundBtn btn = new RoundBtn();
            btn.setText(lbl);
            btn.setFont(btnFont);
            btn.setBackground(btnColor);
            btn.setForeground(fontColor);
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btnPanel.setBackground(bgColor);
            btnPanel.add(btn);
            btn.addActionListener(new FractionTester());
            btn.addMouseListener(new MouseAdapter() { //mouse hover effect
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    btn.setBackground(altbtnColor);
                    btn.setForeground(btnColor);
                }
                public void mouseExited(MouseEvent e){
                    super.mouseEntered(e);
                    btn.setBackground(btnColor);
                    btn.setForeground(fontColor);
                }
            });
        }
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        display.setFont(btnFont);
        display.setPreferredSize(txtDim);
        display.setBackground(bgColor);

        output = new JTextField();
        output.setBounds(285, 60,120, 40);
        output.setFont(btnFont);
        output.setEditable(false);
        output.setBackground(bgColor);

        bgPanel.add(display, BorderLayout.NORTH);
        bgPanel.add(output);
        bgPanel.add(btnPanel, BorderLayout.CENTER);
        add(bgPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    public class RoundBtn extends JButton {
        private int cornerRadius = 5;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FractionGUI calc = new FractionGUI();
        });
    }

}
