package ua.com.tlftgames.utils.scenes.scene2d;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.scenes.scene2d.Stage;

import ua.com.tlftgames.utils.core.GameCore;

abstract public class ManagedStage extends Stage {

	public ManagedStage() {
		super();
	}
	
	protected synchronized <T> void loadAsset(String fileName, Class<T> type) {
		GameCore.getAssetManager().load(fileName, type);
	}
	
	protected synchronized <T> void loadAsset(String fileName, Class<T> type, AssetLoaderParameters<T> parameter) {
		GameCore.getAssetManager().load(fileName, type, parameter);
	}
	
	public synchronized void unloadAsset(String fileName) {
		GameCore.getAssetManager().unload(fileName);
	}
	
	protected synchronized <T> T getAsset (String fileName, Class<T> type) {
		return GameCore.getAssetManager().get(fileName, type);
	}
	
	protected synchronized <T> T getAsset (String fileName) {
		return GameCore.getAssetManager().get(fileName);
	}
	
	abstract public void showLoader();

	abstract public void addAssets();
	
	abstract public void uloadAssets();
	
	abstract public void show();
	
}
