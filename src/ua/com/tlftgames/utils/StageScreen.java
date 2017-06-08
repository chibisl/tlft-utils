package ua.com.tlftgames.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FitViewport;

import ua.com.tlftgames.utils.core.GameCore;
import ua.com.tlftgames.utils.scenes.scene2d.ManagedStage;

public class StageScreen implements Screen {
	
	private boolean stageLoaded = false;
	private ManagedStage stage;
	private int width;
	private int height;
	
	public StageScreen(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void setStage(final ManagedStage stage) {
        Gdx.input.setInputProcessor(null);
        this.updateStage(stage);
    }

    protected void updateStage(ManagedStage stage) {
        if (this.stage != null) {
        	this.stage.uloadAssets();
            this.stage.dispose();
        }
        this.stage = stage;
        Gdx.input.setInputProcessor(this.stage);
        this.stage.setViewport(new FitViewport(this.width, this.height));
        this.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.stage.showLoader();
        this.stage.addAssets();
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void render(float delta) {
    	if (this.stage == null) {
    		return;
    	}
    	if (!this.stageLoaded && GameCore.getAssetManager().update()) {
    		this.stageLoaded = true;
    		this.stage.show();
    	}
        getStage().act(delta);
        Gdx.graphics.getGL20().glClearColor(0, 0, 0, 1);
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        getStage().draw();
    }

    @Override
    public void hide() {
        this.dispose();
    }

    @Override
    public void resize(int width, int height) {
    	if (this.stage == null) {
    		return;
    	}
        Vector2 size = Scaling.fit.apply(this.width, this.height, width, height);
        int viewportX = (int) (width - size.x) / 2;
        int viewportY = (int) (height - size.y) / 2;
        int viewportWidth = (int) size.x;
        int viewportHeight = (int) size.y;
        Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);
        this.stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        if (stage != null) {
            stage.dispose();
        }
    }

	@Override
	public void show() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

}
