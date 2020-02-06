package homeworks.homework1;

import homeworks.control.exeption.IllegalDataException;
import homeworks.control.services.ServiseImpl;


public class TrafficLight extends ServiseImpl {

    @Override
    public String getResult(String userRequest) {
        Double time = parse(userRequest);
        return setColor(time);
    }

    public String setColor(Double time){
        if (time > 10){
            time = time%10;
        }
        if (0<=time && time<=3){
            return TrSignal.RED.toString();
        } else if(3<time && time<=5){
            return TrSignal.YEllOW.toString();
        } else if (5<time && time<=10){
            return TrSignal.GREEN.toString();
        } else {
            throw new IllegalDataException(String.format("%f must be positive",time));
        }
    }
    private Double parse(String request){
        String[] temp = request.replaceAll("[_|.;, ]",":").split(":");
        Double time;
        if (temp.length >= 2){
            Integer minutes = chekInt(temp[0]);
            Integer seconds = chekInt(temp[1]);
            time = minutes + (int)(seconds/60) + (double)seconds%60/60;
            return time;
        } else if (temp.length == 1){
            Integer minutes = chekInt(temp[0]);
            time = (double)minutes;
            return time;
        } else {
            throw new IllegalDataException(String.format("%s not in format \"mm : ss\" or \"mm\"",request));
        }
    }


}

