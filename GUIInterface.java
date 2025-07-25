import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUIInterface implements ActionListener
{
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();  
    JTextField textField1 = new JTextField();
    JTextField textField2 = new JTextField();
    JButton button1 = new JButton(); 
    JButton button2 = new JButton();
    
    String textField1s;
    String textField2s;
    
    public void mainFRAME()
    {
        frameProperties();
        
        panel1.setLayout(null);
        panel1.setBounds(0,0,130,150);
        
        
        panel2.setLayout(null);
        panel2.setBounds(150,0,250,150);
        
        
        panel3.setLayout(null);
        panel3.setBounds(0,150,350,100);
        
        label1.setText("Enter UserID: ");
        label1.setBounds(10,0,500,50);
        
        label2.setText("Enter Password: ");
        label2.setBounds(10,50,550,50);
        
        
        textField1.setBounds(10,10,150,20);
        textField2.setBounds(10,60,150,20);
        
        button1.setBounds(50,10,80,40);
        button1.setText("Done");
        button1.setFocusable(false);
        button1.addActionListener(this);
        
        
        button2.setBounds(150,10,80,40);
        button2.setText("Close");
        button2.addActionListener(e -> frame.dispose());
        button2.setFocusable(false);
        
        panel1.add(label1);
        panel1.add(label2);
        
        panel2.add(textField1);
        panel2.add(textField2);
        
        panel3.add(button1);
        panel3.add(button2);
        
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        
    }
    
    private void frameProperties()
    {
        frame.setTitle("CMPG 211 Security");
        frame.setSize(350,250);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private String userIDInput;
    private String userPasswordInput;
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==button1)
        {
            userIDInput = textField1.getText();
            
            userPasswordInput = textField2.getText();           
            main();
            
            //frame.dispose();
        }
    
    }
    
    UserInput user = new UserInput();
    fileHandleing Rfile = new fileHandleing();
        
    private int arrPosition;
    private String[] fileUserID = new String[15];
    private String[] fileUserPassword = new String[15];
    private String[] fileUserName = new String[15];
    public void main()
    {
        Rfile.ReadFile();
        
        fileUserID = Rfile.getArrUserID();
        fileUserPassword = Rfile.getArrPassword();
        fileUserName = Rfile.getArrName();
        
        arrPosition = user.inputValidate(userIDInput,fileUserID,userPasswordInput,fileUserPassword);
        
        
    }
    
    
    
}
