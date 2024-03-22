package prog2.midgroup01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FracGUI extends JFrame {
    private JPanel btnBox = new JPanel(new GridLayout(5, 1, 5, 5));
    private JPanel fieldBox = new JPanel(new GridBagLayout());
    private JButton addBtn = new JButton("+");
    private JButton subBtn = new JButton("-");
    private JButton mulBtn = new JButton("*");
    private JButton divBtn = new JButton("÷");
    private JButton clearBtn = new JButton("Clear");
    private JTextField frac1 = new JTextField(15);
    private JTextField frac2 = new JTextField(15);
    private JTextField displayDbl = new JTextField(15);
    private JTextField displayRes = new JTextField(15);
    private JLabel textA = new JLabel("Enter two Fractions:");
    private JLabel textFrac = new JLabel("Fraction 1: ");
    private JLabel textFracB = new JLabel("Fraction 2: ");
    private JLabel textRes = new JLabel("Result: ");
    private JLabel textDbl = new JLabel("Decimal: ");
    private Color bgColor = new Color(250, 230, 230);
    private Color btnColor = new Color(250, 170, 170);
    private Color fontColor = new Color(140, 70, 80);
    private Color altbtnColor = new Color(200, 160, 160);
    private Font fieldFont = new Font("Arial", Font.PLAIN,15);
    private Dimension fDim = new Dimension(800, 450);

    public FracGUI() {
        // Main
        setTitle("Fraction Calculator");
        setSize(fDim);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(bgColor);
        setLayout(new GridBagLayout());

        // Create main content
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(bgColor);
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        gbcMain.anchor = GridBagConstraints.NORTH;
        gbcMain.weightx = 1;
        gbcMain.fill = GridBagConstraints.HORIZONTAL;
        gbcMain.insets = new Insets(10, 10, 10, 10);

        GridBagConstraints gbc = new GridBagConstraints();

        // Buttons Panel
        btnBox.setBackground(bgColor);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10,10,10,10);
        add(btnBox, gbc);

        addBtn.setPreferredSize(new Dimension(50, 30)); // Set button size
        addBtn.setBackground(btnColor);
        addBtn.setForeground(fontColor);
        addBtn.addActionListener(new FractionTester());
        addBtn.setFocusPainted(false);
        addBtn.addMouseListener(new MouseAdapter() { //mouse hover effect
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                addBtn.setBackground(altbtnColor);
                addBtn.setForeground(btnColor);
            }
            public void mouseExited(MouseEvent e){
                super.mouseEntered(e);
                addBtn.setBackground(btnColor);
                addBtn.setForeground(fontColor);
            }
        });
        btnBox.add(addBtn);

        mulBtn.setPreferredSize(new Dimension(50, 30)); // Set button size
        mulBtn.setBackground(btnColor);
        mulBtn.setForeground(fontColor);
        mulBtn.addActionListener(new FractionTester());
        mulBtn.setFocusPainted(false);
        mulBtn.addMouseListener(new MouseAdapter() { //mouse hover effect
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                mulBtn.setBackground(altbtnColor);
                mulBtn.setForeground(btnColor);
            }
            public void mouseExited(MouseEvent e){
                super.mouseEntered(e);
                mulBtn.setBackground(btnColor);
                mulBtn.setForeground(fontColor);
            }
        });
        btnBox.add(mulBtn);

        subBtn.setPreferredSize(new Dimension(50, 30)); // Set button size
        subBtn.setBackground(btnColor);
        subBtn.setForeground(fontColor);
        subBtn.addActionListener(new FractionTester());
        subBtn.setFocusPainted(false);
        subBtn.addMouseListener(new MouseAdapter() { //mouse hover effect
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                subBtn.setBackground(altbtnColor);
                subBtn.setForeground(btnColor);
            }
            public void mouseExited(MouseEvent e){
                super.mouseEntered(e);
                subBtn.setBackground(btnColor);
                subBtn.setForeground(fontColor);
            }
        });
        btnBox.add(subBtn);

        divBtn.setPreferredSize(new Dimension(50, 30)); // Set button size
        divBtn.setBackground(btnColor);
        divBtn.setForeground(fontColor);
        divBtn.addActionListener(new FractionTester());
        divBtn.setFocusPainted(false);
        divBtn.addMouseListener(new MouseAdapter() { //mouse hover effect
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                divBtn.setBackground(altbtnColor);
                divBtn.setForeground(btnColor);
            }
            public void mouseExited(MouseEvent e){
                super.mouseEntered(e);
                divBtn.setBackground(btnColor);
                divBtn.setForeground(fontColor);
            }
        });
        btnBox.add(divBtn);

        clearBtn.setPreferredSize(new Dimension(50, 30)); // Set button size
        clearBtn.setBackground(btnColor);
        clearBtn.setForeground(fontColor);
        clearBtn.addActionListener(new FractionTester());
        clearBtn.setFocusPainted(false);
        clearBtn.addMouseListener(new MouseAdapter() { //mouse hover effect
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                clearBtn.setBackground(altbtnColor);
                clearBtn.setForeground(btnColor);
            }
            public void mouseExited(MouseEvent e){
                super.mouseEntered(e);
                clearBtn.setBackground(btnColor);
                clearBtn.setForeground(fontColor);
            }
        });
        btnBox.add(clearBtn);

        helpBtn.setPreferredSize(new Dimension(50, 30)); // Set button size
        helpBtn.setBackground(btnColor);
        helpBtn.setForeground(fontColor);
        helpBtn.addActionListener(new FractionTester());
        helpBtn.setFocusPainted(false);
        helpBtn.addMouseListener(new MouseAdapter() { //mouse hover effect
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                helpBtn.setBackground(altbtnColor);
                helpBtn.setForeground(btnColor);
            }
            public void mouseExited(MouseEvent e){
                super.mouseEntered(e);
                helpBtn.setBackground(btnColor);
                helpBtn.setForeground(fontColor);
            }
        });
        btnBox.add(helpBtn);

        // Fields Panel
        fieldBox.setBackground(bgColor);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(fieldBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        fieldBox.add(textFrac, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        fieldBox.add(frac1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        fieldBox.add(textFracB, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        fieldBox.add(frac2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        fieldBox.add(textRes, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        fieldBox.add(displayRes, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        fieldBox.add(textDbl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        fieldBox.add(displayDbl, gbc);

        textA.setFont(fieldFont);
        textFrac.setForeground(fontColor);
        textFracB.setForeground(fontColor);
        textRes.setForeground(fontColor);
        textDbl.setForeground(fontColor);


        frac1.setFont(fieldFont);
        textFrac.setFont(fieldFont);
        textFrac.setForeground(fontColor);


        frac2.setFont(fieldFont);
        textFracB.setFont(fieldFont);
        textFracB.setForeground(fontColor);

        displayRes.setFont(fieldFont);
        textRes.setFont(fieldFont);
        displayRes.setEditable(false);
        displayDbl.setForeground(fontColor);

        displayDbl.setFont(fieldFont);
        textDbl.setFont(fieldFont);
        displayDbl.setEditable(false);
        displayDbl.setForeground(fontColor);

        setVisible(true);
    }

    //Accessors and Mutators
    public JTextField getFraction1(){
        return frac1;
    }

    public JTextField getFraction2(){
        return frac2;
    }

    public JTextField getDisplayRes(){
        return displayRes;
    }

    public JTextField getDisplayDbl(){
        return displayDbl;
    }

}
