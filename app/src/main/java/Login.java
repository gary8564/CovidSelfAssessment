import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.net.*;

public class Login implements ActionListener {
    HashMap<String,String> logininfo=new HashMap<>();
    JFrame frame=new JFrame();
    InputStream stream = getClass().getClassLoader().getResourceAsStream("Login_page_Image.png");
    JLabel background = new JLabel(new ImageIcon(ImageIO.read(stream)));
    JLabel Company_Name=new JLabel("Corona -- Info Thuringia");
    JButton logbutton1=new JButton("Log out");
    JButton logbutton=new JButton("Log in");
    JButton SignUp=new JButton("Sign up");
    JTextField Id=new JTextField();
    JPasswordField password=new JPasswordField();
    JLabel userIdLabel=new JLabel("Login :");
    JLabel userPassword=new JLabel("Password :");
    JLabel Message=new JLabel("Log in to veiw your details  ");

    Login() throws IOException {
        Toolkit tk=Toolkit.getDefaultToolkit();
        int Width= (int) tk.getScreenSize().getWidth();
        int Height=(int) tk.getScreenSize().getHeight();
        Company_Name.setBounds(300,90,500,60);
        Company_Name.setFont(new Font(null,Font.CENTER_BASELINE,35));
        userIdLabel.setBounds(325,250,150,40);
        userIdLabel.setFont(new Font(null,Font.BOLD,25));
        userPassword.setBounds(325,350,150,40);
        userPassword.setFont(new Font(null,Font.BOLD,25));
        Message.setBounds(400,520,450,35);
        Message.setFont(new Font(null,Font.TYPE1_FONT,15));
        Id.setBounds(325,300,400,45);
        password.setBounds(325,400,400,45);
        logbutton1.setBounds(900,40,140,40);
        logbutton1.setFocusable(false);
        logbutton1.setBackground(Color.gray);
        logbutton1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        logbutton1.addActionListener(this);
        logbutton.setBounds(400,480,200,28);
        logbutton.setFocusable(false);
        logbutton.setBackground(Color.gray);
        logbutton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        logbutton.addActionListener(this);
        SignUp.setBounds(750,40,140,40);
        SignUp.setFocusable(false);
        SignUp.setBackground(Color.gray);
        SignUp.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        SignUp.addActionListener(this);
        frame.setLayout(new BorderLayout());
        frame.add(background);
        background.setLayout(null);
        background.setVisible(true);
        background.add(logbutton1);
        background.add(logbutton);
        background.add(SignUp);
        background.add(Company_Name);
        background.add(Id);
        background.add(password);
        background.add(Message);
        background.add(userIdLabel);
        background.add(userPassword);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Width,Height);
        frame.setForeground(Color.darkGray);
        frame.pack();
        frame.setVisible(true);
        }
    

    @Override
    public void actionPerformed(ActionEvent e) {

        String line="";
        String path="src\\main\\java\\CSV\\DataColect.csv";
        try {
            BufferedReader br = new BufferedReader(new FileReader( path));
            while((line=br.readLine())!=null){
                String[] values=line.split(",");
                logininfo.put(values[4],values[5]);
            }
            if (e.getSource()==SignUp){
          	  SignIn SignIn = new SignIn();
            }
            if(e.getSource()==logbutton) {
                String UserId=Id.getText();
                String UserPass=String.valueOf(password.getPassword());
                if(logininfo.containsKey(UserId)){
                    if(logininfo.get(UserId).equals(UserPass)){
                         User_Welcome_Page User_Welcome_Page=new User_Welcome_Page(UserId);

                    }else {
                        Message.setText("Login Failed");
                    }
                }else {
                    Message.setForeground(Color.red);
                    Message.setText("Please check your User Id or Password");
                }
            }
            if (e.getSource()==logbutton1) {
            	frame.dispose();
            }
        } catch(IOException a){
            a.printStackTrace();
        }
    }
}
