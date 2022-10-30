/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;
public class IdaTree {

    private NQueen queen;
    public IdaTree left;
    public IdaTree right;
    private int func;
    private char[][] array;
    private int genareted;

    public IdaTree(NQueen queen, IdaTree left, IdaTree right, int func, int genareted) {
        this.queen = queen;
        this.left = left;
        this.right = right;
        this.func = func;
        this.genareted = genareted;
    }

    public void setQueen(NQueen queen) {
        this.queen = queen;
    }

    public void setLeft(IdaTree left) {
        this.left = left;
    }

    public void setRight(IdaTree right) {
        this.right = right;
    }

    public void setFunc(int func) {
        this.func = func;
    }

    public void setGenareted(int genareted) {
        this.genareted = genareted;
    }
    
    public NQueen getQueen() {
        return queen;
    }

    public IdaTree getLeft() {
        return left;
    }

    public IdaTree getRight() {
        return right;
    }

    public int getFunc() {
        return func;
    }

    public int getGenareted() {
        return genareted;
    }
    
    public void setArray(char[][] array){
        for(int i = 0 ; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                this.array[i][j] = array[i][j];
        }
        }
    }

    public static void leftNodeRight(IdaTree tree) {
        if (tree.getLeft() != null) {
            IdaTree.leftNodeRight(tree.getLeft());
        }
        System.out.println("func = " + tree.getFunc() + "   path = " + tree.getQueen().getPathCost() + "    hyos = "+ tree.getQueen().getHyorstic() + "  row = " 
        + tree.getQueen().getRow() + "    col = " + tree.getQueen().getColumn());
        if (tree.getRight() != null) {
            IdaTree.leftNodeRight(tree.getRight());
        }
    }

    public static void fillTree(IdaTree tree, NQueen[] queenobj) {
        IdaTree left;
        IdaTree right;
        int func = tree.getFunc();
        int newFunc;
        IdaTree previous = tree;
        left = tree.left;
        right = tree.right;
        for (int i = 1; i < queenobj.length; i++) {
            newFunc = queenobj[i].getHyorstic() + queenobj[i].getPathCost();
            if (func > newFunc) {
                while (left != null) {
                    previous = left;
                    if (left.getFunc() > newFunc) {
                        left = left.left;
                    } else {
                        left = left.right;
                    }
                }
                if (previous.getFunc() > newFunc) {
                    previous.left = new IdaTree(queenobj[i], null, null, queenobj[i].getHyorstic() + queenobj[i].getPathCost(),0);
                } else {
                    previous.right = new IdaTree(queenobj[i], null, null, queenobj[i].getHyorstic() + queenobj[i].getPathCost(),0);
                }
            } else {
                while (right != null) {
                    previous = right;
                    if (right.getFunc() > newFunc) {
                        right = right.left;
                    } else {
                        right = right.right;
                    }
                }
                if (previous.getFunc() > newFunc) {
                    previous.left = new IdaTree(queenobj[i], null, null, queenobj[i].getHyorstic() + queenobj[i].getPathCost(),0);
                } else {
                    previous.right = new IdaTree(queenobj[i], null, null, queenobj[i].getHyorstic() + queenobj[i].getPathCost(),0);
                }
            }
            left = tree.left;
            right = tree.right;
            previous = tree;
        }
    }

    /*
    is to solve of ida
     */
    public static void setFunction(IdaTree tree){
        if(tree.getLeft() != null){
            setFunction(tree.getLeft());
        }
        tree.setFunc(tree.getQueen().getPathCost() + tree.getQueen().getHyorstic());
        if(tree.getRight() != null){
            setFunction(tree.getRight());
        }
    }
    public static int mingen(IdaTree tree,int current,int newCurrent){
        int temp;
        if(newCurrent == -1){
            if(tree.getGenareted() == 1){
                if(tree.getFunc() >= current){
                    newCurrent = tree.getFunc();
                }
                if(tree.getLeft() != null && tree.getLeft().getGenareted() == 1){
                    temp = mingen(tree.getLeft(),current,newCurrent);
                    if(temp > -1){
                        newCurrent = temp;
                    }
                }
                if(tree.getRight() != null && tree.getRight().getGenareted() == 1){
                    temp = mingen(tree.getRight(),current,newCurrent);
                    if(temp > -1){
                        newCurrent = temp;
                    }
                }
            }
        } else{
            if(tree.getGenareted() == 1){
                if(tree.getFunc() >= current && tree.getFunc() <= newCurrent){
                    newCurrent = tree.getFunc();
                }
                if(tree.getLeft() != null && tree.getLeft().getGenareted() == 1){
                    temp = mingen(tree.getLeft(),current,newCurrent);
                    if(temp > -1){
                        newCurrent = temp;
                    }
                }
                if(tree.getRight() != null && tree.getRight().getGenareted() == 1){
                    temp = mingen(tree.getRight(),current,newCurrent);
                    if(temp > -1){
                        newCurrent = temp;
                    }
                }
            }
        }
        tree.setGenareted(0);
        return newCurrent;
    }
    public static void solve(IdaTree tree, char[][] array,NQueen[] queenobj, int currentValue) {
        tree.setGenareted(1);
        int func = tree.getFunc();
        int path = tree.getQueen().getPathCost();
        if(tree.getFunc() <= currentValue){
            if(path != 0 && tree.getQueen().getHyorstic() != 0 && array[tree.getQueen().getRowNew()][tree.getQueen().getColumnNew()] == 'X'){
                array[tree.getQueen().getRowNew()][tree.getQueen().getColumnNew()] = 'Q';
                array[tree.getQueen().getRow()][tree.getQueen().getColumn()] = 'X';
                tree.getQueen().setRow(tree.getQueen().getRowNew());
                tree.getQueen().setColumn(tree.getQueen().getColumnNew());
                NQueen.hysPath2(queenobj, array);
                IdaTree.setFunction(tree);
            }
            if(tree.getLeft() != null){
                solve(tree.getLeft(),array,queenobj,currentValue);
            }
            if(tree.getRight() != null){
                solve(tree.getRight(),array,queenobj,currentValue);
            }
        }

    }
}

//if (tree.getFunc() > currentValue && tree.queen.getHyorstic() != 0) {
         //   currentValue = tree.getFunc();
        //}
       /* if (tree.queen.getHyorstic() != 0) {
           
            if(array[tree.queen.getRowNew()][tree.queen.getColumnNew()] == 'X'){
                array[tree.queen.getRow()][tree.queen.getColumn()] = 'X';
                array[tree.queen.getRowNew()][tree.queen.getColumnNew()] = 'Q';
                tree.queen.setRow(tree.queen.getRowNew());
                tree.queen.setColumn(tree.queen.getColumnNew());
                
            }
            else{
                array[tree.queen.getRow()][tree.queen.getColumn()] = 'X';
                tree.queen.setRow(tree.queen.getRowNew());
                tree.queen.setColumn(tree.queen.getColumnNew());
                int flag = 0;
                int row = (int) (Math.random() * array.length) + 0;
                int column = (int) (Math.random() * array.length) + 0;
                while (flag != 1 && row < array.length && column < array.length && row>=0 && column >= 0){
                    if(array[row][column] == 'X'){
                        array[row][column] = 'Q';
                        tree.queen.setRow(row);
                        tree.queen.setColumn(column);
                        flag = 1;
                    }
                     row = (int) (Math.random() * array.length) + 0;
                     column = (int) (Math.random() * array.length) + 0;
                }
            }
            
        }
        if (tree.left != null) {
            solve(tree.left, array,queenobj, currentValue);
        }
        if (tree.right != null) {
            solve(tree.right, array,queenobj, currentValue);
        }
*/
