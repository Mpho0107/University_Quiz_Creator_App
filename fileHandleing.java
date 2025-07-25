import java.io.*;
import java.util.*;

public class fileHandleing
{
    private int count = 0;
    private int GPCOUNT = 15; //Group members count
    public String data;
    public String[] userID = new String[GPCOUNT];
    public String[] password = new String[GPCOUNT];
    public String[] name = new String[GPCOUNT];
    
    public void ReadFile()
    {
        //Reads the file contects of Authorized Persons and assigns it to the arrays. 
        
        try
        {
            File Rfile = new File("Authorized Persons.txt");
            Scanner sc = new Scanner(Rfile);
            
            while(sc.hasNext())
            {
                userID[count] = sc.next();
                password[count] = sc.next();
                name[count] = sc.nextLine();
                
                setArrayFields(userID,password,name);
                
                
                count++;
            }
            
        }catch(Exception err){}
        
    }
    
    public void setArrayFields(String[] FileUserID,String[] FilePassword,String[] Name)
    {
        this.userID = FileUserID;
        this.password = FilePassword;
        this.name = Name;
    }
    
    public String[] getArrUserID()
    {
        return userID;   
    }
    
    public String[] getArrPassword()
    {
        return password;
    }
    
    public String[] getArrName()
    {
        return name; 
    }
    
    @Override
    public String toString()
    {
        System.out.print(userID[count]);
        System.out.println(password[count]);
        System.out.println(name[count]);
        
        return "Done"; 
    }
}
