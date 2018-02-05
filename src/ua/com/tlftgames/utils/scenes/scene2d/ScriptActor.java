package ua.com.tlftgames.utils.scenes.scene2d;

import java.util.Collection;
import java.util.HashMap;

import com.badlogic.gdx.scenes.scene2d.Actor;

import ua.com.tlftgames.utils.scenes.scene2d.script.Script;
import ua.com.tlftgames.utils.scenes.scene2d.script.ScriptEvent;

public class ScriptActor extends Actor {
    private HashMap<Class<? extends Script>, Script> scripts = new HashMap<Class<? extends Script>, Script>();

    public <T extends Script> T getScript(Class<T> type) {
        return type.cast(scripts.get(type));
    }

    public <T extends Script> boolean hasScript(Class<T> type) {
        return scripts.get(type) != null;
    }

    public <T extends Script> void addScript(T script) {
        script.setActor(this);
        scripts.put(script.getClass(), script);
    }

    public <T extends Script> void removeScript(Class<T> type) {
        scripts.remove(type);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        Collection<Script> scripts = this.scripts.values();
        if (scripts.size() > 0) {
            for (Script script : scripts) {
                script.act(delta);
            }
        }
    }

    public void dispatch(ScriptEvent event) {
        Collection<Script> scripts = this.scripts.values();
        if (scripts.size() > 0) {
            for (Script script : scripts) {
                script.handle(event);
            }
        }
    }

    public void dispatch(int eventId) {
        this.dispatch(new ScriptEvent(eventId));
    }
}
