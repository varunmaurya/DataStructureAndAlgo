package com.varun.interviewPrograms;

/**
 * Leet code weekly competition
 *
 * games start at every 15 min and 1 game is for 15 min, how many games played within given time
 * if you started playing at 10:20 and stopped at 10:50, though you spent 30 min, only 1 game will be considered
 * from 10:30- 10:45
 * if end hr is less than start hr , it means its next days hr ( after crossing 24 hrs)
 */
public class NumberOfgames {
    public static void main(String[] args) {
        int numOfRounds = numberOfRounds("10:20","11:20");
        System.out.println("GamesPLayed "+ numOfRounds);
    }

    public static int numberOfRounds(String startTime, String finishTime) {

        int startHr = Integer.parseInt(startTime.split(":")[0]);
        int startMin = Integer.parseInt(startTime.split(":")[1]);

        int endHr = Integer.parseInt(finishTime.split(":")[0]);
        int endMin = Integer.parseInt(finishTime.split(":")[1]);

        if(startMin%15!=0){
            startMin = startMin +(15- startMin%15);
        }

        if(endMin%15!=0){
            endMin=endMin-(endMin%15);
        }
        int gamesPlayed = 0;
        int totalStartMin = (startHr*60+startMin);
        int totalEndMin = (endHr*60+endMin);
        if(totalStartMin<=totalEndMin) {
            gamesPlayed = ((endHr * 60 + endMin) - (startHr * 60 + startMin)) / 15;
        }else{
            gamesPlayed = ((24*60)+(endHr*60+endMin) - (startHr*60+startMin))/15;
        }

        return gamesPlayed;


    }
}
