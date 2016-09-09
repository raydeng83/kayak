import com.ldeng.Location
import spock.lang.Specification

/**
 * Created by Le on 9/8/2016 0008.
 */
class LocationSpec extends Specification{

    def "set location"() {
        given:
            Location<Integer, Integer> location = new Location();

        when:
            location.setLocation(-1, 3);

        then:
            -1 == location.getX();
            3 == location.getY();
    }
}
