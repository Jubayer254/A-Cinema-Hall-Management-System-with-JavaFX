package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class login_controller {
    @FXML
    Button LOG;
    @FXML
    Button signup;
    @FXML
    TextField l_name;
    @FXML
    PasswordField l_pass;
    @FXML
    TextField wrong;

    @FXML
    public void sign(ActionEvent e)   throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Stage window = (Stage) signup.getScene().getWindow();
        window.setScene(new Scene(root,980,560));
    }
    @FXML
    public void login(ActionEvent e)   throws Exception{
        // TODO add your handling code here:
        File read=new File("Username.txt");
        File read1=new File("Password.txt");
        String user=l_name.getText();
        String pass=l_pass.getText();
        try {
            BufferedReader buf = new BufferedReader(new FileReader(read));
            BufferedReader buf1 = new BufferedReader(new FileReader(read1));
            String inputfile=buf.readLine();
            String inputfile1=buf1.readLine();
            int flag=0;
            while(inputfile!=null&&inputfile1!=null){
                if(user.equals(inputfile)&&pass.equals(inputfile1)){
                    flag=1;
                    Parent root = FXMLLoader.load(getClass().getResource("Afterlogin.fxml"));
                    Stage window = (Stage) LOG.getScene().getWindow();
                    window.setScene(new Scene(root,980,560));
                    break;
                }
                else{
                    inputfile=buf.readLine();
                    inputfile1=buf1.readLine();
                }
            }
            if(flag==0){
                wrong.setText("Wrong Username or Password");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    public void close(ActionEvent e)   {
        System.exit(0);
    }

}
