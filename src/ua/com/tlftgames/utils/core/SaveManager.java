package ua.com.tlftgames.utils.core;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class SaveManager {
	
	private Preferences save;
	
	public SaveManager(String gameName) {
		if (Gdx.app.getType() == ApplicationType.Android) {
            this.save = Gdx.app.getPreferences(gameName.replace(" ", "_") + "_save");
        } else {
            this.save = Gdx.app.getPreferences("../" + gameName.replace(" ", "_") + "/save");
        }
	}
	
	public int loadInteger(String key, int defaultValue) {
        return this.save.getInteger(key, defaultValue);
    }
	
	public int loadInteger(String key) {
        return this.save.getInteger(key);
    }
	
	public String loadString(String key, String defaultValue) {
        return this.save.getString(key, defaultValue);
    }
	
	public String loadString(String key) {
        return this.save.getString(key);
    }
	
	public Boolean loadBoolean(String key, Boolean defaultValue) {
        return this.save.getBoolean(key, defaultValue);
    }
	
	public Boolean loadBoolean(String key) {
        return this.save.getBoolean(key);
    }
	
	public float loadFloat(String key, float defaultValue) {
        return this.save.getFloat(key, defaultValue);
    }
	
	public float loadFloat(String key) {
        return this.save.getFloat(key);
    }
	
	public long loadLong(String key, long defaultValue) {
        return this.save.getLong(key, defaultValue);
    }
	
	public long loadLong(String key) {
        return this.save.getLong(key);
    }
	
	public void saveInteger(String key, int value) {
		this.save.putInteger(key, value).flush();
	}
	
	public void saveString(String key, String value) {
		this.save.putString(key, value).flush();
	}
	
	public void saveBoolean(String key, boolean value) {
		this.save.putBoolean(key, value).flush();
	}
	
	public void saveFloat(String key, float value) {
		this.save.putFloat(key, value).flush();
	}
	
	public void saveLong(String key, long value) {
		this.save.putLong(key, value).flush();
	}
	
	public void clear() {
		this.save.clear();
		this.save.flush();
	}
	
}
