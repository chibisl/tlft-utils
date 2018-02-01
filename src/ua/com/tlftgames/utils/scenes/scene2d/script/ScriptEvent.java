package ua.com.tlftgames.utils.scenes.scene2d.script;

public class ScriptEvent {
    private int id;
    private Object data;

    public ScriptEvent(int id) {
        this.id = id;
    }

    public ScriptEvent(int id, Object data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return this.id;
    }

    public Object getData() {
        return this.data;
    }
}
