package Labs.task7.component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{
    List<Component> componentList = new ArrayList<>();
    void add(Component c) {
        componentList.add(c);
    }

    void remove(Component c) {
        componentList.remove(c);
    }

    Component getChild(int i) {
        return componentList.get(i);
    }

    @Override
    public void operation() {
        System.out.println("Composite Operation");
        for (var v: componentList){
            v.operation();
        }
    }
}
