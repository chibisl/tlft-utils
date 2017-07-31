package ua.com.tlftgames.utils.scenes.scene2d;

import java.util.HashMap;

import com.badlogic.gdx.scenes.scene2d.Actor;

import ua.com.tlftgames.utils.component.Component;

public class ComponentActor extends Actor {
    private HashMap<Class<? extends Component>, Object> components = new HashMap<Class<? extends Component>, Object>();

    public <T extends Component> T getComponent(Class<T> type) {
        return type.cast(components.get(type));
    }

    public <T extends Component> void addComponent(Class<T> type, T component) {
        component.setObject(this);
        components.put(type, component);
    }

    public <T extends Component> void removeComponent(Class<T> type) {
        components.remove(type);
    }
}
