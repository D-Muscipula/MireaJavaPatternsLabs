package Labs.task7.facade;

import java.util.ArrayList;
import java.util.List;

public class Facade {
    List<DifficultThing> list = new ArrayList<>(){{
        add(new DifficultThing1());
        add(new DifficultThing2());
        add(new DifficultThing3());
    }};

    public void doEasy() {
        for (DifficultThing difficultThing : list) {
            difficultThing.doSomethingHard();
        }
    }
}
