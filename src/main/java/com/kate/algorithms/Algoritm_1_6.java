package com.kate.algorithms;

import com.kate.Helper;
import com.kate.debug.Debug;
import java.util.ArrayList;

public class Algoritm_1_6 {
    
    private class Ship {
        int[] daysPort;
        int stopPort;
        int stopDay;

        public int getStopDay() {
            return stopDay;
        }

        public void setStopDay(int stopDay) {
            this.stopDay = stopDay;
        }

        public int getStopPort() {
            return stopPort;
        }

        public void setStopPort(int stopPort) {
            this.stopPort = stopPort;
        }

        public void setPortAtDay(int day, int port) {
            daysPort[day] = port;
        }

        public int[] getDaysPort() {
            return daysPort;
        }

        public int getPortAtDay(int day) {
            return daysPort[day];
        }

        public Ship(int numOfDays) {
            daysPort = new int[numOfDays];
            stopPort = -1;
            stopDay  = -1;
            for (int d = 0; d < numOfDays; d++) {
                daysPort[d] = -1; // the ship is in the sea
            }
        }
    }
    
    ArrayList<Ship> ships;
    /*
    -1  - in sea
    -2  - stay in port
    >=0 - stay 
    */
    Integer numOfDays;
    Integer numOfSheepsPorts;

    public void printSchedules() {
        
        String printString;
        printString = "|  d\\s |";
        for (int s = 0; s < numOfSheepsPorts; s++) {
            printString += ((s < 10 && numOfSheepsPorts > 10) ? " 0" : " ") + s + " |";
        }
        int maxLength = printString.length() - 1;
        
        String shiftString    = "   ";
        String titleAddString = "   ";
        
        int titleLength = new String("Day-Ship Main Schedule:   ").length();
        if (titleLength > maxLength + shiftString.length()) {
            int addLength = titleLength - (maxLength + shiftString.length());
            for (int i = 1; i < addLength; i++) {
                shiftString += " ";
            }
        }
        else if (titleLength < maxLength + shiftString.length()) {
            int addLength = maxLength + shiftString.length() - titleLength;
            for (int i = 0; i <= addLength; i++) {
                titleAddString += " ";
            }
        }
        
        Debug.print("bb", "Day-Ship Main Schedule:" + titleAddString + "Day-Ship Short Schedule:");

        String str = "";
        for (int i = 0; i <= maxLength; i++) {
            str += "=";
        }
        Debug.print("b", str + shiftString + str);
        Debug.print("b", printString + shiftString + printString);

        printString = "";
        for (int i = 0; i <= maxLength; i++) {
            printString += "-";
        }
        Debug.print("b", printString + shiftString + printString);
        
        for (int d = 0; d < numOfDays; d++) {
            
            printString = "| ";
            if (numOfDays > 10) {
                printString += (d < 10) ? " 0" : " ";
            }
            else {
                printString += "  ";
            }
            printString += d + "  |";
            
            for (int s = 0; s < numOfSheepsPorts; s++) {
                Ship ship = ships.get(s);
                int port = ship.getPortAtDay(d);
                if (port == -1) {
                    printString += ((numOfSheepsPorts > 10) ? "   " : "  ") + " |";
                }
                else {
                    printString += ((port < 10 && numOfSheepsPorts > 10) ? " 0" : " ") + port + " |";
                }
            }

            printString += shiftString + "| ";
            if (numOfDays > 10) {
                printString += (d < 10) ? " 0" : " ";
            }
            else {
                printString += "  ";
            }
            printString += d + "  |";

            for (int s = 0; s < numOfSheepsPorts; s++) {
                Ship ship = ships.get(s);
                if (d > ship.getStopDay()) {
                    printString += ((numOfSheepsPorts > 10) ? " --" : " -") + " |";
                    continue;
                }
                int port = ship.getPortAtDay(d);
                if (port == -1) {
                    printString += ((numOfSheepsPorts > 10) ? "   " : "  ") + " |";
                }
                else {
                    printString += ((port < 10 && numOfSheepsPorts > 10) ? " 0" : " ") + port + " |";
                }
            }
            
            Debug.print("b", printString);
        }
        
        printString = "";
        for (int i = 0; i <= maxLength; i++) {
            printString += "-";
        }
        Debug.print("b", printString + shiftString + printString);
    }
    
    public void getSchedules(int type, int shift) {
        if (type == 0) {
            for (int s = 0; s < numOfSheepsPorts; s++) {
                Ship ship = ships.get(s);
                for (int port = 0; port < numOfSheepsPorts; port++) {
                    int day = port + shift;
                    if (day > numOfDays.intValue() - 1) {
                        day = day - numOfDays.intValue();
                    }
                    day += s;
                    if (day > numOfDays.intValue() - 1) {
                        day = day - numOfDays.intValue();
                    }
                    ship.setPortAtDay(day, port);
                }
            }
        }
        else if (type == 1) {
            for (int s = 0; s < numOfSheepsPorts; s++) {
                Ship ship = ships.get(s);
                ArrayList<Integer> busyDays = new ArrayList<>();
                for (int port = 0; port < numOfSheepsPorts; port++) {
                    ArrayList<Integer> freeDays = getFreeDaysForPort(port);
                    int index = Helper.getRandomIndexFromList(freeDays);
                    int day = -1;
                    int freeDay = freeDays.get(index);
                    if (busyDays.indexOf(freeDay) == -1) {
                        day = freeDay;
                    }
                    else {
                        for (int d = index + 1; d < freeDays.size(); d++) {
                            freeDay = freeDays.get(d);
                            if (busyDays.indexOf(freeDay) == -1) {
                                day = freeDay;
                                break;
                            }
                        }
                        if (day == -1) {
                            for (int d = 0; d < index; d++) {
                                freeDay = freeDays.get(d);
                                if (busyDays.indexOf(freeDay) == -1) {
                                    day = freeDay;
                                    break;
                                }
                            }
                        }
                    }
                    if (day == -1) {
                        Debug.print("rbi", "Error: not found free day for ship == " + s + "; port == " + port);
                    }
                    else {
                        busyDays.add(day);
                        ship.setPortAtDay(day, port);
                    }
                }
            }
        }
        solve();
        printSchedules();
        testSolution();
    }
    
    private void testSolution() {
        for (int p = 0; p < numOfSheepsPorts; p++) {
            int stopDay = -1;
            for (int s = 0; s < numOfSheepsPorts; s++) {
                Ship ship = ships.get(s);
                if (ship.getStopPort() != p) continue;
                stopDay = ship.getStopDay();
            }
            if (stopDay == -1) {
                Debug.print("rb", "Error: for port == " + p + " stopDay not found");
            }
            else {
                for (int d = stopDay + 1; d < numOfDays; d++) {
                    for (int s = 0; s < numOfSheepsPorts; s++) {
                        Ship ship = ships.get(s);
                        int port = ship.getPortAtDay(d);
                        if (port == p) {
                            Debug.print("rb", "Error: for port == " + p + "; ship == " + s + "; day == " + d);
                        }
                    }
                }
            }
        }
    }
    
    private void solve() {
        ArrayList<Integer> busyPorts = new ArrayList<>();
        for (int d = 0; d < numOfDays; d++) {
            int day = numOfDays - d - 1;
            //Debug.print("rb", "day == " + day);
            for (int s = 0; s < numOfSheepsPorts; s++) {
                Ship ship = ships.get(s);
                if (ship.getStopPort() != -1) continue;
                int port = ship.getDaysPort()[day];
                if (port == -1) continue;
                if (busyPorts.indexOf(port) != -1) continue;
                //Debug.print("wb", "set ship == " + s + "; stopPort == " + port);
                ship.setStopPort(port);
                ship.setStopDay(day);
                busyPorts.add(port);
            }
        }
    }
    
    private ArrayList<Integer> getFreeDaysForPort(int port) {
        ArrayList<Integer> freeDays = new ArrayList<>();
        for (int d = 0; d < numOfDays; d++) {
            boolean free = true;
            for (int s = 0; s < numOfSheepsPorts; s++) {
                Ship ship = ships.get(s);
                int[] daysPort = ship.getDaysPort();
                if (daysPort[d] == port) {
                    free = false;
                    break;
                }
            }
            if (free) {
                freeDays.add(d);
            }
        }
        return freeDays;
    }
    
    public void init(Integer numOfSheeps, Integer numOfDays) {
        this.numOfSheepsPorts = numOfSheeps;
        this.numOfDays   = numOfDays;
        
        ships.clear();
        for (int s = 0; s < numOfSheeps; s++) {
            Ship ship = new Ship(numOfDays);
            ships.add(ship);
        }

    }

    public Integer getNumOfDays() {
        return numOfDays;
    }

    public Integer getNumOfSheepsPorts() {
        return numOfSheepsPorts;
    }
    
    public Algoritm_1_6() {
        ships = new ArrayList<>();
    }
    
}
