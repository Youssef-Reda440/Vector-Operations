package vector_operations;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Vector_Operations extends Application {  
    Label sys1_lbl = new Label("Vector A System : ");
    Label com1_lbl = new Label("Vector A Components : ");
    Label sys2_lbl = new Label("Vector B System : ");
    Label com2_lbl = new Label("Vector B Components  : ");
    Label oper_lbl = new Label("Operation : ");

    ComboBox<String> systemBox1 = new ComboBox<>();
    ComboBox<String> systemBox2 = new ComboBox<>();
    ComboBox<String> operationBox = new ComboBox<>();
    
    TextField A_Txf1 = new TextField();
    TextField A_Txf2 = new TextField();
    TextField A_Txf3 = new TextField();
    TextField B_Txf1 = new TextField();
    TextField B_Txf2 = new TextField();
    TextField B_Txf3 = new TextField();
    TextField Result_Txf1 = new TextField();
    TextField Result_Txf2 = new TextField();
    TextField Result_Txf3 = new TextField();
    
    @Override
    public void start(Stage primaryStage) {      
        systemBox1.getItems().addAll("Cartesian" , "Cylendrical" , "Spherical");
        systemBox1.setPromptText("Select System");
        systemBox1.setValue("Cartesian");
        
        systemBox2.getItems().addAll("Cartesian" , "Cylendrical" , "Spherical");
        systemBox2.setPromptText("Select System");
        systemBox2.setValue("Cartesian");
        
        operationBox.getItems().addAll("+" , "-");
        operationBox.setPromptText("Select Operation");
     
        Button compute = new Button("Compute");
        Button Reset = new Button("Reset");
        Button Exit = new Button("Exit");
        
        compute.setOnAction(e -> {
            handlecompute();            
        });
        
        Reset.setOnAction(e -> {
            A_Txf1.clear();
            A_Txf2.clear();
            A_Txf3.clear();

            B_Txf1.clear();
            B_Txf2.clear();
            B_Txf3.clear();

            Result_Txf1.clear();
            Result_Txf2.clear();
            Result_Txf3.clear();            
        });
        
        Exit.setOnAction(e -> {
            System.exit(0);
        });
        
        HBox h = new HBox(5);
        h.getChildren().addAll(Reset , Exit);
        h.setAlignment(Pos.BOTTOM_RIGHT);
        h.setPadding(new Insets(10));
                   
        VBox V1 = new VBox(5);
        V1.getChildren().addAll(sys1_lbl, systemBox1, com1_lbl, A_Txf1, A_Txf2, A_Txf3);
        VBox V2 = new VBox(5);
        V2.getChildren().addAll(sys2_lbl, systemBox2, com2_lbl, B_Txf1, B_Txf2, B_Txf3);
        VBox V3 = new VBox(5);
        V3.getChildren().addAll(oper_lbl, operationBox, compute, Result_Txf1, Result_Txf2, Result_Txf3, h);
        
        
        VBox root = new VBox(10);
        root.getChildren().addAll(V1, V2, V3);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private double[] readVector(TextField t1, TextField t2, TextField t3) {
        double x = Double.parseDouble(t1.getText());
        double y = Double.parseDouble(t2.getText());
        double z = Double.parseDouble(t3.getText());
        return new double[]{ x, y, z };
    }

    private void handlecompute() {
        String VectorA_System = systemBox1.getValue();
        String VectorB_System = systemBox2.getValue();
        String Operation = operationBox.getValue();
        
        double[] A = readVector(A_Txf1, A_Txf2, A_Txf3);
        double[] B = readVector(B_Txf1, B_Txf2, B_Txf3);
        double[] R = new double[3];
        
        switch (VectorA_System){
            case "Cartesian" :              
                break;
            case "Cylendrical" :
                // Convert to Cartesian
                Cylendrical cyl = new Cylendrical(A[0], A[1], A[2]);
                Cartesian c1 = cyl.toCartesian(cyl);
                A[0] = c1.getX();
                A[1] = c1.getY();
                A[2] = c1.getZ();               
                break;
            case "Spherical" :
                // Convert to Cartesian
                Spherical s = new Spherical(A[0], A[1], A[2]);
                Cartesian c2 = s.toCartesian(s);
                A[0] = c2.getX();
                A[1] = c2.getY();
                A[2] = c2.getZ();
                break;
            default :
                break;
        }
        
        switch (VectorB_System){
            case "Cartesian" :            
                break;
            case "Cylendrical" :               
                // Convert to Cartesian
                Cylendrical cyl = new Cylendrical(B[0], B[1], B[2]);
                Cartesian c1 = cyl.toCartesian(cyl);
                B[0] = c1.getX();
                B[1] = c1.getY();
                B[2] = c1.getZ();  
                break;
            case "Spherical" :
                // Convert to Cartesian
                Spherical s = new Spherical(B[0], B[1], B[2]);
                Cartesian c2 = s.toCartesian(s);
                B[0] = c2.getX();
                B[1] = c2.getY();
                B[2] = c2.getZ();
                break;
            default :
                break;
        }
        
        switch (Operation){
            case "+" :
                for (int i=0; i < 3; i++)
                    R[i] = A[i] + B[i];
                break;
            case "-" :
                for (int i=0; i < 3; i++)
                    R[i] = A[i] - B[i];
                break;         
            default :
                break;
        }
        
        Result_Txf1.setText(String.format("%.3f",R[0]));
        Result_Txf2.setText(String.format("%.3f",R[1]));
        Result_Txf3.setText(String.format("%.3f",R[2]));    
    }    
        
}
