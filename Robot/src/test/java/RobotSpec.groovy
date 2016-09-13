import com.ldeng.Location
import com.ldeng.Robot
import com.ldeng.enums.Command
import com.ldeng.enums.Direction
import spock.lang.Specification

/**
 * Created by Le on 9/8/2016 0008.
 *
 * Unit test for Robot class
 */
class RobotSpec extends Specification {

    def "default robot location should be [0,0] and direction should be FORWARD"() {
        given:
        Robot robot = new Robot()

        expect:
        0 == robot.getLocation().getX()
        0 == robot.getLocation().getY()
        Direction.FORWARD == robot.getDirection()
    }

    def "robot can turn left"() {
        given:
        Robot robot = new Robot()

        when:
        robot.turnLeft()

        then:
        Direction.LEFT == robot.getDirection();
    }

    def "robot can turn right"() {
        given:
        Robot robot = new Robot()

        when:
        robot.turnRight()

        then:
        Direction.RIGHT == robot.getDirection();
    }

    def "robot can move forward"() {
        given:
        Robot robot = new Robot()

        when:
        robot.turnRight()
        robot.forward()

        then:
        1 == robot.getLocation().getX()
        0 == robot.getLocation().getY()
    }

    def "can set robot location on the fly"() {
        given:
        Robot robot = new Robot()

        when:
        robot.setLocation(new Location(-2, 4))

        then:
        -2 == robot.getLocation().getX()
        4 == robot.getLocation().getY()
    }

    def "can parse command"() {
        given:
        Robot robot = new Robot()

        when:
        robot.commandParser("LFR")

        then:
        Command.TURN_LEFT == robot.getCommandList().get(0)
        Command.MOVE_FORWARD == robot.getCommandList().get(1)
        Command.TURN_RIGHT == robot.getCommandList().get(2)
    }

    def "can execute command"() {
        given:
        Robot robot = new Robot()

        when:
        robot.commandParser("RFRFLF")
        robot.execute()

        then:
        2 == robot.getLocation().getX()
        -1 == robot.getLocation().getY()
    }

}
