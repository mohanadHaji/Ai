/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1
 */
public class NQueen {

    private int row;
    private int column;
    private int rowNew;
    private int columnNew;
    private int hyorstic;
    private int pathCost;

    public NQueen(int row, int column, int hyorstic, int pathCost, int rowNew, int columnNew) {
        this.row = row;
        this.column = column;
        this.hyorstic = hyorstic;
        this.pathCost = pathCost;
        this.rowNew = rowNew;
        this.columnNew = columnNew;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setHyorstic(int hyorstic) {
        this.hyorstic = hyorstic;
    }

    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getHyorstic() {
        return hyorstic;
    }

    public int getPathCost() {
        return pathCost;
    }

    public void setRowNew(int rowNew) {
        this.rowNew = rowNew;
    }

    public void setColumnNew(int columnNew) {
        this.columnNew = columnNew;
    }

    public int getRowNew() {
        return rowNew;
    }

    public int getColumnNew() {
        return columnNew;
    }

    public static void randomFill(char[][] queenArray, int nQueen, int[] data) {
        int row = (int) (Math.random() * nQueen) + 0;
        int column = (int) (Math.random() * nQueen) + 0;
        
        for (int i = 0; i < queenArray.length; i++) {
            if (queenArray[row][column] == 'X') {  
                queenArray[row][column] = 'Q';
                data[2 * i] = row;
                data[2 * i + 1] = column;
                
            } else {
                i--;
            }
            row = (int) (Math.random() * nQueen) + 0;
            column = (int) (Math.random() * nQueen) + 0;
        }
    }

    public static void printArray(char[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array.length; col++) {
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }
    }

    /*
sear for every queen and see how much in conflect with other
     */
    public static void hyorstic(int[] data, int[] nQueenHyo, char nQueenp[][]) {
        int hys = 0;
        int count = 0;
        int forWordDiagonalRow;
        int backWordDiagonalRow;
        int forWordDiagonalCol;
        int backWordDiagonalCol;
        int downDiagonalRow;
        int upDiagonalRow;
        int upDiagonalCol;
        int downDiagonalCol;
        for (int row = 0; row < nQueenp.length; row++) {
            for (int col = 0; col < nQueenp.length; col++) {
                if (nQueenp[row][col] == 'Q') {
                    hys = 0;
                    for (int i = 0; i < nQueenp.length; i++) {
                        if (i != col) {
                            if (nQueenp[row][i] == 'Q') {
                                hys = hys + 1;
                            }
                        }
                    }
                    for (int i = 0; i < nQueenp.length; i++) {
                        if (i != row) {
                            if (nQueenp[i][col] == 'Q') {
                                hys = hys + 1;
                            }
                        }
                    }

                    for (int i = 1; i < nQueenp.length; i++) {
                        forWordDiagonalRow = row + i;
                        forWordDiagonalCol = col + i;
                        backWordDiagonalRow = row - i;
                        backWordDiagonalCol = col - i;
                        downDiagonalRow = row - i;
                        upDiagonalCol = col + i;
                        upDiagonalRow = row + i;
                        downDiagonalCol = col - i;
                        if (forWordDiagonalRow < nQueenp.length && forWordDiagonalCol < nQueenp.length && nQueenp[forWordDiagonalRow][forWordDiagonalCol] == 'Q') {
                            hys = hys + 1;
                        }
                        if (backWordDiagonalRow >= 0 && backWordDiagonalCol >= 0 && nQueenp[backWordDiagonalRow][backWordDiagonalCol] == 'Q') {
                            hys = hys + 1;
                        }
                        if (downDiagonalRow >= 0 && upDiagonalCol < nQueenp.length && nQueenp[downDiagonalRow][upDiagonalCol] == 'Q') {
                            hys = hys + 1;
                        }
                        if (upDiagonalRow < nQueenp.length && downDiagonalCol >= 0 && nQueenp[upDiagonalRow][downDiagonalCol] == 'Q') {
                            hys = hys + 1;
                        }
                    }
                    if(count < nQueenp.length){
                    nQueenHyo[count] = hys;
                    data[2 * count] = row;
                    data[2 * count + 1] = col;
                    count++;
                    }
                }
            }
        }
    }

  
    
    public static int hyorPoint(char[][] array,int row, int col){
        int hys = 0;
        int count = 0;
        int forWordDiagonalRow;
        int backWordDiagonalRow;
        int forWordDiagonalCol;
        int backWordDiagonalCol;
        int downDiagonalRow;
        int upDiagonalRow;
        int upDiagonalCol;
        int downDiagonalCol;
        int num = array.length;
        for(int i = 1; i<array.length; i++){
            forWordDiagonalRow = row + i;
            forWordDiagonalCol = col + i;
            backWordDiagonalRow = row - i;
            backWordDiagonalCol = col - i;
            downDiagonalRow = row - i;
            upDiagonalCol = col + i;
            upDiagonalRow = row + i;
            downDiagonalCol = col - i;
            if(forWordDiagonalRow < num && forWordDiagonalCol < num 
                    && forWordDiagonalCol >= 0 && forWordDiagonalRow >= 0 && array[forWordDiagonalRow][forWordDiagonalCol] == 'Q'){
                hys = hys + 1;
                
            }
            if(backWordDiagonalRow < num && backWordDiagonalCol < num 
                    && backWordDiagonalCol >= 0 && backWordDiagonalRow >= 0 && array[backWordDiagonalRow][backWordDiagonalCol] == 'Q'){
                hys = hys + 1;
                
            }
            if(downDiagonalRow < num && upDiagonalCol < num 
                    && upDiagonalCol >= 0 && downDiagonalRow >= 0 && array[downDiagonalRow][upDiagonalCol] == 'Q'){
                hys = hys + 1;
                
            }
            if(upDiagonalRow < num && downDiagonalCol < num 
                    && downDiagonalCol >= 0 && upDiagonalRow >= 0 && array[upDiagonalRow][downDiagonalCol] == 'Q'){
                hys = hys + 1;
                
            }
            if(row < num && col + i < num 
                    && row >= 0 && col + i >= 0 && array[row][col + i] == 'Q'){
                hys = hys + 1;
                
            }
            if(row < num && col - i < num 
                    && row >= 0 && col - i >= 0 && array[row][col - i] == 'Q'){
                hys = hys + 1;
                
            }
        }
        return hys;
    }
    
    
    
    /*
 this method will consider the point given as queen and see if that is confelct with other queen 
     */
    private static boolean confelctPoint(char[][] array, int row, int col, int defRow, int defCol) {
        int forWordRightDiagonalRow;
        int backWordLeftDiagonalRow;
        int forWordRightDiagonalCol;
        int backWordLeftDiagonalCol;
        int downDiagonalRow;
        int upDiagonalRow;
        int upDiagonalCol;
        int downDiagonalCol;
        if (row < array.length && col < array.length && row >= 0 && col >= 0 && array[row][col] == 'Q') {
            return false;
        }
        if(row > array.length || row < 0 || col > array.length || col < 0)
        {
            return false;
        }
        for (int i = 1; i < array.length; i++) {
            forWordRightDiagonalRow = row + i;
            forWordRightDiagonalCol = col + i;
            backWordLeftDiagonalRow = row - i;
            backWordLeftDiagonalCol = col - i;
            downDiagonalRow = row - i;
            upDiagonalCol = col + i;
            upDiagonalRow = row + i;
            downDiagonalCol = col - i;
            if (forWordRightDiagonalRow < array.length 
                    && forWordRightDiagonalCol < array.length && forWordRightDiagonalRow>=0 && forWordRightDiagonalCol>= 0 
                    &&array[forWordRightDiagonalRow][forWordRightDiagonalCol] == 'Q') {
                return false;
            }
            if (backWordLeftDiagonalRow >= 0 
                    && backWordLeftDiagonalCol >= 0 && array[backWordLeftDiagonalRow][backWordLeftDiagonalCol] == 'Q') {
                return false;
            }

            if (downDiagonalRow >= 0 && upDiagonalCol < array.length && array[downDiagonalRow][upDiagonalCol] == 'Q') {
                return false;
            }
            if ( upDiagonalRow < array.length 
                    && downDiagonalCol >= 0 && upDiagonalRow>=0 && downDiagonalCol<array.length && array[upDiagonalRow][downDiagonalCol] == 'Q') {
                return false;
            }
            if (( row + i < array.length && array[row + i][col] == 'Q') ||  (row - i >= 0 && array[row - i][col] == 'Q')) {
                return false;
            }
            if (( col + i < array.length &&row<array.length&&row>=0&& array[row][col + i] == 'Q') || (col - i >= 0 &&row<array.length&&row>=0&& array[row][col - i] == 'Q')) {
                return false;
            }
        }
        return true;

    }

    /*
 the method will retuen the path for the closest point to become with no confelct with other queens
     */
    public static int path(char[][] array, int[] data, int row, int col) {
        int count = 1;
        int forWordDiagonalRow;
        int backWordDiagonalRow;
        int forWordDiagonalCol;
        int backWordDiagonalCol;
        int downDiagonalRow;
        int upDiagonalRow;
        int upDiagonalCol;
        int downDiagonalCol;
        for (int i = 1; i < array.length; i++) {
            forWordDiagonalRow = row + i;
            forWordDiagonalCol = col + i;
            backWordDiagonalRow = row - i;
            backWordDiagonalCol = col - i;
            downDiagonalRow = row - i;
            upDiagonalCol = col + i;
            upDiagonalRow = row + i;
            downDiagonalCol = col - i;
            if (forWordDiagonalRow < array.length && forWordDiagonalCol < array.length &&array[forWordDiagonalRow][forWordDiagonalCol] != 'Q'
                    && NQueen.confelctPoint(array, forWordDiagonalRow, forWordDiagonalCol, row, col) == true) {
                data[0] = forWordDiagonalRow;
                data[1] = forWordDiagonalCol;
                return count;
            }
            if (backWordDiagonalRow >= 0 && backWordDiagonalCol >= 0 &&array[backWordDiagonalRow][backWordDiagonalCol] != 'Q' 
                    && NQueen.confelctPoint(array, backWordDiagonalRow, backWordDiagonalCol, row, col) == true) {
                data[0] = backWordDiagonalRow;
                data[1] = backWordDiagonalCol;
                return count;
            }
            if (downDiagonalRow >= 0 && upDiagonalCol < array.length && array[downDiagonalRow][upDiagonalCol] != 'Q' &&
                    NQueen.confelctPoint(array, downDiagonalRow, upDiagonalCol, row, col) == true) {
                data[0] = downDiagonalRow;
                data[1] = upDiagonalCol;
                return count;
            }
            if (upDiagonalRow < array.length && downDiagonalCol >= 0 &&array[upDiagonalRow][downDiagonalCol] != 'Q' &&
                    NQueen.confelctPoint(array, upDiagonalRow, downDiagonalCol, row, col) == true) {
                data[0] = upDiagonalRow;
                data[1] = downDiagonalCol;
                return count;
            }
            if (row + i < array.length &&array[row+i][col] != 'Q' && NQueen.confelctPoint(array, row + i, col, row, col) == true) {
                data[0] = row + i;
                data[1] = col;
                return count;
            }
            if (row - i >= 0 && array[row-i][col] != 'Q' && NQueen.confelctPoint(array, row - i, col, row, col) == true) {
                data[0] = row - i;
                data[1] = col;
                return count;
            }
            if (col + i < array.length && array[row][col + i] != 'Q' && NQueen.confelctPoint(array, row, col + i, row, col) == true) {
                data[0] = row;
                data[1] = col + i;
                return count;
            }
            if (col - i >= 0 && array[row][col-i] != 'Q' && NQueen.confelctPoint(array, row, col - i, row, col) == true) {
                data[0] = row;
                data[1] = col - i;
                return count;
            }
            count++;
        }
        //------------------------------------------------------
        	int rowf;
        int rowb;
        int colf;
        int colb;
        int forWordDiagonalRown;
        int backWordDiagonalRown;
        int forWordDiagonalColn;
        int backWordDiagonalColn;
        int downDiagonalRown;
        int upDiagonalRown;
        int upDiagonalColn;
        int downDiagonalColn;
        int rowfn;
        int rowbn;
        int colfn;
        int colbn;
        for (int i = 1; i < array.length; i++) {
            count = 2;
            forWordDiagonalRown = row + i;
            forWordDiagonalColn = col + i;
            backWordDiagonalRown = row - i;
            backWordDiagonalColn = col - i;
            downDiagonalRown = row - i;
            upDiagonalColn = col + i;
            upDiagonalRown = row + i;
            downDiagonalColn = col - i;
            rowfn = row + i;
            rowbn = row - i;
            colfn = col + i;
            colbn = col - i;
            if (forWordDiagonalRown < array.length && forWordDiagonalColn < array.length) {
                for (int j = 0; j < array.length; j++) {

                    backWordDiagonalRow = forWordDiagonalRown - j;
                    backWordDiagonalCol = forWordDiagonalColn - j;
                    downDiagonalRow = forWordDiagonalRown - j;
                    upDiagonalCol = forWordDiagonalColn + j;
                    upDiagonalRow = forWordDiagonalRown + j;
                    downDiagonalCol = forWordDiagonalColn - j;
                    rowf = forWordDiagonalRown + j;
                    rowb = forWordDiagonalRown - j;
                    colf = forWordDiagonalColn + j;
                    colb = forWordDiagonalColn - j;
                    forWordDiagonalRow = forWordDiagonalRown + j;
                    forWordDiagonalCol = forWordDiagonalColn + j;
                    if (forWordDiagonalRow < array.length && forWordDiagonalCol < array.length && NQueen.confelctPoint(array, forWordDiagonalRow, forWordDiagonalCol, row, col) == true) {
                        data[0] = forWordDiagonalRow;
                        data[1] = forWordDiagonalCol;
                        return count;
                    }
                    if (backWordDiagonalRow >= 0 && backWordDiagonalCol >= 0 && NQueen.confelctPoint(array, backWordDiagonalRow, backWordDiagonalCol, row, col) == true) {
                        data[0] = backWordDiagonalRow;
                        data[1] = backWordDiagonalCol;
                        return count;
                    }
                    if (downDiagonalRow >= 0 && upDiagonalCol < array.length && NQueen.confelctPoint(array, downDiagonalRow, upDiagonalCol, row, col) == true) {
                        data[0] = downDiagonalRow;
                        data[1] = upDiagonalCol;
                        return count;
                    }
                    if (upDiagonalRow < array.length && downDiagonalCol >= 0 && NQueen.confelctPoint(array, upDiagonalRow, downDiagonalCol, row, col) == true) {
                        data[0] = upDiagonalRow;
                        data[1] = downDiagonalCol;
                        return count;
                    }
                    if (rowf < array.length && NQueen.confelctPoint(array, rowf, forWordDiagonalColn, row, col) == true) {
                        data[0] = rowf;
                        data[1] = forWordDiagonalColn;
                        return count;
                    }
                    if (rowb >= 0 && NQueen.confelctPoint(array, rowb, forWordDiagonalColn, row, col) == true) {
                        data[0] = rowb;
                        data[1] = forWordDiagonalColn;
                        return count;
                    }
                    if (colf < array.length && NQueen.confelctPoint(array, forWordDiagonalRown, colf, row, col) == true) {
                        data[0] = forWordDiagonalRown;
                        data[1] = colf;
                        return count;
                    }
                    if (colb >= 0 && NQueen.confelctPoint(array, forWordDiagonalRown, colb, row, col) == true) {
                        data[0] = forWordDiagonalRown;
                        data[1] = colb;
                        return count;
                    }
                    count++;
                }
            }
            //====================================================================================1
            count = 2;
            if (backWordDiagonalRown >= 0 && backWordDiagonalColn >= 0) {
                for (int j = 0; j < array.length; j++) {
                    forWordDiagonalRow = backWordDiagonalRown + j;
                    forWordDiagonalCol = backWordDiagonalColn + j;
                    backWordDiagonalRow = backWordDiagonalRown - j;
                    backWordDiagonalCol = backWordDiagonalColn - j;
                    downDiagonalRow = backWordDiagonalRown - j;
                    upDiagonalCol = backWordDiagonalColn + j;
                    upDiagonalRow = backWordDiagonalRown + j;
                    downDiagonalCol = backWordDiagonalColn - j;
                    rowf = backWordDiagonalRown + j;
                    rowb = backWordDiagonalRown - j;
                    colf = backWordDiagonalColn + j;
                    colb = backWordDiagonalColn - j;
                    if (forWordDiagonalRow < array.length && forWordDiagonalCol < array.length && NQueen.confelctPoint(array, forWordDiagonalRow, forWordDiagonalCol, row, col) == true) {
                        data[0] = forWordDiagonalRow;
                        data[1] = forWordDiagonalCol;
                        return count;
                    }
                    if (backWordDiagonalRow >= 0 && backWordDiagonalCol >= 0 && NQueen.confelctPoint(array, backWordDiagonalRow, backWordDiagonalCol, row, col) == true) {
                        data[0] = backWordDiagonalRow;
                        data[1] = backWordDiagonalCol;
                        return count;
                    }
                    if (downDiagonalRow >= 0 && upDiagonalCol < array.length && NQueen.confelctPoint(array, downDiagonalRow, upDiagonalCol, row, col) == true) {
                        data[0] = downDiagonalRow;
                        data[1] = upDiagonalCol;
                        return count;
                    }
                    if (upDiagonalRow < array.length && downDiagonalCol >= 0 && NQueen.confelctPoint(array, upDiagonalRow, downDiagonalCol, row, col) == true) {
                        data[0] = upDiagonalRow;
                        data[1] = downDiagonalCol;
                        return count;
                    }
                    if (rowf < array.length && NQueen.confelctPoint(array, rowf, backWordDiagonalColn, row, col) == true) {
                        data[0] = rowf;
                        data[1] = backWordDiagonalColn;
                        return count;
                    }
                    if (rowb >= 0 && NQueen.confelctPoint(array, rowb, backWordDiagonalColn, row, col) == true) {
                        data[0] = rowb;
                        data[1] = backWordDiagonalColn;
                        return count;
                    }
                    if (colf < array.length && NQueen.confelctPoint(array, backWordDiagonalRown, colf, row, col) == true) {
                        data[0] = backWordDiagonalRown;
                        data[1] = colf;
                        return count;
                    }
                    if (colb >= 0 && NQueen.confelctPoint(array, backWordDiagonalRown, colb, row, col) == true) {
                        data[0] = backWordDiagonalRown;
                        data[1] = colb;
                        return count;
                    }
                    count++;
                }
            }
            //====================================================================================2
            count = 2;
            //================================================================================================
            if (downDiagonalRown >= 0 && upDiagonalColn < array.length) {
                for (int j = 0; j < array.length; j++) {
                    forWordDiagonalRow = downDiagonalRown + j;
                    forWordDiagonalCol = upDiagonalColn + j;
                    backWordDiagonalRow = downDiagonalRown - j;
                    backWordDiagonalCol = upDiagonalColn - j;
                    downDiagonalRow = downDiagonalRown - j;
                    upDiagonalCol = upDiagonalColn + j;
                    upDiagonalRow = downDiagonalRown + j;
                    downDiagonalCol = upDiagonalColn - j;
                    rowf = downDiagonalRown + j;
                    rowb = downDiagonalRown - j;
                    colf = upDiagonalColn + j;
                    colb = upDiagonalColn - j;
                    if (forWordDiagonalRow < array.length && forWordDiagonalCol < array.length && NQueen.confelctPoint(array, forWordDiagonalRow, forWordDiagonalCol, row, col) == true) {
                        data[0] = forWordDiagonalRow;
                        data[1] = forWordDiagonalCol;
                        return count;
                    }
                    if (backWordDiagonalRow >= 0 && backWordDiagonalCol >= 0 && NQueen.confelctPoint(array, backWordDiagonalRow, backWordDiagonalCol, row, col) == true) {
                        data[0] = backWordDiagonalRow;
                        data[1] = backWordDiagonalCol;
                        return count;
                    }
                    if (downDiagonalRow >= 0 && upDiagonalCol < array.length && NQueen.confelctPoint(array, downDiagonalRow, upDiagonalCol, row, col) == true) {
                        data[0] = downDiagonalRow;
                        data[1] = upDiagonalCol;
                        return count;
                    }
                    if (upDiagonalRow < array.length && downDiagonalCol >= 0 && NQueen.confelctPoint(array, upDiagonalRow, downDiagonalCol, row, col) == true) {
                        data[0] = upDiagonalRow;
                        data[1] = downDiagonalCol;
                        return count;
                    }
                    if (rowf < array.length && NQueen.confelctPoint(array, rowf, upDiagonalColn, row, col) == true) {
                        data[0] = rowf;
                        data[1] = upDiagonalColn;
                        return count;
                    }
                    if (rowb >= 0 && NQueen.confelctPoint(array, rowb, upDiagonalColn, row, col) == true) {
                        data[0] = rowb;
                        data[1] = upDiagonalColn;
                        return count;
                    }
                    if (colf < array.length && NQueen.confelctPoint(array, downDiagonalRown, colf, row, col) == true) {
                        data[0] = downDiagonalRown;
                        data[1] = colf;
                        return count;
                    }
                    if (colb >= 0 && NQueen.confelctPoint(array, downDiagonalRown, colb, row, col) == true) {
                        data[0] = downDiagonalRown;
                        data[1] = colb;
                        return count;
                    }
                    count++;
                }
            }
            //======================================================================
            count = 2;
            if (upDiagonalRown < array.length && downDiagonalColn >= 0) {
                for (int j = 0; j < array.length; j++) {
                    forWordDiagonalRow = upDiagonalRown + j;
                    forWordDiagonalCol = downDiagonalColn + j;
                    backWordDiagonalRow = upDiagonalRown - j;
                    backWordDiagonalCol = downDiagonalColn - j;
                    downDiagonalRow = upDiagonalRown - j;
                    upDiagonalCol = downDiagonalColn + j;
                    upDiagonalRow = upDiagonalRown + j;
                    downDiagonalCol = downDiagonalColn - j;
                    rowf = upDiagonalRown + j;
                    rowb = upDiagonalRown - j;
                    colf = downDiagonalColn + j;
                    colb = downDiagonalColn - j;
                    if (forWordDiagonalRow < array.length && forWordDiagonalCol < array.length && NQueen.confelctPoint(array, forWordDiagonalRow, forWordDiagonalCol, row, col) == true) {
                        data[0] = forWordDiagonalRow;
                        data[1] = forWordDiagonalCol;
                        return count;
                    }
                    if (backWordDiagonalRow >= 0 && backWordDiagonalCol >= 0 && NQueen.confelctPoint(array, backWordDiagonalRow, backWordDiagonalCol, row, col) == true) {
                        data[0] = backWordDiagonalRow;
                        data[1] = backWordDiagonalCol;
                        return count;
                    }
                    if (downDiagonalRow >= 0 && upDiagonalCol < array.length && NQueen.confelctPoint(array, downDiagonalRow, upDiagonalCol, row, col) == true) {
                        data[0] = downDiagonalRow;
                        data[1] = upDiagonalCol;
                        return count;
                    }
                    if (upDiagonalRow < array.length && downDiagonalCol >= 0 && NQueen.confelctPoint(array, upDiagonalRow, downDiagonalCol, row, col) == true) {
                        data[0] = upDiagonalRow;
                        data[1] = downDiagonalCol;
                        return count;
                    }
                    if (rowf < array.length && NQueen.confelctPoint(array, rowf, downDiagonalColn, row, col) == true) {
                        data[0] = rowf;
                        data[1] = downDiagonalColn;
                        return count;
                    }
                    if (rowb >= 0 && NQueen.confelctPoint(array, rowb, downDiagonalColn, row, col) == true) {
                        data[0] = rowb;
                        data[1] = downDiagonalColn;
                        return count;
                    }
                    if (colf < array.length && NQueen.confelctPoint(array, upDiagonalRown, colf, row, col) == true) {
                        data[0] = upDiagonalRown;
                        data[1] = colf;
                        return count;
                    }
                    if (colb >= 0 && NQueen.confelctPoint(array, upDiagonalRown, colb, row, col) == true) {
                        data[0] = upDiagonalRown;
                        data[1] = colb;
                        return count;
                    }
                    count++;
                }
            }
            //========================================================================================
            count = 2;
            //======================================================================
            if (rowfn < array.length) {
                for (int j = 0; j < array.length; j++) {
                    forWordDiagonalRow = rowfn + j;
                    forWordDiagonalCol = col + j;
                    backWordDiagonalRow = rowfn - j;
                    backWordDiagonalCol = col - j;
                    downDiagonalRow = rowfn - j;
                    upDiagonalCol = col + j;
                    upDiagonalRow = rowfn + j;
                    downDiagonalCol = col - j;
                    rowf = rowfn + j;
                    rowb = rowfn - j;
                    colf = col + j;
                    colb = col - j;
                    if (forWordDiagonalRow < array.length && forWordDiagonalCol < array.length && NQueen.confelctPoint(array, forWordDiagonalRow, forWordDiagonalCol, row, col) == true) {
                        data[0] = forWordDiagonalRow;
                        data[1] = forWordDiagonalCol;
                        return count;
                    }
                    if (backWordDiagonalRow >= 0 && backWordDiagonalCol >= 0 && NQueen.confelctPoint(array, backWordDiagonalRow, backWordDiagonalCol, row, col) == true) {
                        data[0] = backWordDiagonalRow;
                        data[1] = backWordDiagonalCol;
                        return count;
                    }
                    if (downDiagonalRow >= 0 && upDiagonalCol < array.length && NQueen.confelctPoint(array, downDiagonalRow, upDiagonalCol, row, col) == true) {
                        data[0] = downDiagonalRow;
                        data[1] = upDiagonalCol;
                        return count;
                    }
                    if (upDiagonalRow < array.length && downDiagonalCol >= 0 && NQueen.confelctPoint(array, upDiagonalRow, downDiagonalCol, row, col) == true) {
                        data[0] = upDiagonalRow;
                        data[1] = downDiagonalCol;
                        return count;
                    }
                    if (rowf < array.length && NQueen.confelctPoint(array, rowf, col, row, col) == true) {
                        data[0] = rowf;
                        data[1] = col;
                        return count;
                    }
                    if (rowb >= 0 && NQueen.confelctPoint(array, rowb, col, row, col) == true) {
                        data[0] = rowb;
                        data[1] = col;
                        return count;
                    }
                    if (colf < array.length && NQueen.confelctPoint(array, rowfn, colf, row, col) == true) {
                        data[0] = rowfn;
                        data[1] = colf;
                        return count;
                    }
                    if (colb >= 0 && NQueen.confelctPoint(array, rowfn, colb, row, col) == true) {
                        data[0] = rowfn;
                        data[1] = colb;
                        return count;
                    }
                    count++;
                }
            }
            count = 2;
            //====================================================================
            if (rowbn >= 0) {
                for (int j = 0; j < array.length; j++) {
                    forWordDiagonalRow = rowbn + j;
                    forWordDiagonalCol = col + j;
                    backWordDiagonalRow = rowbn - j;
                    backWordDiagonalCol = col - j;
                    downDiagonalRow = rowbn - j;
                    upDiagonalCol = col + j;
                    upDiagonalRow = rowbn + j;
                    downDiagonalCol = col - j;
                    rowf = rowbn + j;
                    rowb = rowbn - j;
                    colf = col + j;
                    colb = col - j;
                    if (forWordDiagonalRow < array.length && forWordDiagonalCol < array.length && NQueen.confelctPoint(array, forWordDiagonalRow, forWordDiagonalCol, row, col) == true) {
                        data[0] = forWordDiagonalRow;
                        data[1] = forWordDiagonalCol;
                        return count;
                    }
                    if (backWordDiagonalRow >= 0 && backWordDiagonalCol >= 0 && NQueen.confelctPoint(array, backWordDiagonalRow, backWordDiagonalCol, row, col) == true) {
                        data[0] = backWordDiagonalRow;
                        data[1] = backWordDiagonalCol;
                        return count;
                    }
                    if (downDiagonalRow >= 0 && upDiagonalCol < array.length && NQueen.confelctPoint(array, downDiagonalRow, upDiagonalCol, row, col) == true) {
                        data[0] = downDiagonalRow;
                        data[1] = upDiagonalCol;
                        return count;
                    }
                    if (upDiagonalRow < array.length && downDiagonalCol >= 0 && NQueen.confelctPoint(array, upDiagonalRow, downDiagonalCol, row, col) == true) {
                        data[0] = upDiagonalRow;
                        data[1] = downDiagonalCol;
                        return count;
                    }
                    if (rowf < array.length && NQueen.confelctPoint(array, rowf, col, row, col) == true) {
                        data[0] = rowf;
                        data[1] = col;
                        return count;
                    }
                    if (rowb >= 0 && NQueen.confelctPoint(array, rowb, col, row, col) == true) {
                        data[0] = rowf;
                        data[1] = col;
                        return count;
                    }
                    if (colf < array.length && NQueen.confelctPoint(array, rowbn, colf, row, col) == true) {
                        data[0] = rowbn;
                        data[1] = colf;
                        return count;
                    }
                    if (colb >= 0 && NQueen.confelctPoint(array, rowbn, colb, row, col) == true) {
                        data[0] = rowbn;
                        data[1] = colb;
                        return count;
                    }
                    count++;
                }
            }
            //=========================================================================================
            count = 2;
            if (colfn < array.length) {
                for (int j = 0; j < array.length; j++) {
                    forWordDiagonalRow = rowbn + j;
                    forWordDiagonalCol = col + j;
                    backWordDiagonalRow = rowbn - j;
                    backWordDiagonalCol = col - j;
                    downDiagonalRow = rowbn - j;
                    upDiagonalCol = col + j;
                    upDiagonalRow = rowbn + j;
                    downDiagonalCol = col - j;
                    rowf = rowbn + j;
                    rowb = rowbn - j;
                    colf = col + j;
                    colb = col - j;
                    if (forWordDiagonalRow < array.length && forWordDiagonalCol < array.length && NQueen.confelctPoint(array, forWordDiagonalRow, forWordDiagonalCol, row, col) == true) {
                        data[0] = forWordDiagonalRow;
                        data[1] = forWordDiagonalCol;
                        return count;
                    }
                    if (backWordDiagonalRow >= 0 && backWordDiagonalCol >= 0 && NQueen.confelctPoint(array, backWordDiagonalRow, backWordDiagonalCol, row, col) == true) {
                        data[0] = backWordDiagonalRow;
                        data[1] = backWordDiagonalCol;
                        return count;
                    }
                    if (downDiagonalRow >= 0 && upDiagonalCol < array.length && NQueen.confelctPoint(array, downDiagonalRow, upDiagonalCol, row, col) == true) {
                        data[0] = downDiagonalRow;
                        data[1] = upDiagonalCol;
                        return count;
                    }
                    if (upDiagonalRow < array.length && downDiagonalCol >= 0 && NQueen.confelctPoint(array, upDiagonalRow, downDiagonalCol, row, col) == true) {
                        data[0] = upDiagonalRow;
                        data[1] = downDiagonalCol;
                        return count;
                    }
                    if (rowf < array.length && NQueen.confelctPoint(array, rowf, colfn, row, col) == true) {
                        data[0] = rowf;
                        data[1] = colfn;
                        return count;
                    }
                    if (rowb >= 0 && NQueen.confelctPoint(array, rowb, colfn, row, col) == true) {
                        data[0] = rowb;
                        data[1] = colfn;
                        return count;
                    }
                    if (colf < array.length && NQueen.confelctPoint(array, row, colf, row, col) == true) {
                        data[0] = row;
                        data[1] = colf;
                        return count;
                    }
                    if (colb >= 0 && NQueen.confelctPoint(array, row, colb, row, col) == true) {
                        data[0] = row;
                        data[1] = colb;
                        return count;
                    }
                    count++;
                }
            }
            //========================================================
            count = 2;
            if (colbn >= 0) {
                for (int j = 0; j < array.length; j++) {
                    forWordDiagonalRow = rowbn + j;
                    forWordDiagonalCol = col + j;
                    backWordDiagonalRow = rowbn - j;
                    backWordDiagonalCol = col - j;
                    downDiagonalRow = rowbn - j;
                    upDiagonalCol = col + j;
                    upDiagonalRow = rowbn + j;
                    downDiagonalCol = col - j;
                    rowf = rowbn + j;
                    rowb = rowbn - j;
                    colf = col + j;
                    colb = col - j;
                    if (forWordDiagonalRow < array.length && forWordDiagonalCol < array.length && NQueen.confelctPoint(array, forWordDiagonalRow, forWordDiagonalCol, row, col) == true) {
                        data[0] = forWordDiagonalRow;
                        data[1] = forWordDiagonalCol;
                        return count;
                    }
                    if (backWordDiagonalRow >= 0 && backWordDiagonalCol >= 0 && NQueen.confelctPoint(array, backWordDiagonalRow, backWordDiagonalCol, row, col) == true) {
                        data[0] = backWordDiagonalRow;
                        data[1] = backWordDiagonalCol;
                        return count;
                    }
                    if (downDiagonalRow >= 0 && upDiagonalCol < array.length && NQueen.confelctPoint(array, downDiagonalRow, upDiagonalCol, row, col) == true) {
                        data[0] = downDiagonalRow;
                        data[1] = upDiagonalCol;
                        return count;
                    }
                    if (upDiagonalRow < array.length && downDiagonalCol >= 0 && NQueen.confelctPoint(array, upDiagonalRow, downDiagonalCol, row, col) == true) {
                        data[0] = upDiagonalRow;
                        data[1] = downDiagonalCol;
                        return count;
                    }
                    if (rowf < array.length && colfn < array.length && NQueen.confelctPoint(array, rowf, colfn, row, col) == true) {
                        data[0] = rowf;
                        data[1] = colbn;
                        return count;
                    }
                    if (rowb >= 0 && colfn < array.length && NQueen.confelctPoint(array, rowb, colfn, row, col) == true) {
                        data[0] = rowb;
                        data[1] = colfn;
                        return count;
                    }
                    if (colf < array.length && NQueen.confelctPoint(array, row, colf, row, col) == true) {
                        data[0] = row;
                        data[1] = colf;
                        return count;
                    }
                    if (colb >= 0 && NQueen.confelctPoint(array, row, colb, row, col) == true) {
                        data[0] = row;
                        data[1] = colb;
                        return count;
                    }
                    count++;
                }
            }}
            //================================================================================================
            for(int i = 0; i<array.length;i++){
                for(int j = 0; j < array.length; j++){
                    if(NQueen.confelctPoint(array, i, j, row, col) == true){
                        data[0] = i;
                        data[1] = j;
                        return (Math.abs(row - i) + Math.abs(col - j));
                    }
                }
            }
        
        data[0] = -1;
        data[1] = -1;
        return 0;
    }

    public static void hysPath(NQueen[] queenobj, char mat[][]) {
        int Nqueen = mat.length;
        int[] data = new int[Nqueen * 2];
        int[] data1 = new int[Nqueen * 2];
        int[] hys = new int[Nqueen];
        NQueen.randomFill(mat, Nqueen, data);

        for (int i = 0; i < Nqueen; i++) {
            queenobj[i] = new NQueen(data[2 * i], data[2 * i + 1], 0, 0, -1, -1);
        }
        NQueen.hyorstic(data1, hys, mat);
        for (int i = 0; i < Nqueen; i++) {
            for (int j = 0; j < Nqueen; j++) {
                if (queenobj[j].getRow() == data1[2 * i] && queenobj[j].getColumn() == data1[2 * i + 1]) {
                    queenobj[j].setHyorstic(hys[i]);
                    break;
                }
            }
            
        }
        for (int i = 0; i < Nqueen; i++) {
            if (queenobj[i].getHyorstic() != 0) {
                queenobj[i].setPathCost(NQueen.path(mat, data, queenobj[i].getRow(), queenobj[i].getColumn()));
                queenobj[i].setRowNew(data[0]);
                queenobj[i].setColumnNew(data[1]);
            }
            else{
                queenobj[i].setPathCost(0);
            }
        }
    }
    public static void hysPath2(NQueen[] queenobj, char mat[][]) {
        int Nqueen = mat.length;
        int[] data = new int[Nqueen * 2];
        int[] data1 = new int[Nqueen * 2];
        int[] hys = new int[Nqueen];
        NQueen.hyorstic(data1, hys, mat);
        for (int i = 0; i < Nqueen; i++) {
            for (int j = 0; j < Nqueen; j++) {
                if (queenobj[j].getRow() == data1[2 * i] && queenobj[j].getColumn() == data1[2 * i + 1]) {
                    queenobj[j].setHyorstic(hys[i]);
                    break;
                }
            }
        }
        for (int i = 0; i < Nqueen; i++) {
            if (queenobj[i].getHyorstic() != 0) {
                queenobj[i].setPathCost(NQueen.path(mat, data, queenobj[i].getRow(), queenobj[i].getColumn()));
                queenobj[i].setRowNew(data[0]);
                queenobj[i].setColumnNew(data[1]);
            }
            else{
                queenobj[i].setPathCost(0);
            }
        }
    }
}


