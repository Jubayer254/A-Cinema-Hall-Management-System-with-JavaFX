package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class cusHandle implements Initializable {
    @FXML
    TextArea det;
    @FXML
    Button show;
    String details="";
    @FXML
    Button B;
    @FXML
    ScrollBar s1;
    @FXML
    ScrollBar s2;

    @FXML
    void bkhome() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Afterlogin.fxml"));
        Stage window = (Stage) B.getScene().getWindow();
        window.setScene(new Scene(root,980,560));
    }
    @FXML
    void Do() throws IOException {
        FileReader fr = new FileReader("Ticket_det.txt");
        BufferedReader br = new BufferedReader(fr);
        try {
            while (true) {
                String s = br.readLine();
                if (s == null) break;
                det.setText(s);
                details = details +s +"\n";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        br.close();
        fr.close();
        det.setText(details);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        s1.setLayoutX(det.getWidth()-s1.getWidth());
        s2.setLayoutY(det.getHeight()-s1.getHeight());
        det.setStyle("-fx-control-inner-background: #420075; -fx-font-family: 'Times New Roman'; -fx-font-size: 17");
    }
}
