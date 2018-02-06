package com.kate.algorithms;

import com.kate.Helper;
import com.kate.debug.Debug;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Algoritm_1_6 {
    Integer numOfDays;
    Integer numOfSheepsPorts;
    
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

        public int getPortDay(int port) {
            for (int d = 0; d < numOfDays; d++) {
                if (daysPort[d] == port)
                    return d;
            }
            return -1;
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
        
//        public Ship copy() {
//            Ship copy = new Ship();
//        }
    }
    
    ArrayList<Ship> ships;
    /*
    -1  - in sea
    -2  - stay in port
    >=0 - stay 
    */

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
        
        Debug.println("bb", "Day-Ship Main Schedule:" + titleAddString + "Day-Ship Short Schedule:");

        String str = "";
        for (int i = 0; i <= maxLength; i++) {
            str += "=";
        }
        Debug.println("b", str + shiftString + str);
        Debug.println("b", printString + shiftString + printString);

        printString = "";
        for (int i = 0; i <= maxLength; i++) {
            printString += "-";
        }
        Debug.println("b", printString + shiftString + printString);
        
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
            
            Debug.println("b", printString);
        }
        
        printString = "";
        for (int i = 0; i <= maxLength; i++) {
            printString += "-";
        }
        Debug.println("b", printString + shiftString + printString);
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
                        Debug.println("rbi", "Error: not found free day for ship == " + s + "; port == " + port);
                    }
                    else {
                        busyDays.add(day);
                        ship.setPortAtDay(day, port);
                    }
                }
            }
        }
        //printSchedules();
        solve();
        printSchedules();
        testSolution();
    }

    private void readPortsDaysShips(HashMap<Integer, HashMap<Integer, Integer>> portsDaysShips) {
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : portsDaysShips.entrySet()) {
            int port = entry.getKey();
            Debug.println("rb", "port == " + port);
            HashMap<Integer, Integer> portDaysShips = entry.getValue();
            for (int d = 0; d < numOfDays; d++) {
                Integer ship = portDaysShips.get(d);
                Debug.println("wb", "day == " + d + "; ship == " + ship );
            }
        }
    }
    
    private boolean getStopDayShipPort(HashMap<Integer, HashMap<Integer, Integer>> portsDaysShips) {
        int stopDay  = numOfDays + 1;
        int stopPort = -1;
        int stopShip = -1;
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : portsDaysShips.entrySet()) {
            int port = entry.getKey();
            HashMap<Integer, Integer> portDaysShips = entry.getValue();
            for (int d = 0; d < numOfDays; d++) {
                int day = numOfDays - d - 1;
                Integer shipNum = portDaysShips.get(day);
                if (shipNum == null) {
                    continue;
                }
                else {
                    Ship ship = ships.get(shipNum);
                    if (ship.getStopDay() != -1) continue;
                    if ( day < stopDay) {
                        stopDay = day;
                        stopPort = port;
                        stopShip = shipNum;
                    }
                    break;
                }
            }
        }
        //Debug.println("wb", "stopDay == " + stopDay + "; stopPort == " + stopPort + "; stopShip == " + stopShip);
        if (stopPort == -1) return false;
        Ship ship = ships.get(stopShip);
        ship.setStopDay(stopDay);
        ship.setStopPort(stopPort);
        portsDaysShips.remove(stopPort);
        return true;
    }
    
    private void solve() {
        HashMap<Integer, HashMap<Integer, Integer>> portsDaysShips = new HashMap<>();
        for (int p = 0; p < numOfSheepsPorts; p++) {
            HashMap<Integer, Integer> portDaysShips = new HashMap<>();
            for (int s = 0; s < numOfSheepsPorts; s++) {
                Ship ship = ships.get(s);
                int day = ship.getPortDay(p);
                portDaysShips.put(day, s);
                //Debug.println("wb", "p == " + p + "; s == " + s + "; day == " + day);
            }
            portsDaysShips.put(p, portDaysShips);
        }
        //readPortsDaysShips(portsDaysShips);
        for (int p = 0; p < numOfSheepsPorts; p++) {
            if (!getStopDayShipPort(portsDaysShips)) {
                return;
            }
        }
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
                Debug.println("rb", "Error: for port == " + p + " stopDay not found");
            }
            else {
                for (int d = stopDay + 1; d < numOfDays; d++) {
                    for (int s = 0; s < numOfSheepsPorts; s++) {
                        Ship ship = ships.get(s);
                        if (ship.getStopDay() > stopDay) {
                            int port = ship.getPortAtDay(d);
                            if (port == p) {
                                Debug.println("rb", "Error: for port == " + p + "; ship == " + s + "; day == " + d);
                            }
                        }
                    }
                }
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
