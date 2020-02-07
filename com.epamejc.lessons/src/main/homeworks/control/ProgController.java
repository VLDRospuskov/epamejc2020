package homeworks.control;

import homeworks.control.commands.Commands;

import homeworks.control.exeption.IllegalDataException;
import homeworks.control.services.Service;
import homeworks.homework1.TrafficLight;
import homeworks.homework2.arrays.Pyramid;
import homeworks.homework2.arrays.RandomChar;
import homeworks.homework2.arrays.strategy.MakeString;
import homeworks.homework2.recursion.CountNums;
import homeworks.homework2.recursion.Exponentiation;
import homeworks.homework2.recursion.FibonacciNumbers;
import homeworks.homework2.strings.EvenOdd;
import homeworks.homework2.strings.MakeWord;
import homeworks.homework2.strings.RewerseWords;
import homeworks.homework2.strings.SwitchChar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ProgController implements Aplication {

    Map<Commands, Service> services;
    public ProgController(){
        services = getServiceMap();
    }
    @Override
    public void action() {
        String Stop = "/stop";
        String list = "/list";
        System.out.println("Приветствую");
        System.out.println("Список моих команд:");
        System.out.println(getCommandList());
        boolean isStoped = false;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (!isStoped){
                String userRequest = reader.readLine();
                if (userRequest.equals(Stop)){
                    isStoped = true;
                } else if (userRequest.equals(list)){
                    System.out.println(getCommandList());
                } else{
                    initService(userRequest);
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    private void initService(String userRequest){
        Service service;
        try{
            String[] commands = getSplit(userRequest);
            if (isCommand(commands[0])) {
                service = getService(commands[0]);
                String body = getBody(commands);
                System.out.println(service.getResult(body));
            } else {
                throw new IllegalDataException(commands[0] + " is not a command, " +
                        "push \"/list\" for command list");
            }
        } catch (IllegalDataException ex){
            System.out.println(ex.getMessage());
        }
    }
    private String getCommandList(){
        StringBuilder sb = new StringBuilder();
        for (Commands commands : Commands.values()){
            sb.append(commands.getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }
    private String getBody(String[] request){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < request.length; i++){
            if (i == request.length-1){
                sb.append(request[i]);
            }else {
                sb.append(request[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    private Service getService(String request){
        for (Map.Entry<Commands,Service> pair : services.entrySet()){
            if (pair.getKey().toString().equals(request.substring(1))){
                return pair.getValue();
            }
        }
        throw new IllegalDataException(request + " is not in command list");
    }
    private Map<Commands,Service> getServiceMap(){
        Map<Commands,Service> services = new HashMap<>();
        services.put(Commands.TRAFFICLIGHT,new TrafficLight());
        services.put(Commands.EVENODDSTR, new MakeString());
        services.put(Commands.PYRAMID, new Pyramid());
        services.put(Commands.RANDOMCHAR, new RandomChar());
        services.put(Commands.COUNTNUMS, new CountNums());
        services.put(Commands.POW, new Exponentiation());
        services.put(Commands.FIBONACCI,new FibonacciNumbers());
        services.put(Commands.EVENODD,new EvenOdd());
        services.put(Commands.MAKEWORD,new MakeWord());
        services.put(Commands.REWERSEWORD,new RewerseWords());
        services.put(Commands.SWITHCHAR,new SwitchChar());
        return services;
    }
    private String[] getSplit(String userRequest){
        String[] temp = userRequest.split("\\s+");
        if (temp.length >= 2){
            return temp;
        } else {
            throw new IllegalDataException(userRequest + " request must contain command \"/expo\"(for example) and body");
        }
    }
    private boolean isCommand(String command){
       for (Map.Entry<Commands,Service> pair : services.entrySet()){
           if (command.startsWith("/") && pair.getKey().toString().equals(command.substring(1))){
               return true;
           }
       }
       return false;
    }
}
