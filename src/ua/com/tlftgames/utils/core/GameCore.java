package ua.com.tlftgames.utils.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.assets.AssetManager;

public class GameCore {

	private static String gameName = "Dummy_Game";
	private static AssetManager assetManager;
	private static SaveManager saveManager;
	private static Preferences settings;

	public static void setGameName(String name) {
		gameName = name;
	}

	public static String getGameName() {
		return gameName;
	}
	
	public static AssetManager getAssetManager() {
		if (assetManager == null) {
			assetManager = new AssetManager();
		}

		return assetManager;
	}
	
	public static SaveManager getSaveManager() {
		if (saveManager == null) {
			saveManager = new SaveManager(gameName);
		}

		return saveManager;
	}
	
	public static Preferences getSettings() {
		if (settings == null) {
			if (Gdx.app.getType() == ApplicationType.Android) {
				settings = Gdx.app.getPreferences(gameName.replace(" ", "_") + "_settings");
	        } else {
	        	settings = Gdx.app.getPreferences("../" + gameName.replace(" ", "_") + "/settings");
	        }
		}

		return settings;
	}

	public static void clear() {
		gameName = null;
		if (assetManager != null) {
			assetManager.clear();
			assetManager = null;
		}		
		saveManager = null;
		settings = null;
	}
}
