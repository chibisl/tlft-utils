package ua.com.tlftgames.utils.tiled;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureRegionTile extends CellTile {
	private TextureRegion region;

	public TextureRegionTile(TextureRegion region) {
		this.region = region;
	}
	
	public void setRegion(TextureRegion region) {
		this.region = region;
	}

	public TextureRegion getRegion() {
		return region;
	}
}
