package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class signup_input {
    @FXML
    Button back;
    @FXML
    TextField name;
    @FXML
    TextField email;
    @FXML
    PasswordField pass;
    @FXML
    TextField age;
    @FXML
    MenuButton gender;
    @FXML
    TextField pnum;
    @FXML
    TextField wrong;
    @FXML
    Button go;
    @FXML
    MenuItem Male;
    @FXML
    MenuItem Female;
    @FXML
    MenuItem Others;
    String e;

    @FXML
    public void home(ActionEvent e)   throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root,980,560));
    }
    @FXML
    public void male(){
        e = "Male";
        gender.setText("Male");
    }
    @FXML
    public void female(){
        e = "Female";
        gender.setText("Female");
    }
    @FXML
    public void others(){
        e = "Others";
        gender.setText("Others");
    }

    @FXML
    public void signup(){
        String a=name.getText();
        String b=email.getText();
        String c=pass.getText();
        String d=age.getText();
        String f=pnum.getText();
        String g="";
        if(a.equals(g)||b.equals(g)||c.equals(g)||d.equals(g)||e.equals("Select Gender")||f.equals(g)){
            wrong.setText("Please Enter all the Informations");
        }
        else{
            wrong.setText("Account Created Successfully");
            File userInformation=new File("userInformation.txt");
            File username=new File("Username.txt");
            File password=new File("Password.txt");
            try {
                BufferedWriter buf = new BufferedWriter(new FileWriter(userInformation,true));
                buf.write("Name: "+a);
                buf.newLine();
                buf.write("Password: "+c);
                buf.newLine();
                buf.write("Email: "+b);
                buf.newLine();
                buf.write("Age: "+d);
                buf.newLine();
                buf.write("Gender: "+e);
                buf.newLine();
                buf.write("Phone Number: "+f);
                buf.newLine();
                buf.newLine();
                buf.newLine();
                buf.write("----------------------------------------------------------");
                buf.newLine();
                buf.newLine();
                buf.newLine();
                buf.close();
                BufferedWriter buf2 = new BufferedWriter(new FileWriter(username,true));
                buf2.write(a);
                buf2.newLine();
                buf2.close();
                BufferedWriter buf3 = new BufferedWriter(new FileWriter(password,true));
                buf3.write(c);
                buf3.newLine();
                buf3.close();
            } catch (Exception ex) {
                wrong.setText("Please Enter all the Informations");
            }
        }
    }
}
