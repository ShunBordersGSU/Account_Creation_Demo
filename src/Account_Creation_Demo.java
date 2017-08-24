import java.awt.EventQueue;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Account_Creation_Demo {

    private JFrame frame;
    private JPanel AccountCreation;
    private JPanel AccountCreated;
    private JTextField email;
    private JPasswordField pass1;
    private JPasswordField pass2;
    private Pattern pattern;
    private Matcher matcher;
    private JLabel invalidEP;
    private JLabel invalidP;
    private JLabel invalidU;
    private JLabel lblAccountCreated;
    private JButton btnExit;
    private JLabel lblPasswordsMustHave;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Account_Creation_Demo window = new Account_Creation_Demo();
                    window.frame.setVisible(true);
                    window.frame.setResizable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Account_Creation_Demo() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(SystemColor.textHighlight);
        frame.getContentPane().setLayout(null);

        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBounds(0, 0, 450, 277);
        panel_2_1.setBackground(SystemColor.textHighlight);
        frame.getContentPane().add(panel_2_1);
        panel_2_1.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(47, 79, 79));
        panel_1.setBounds(0, 0, 450, 278);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblCreateNewAccount = new JLabel("Create New Account");
        lblCreateNewAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCreateNewAccount.setBounds(116, 18, 171, 16);
        panel_2_1.add(lblCreateNewAccount);

        JLabel lblEnterUsername = new JLabel("Enter Email");
        lblEnterUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnterUsername.setBounds(122, 53, 159, 16);
        panel_2_1.add(lblEnterUsername);

        email = new JTextField();
        email.setBounds(136, 81, 130, 26);
        panel_2_1.add(email);
        email.setColumns(10);

        JLabel lblEnterPassword = new JLabel("Enter Password");
        lblEnterPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnterPassword.setBounds(130, 125, 143, 16);
        panel_2_1.add(lblEnterPassword);

        JLabel lblConfirmPassword = new JLabel("Confirm Password");
        lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblConfirmPassword.setBounds(127, 191, 148, 16);
        panel_2_1.add(lblConfirmPassword);

        pass1 = new JPasswordField();
        pass1.setBounds(136, 153, 130, 26);
        panel_2_1.add(pass1);
        pass1.setColumns(10);

        pass2 = new JPasswordField();
        pass2.setBounds(136, 219, 130, 26);
        panel_2_1.add(pass2);
        pass2.setColumns(10);

        JButton btnCreate = new JButton("Create");
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                invalidU.setVisible(false);
                invalidP.setVisible(false);
                invalidEP.setVisible(false);
                boolean validEmail= verifyEmail();
                boolean validPass= verifyPass();
                if (validEmail==false && validPass==false){
                    invalidEP.setVisible(true);
                }
                else if (validEmail==false){
                    invalidU.setVisible(true);
                }
                else if (validPass==false){
                    invalidP.setVisible(true);
                }
                else{
                    panel_1.setVisible(true);
                    panel_2_1.setVisible(false);
                }
            }
        });
        btnCreate.setBounds(305, 219, 117, 29);
        panel_2_1.add(btnCreate);

        invalidEP = new JLabel("Invalid Email and Password");
        invalidEP.setHorizontalAlignment(SwingConstants.CENTER);
        invalidEP.setBounds(99, 257, 204, 16);
        panel_2_1.add(invalidEP);
        invalidEP.setVisible(false);

        invalidP = new JLabel("Invalid Password or Passwords do not Match");
        invalidP.setHorizontalAlignment(SwingConstants.CENTER);
        invalidP.setBounds(53, 242, 297, 16);
        panel_2_1.add(invalidP);
        invalidP.setVisible(false);

        invalidU = new JLabel("Invalid Email");
        invalidU.setHorizontalAlignment(SwingConstants.CENTER);
        invalidU.setBounds(6, 86, 130, 16);
        panel_2_1.add(invalidU);

        lblPasswordsMustHave = new JLabel("Passwords must have a number, both lower and upercase letters, a special character, and length of 6 characters");
        lblPasswordsMustHave.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
        lblPasswordsMustHave.setBounds(6, 92, 438, 49);
        panel_2_1.add(lblPasswordsMustHave);
        invalidU.setVisible(false);

        lblAccountCreated = new JLabel("Account Created!");
        lblAccountCreated.setHorizontalAlignment(SwingConstants.CENTER);
        lblAccountCreated.setBounds(62, 130, 326, 16);
        panel_1.add(lblAccountCreated);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBounds(155, 197, 117, 29);
        panel_1.add(btnExit);
        panel_1.setVisible(false);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public boolean verifyEmail(){
        final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        pattern = Pattern.compile(EMAIL_PATTERN);

        String emailCheck=email.getText();

        matcher = pattern.matcher(emailCheck);

        return matcher.matches();
    }

    public boolean verifyPass(){
        if (!(Arrays.equals(pass1.getPassword(), pass2.getPassword())))
            return false;

        if(pass1.getPassword().length < 6)
            return false;

        String regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}";
        String password = pass1.getPassword().toString();

        if (password.matches(regexp))
            return true;

        return false;
    }
}
