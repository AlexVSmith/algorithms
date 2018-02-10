package com.kate.algorithms;

import com.kate.Helper;
import com.kate.debug.Debug;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Algoritm_1_7 {
    private final int numOfWires;
    private final HashMap<Integer, HashMap<Integer, PointOfBlock>> inputWires; // wire, wireNum
    private final HashMap<Integer, HashMap<Integer, PointOfBlock>> rowsColumnsPoints; // row, column
    private final HashMap<Integer, HashMap<Integer, PointOfBlock>> columnsRowsPoints; // row, column

    private class PointOfBlock {
        int wire;
        int wireNum;
        int row;
        int column;

        public PointOfBlock(int wire, int wireNum, int row, int column) {
            this.wire = wire;
            this.wireNum = wireNum;
            this.row = row;
            this.column = column;
        }

        public int getWire() {
            return wire;
        }

        public int getWireNum() {
            return wireNum;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
        
    }
    
    private ArrayList<Integer> getFreePointsOfRow(HashMap<Integer, PointOfBlock> rowColunmPoints) {
        ArrayList<Integer> freePoints = new ArrayList<>();
        for (int c = 0; c < numOfWires; c++) {
            if (rowColunmPoints.get(c) == null) {
                freePoints.add(c);
            }
        }
        return freePoints;
    }
    
    public void init() {
        inputWires.clear();
        rowsColumnsPoints.clear();
        columnsRowsPoints.clear();
        int w, i;
        for (w = 0; w < numOfWires; w++) {
            //InputWire inputWire = new InputWire();
            ArrayList<Integer> freeRows = new ArrayList<>();
            for (int r = 0; r < numOfWires; r++) {
                freeRows.add(r);
            }
            for (i = 0; i < numOfWires; i++) {

                int rowIndex = Helper.getRandomIndexFromList(freeRows);
                int row = freeRows.get(rowIndex);
                
                HashMap<Integer, PointOfBlock> rowColunmPoints = rowsColumnsPoints.get(row);
                if (rowColunmPoints == null) {
                    rowColunmPoints = new HashMap<>();
                }
                ArrayList<Integer> freePoints = getFreePointsOfRow(rowColunmPoints);
                int columnIndex = Helper.getRandomIndexFromList(freePoints);
                int column = freePoints.get(columnIndex);
                
                PointOfBlock pointOfBlock = new PointOfBlock(w, i, row, column);
                
                rowColunmPoints.put(column, pointOfBlock);
                rowsColumnsPoints.put(row, rowColunmPoints);
                
                HashMap<Integer, PointOfBlock> columnRowsPoints = columnsRowsPoints.get(column);
                if (columnRowsPoints == null) {
                    columnRowsPoints = new HashMap<>();
                }
                columnRowsPoints.put(row, pointOfBlock);
                columnsRowsPoints.put(column, columnRowsPoints);
                
                HashMap<Integer, PointOfBlock> wirePoints = inputWires.get(w);
                if (wirePoints == null) {
                    wirePoints = new HashMap<>();
                }
                wirePoints.put(i, pointOfBlock);
                inputWires.put(w, wirePoints);
                
                freeRows.remove(rowIndex);
                //Debug.println("wb", "w == " + w + "; i == " + i + "; r == " + row + "; c == " + column);
            }
        }
    }
    
    public Algoritm_1_7(int numOfWires) {
        this.numOfWires = numOfWires;
        inputWires = new HashMap<>();
        rowsColumnsPoints = new HashMap<>();
        columnsRowsPoints = new HashMap<>();
        init();
        printWires();
    }

    private String getWireColor(int num) {
        //if (numOfWires <= 10) {
            if (num == 0) {
                return "b";
            }
            else if (num == 1) {
                return "r";
            }
            else if (num == 2) {
                return "w";
            }
            else if (num == 3) {
                return "x";
            }
            else if (num == 4) {
                return "d";
            }
            else if (num == 5) {
                return "g";
            }
            else if (num == 6) {
                return "y";
            }
            else if (num == 7) {
                return "o";
            }
            else if (num == 8) {
                return "p";
            }
            else if (num == 9) {
                return "c";
            }
        //}
        return "x";
    }
    
    private void printWires() {
        Debug.print("xb", "\n");
        String printChars  = "";
        String printString = "";
        printChars = "|  o\\i |";
        printString += printChars;
        Debug.print("xb", printChars);
        for (int w = 0; w < numOfWires; w++) {
            printChars = "  ";
            if (numOfWires > 10) {
                printChars += " ";
            }
            printChars  += ((w < 10 && numOfWires > 10) ? "0" : "") + w;
            Debug.print(getWireColor(w) + "b", printChars);
            printString += printChars;
            
            printChars = "  |";
            Debug.print("xb", printChars);
            printString += printChars;
        }
        Debug.print("xb", "\n");
        int maxLength = printString.length();

        String str = "";
        for (int i = 0; i < maxLength; i++) {
            str += "=";
        }
        Debug.println("xb", str);
        
        
        for (int r = 0; r < numOfWires; r++) {
            Debug.print("xb", "|  ");
            str = "";
            if (numOfWires < 10) {
                str += " ";
            }
            else {
                if (r < 10) {
                    str += "0";
                }
            }
            str  += r;
            Debug.print("xb", str);
            
            Debug.print("xb", "  |");
            HashMap<Integer, PointOfBlock> rowColunmPoints = rowsColumnsPoints.get(r);
            for (int c = 0; c < numOfWires; c++) {
                PointOfBlock pointOfBlock = rowColunmPoints.get(c);
                str = " ";
                int w = pointOfBlock.getWire();
                if (w < 10 && numOfWires > 10) {
                    str += "0";
                }
                str += w + ".";
                int i = pointOfBlock.getWireNum();
                if (i < 10 && numOfWires > 10) {
                    str += "0";
                }
                str += i;
                Debug.print(getWireColor(w) + "b", str);
                Debug.print("xb", " |");
            }
            Debug.print("xb", "\n");
        }
        
    }

    public void solve() {
        
        HashMap<Integer, PointOfBlock> columnRowsPoints = columnsRowsPoints.get(0);
        
        HashMap<Integer, PointOfBlock> possiblePoints = new HashMap();
        for (int r = 0; r < numOfWires; r++) {
            PointOfBlock testPoint = columnRowsPoints.get(r);
//            Debug.println("b", 
//                    "testPoint; wire == " + testPoint.getWire() + 
//                    "; wireNum == " + testPoint.getWireNum() + 
//                    "; row == " + testPoint.getRow() + 
//                    "; column == " + testPoint.getColumn());
            PointOfBlock wirePoint = possiblePoints.get(testPoint.getWire());
            if ( wirePoint != null) {
//                Debug.println("r", 
//                        "wirePoint; wire == " + wirePoint.getWire() + 
//                        "; wireNum == " + wirePoint.getWireNum() + 
//                        "; row == " + wirePoint.getRow() + 
//                        "; column == " + wirePoint.getColumn());
                if (testPoint.getWireNum() > wirePoint.getWireNum()) {
//                    Debug.println("r", "continue;");
                    continue;
                }
            }
            possiblePoints.put(testPoint.getWire(), testPoint);
        }

        HashMap<Integer, PointOfBlock> finishedPoints   = new HashMap();
        HashMap<Integer, PointOfBlock> testPoints       = new HashMap();
        
        ArrayList<Integer> restWires = new ArrayList();
        ArrayList<Integer> restRows = new ArrayList();

        for (int r = 0; r < numOfWires; r++) {
            restWires.add(r);
            restRows.add(r);
        }

        for ( Entry<Integer, PointOfBlock> entry : possiblePoints.entrySet() ) {
            PointOfBlock possiblePoint = (PointOfBlock) entry.getValue();
            
            int indexOfRow = restRows.indexOf(possiblePoint.getRow());
            if (indexOfRow != -1) {
                restRows.remove(indexOfRow);
            }
            
            int indexOfWire = restWires.indexOf(possiblePoint.getWire());
            if (indexOfWire != -1) {
                restWires.remove(indexOfWire);
            }
            //foundWire.add(possiblePoint.getWire());
            //foundRow.add(possiblePoint.getRow());
            Debug.println("d", 
                    "possiblePoint; wire == " + possiblePoint.getWire() + 
                    "; wireNum == " + possiblePoint.getWireNum() + 
                    "; row == " + possiblePoint.getRow() + 
                    "; column == " + possiblePoint.getColumn());
            if (possiblePoint.getWireNum() == 0) {
                finishedPoints.put(possiblePoint.getWire(), possiblePoint);
            }
            else {
                testPoints.put(possiblePoint.getWire(), possiblePoint);
            }
        }
        
        for (int restRow : restRows) {
            Debug.println("r", "restRow == " + restRow);
            int columnNum = -1;
            for (int restWire : restWires) {
                Debug.println("r", "restWire == " + restWire);
            }
        }
        
    }
    
}
