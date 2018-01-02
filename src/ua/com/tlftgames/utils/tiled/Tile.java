package ua.com.tlftgames.utils.tiled;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface Tile {
	
	public void setX(float x);

	public float getX();

	public void setY(float y);

	public float getY();

	public TextureRegion getRegion();

	public float getWidth();

	public float getHeight();
}
