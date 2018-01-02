package ua.com.tlftgames.utils.tiled;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class CellTile implements Tile {
	private float x = 0;
	private float y = 0;
	private float width = 0;
	private float height = 0;
	
	public void setX(float x) {
		this.x = x;
	}

	public float getX() {
		return x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getY() {
		return y;
	}
	
	public void setWidth(float width) {
		this.width = width;
	}

	public float getWidth() {
		return width;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}

	public float getHeight() {
		return height;
	}

	public float getRealX() {
		return x * width;
	}

	public float getRealY() {
		return y * height;
	}
	
	abstract public TextureRegion getRegion();
}
