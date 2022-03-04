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

public class Sell_Controller {
    @FXML
    Button con;
    @FXML
    Button back2;

    @FXML
    public TextField MT;
    @FXML
    public TextField CN;
    @FXML
    public TextField CE;
    @FXML
    public DatePicker date;
    @FXML
    public MenuButton time;
    @FXML
    public MenuButton hall;
    @FXML
    public TextField price;
    @FXML
    public TextField seatno;
    @FXML
    public TextField wrong;
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
    MenuItem m1;
    @FXML
    MenuItem m2;
    @FXML
    MenuItem m3;
    @FXML
    MenuItem m4;

    String H;
    String T;

    @FXML
    public void one(){
        H = "Hall 1";
        hall.setText("Hall 1");
    }
    public void two(){
        H = "Hall 2";
        hall.setText("Hall 2");
    }
    public void three(){
        H = "Hall 3";
        hall.setText("Hall 3");
    }
    public void four(){
        H = "Hall 4";
        hall.setText("Hall 4");
    }
    public void five(){
        H = "Hall 5";
        hall.setText("Hall 5");
    }
    public void six(){
        H = "Hall 6";
        hall.setText("Hall 6");
    }
    public void seven(){
        H = "Hall 7";
        hall.setText("Hall 7");
    }
    public void eight(){
        H = "Hall 8";
        hall.setText("Hall 8");
    }
    public void nine(){
        H = "Hall 9";
        hall.setText("Hall 9");
    }
    public void ten(){
        H = "Hall 10";
        hall.setText("Hall 10");
    }

    public void m1(){
        T = "9.00 AM";
        time.setText("9.00 AM");
    }
    public void m2(){
        T = "12.00 PM";
        time.setText("12.00 PM");
    }
    public void m3(){
        T = "3.00 PM";
        time.setText("3.00 PM");
    }
    public void m4(){
        T = "6.00 PM";
        time.setText("6.00 PM");
    }


    public void backhome(ActionEvent e)   throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Afterlogin.fxml"));
        Stage window = (Stage) back2.getScene().getWindow();
        window.setScene(new Scene(root, 980, 560));
    }
    public void confirm(ActionEvent e)   throws Exception {
        String a = MT.getText();
        String b = CN.getText();
        String c = CE.getText();
        LocalDate d = date.getValue();
        String f = T;
        String g = H;
        String h = seatno.getText();
        String p = price.getText();
        String i = "";

        int flag2=0;
        int flag=0;
        File read2=new File("Only_MOV.txt");
        try {
            BufferedReader buff = new BufferedReader(new FileReader(read2));
            String inputfile=buff.readLine();
            while(inputfile!=null){
                if(a.equals(inputfile)){
                    flag=1;
                    break;
                }
                else{
                    inputfile=buff.readLine();
                }
            }
            if(flag==0){
                wrong.setText("Movie is not in the Database");
            }
            buff.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        File Dt=new File("Date.txt");
        File Tm=new File("Time.txt");
        File Hl=new File("Hall.txt");
        File St=new File("Seat.txt");
        try {
            BufferedReader buffD = new BufferedReader(new FileReader(Dt));
            BufferedReader buffT = new BufferedReader(new FileReader(Tm));
            BufferedReader buffH = new BufferedReader(new FileReader(Hl));
            BufferedReader buffS = new BufferedReader(new FileReader(St));
            String input_file1=buffD.readLine();
            String input_file2=buffT.readLine();
            String input_file3=buffH.readLine();
            String input_file4=buffS.readLine();
            if (a.equals(i) || b.equals(i) || c.equals(i) || f.equals(i) || g.equals(i) || h.equals(i)|| p.equals(i)|| d.toString().equals(i)) {
                if(flag==1) {
                    wrong.setText("Please Enter all the Information");
                }
            }
            while(input_file1!=null && input_file2!=null && input_file3!=null && input_file4!=null){
                if(d.toString().equals(input_file1) && f.equals(input_file2) && g.equals(input_file3) && h.equals(input_file4)){
                    flag2=1;
                    break;
                }
                else{
                    input_file1=buffD.readLine();
                    input_file2=buffT.readLine();
                    input_file3=buffH.readLine();
                    input_file4=buffS.readLine();
                }
            }
            if(flag2==1){
                wrong.setText("Seat is already booked");
            }
            buffD.close();
            buffT.close();
            buffH.close();
            buffS.close();
        } catch (IOException ex) {
            wrong.setText("Please Enter all the Information");
        }


        if(flag == 1 && flag2 == 0) {
            if (a.equals(i) || b.equals(i) || c.equals(i) || f.equals(i) || g.equals(i) || h.equals(i)|| p.equals(i)|| d.toString().equals(i)) {
                wrong.setText("Please Enter all the Information");
            } else {
                wrong.setText("Ticket Sold Successfully");
                //File
                try {
                    File MovInformation = new File("Ticket.txt");
                    BufferedWriter buf = new BufferedWriter(new FileWriter(MovInformation, true));
                    buf.write(a + "  ");
                    buf.write(b + "  ");
                    buf.write(c + "  ");
                    buf.write(d + "  ");
                    buf.write(f + "  ");
                    buf.write(g + "  ");
                    buf.write(h + "  ");
                    buf.write(p + "  ");
                    buf.newLine();
                    buf.close();

                    File Date = new File("Date.txt");
                    BufferedWriter bufD = new BufferedWriter(new FileWriter(Date, true));
                    bufD.write(d.toString());
                    bufD.newLine();
                    bufD.close();

                    File Time = new File("Time.txt");
                    BufferedWriter bufT = new BufferedWriter(new FileWriter(Time, true));
                    bufT.write(f);
                    bufT.newLine();
                    bufT.close();

                    File Hall = new File("Hall.txt");
                    BufferedWriter bufH = new BufferedWriter(new FileWriter(Hall, true));
                    bufH.write(g);
                    bufH.newLine();
                    bufH.close();

                    File Seat = new File("Seat.txt");
                    BufferedWriter bufS = new BufferedWriter(new FileWriter(Seat, true));
                    bufS.write(h);
                    bufS.newLine();
                    bufS.close();

                    File Mov = new File("Ticket_det.txt");
                    BufferedWriter buf2 = new BufferedWriter(new FileWriter(Mov, true));
                    buf2.write("Movie Title: " + a);
                    buf2.newLine();
                    buf2.write("Customer Name: " + b);
                    buf2.newLine();
                    buf2.write("Customer Email: " + c);
                    buf2.newLine();
                    buf2.write("Date: " + d);
                    buf2.newLine();
                    buf2.write("Time: " + f);
                    buf2.newLine();
                    buf2.write("Hall: " + g);
                    buf2.newLine();
                    buf2.write("Seat No: " + h);
                    buf2.newLine();
                    buf2.write("Price: " + p);
                    buf2.newLine();
                    buf2.write("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    buf2.newLine();
                    buf2.newLine();
                    buf2.close();

                } catch (Exception ex) {
                    wrong.setText("Please Enter all the Information");
                }

                FXMLLoader loader = new FXMLLoader(getClass().getResource("confirm.fxml"));
                Parent root = loader.load();
                Show_controller x = loader.getController();
                x.Shows(b,c,d.toString(),g,a,h,f,p);
                mail m =new mail();
                String Body = "<h1>Welcome to CineMagic</h1><h2>Ticket Confirmation</h2>Name: "+b+"<br />"+"Watch Date: "+d.toString()+"<br />"+"Hall Number: "+g+"<br />"+"Movie Name: "+a+"<br />"+"Seat No: "+h+"<br />"+"Watch Time: "+f+"<br />"+"Cost: "+p;
                m.getbody(Body);
                m.sendMail(c);
                Stage window = (Stage) con.getScene().getWindow();
                window.setScene(new Scene(root, 980, 560));
            }
        }
    }
}

