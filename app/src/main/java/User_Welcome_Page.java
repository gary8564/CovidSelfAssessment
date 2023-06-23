import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import java.net.*;

public class User_Welcome_Page implements ActionListener {

    String Userid;
    JFrame frame=new JFrame();
    InputStream stream = getClass().getClassLoader().getResourceAsStream("welcome_home_page.png");
    JLabel background = new JLabel(new ImageIcon(ImageIO.read(stream)));

    List<Symptom> symptom = new ArrayList<Symptom>();
    String filePath = "src\\main\\java\\CSV\\DataHealthColect.csv";
    Symptom[] sympt = new Symptom[500];
    private int i=0;
    String line="";

    JButton Submit=new JButton("Submit");
    JLabel Fever=new JLabel("Fever*");
    ButtonGroup group1=new ButtonGroup();
    ButtonGroup group2=new ButtonGroup();
    ButtonGroup group3=new ButtonGroup();
    ButtonGroup group4=new ButtonGroup();
    ButtonGroup group5=new ButtonGroup();
    ButtonGroup group6=new ButtonGroup();
    ButtonGroup group7=new ButtonGroup();

    JRadioButton With_fever=new JRadioButton("Yes");
    JRadioButton No_fever=new JRadioButton("No");


    JLabel Cold=new JLabel("Cold*");
    JRadioButton With_Cold=new JRadioButton("Yes");
    JRadioButton No_Cold=new JRadioButton("No");


    JLabel Cough=new JLabel("Cough* ");
    JRadioButton With_Cough=new JRadioButton("Yes");
    JRadioButton No_Cough=new JRadioButton("No");


    JLabel Headache=new JLabel("Headache*");
    JRadioButton With_Headache=new JRadioButton("Yes");
    JRadioButton No_Headache=new JRadioButton("No");

    JLabel Body_aches=new JLabel("Body aches*");
    JRadioButton With_Body_aches=new JRadioButton("Yes");
    JRadioButton No_Body_aches=new JRadioButton("No");

    JLabel Breathing_Trouble=new JLabel("Breathing Trouble*");
    JRadioButton With_Breathing_Trouble=new JRadioButton("Yes");
    JRadioButton No_Breathing_Trouble=new JRadioButton("No");

    JLabel Vomiting=new JLabel("Vomiting*");
    JRadioButton With_Vomiting=new JRadioButton("Yes");
    JRadioButton No_Vomiting=new JRadioButton("No");
    User_Welcome_Page(String UserId) throws IOException {
        Toolkit tk=Toolkit.getDefaultToolkit();
        int Width= (int) tk.getScreenSize().getWidth();
        int Height=(int) tk.getScreenSize().getHeight();
        Fever.setBounds(450,50,150,40);
        Fever.setFont(new Font(null,Font.ITALIC,18));
        With_fever.setBounds(450,90,80,40);
        No_fever.setBounds(570,90,80,40);
        Cough.setBounds(450,130,150,40);
        Cough.setFont(new Font(null,Font.ITALIC,18));
        With_Cough.setBounds(450,160,80,40);
        No_Cough.setBounds(570,160,80,40);
        Cold.setBounds(450,210,150,40);
        Cold.setFont(new Font(null,Font.ITALIC,18));
        With_Cold.setBounds(450,240,80,40);
        No_Cold.setBounds(570,240,80,40);
        Headache.setBounds(450,290,150,40);
        Headache.setFont(new Font(null,Font.ITALIC,18));
        With_Headache.setBounds(450,320,80,40);
        No_Headache.setBounds(570,320,80,40);
        Body_aches.setBounds(450,370,150,40);
        Body_aches.setFont(new Font(null,Font.ITALIC,18));
        With_Body_aches.setBounds(450,410,80,40);
        No_Body_aches.setBounds(570,410,80,40);
        Breathing_Trouble.setBounds(450,450,350,40);
        Breathing_Trouble.setFont(new Font(null,Font.ITALIC,18));
        With_Breathing_Trouble.setBounds(450,490,80,40);
        No_Breathing_Trouble.setBounds(570,490,80,40);
        Vomiting.setBounds(450,530,350,40);
        Vomiting.setFont(new Font(null,Font.ITALIC,18));
        With_Vomiting.setBounds(450,560,80,40);
        No_Vomiting.setBounds(570,560,80,40);
        Submit.setBounds(450,610,240,40);
        Submit.setFocusable(false);
        Submit.setBackground(Color.gray);
        Submit.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        Submit.addActionListener(this);
        this.Userid = UserId;

        frame.setLayout(new BorderLayout());
        frame.add(background);
        background.add(Submit);
        background.add(Fever);
        background.add(With_fever);
        background.add(No_fever);
        group1.add(With_fever);
        group1.add(No_fever);
        background.add(Cough);
        background.add(With_Cough);
        background.add(No_Cough);
        group2.add(With_Cough);
        group2.add(No_Cough);
        background.add(Cold);
        background.add(With_Cold);
        background.add(No_Cold);
        group3.add(With_Cold);
        group3.add(No_Cold);
        background.add(Headache);
        background.add(With_Headache);
        background.add(No_Headache);
        group4.add(With_Headache);
        group4.add(No_Headache);
        background.add(Body_aches);
        background.add(With_Body_aches);
        background.add(No_Body_aches);
        group5.add(With_Body_aches);
        group5.add(No_Body_aches);
        background.add(Breathing_Trouble);
        background.add(With_Breathing_Trouble);
        background.add(No_Breathing_Trouble);
        group6.add(With_Breathing_Trouble);
        group6.add(No_Breathing_Trouble);
        background.add(Vomiting);
        background.add(With_Vomiting);
        background.add(No_Vomiting);
        group7.add(With_Vomiting);
        group7.add(No_Vomiting);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Width,Height);
        frame.pack();
        frame.setLayout(null);
        frame.setVisible(true);

        try{
            BufferedReader br=new BufferedReader(new FileReader(filePath));
            while ((line= br.readLine())!=null){
                sympt[i]=new Symptom();
                String[] row=line.split("\n");
                for(int j=0;j< row.length;j++){
                    String[] col=row[j].split(",");
                    sympt[i].setName(col[0]);
                    sympt[i].setFever(Boolean.valueOf(col[1]));
                    sympt[i].setCough(Boolean.valueOf(col[2]));
                    sympt[i].setCold(Boolean.valueOf(col[3]));
                    sympt[i].setHeadache(Boolean.valueOf(col[4]));
                    sympt[i].setBody_aches(Boolean.valueOf(col[5]));
                    sympt[i].setBreathing_Trouble(Boolean.valueOf(col[6]));
                    sympt[i].setVomiting(Boolean.valueOf(col[7]));
                    symptom.add(sympt[i]);

                }i++;
            }
        } catch(IOException e){
            e.printStackTrace();
        }

    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Submit) {
            i++;
            sympt[i]=new Symptom();
            sympt[i].setName(Userid);
            sympt[i].setFever(With_fever.isSelected());
            sympt[i].setCold(With_Cold.isSelected());
            sympt[i].setCough(With_Cough.isSelected());
            sympt[i].setHeadache(With_Headache.isSelected());
            sympt[i].setBody_aches(With_Body_aches.isSelected());
            sympt[i].setBreathing_Trouble(With_Breathing_Trouble.isSelected());
            sympt[i].setVomiting(With_Vomiting.isSelected());

            
            symptom.add(sympt[i]);

            frame.dispose();



        }

        FileWriter fileWriter = null ;
            try {
                fileWriter = new FileWriter (filePath);
                for ( Symptom s : symptom ) {
                    fileWriter . append (s.getName());
                    fileWriter . append ( "," );
                    fileWriter . append (String.valueOf(s.getFever()));
                    fileWriter . append ( "," );
                    fileWriter .append (String.valueOf(s.getCough()));
                    fileWriter .append(",");
                    fileWriter .append (String.valueOf(s.getCold()));
                    fileWriter .append(",");
                    fileWriter . append (String.valueOf(s.getHeadache()));
                    fileWriter . append ( "," );
                    fileWriter . append (String.valueOf(s.getBody_aches()));
                    fileWriter . append ( "," );
                    fileWriter .append (String.valueOf(s.getBreathing_Trouble()));
                    fileWriter .append (",");
                    fileWriter .append (String.valueOf(s.getVomiting()));
                    fileWriter . append ( "\n" ); } 
            } catch ( Exception ex ) {
            	ex.printStackTrace (); 
            } finally { 
            	try {
            		assert fileWriter != null;
            		fileWriter.flush ();
            		fileWriter.close (); 
                } catch ( Exception a ) {
                	a.printStackTrace (); 
                } 
            }
            
            Advice advice= new Advice(With_fever.isSelected(),With_Cold.isSelected(),
        			With_Cough.isSelected(),With_Headache.isSelected(),With_Body_aches.isSelected(),
        			With_Breathing_Trouble.isSelected(),With_Vomiting.isSelected());
            		
                

    }



}