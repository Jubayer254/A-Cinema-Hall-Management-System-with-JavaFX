package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

class info {
    String MName;
    String ret;
    String cat;
    String Rdate;
    String Rtime;
    String det;

    public info(String a, String b, String c, String d, String e, String f) {
        MName = a;
        ret = b;
        cat = c;
        Rdate = d;
        Rtime = e;
        det = f;
    }
}

public class del_controller{
    @FXML
    public TextField mov;
    @FXML
    Button delete;
    @FXML
    Button back2;
    @FXML
    public TextField wrong;
    public void backhome(ActionEvent e)   throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Afterlogin.fxml"));
        Stage window = (Stage) back2.getScene().getWindow();
        window.setScene(new Scene(root, 980, 560));
    }
    @FXML
    public void del(){
        ArrayList<info> arr = new ArrayList<>();
        File Mov2=new File("MovShow.txt");
        File Mov3=new File("Only_MOV.txt");
        File read = new File("MovieInformation.txt");
        File MovInformation = new File("MovieInformation.txt");
        int i = 0;
        try {
            BufferedReader buf = new BufferedReader(new FileReader(read));
            String Line = buf.readLine();
            boolean flag = false;
            String MovName = mov.getText();
            while (Line != null) {
                String[] parts = Line.split("  ");
                String MovieName = parts[0];
                String rating = parts[1];
                String category = parts[2];
                String release = parts[3];
                String runTime = parts[4];
                String details = parts[5];
                info a = new info(MovieName, rating, category, release, runTime, details);
                arr.add(a);
                Line = buf.readLine();
            }
            buf.close();
            for(int k=0;k<arr.size();k++){
                String Name2 = arr.get(k).MName;
                if (MovName.equals(Name2)) {
                    flag = true;
                    arr.remove(k);
                    wrong.setText("Movie removed successfully");
                    break;
                }
            }
            if (flag == false) {
                wrong.setText("Movie did not found");
            }
            BufferedWriter buf1 = new BufferedWriter(new FileWriter(MovInformation));
            BufferedWriter buf2 = new BufferedWriter(new FileWriter(Mov2));
            BufferedWriter buf3 = new BufferedWriter(new FileWriter(Mov3));
            for(int k=0;k<arr.size();k++){
                buf1.write(arr.get(k).MName + "  ");
                buf1.write(arr.get(k).ret + "  ");
                buf1.write(arr.get(k).cat + "  ");
                buf1.write(arr.get(k).Rdate + "  ");
                buf1.write(arr.get(k).Rtime + "  ");
                buf1.write(arr.get(k).det + "  ");
                buf1.newLine();

                buf2.write("Movie Title: "+arr.get(k).MName);
                buf2.newLine();
                buf2.write("IMDB Rating: "+arr.get(k).ret);
                buf2.newLine();
                buf2.write("Category: "+arr.get(k).cat);
                buf2.newLine();
                buf2.write("Release Date: "+arr.get(k).Rtime + "  ");
                buf2.newLine();
                buf2.write("Runtime: "+arr.get(k).Rtime + "  ");
                buf2.newLine();
                buf2.write("Description: "+arr.get(k).det + "  ");
                buf2.newLine();
                buf2.write("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                buf2.newLine();
                buf2.newLine();

                buf3.write(arr.get(k).MName);
                buf3.newLine();
            }
            buf1.close();
            buf2.close();
            buf3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
