import com.ldeng.Location
import spock.lang.Specification

/**
 * Created by Le on 9/8/2016 0008.
 *
 * Unit test for Location class
 */
class LocationSpec extends Specification{

    def "can set location"() {
        given:
            Location<Integer, Integer> location = new Location();

        when:
            location.setLocation(-1, 3);

        then:
            -1 == location.getX();
            3 == location.getY();
    }
}
