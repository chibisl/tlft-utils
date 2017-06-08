package ua.com.tlftgames.utils;

import com.badlogic.gdx.Game;

import ua.com.tlftgames.utils.core.GameCore;

public class StageGame extends Game {
	
	private int width;
	private int height;
	
	public StageGame(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void create() {
        this.setScreen(new StageScreen(this.width, this.height));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
    	GameCore.clear();
        super.dispose();
    }
    
    @Override
    public StageScreen getScreen() {
    	return (StageScreen)this.screen;
    }

}
