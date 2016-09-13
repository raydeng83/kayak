package com.ldeng;

import com.ldeng.enums.Command;
import com.ldeng.enums.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le on 9/7/2016 0007.
 *
 * A robot is abstracted with properties of Location, Direction and CommandList.
 *
 * Commands for robot includes TurnLeft, TurnRight and Forward.
 *
 * A command parser is used to parse the incoming command sequence.
 *
 * The execution method is called to execute the command sequence.
 */
public class Robot {
    private Location<Integer, Integer> location;
    private Direction direction;
    private List<Command> commandList;
    private int x;
    private int y;

    //Constructor to initialize the Robot; the assumed starting location is [0,0]
    public Robot() {
        this.x=0;
        this.y=0;
        this.location=new Location<>(x,y);
        this.direction=Direction.FORWARD;
        this.commandList = new ArrayList<>();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Location<Integer, Integer> getLocation() {
        return location;
    }

    public void setLocation(Location<Integer, Integer> location) {
        this.location = location;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }



    /**
     * Commands defined
     */
    public void turnLeft() {
        switch (direction) {
            case FORWARD: direction = Direction.LEFT; break;
            case LEFT: direction = Direction.BACKWARD; break;
            case RIGHT: direction = Direction.FORWARD; break;
            case BACKWARD: direction = Direction.RIGHT; break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case FORWARD: direction = Direction.RIGHT; break;
            case LEFT: direction = Direction.FORWARD; break;
            case RIGHT: direction = Direction.BACKWARD; break;
            case BACKWARD: direction = Direction.LEFT; break;
        }
    }

    public void forward() {
        switch (direction) {
            case FORWARD: location.setLocation(x,++y); break;
            case LEFT: location.setLocation(--x,y); break;
            case RIGHT: location.setLocation(++x, y); break;
            case BACKWARD: location.setLocation(x, --y); break;
        }
    }


    /**
     * Command Parser
     */
    public List<Command> commandParser(String commands) {
        for (char c : commands.toCharArray()) {
            switch (c) {
                case 'L': commandList.add(Command.TURN_LEFT);break;
                case 'R': commandList.add(Command.TURN_RIGHT);break;
                case 'F': commandList.add(Command.MOVE_FORWARD);break;
            }
        }

        return commandList;
    }

    /**
     * To execute command sequence after they have been parsed
     */
    public void execute () {
        for (Command command : commandList) {
            switch (command) {
                case TURN_LEFT: this.turnLeft();break;
                case TURN_RIGHT: this.turnRight();break;
                case MOVE_FORWARD: this.forward();break;
            }
            System.out.println("Command is "+command+"; Direction is "+direction+"; location is: "+location.toString
                    ());
        }
    }
}
