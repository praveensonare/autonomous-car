package com.autonomous.car;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.Point;
import java.util.Scanner;

@Getter
@Setter
public class GameService {

    private static final int ADD_CAR = 1;
    private static final int RUN_SIMULATION = 2;
    private static final int EXIT_APP = 2;

    Scanner sc= new Scanner(System.in);
    private static ArrayList<Car> cars = new ArrayList<>();
    Map<Long, ArrayList<Car>> cMap = new HashMap<>();
    int maxCommandLength = 0;
    private GameService() {
    }

    public static GameService instance;
    public static GameService getInstance()
    {
        if( instance == null)
            instance = new GameService();

        return  instance;
    }

    public void init()
    {
        cars.clear();
        cMap.clear();
    }
    public void setField() {
        Field.getInstance().setWidth(sc.nextInt());
        Field.getInstance().setHeight(sc.nextInt());
        System.out.println("You have created a field of " + Field.getInstance().getWidth() + " x " + Field.getInstance().getHeight() +". ");
    }

    public void startupMenu(){
        System.out.println("Welcome to Auto Driving Car Simulation!\n\nPlease enter the width and height of the simulation field in x y format:");
        setField();
    }
    public void subMenu()
    {
        while( true ) {

            System.out.println("Please choose from the following options: \n" +
                    "[1] Add a car to field \n" +
                    "[2] Run simulation ");
            int option = sc.nextInt();
            switch (option) {
                case ADD_CAR -> {
                    addNewCar();
                    Status();
                }
                case RUN_SIMULATION -> {
                    runSimulation();
                    afterSimulationMessage();
                    return;
                }
            }
        }

    }

    void addNewCar() {
        Car car = new Car();
        System.out.println("Please enter the name of the car:");
        car.setName(sc.next());
        System.out.println("Please enter initial position of car " + car.getName() + " int x y Direction format");
        car.setPoint(new Point(sc.nextInt(), sc.nextInt()));
        car.setDirection(Utility.getDirection(sc.next()));
        System.out.println("Please enter the commands for car " + car.getName() + ":");
        car.setCommand(sc.next());
        maxCommandLength = (car.getCommand().length() > maxCommandLength) ? car.getCommand().length() : maxCommandLength;
        cars.add(car);
        
    }

    public void afterSimulationMessage()
    {
        System.out.println("Please choose from the following options: \n" +
                "[1] Start over \n" +
                "[2] Exit ");

        int option = sc.nextInt();
        if (option == EXIT_APP)
            exitApplication();
    }

    public void runSimulation()
    {
        Status();

        boolean isMoveSuccess;
        ArrayList<Car> simulationCars = new ArrayList<Car> (cars);
        for( int idx = 0; idx < maxCommandLength; ++idx) {
            for (Car car : simulationCars) {
                if (!car.moveCar(idx)) {
                    // no need to process cars 1. breakdown, 2. cmd finished
                    cars.remove(car);
                }
            }
        }

        System.out.println("After simulation, the result is:");

        for( Car car : cars ) {
            Point p = car.getPoint();
            if (car.isCarCollided()) {
                System.out.println(" - " + car.getName() + ", collides with " + getCollisionCars(car) +" at (" + p.x + "," + p.y + "), at step " + car.getStep());
            } else {
                System.out.println(" - " + car.getName() + ", (" + p.x + "," + p.y + "), " + car.getDirection().toString());
            }
        }

    }

    String getCollisionCars(Car car) {
        String carNames = "";
        long key = ((long) car.getPoint().x << 32) | car.getPoint().y;
        return carNames;
    }
    public void Status() {
        System.out.println("Your current list of cars are:");
        for( Car car : cars ) {
            System.out.println(" - " + car.getName() + ", (" + car.getPoint().x + "," + car.getPoint().y + "), " + car.getDirection().toString() +", " + car.getCommand() );
        }
    }

    public void exitApplication()
    {
        System.out.println("Thank you for running the simulation. Goodbye!");
        System.exit(0);
    }

}

