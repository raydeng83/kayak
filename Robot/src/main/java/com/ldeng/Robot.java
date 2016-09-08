package com.ldeng;

import com.ldeng.enums.Command;
import com.ldeng.enums.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le on 9/7/2016 0007.
 */
public class Robot {
    private Location<Integer, Integer> location;
    private Direction direction;
    private List<Command> commandList;
    private int x;
    private int y;

    public Robot() {
        this.x=0;
        this.y=0;
        this.location=new Location<>(x,y);
        this.direction=Direction.FORWARD;
        this.commandList = new ArrayList<>();
    }

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

    public String getCurrentLocation() {
        return location.toString();
    }

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
