package main.homeworks.homework1;

import main.homeworks.homework2.prog.Programm;

import java.io.IOException;




public class TrafficLight extends Programm {
    public static void main(String[] args) throws IOException {
        new TrafficLight().go();
    }
    @Override
    public String startString() {
        return STARTTRAFFIC;
    }

    @Override
    public String secondInputString() {
        return null;
    }

    @Override
    public int inputtimes() {
        return 1;
    }

    @Override
    public String makeResult(String Finput, String Sinput) {
        String result = ALERTDATA;
        Double time = parse(Finput);
        if (time != null){
            result = setColor(time);
        }
        return result;
    }
    public String setColor(Double time){
        String result = ALERTDATA;

        if (time > 10){
            time = time%10;
        }
        if (0<=time && time<=3){
            return TrSignal.RED.toString();
        } else if(3<time && time<=5){
            return TrSignal.YEllOW.toString();
        } else if (5<time && time<=10){
            return TrSignal.GREEN.toString();
        }

        return result;
    }
    private Double parse(String request){
        String[] temp = request.replaceAll("[_|.;, ]",":").split(":");
        Double minutes = null;
        Double seconds = null;
        Double time = null;
        if (temp.length == 2){
            minutes = chekDouble(temp[0]);
            seconds = chekDouble(temp[1]);
        } else if (temp.length == 1){
            minutes = chekDouble(temp[0]);
        }
        if (minutes != null && seconds != null){
            time = minutes + (int)(seconds/60) + seconds%60/60;
        } else if(minutes!= null){
            time = minutes;
        }

       return time;
    }
}

