package ua.com.tlftgames.utils.scenes.scene2d;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

import ua.com.tlftgames.utils.scenes.scene2d.script.Script;
import ua.com.tlftgames.utils.scenes.scene2d.script.ScriptEvent;

public class ScriptActor extends Actor {
    private Array<Script> scripts = new Array<Script>();

    public void addScript(Script script) {
        script.setActor(this);
        this.scripts.add(script);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        Array<Script> scripts = this.scripts;
        if (scripts.size > 0) {
            for (int i = 0; i < scripts.size; i++) {
                scripts.get(i).act(delta);
            }
        }
    }

    public void dispatch(ScriptEvent event) {
        Array<Script> scripts = this.scripts;
        if (scripts.size > 0) {
            for (int i = 0; i < scripts.size; i++) {
                scripts.get(i).handle(event);
            }
        }
    }

    public void dispatch(int eventId) {
        this.dispatch(new ScriptEvent(eventId));
    }
}
