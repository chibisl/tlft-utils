package ua.com.tlftgames.utils.scenes.scene2d.script;

import ua.com.tlftgames.utils.scenes.scene2d.ScriptActor;

public class Script {
    protected ScriptActor actor;

    public void setActor(ScriptActor actor) {
        this.actor = actor;
    }

    public void act(float delta) {
        // Nothing to do here
    }

    public void handle(ScriptEvent event) {
        // Nothing to do here
    }

}
