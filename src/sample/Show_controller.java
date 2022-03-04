package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Show_controller {
    String CName;
    String CEmail;
    String Date;
    String Hall_Number;
    String MName;
    String Num;
    String time;
    String price;

    @FXML
    TextField s1;
    @FXML
    TextField s2;
    @FXML
    TextField s3;
    @FXML
    TextField s4;
    @FXML
    TextField s5;
    @FXML
    TextField s6;
    @FXML
    TextField s7;
    @FXML
    TextField s8;
    @FXML
    Button back3;




    public void backhome2(ActionEvent e)   throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sell.fxml"));
        Stage window = (Stage) back3.getScene().getWindow();
        window.setScene(new Scene(root,980,560));
    }
    public void Shows(String CName, String CEmail, String Date, String Hall_Number, String MName, String Num, String time, String price){
        s1.setText(CName);
        s2.setText(CEmail);
        s3.setText(Date);
        s4.setText(Hall_Number);
        s5.setText(MName);
        s6.setText(Num);
        s7.setText(time);
        s8.setText(price);
    }
}
