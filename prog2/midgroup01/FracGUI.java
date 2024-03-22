package 
  
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FractionGUI extends JFrame implements ActionListener {
    private JPanel btnBox = new JPanel();
    private JPanel fieldBox = new JPanel();
    private JButton addBtn = new JButton();
    private JButton subBtn = new JButton();
    private JButton mulBtn = new JButton();
    private JButton divBtn = new JButton();
    private JButton clearBtn = new JButton();
    private JTextField frac1 = new JTextField(20);
    private JTextField frac2 = new JTextField(20);
    private JTextField displayRes = new JTextField(20);
    private JLabel textA = new JLabel();
    private Color bgColor = new Color(250, 230, 230);
    private Color btnColor = new Color(250, 170, 170);
    private Color fontColor = new Color(140, 70, 80);
    private Color altbtnColor = new Color(200, 160, 160);
    private Dimension fDim = new Dimension(800, 450);
    //private ImageIcon logo = new ImageIcon(getClass().getResource("logo.png"));

    public FractionGUI() {
        //main
        setTitle("Fraction Calculator");
        setSize(fDim);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setIconImage(logo.getImage());
        setResizable(false);
        getContentPane().setBackground(bgColor);

        //buttons
        addBtn.setText("+");
        addBtn.setBackground(btnColor);
        addBtn.setForeground(fontColor);
        addBtn.addActionListener(this);
        mulBtn.setText("*");
        mulBtn.setBackground(btnColor);
        mulBtn.setForeground(fontColor);
        mulBtn.addActionListener(this);
        subBtn.setText("-");
        subBtn.setBackground(btnColor);
        subBtn.setForeground(fontColor);
        subBtn.addActionListener(this);
        divBtn.setText("÷");
        divBtn.setBackground(btnColor);
        divBtn.setForeground(fontColor);
        divBtn.addActionListener(this);
        clearBtn.setText("Clear");
        clearBtn.setBackground(btnColor);
        clearBtn.setForeground(fontColor);
        clearBtn.addActionListener(this);

        //g
        textA.setText("Enter two Fractions:");

        //input
        displayRes.setEditable(false);
        displayRes.setBackground(altbtnColor);
        frac1.setBackground(altbtnColor);
        frac2.setBackground(altbtnColor);


        //layout



        //a
        add(btnBox, BorderLayout.EAST);
        add(fieldBox, BorderLayout.WEST);
        add(frac1);
        add(frac2);
        add(textA);
        fieldBox.setSize(400,450);
        fieldBox.setLayout(new GridLayout(3,1));
        fieldBox.add(frac1);
        fieldBox.add(frac2);
        fieldBox.add(displayRes);
        btnBox.setSize(400,450);
        btnBox.add(addBtn);
        btnBox.add(mulBtn);
        btnBox.add(subBtn);
        btnBox.add(divBtn);
        btnBox.add(clearBtn);


    }

    public void actionPerformed(ActionEvent e) { // if possible pa case
        if (e.getSource() == addBtn) {
  // code
            displayRes.setText(res.toString());
        } else if (e.getSource() == mulBtn) {
  // code
            displayRes.setText(res.toString());
        } else if (e.getSource() == subBtn) {
  // code
            displayRes.setText(res.toString());
        } else if (e.getSource() == divBtn) {
  // code
            displayRes.setText(res.toString());
        } else if (e.getSource() == clearBtn) {
            frac1.setText("");
            frac2.setText("");
            displayRes.setText("");
        }
    }
  

 // add parse ,, for // etc + numberformatexception

    public static void main(String[] args) {
        FractionGUI calculator = new FractionGUI();
        calculator.setVisible(true);
    }
}
