package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.Date;

public class movie_controller {
    @FXML
    Button back2;
    @FXML
    Button Submit;
    @FXML
    TextField m_name;
    @FXML
    MenuButton rat;
    @FXML
    MenuButton category;
    @FXML
    DatePicker rel;
    @FXML
    TextField r_time;
    @FXML
    TextArea dis;
    @FXML
    MenuItem one;
    @FXML
    MenuItem two;
    @FXML
    MenuItem three;
    @FXML
    MenuItem four;
    @FXML
    MenuItem five;
    @FXML
    MenuItem six;
    @FXML
    MenuItem seven;
    @FXML
    MenuItem eight;
    @FXML
    MenuItem nine;
    @FXML
    MenuItem ten;
    @FXML
    MenuItem action;
    @FXML
    MenuItem adv;
    @FXML
    MenuItem rom;
    @FXML
    MenuItem sifi;
    @FXML
    MenuItem hor;
    @FXML
    MenuItem bio;
    @FXML
    TextField wrong;


    String rating;
    String cat;

    @FXML
    public void one(){
        rating = "1.0";
        rat.setText("1.0");
    }
    public void two(){
        rating = "2.0";
        rat.setText("2.0");
    }
    public void three(){
        rating = "3.0";
        rat.setText("3.0");
    }
    public void four(){
        rating = "4.0";
        rat.setText("4.0");
    }
    public void five(){
        rating = "5.0";
        rat.setText("5.0");
    }
    public void six(){
        rating = "6.0";
        rat.setText("6.0");
    }
    public void seven(){
        rating = "7.0";
        rat.setText("7.0");
    }
    public void eight(){
        rating = "8.0";
        rat.setText("8.0");
    }
    public void nine(){
        rating = "9.0";
        rat.setText("9.0");
    }
    public void ten(){
        rating = "10.0";
        rat.setText("10.0");
    }

    public void A(){
        cat = "Action";
        category.setText("Action");
    }
    public void Ad(){
        cat = "Adventure";
        category.setText("Adventure");
    }
    public void R(){
        cat = "Romantic";
        category.setText("Romantic");
    }
    public void S(){
        cat = "Si-Fi";
        category.setText("Si-Fi");
    }
    public void H(){
        cat = "Horror";
        category.setText("Horror");
    }
    public void Bio(){
        cat = "Biography";
        category.setText("Biography");
    }

    public void backhome(ActionEvent e)   throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Afterlogin.fxml"));
        Stage window = (Stage) back2.getScene().getWindow();
        window.setScene(new Scene(root,980,560));
    }
    public void addM(){
        String a = m_name.getText();
        String b = rating;
        String c = cat;
        LocalDate d = rel.getValue();
        String e = r_time.getText();
        String f = dis.getText();
        String i = "";

        if (a.equals(i) || b.equals("Select Rating") || c.equals("Select Category") || e.equals(i) || f.equals(i)) {
            wrong.setText("Please Enter all the Information");
        }
        else {
            wrong.setText("Movie Added Successfully");
            //File
            try {
                File MovInformation = new File("MovieInformation.txt");
                BufferedWriter buf = new BufferedWriter(new FileWriter(MovInformation, true));
                File read = new File("MovieInformation.txt");
                buf.write(a + "  ");
                buf.write(b + "  ");
                buf.write(c + "  ");
                buf.write(d + "  ");
                buf.write(e + "  ");
                buf.write(f + "  ");
                buf.newLine();
                buf.close();

                File Mov=new File("MovShow.txt");
                BufferedWriter buf2 = new BufferedWriter(new FileWriter(Mov,true));
                buf2.write("Movie Title: "+a);
                buf2.newLine();
                buf2.write("IMDB Rating: "+b);
                buf2.newLine();
                buf2.write("Category: "+c);
                buf2.newLine();
                buf2.write("Release Date: "+d);
                buf2.newLine();
                buf2.write("Runtime: "+e);
                buf2.newLine();
                buf2.write("Description: "+f);
                buf2.newLine();
                buf2.write("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                buf2.newLine();
                buf2.newLine();
                buf2.close();

                File Mov2=new File("Only_MOV.txt");
                BufferedWriter buf3 = new BufferedWriter(new FileWriter(Mov2,true));
                buf3.write(a);
                buf3.newLine();
                buf3.close();
            } catch (Exception ex) {
                wrong.setText("Please Enter all the Information");
            }
        }
    }
}
