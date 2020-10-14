package exchange.service;





import entity.Student;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.DBConfig;

//import models.Student;
//import models.StudentConflictException;
//import models.Team;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Exchange extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    ArrayList<String> strings = new ArrayList<String>();
    ArrayList<String> strings1 = new ArrayList<String>();

    Stage stage1 = new Stage();
    @Override
    public void start(Stage stage) throws Exception {
        stage=stage1;
        restart();
    }
    public void restart() throws IOException, ClassNotFoundException {
    	
        Connection connection=null;
        
        Statement statement =null;
        Statement statement2 =null;
        ArrayList<String> PID =new ArrayList<String>();
        ArrayList<String> S1 =new ArrayList<String>();
        ArrayList<String> S2 =new ArrayList<String>();
        ArrayList<String> S3 =new ArrayList<String>();
        ArrayList<String> S4 =new ArrayList<String>();
        ArrayList<String> SID =new ArrayList<String>();
        ArrayList<String> SEX =new ArrayList<String>();
        ArrayList<Double> experence = new ArrayList<>();
        ArrayList<String> pType =new ArrayList<String>();
        ArrayList<Double> gpa = new ArrayList<>();

        try{

            connection=DBConfig.getConnection();
            String sql = "select * from team;";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                PID.add(resultSet.getString("PID"));
                S1.add(resultSet.getString("SID1"));
                S2.add(resultSet.getString("SID2"));
                S3.add(resultSet.getString("SID3"));
                S4.add(resultSet.getString("SID4"));

            }
            String sql2="select * from student;";
            statement2 = connection.createStatement();
            ResultSet resultSet2 = statement.executeQuery(sql2);
            while ((resultSet2.next())){
                SID.add(resultSet2.getString("SID"));
                SEX.add(resultSet2.getString("gender"));
                pType.add(resultSet2.getString("pType"));
                experence.add(resultSet2.getDouble("experence"));
                gpa.add(resultSet2.getDouble("GPA"));
            }
        }catch (Exception e){
            e.printStackTrace();

        }


        AnchorPane anchorPane = new AnchorPane();
        ArrayList<String> a =new ArrayList<String>();


         for (int i=0;i<PID.size();i++){
            VBox vBox = new VBox();
            AnchorPane anchorPane2 = new AnchorPane();

            Label label1 = new Label();

            label1.setText("Team" + (i+1));
            strings.add("Team" + (i+1));
           // strings1.add(entry.getKey().toString());
            vBox.getChildren().addAll(label1);

       ArrayList<String> rr = new ArrayList<>();

             rr.add(PID.get(i));
             rr.add(S1.get(i));
             rr.add(S2.get(i));
             rr.add(S3.get(i));
             rr.add(S4.get(i));

                 for (int j=0;j<(rr.size()-1);j++) {
                     CheckBox r = new CheckBox(rr.get(j+1));
                     r.setPrefSize(70, 30);
                     r.selectedProperty().addListener(new ChangeListener<Boolean>() {
                         @Override
                         public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                             if (t1 == true) {
                                 a.add(r.getText());

                             }
                             if (t1 == false) {
                                 a.remove(r.getText());
                             }

                         }
                     });

                     vBox.getChildren().addAll(r);
                 }


            vBox.setPadding(new Insets(20));
            vBox.setSpacing(20);
            anchorPane2.getChildren().addAll(vBox);
            if(i==0){
                anchorPane2.setStyle("-fx-background-color:#DEB887");
            }
            if(i==1){
                anchorPane2.setStyle("-fx-background-color:#F0E68C");
            }
            if(i==2){
                anchorPane2.setStyle("-fx-background-color:#32CD32");
            }
            if(i==3){
                anchorPane2.setStyle("-fx-background-color:#FF0000");
            }
            if(i==4){
                anchorPane2.setStyle("-fx-background-color:#7B68EE");
            }

            anchorPane2.setPrefSize(100, 150);
            anchorPane.setTopAnchor(anchorPane2, 20.0);
            anchorPane.setLeftAnchor(anchorPane2, 20.0*(i+1)+i*160);
            anchorPane.getChildren().addAll(anchorPane2);




        }
 /*BarChart<String,Number> barChart =getView1();
        anchorPane.setTopAnchor(barChart, 470.0);
        anchorPane.setLeftAnchor(barChart,300.0 );
        anchorPane.getChildren().add(barChart);

        BarChart<String,Number> barChart2 =getView2();
        anchorPane.setTopAnchor(barChart2, 470.0);
        anchorPane.setLeftAnchor(barChart2,20.0 );
        anchorPane.getChildren().add(barChart2);

        BarChart<String,Number> barChart3 =getView3();
        anchorPane.setTopAnchor(barChart3, 470.0);
        anchorPane.setLeftAnchor(barChart3,600.0 );
        anchorPane.getChildren().add(barChart3);
*/


        Button button2 = new Button("Swap");

        button2.setPrefSize(60,40);

        button2.setLayoutX(550);
        button2.setLayoutY(350);




        button2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getClickCount()==1&&mouseEvent.getButton().name().equals(MouseButton.PRIMARY.name())){
                    if (a.size()==2) {
                        HashMap<Integer, ArrayList<String>> c = new HashMap<>();
                        String [] d=new String[2];
                        String [] f =new String[2];
                        int j=0;

                        for (String A : a) {
                            d[j]=A;

                            //String[] tm = new String[]{PID.get(i-1), S1.get(i-1), S2.get(i-1), S3.get(i-1), S4.get(i-1)};
                            for(int i=0;i<PID.size();i++){
                                ArrayList<String> t = new ArrayList<String>();

                                t.add(S1.get(i));
                                t.add(S2.get(i));
                                t.add(S3.get(i));
                                t.add(S4.get(i));
                                for (int y=0;y<t.size();y++) {
                                    if(t.get(y).equals(A)){
                                      f[j]=PID.get(i);
                                        t.remove(t.get(y));
                                        c.put(j,t);
                                    }
                                }
                            }
                            j++;
                        }
                        boolean flag = false;
                        boolean flag1 = false;

                        c.get(0).add(d[1]);
                        c.get(1).add(d[0]);
                       for (int q=0;q<2;q++) {
                           double sum = 0;
                           int x = 0;
                           int v = 0;
                           for (String e : c.get(q)) {
                               for (int i = 0; i < SID.size(); i++) {
                                   ArrayList<String> t = new ArrayList<String>();
                                   t.add(SID.get(i));
                                   t.add(SEX.get(i));
                                   t.add(pType.get(i));
                                   t.add(experence.get(i).toString());
                                   t.add(gpa.get(i).toString());
                                   if (e.equals(t.get(0))) {
                                       if (t.get(1).equals("female")) {
                                           x++;
                                       }
                                       if (t.get(2).equals("A") || t.get(2).equals("B")) {
                                           flag = true;
                                       }
                                       if (Double.parseDouble(t.get(3)) >= 5) {
                                           flag1 = true;
                                       }
                                       if (Double.parseDouble(t.get(4)) >= 3) {
                                           v++;
                                       }

                                       sum = sum + Double.parseDouble(t.get(4));
                                   }
                               }
                           }
                           if (flag == false) {
                               Alert alert = new Alert(Alert.AlertType.WARNING);
                               alert.setTitle("swap fail");
                               alert.setHeaderText("ERROR");
                               alert.setContentText("Lack of A and B personality types");
                               alert.showAndWait();
                               c.get(0).remove(d[1]);
                               c.get(1).remove(d[0]);
                               c.get(0).add(d[0]);
                               c.get(1).add(d[1]);
                               return;

                           }
                           if (flag1 == false) {
                               Alert alert = new Alert(Alert.AlertType.WARNING);
                               alert.setTitle("swap fail");
                               alert.setHeaderText("ERROR");
                               alert.setContentText("Lack of work experience for 5 years");
                               alert.showAndWait();
                               c.get(0).remove(d[1]);
                               c.get(1).remove(d[0]);
                               c.get(0).add(d[0]);
                               c.get(1).add(d[1]);
                               return;

                           }
                           if (x > 1) {
                               Alert alert = new Alert(Alert.AlertType.WARNING);
                               alert.setTitle("swap fail");
                               alert.setHeaderText("ERROR");
                               alert.setContentText("More than 1 girl");
                               alert.showAndWait();
                               c.get(0).remove(d[1]);
                               c.get(1).remove(d[0]);
                               c.get(0).add(d[0]);
                               c.get(1).add(d[1]);
                               return;

                           }
                           if (v < 2) {
                               Alert alert = new Alert(Alert.AlertType.WARNING);
                               alert.setTitle("swap fail");
                               alert.setHeaderText("ERROR");
                               alert.setContentText("Fewer than 2 students have a gpa of 3");
                               alert.showAndWait();
                               c.get(0).remove(d[1]);
                               c.get(1).remove(d[0]);
                               c.get(0).add(d[0]);
                               c.get(1).add(d[1]);
                               return;
                           }
                           if (sum / 4 > 3.5) {
                               Alert alert = new Alert(Alert.AlertType.WARNING);
                               alert.setTitle("swap fail");
                               alert.setHeaderText("ERROR");
                               alert.setContentText("Gpa is greater than 3.5");
                               alert.showAndWait();
                               c.get(0).remove(d[1]);
                               c.get(1).remove(d[0]);
                               c.get(0).add(d[0]);
                               c.get(1).add(d[1]);
                               return;
                           }
                       }


                        try{

                            Connection connection=null;
                            String sql2 = "update team set SID1=?,SID2=?,SID3=?,SID4=? where PID=?;";

                            connection=DBConfig.getConnection();
                            PreparedStatement  ps = connection.prepareStatement(sql2);
                                
                                ps.setString(1, c.get(0).get(0));
                                ps.setString(2, c.get(0).get(1));
                                ps.setString(3, c.get(0).get(2));
                                ps.setString(4, c.get(0).get(3));
                                ps.setString(5, f[0]);
                                ps.executeUpdate();
                            } catch (SQLException e) {
                                System.out.println("The operation failure");
                                e.printStackTrace();
                            }
                            
                             try { 

                             String sql3 = "update team set SID1=?,SID2=?,SID3=?,SID4=? where PID=?;";
                             Connection connection=null;
                                 connection=DBConfig.getConnection();
                                 PreparedStatement  ps2 = connection.prepareStatement(sql3);
                                   
                                ps2.setString(1, c.get(1).get(0));
                                ps2.setString(2, c.get(1).get(1));
                                ps2.setString(3, c.get(1).get(2));
                                ps2.setString(4, c.get(1).get(3));
                                ps2.setString(5, f[1]);
                                ps2.executeUpdate();

                                restart();

                            } catch (SQLException e) {
                                System.out.println("The operation failure");
                                e.printStackTrace();
                            } catch (IOException e) {
                                 e.printStackTrace();
                             } catch (ClassNotFoundException e) {
                                 e.printStackTrace();
                             }


                    }
                    }


                       
                  
                    
                }
            

                });

        
        anchorPane.getChildren().add(button2);


        Scene scene = new Scene(anchorPane);
        stage1.setScene(scene);
        stage1.setTitle("cheak student");
        stage1.setHeight(800);
        stage1.setWidth(1000);

        stage1.show();


    }
    }
   /* public  BarChart<String,Number> getView1() throws IOException, ClassNotFoundException {

        repository.initialize();
        ProjectManager projectManager=new ProjectManager(repository);
        CategoryAxis x =new CategoryAxis();
        x.setLabel("team");
        NumberAxis y = new NumberAxis(0.0,4.0,0.5);

        ObservableList<XYChart.Series<String,Number>> list = FXCollections.observableArrayList();
        XYChart.Series<String,Number> xy = new XYChart.Series<String,Number>();
        ObservableList<XYChart.Data<String,Number>> list1 = FXCollections.observableArrayList();

        projectManager.calculateASK();
        int i=0;
        Iterator iterator3 = projectManager.calculateASK().entrySet().iterator();

        while (iterator3.hasNext()) {
            Map.Entry entry4 = (Map.Entry) iterator3.next();

            if(strings1.get(i).equals(entry4.getKey().toString())){
                XYChart.Data<String,Number> D = new XYChart.Data<String, Number>(strings.get(i),Double.valueOf(entry4.getValue().toString()));
                list1.add(D);
                i++;
            }

        }
        xy.setData(list1);
        list.add(xy);

        BarChart<String,Number> bar =new BarChart<String,Number>(x,y,list);

        bar.setPrefWidth(220);
        bar.setPrefHeight(300);
        bar.setTitle("AverageSkill\nStd Dev ="+projectManager.calculateSDSC());
        bar.getBorder();





        return bar;
    }*/
   













