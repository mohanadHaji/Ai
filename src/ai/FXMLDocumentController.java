/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author 1
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button;
    @FXML
    private TextField textQueen;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        int Nqueen = Integer.parseInt(textQueen.getText().toString());
        int min, row, column;
        int count = 0;
        int count2 = 0;
        int temp;
        String print;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        char[][] array = new char[Nqueen][Nqueen];
        NQueen[] queenobj = new NQueen[Nqueen];
        IdaTree tree;
        for (int i = 0; i < Nqueen; i++) {
            Arrays.fill(array[i], 'X');
        }
        NQueen.hysPath(queenobj, array);
        tree = new IdaTree(queenobj[0], null, null, queenobj[0].getHyorstic() + queenobj[0].getPathCost(),0);
        IdaTree.fillTree(tree,queenobj);
        System.out.println(tree.getQueen().getHyorstic());
        NQueen.printArray(array);
        min = queenobj[0].getHyorstic()+queenobj[0].getPathCost();
        for(int i = 1;i<Nqueen;i++){
            if(queenobj[i].getHyorstic()+queenobj[i].getPathCost()<min){
                min = queenobj[i].getHyorstic()+queenobj[i].getPathCost();
            }
        }
        int flag = 0;
        
        for(int i = 0; i < Nqueen; i++){
            System.out.println(" queeen path = " + queenobj[i].getPathCost() + "   queen hyo =   "+ queenobj[i].getHyorstic());
        }
        IdaTree.setFunction(tree);
        IdaTree.leftNodeRight(tree);
        
        
        for(int i = 0; i < Nqueen;i++){
            for(int j = 0; j< Nqueen; j++){
                sb.append(array[i][j]);
            }
            sb.append("\n");
        }
        print = sb.toString();
        label1.setText(print);
        while(flag != 1){
            IdaTree.solve(tree, array, queenobj, min);
            
            temp = IdaTree.mingen(tree, min, -1); 
            if(temp > -1)
            {
              min =   temp;
            }
            
            for(int i=0;i<Nqueen;i++){
            //System.out.println(queenobj[i].getHyorstic()+ "   row = "+ queenobj[i].getRow()+ "    col = "+ queenobj[i].getColumn());
            if(queenobj[i].getHyorstic() == 0){
                flag = 1;
                
            }
            else{
                flag = 0;
                break;
            }
        }
        if(count == 3){
            count = 0;
        for(int i = 0; i< Nqueen;i++){
                if(queenobj[i].getPathCost() == 0 && queenobj[i].getHyorstic() != 0){
                    while(count2 != 1){
                 row = (int) (Math.random() * Nqueen) + 0;
                 column = (int) (Math.random() * Nqueen) + 0;
                 if(array[row][column] == 'X'){
                     array[row][column] = 'Q';
                     array[queenobj[i].getRow()][queenobj[i].getColumn()] = 'X';
                     queenobj[i].setRow(row);
                     queenobj[i].setColumn(column);
                     count2 = 1;
                     
                 }
                    }
                    count2 = 0;
                    NQueen.hysPath2(queenobj, array);
                    
            }
                
        }
        }
            System.out.println("---------------------------------------------------------------------"+min+"     "+tree.getFunc());
        NQueen.printArray(array);
        for(int i = 0; i < Nqueen; i++){
            System.out.println(" queeen path = " + queenobj[i].getPathCost() + "   queen hyo =   "+ queenobj[i].getHyorstic()
            + " row = " +   queenobj[i].getRow() + "   col = " + queenobj[i].getColumn()+ "  new row = " + queenobj[i].getRowNew() +"   col new = " + queenobj[i].getColumnNew());
        }
        count++;
       
        }
        System.out.println("aiproject.AiProject.main()");
        NQueen.printArray(array);
        for(int i = 0; i < Nqueen;i++){
            for(int j = 0; j< Nqueen; j++){
                sb2.append(array[i][j]);
            }
            sb2.append("\n");
        }
        print = sb2.toString();
        label2.setText(print);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
