package homework.homework3.allInAll;

import homework.homework3.pyramidGenerator.PyramidGenerator;
import homework.homework3.randomCharGenerator.RandomCharGenerator;
import homework.homework3.strategyCharGenerator.StrategyCharGenerator;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadController {

    public static final Object sync = new Object();


    public void start() {

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {

                String[] userInput = getUserInput(reader);
                String numberOfLevelsForPyramid = userInput[0];
                String rowsAndColumnsRandom = userInput[1];
                String rowsAndColumnsStrategy = userInput[2];
                String userStrategy = userInput[3];

                if (numberOfLevelsForPyramid.equalsIgnoreCase("exit")
                        || rowsAndColumnsRandom.equalsIgnoreCase("exit")
                        || rowsAndColumnsStrategy.equalsIgnoreCase("exit")
                        || userStrategy.equalsIgnoreCase("exit")) {
                    break;
                }

                List<Runnable> runnableTasks = getTasks(numberOfLevelsForPyramid, rowsAndColumnsRandom,
                        rowsAndColumnsStrategy, userStrategy);

                List<Future<?>> checkList = new ArrayList<>();
                for (Runnable task: runnableTasks) {
                    checkList.add(executor.submit(task));
                }

                waitUntilAllDone(checkList);
            }

            executor.shutdown();
            while (!executor.isTerminated()) {
                executor.awaitTermination(100,TimeUnit.MILLISECONDS);
            }
            System.out.println("Controller stopped!");

        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    private void waitUntilAllDone(List<Future<?>> checkList) throws InterruptedException {
        while (true) {
            int sum = 0;
            for (Future<?> task : checkList) {
                if (task.isDone()) {
                    sum++;
                }
            }
            if (sum == checkList.size()) {
                break;
            } else {
                Thread.sleep(100);
            }
        }
    }

    @SneakyThrows
    private String[] getUserInput (BufferedReader reader) {

        System.out.println("\n********************************************");

        System.out.print("Enter number of levels for pyramid: ");
        String numberOfLevelsForPyramid = reader.readLine();
        System.out.println("********************************************");

        System.out.print("Enter 'rows columns' for random char generator: ");
        String rowsAndColumnsRandom = reader.readLine();
        System.out.println("********************************************");

        System.out.print("Enter 'rows columns' for strategy char generator: ");
        String rowsAndColumnsStrategy = reader.readLine();
        System.out.print("Select strategy even/odd: ");
        String userStrategy = reader.readLine();
        System.out.println("********************************************");

        return new String[]{numberOfLevelsForPyramid, rowsAndColumnsRandom, rowsAndColumnsStrategy, userStrategy};
    }

    private List<Runnable> getTasks (String numberOfLevelsForPyramid,
                                     String rowsAndColumnsRandom,
                                     String rowsAndColumnsStrategy, String userStrategy) {

        Runnable pyramidTask = getPyramidTask(numberOfLevelsForPyramid);

        Runnable randomCharTask = getRandomCharTask(rowsAndColumnsRandom);

        Runnable strategyCharTask = getStrategyCharTask(rowsAndColumnsStrategy, userStrategy);

        List<Runnable> runnableTasks = new ArrayList<>();
        runnableTasks.add(pyramidTask);
        runnableTasks.add(randomCharTask);
        runnableTasks.add(strategyCharTask);

        return runnableTasks;
    }

    private Runnable getStrategyCharTask(String rowsAndColumnsStrategy, String userStrategy) {
        return () -> {
                StrategyCharGenerator generator = new StrategyCharGenerator();
                generator.generate(rowsAndColumnsStrategy, userStrategy);
            };
    }

    private Runnable getRandomCharTask(String rowsAndColumnsRandom) {
        return () -> {
                RandomCharGenerator generator = new RandomCharGenerator();
                generator.generate(rowsAndColumnsRandom);
            };
    }

    private Runnable getPyramidTask(String numberOfLevelsForPyramid) {
        return () -> {
                PyramidGenerator generator = new PyramidGenerator();
                generator.generate(numberOfLevelsForPyramid);
            };
    }
}


