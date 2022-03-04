package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    Button add;
    @FXML
    Button rem;
    @FXML
    Button logout;
    @FXML
    Button sell;
    @FXML
    Button his;
    @FXML
    Button cus;


    @FXML
    public void addmov(ActionEvent e)   throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("addmovie.fxml"));
        Stage window = (Stage) add.getScene().getWindow();
        window.setScene(new Scene(root,980,560));
    }
    public void remove(ActionEvent e)   throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("remove.fxml"));
        Stage window = (Stage) rem.getScene().getWindow();
        window.setScene(new Scene(root,980,560));
    }
    public void out(ActionEvent e)   throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage) logout.getScene().getWindow();
        window.setScene(new Scene(root,980,560));
    }
    public void sellt(ActionEvent e)   throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sell.fxml"));
        Stage window = (Stage) sell.getScene().getWindow();
        window.setScene(new Scene(root,980,560));
    }
    public void history(ActionEvent e)   throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MovInfo.fxml"));
        Stage window = (Stage) his.getScene().getWindow();
        window.setScene(new Scene(root, 980, 560));
    }
    public void Cushistory(ActionEvent e)   throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Customer.fxml"));
        Stage window = (Stage) cus.getScene().getWindow();
        window.setScene(new Scene(root, 980, 560));
    }
}
