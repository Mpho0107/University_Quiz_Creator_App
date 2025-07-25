import javax.swing.*;

public class UserInput implements inputValidation  
{
    private int passwordTry = 0;
    private int count = 0;
    private int pCount;
    private boolean matchUser = false;
    
    @Override
    public int inputValidate(String userIDInput,String[] arrUserID,String userPasswordInput,String[] arrPassword)
    {
        try{
        //must find the matchings persons details and confirm password
            do
            {
            //System.out.println("Comparing: "+ userIDInput +" And "+ arrUserID[count]);
              if(userIDInput.equals(arrUserID[count])) //if the user input matchs the userID of array 
             {
              pCount = count;  //then return the number(index) of an arry position 
              matchUser = true;
              validatePassword(pCount,userPasswordInput,arrPassword);
             }
            else
            {
              matchUser = false;
            }
            
            count++;
            
            }while( matchUser == false && count <arrUserID.length);
        }catch(Exception er){JOptionPane.showMessageDialog(null,"UserID does not exist");}
        
        
        return pCount;
        }
    
    private boolean validatePassword(int Position,String userPassword,String[] arrPassword)
    {
        boolean correct;
        
        if(userPassword.equals(arrPassword[Position]))
        {
            correct = true;
            JOptionPane.showMessageDialog(null,"Correct Password");
        }
        else
        {
            correct = false;
            JOptionPane.showMessageDialog(null,"Incorrect Password");
        }
        
        return correct;
    }
    
    @Override
    public boolean forgotPassword(String[] name, int Position,String answer)
    {
        String safeWord = "apples";
        boolean correct;
        
        System.out.println(name[Position] +" What's the groups' safe word?");
        
        if(safeWord.toLowerCase().equals(answer.toLowerCase()))
        {
            correct = true;
            JOptionPane.showMessageDialog(null,"Correct Password");
        }
        else
        {
            correct = false;
        }
        return correct;
    }
    
}
