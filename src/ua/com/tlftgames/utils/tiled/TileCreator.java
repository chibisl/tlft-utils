package ua.com.tlftgames.utils.tiled;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.utils.Array;

import ua.com.tlftgames.utils.tiled.AnimationTile;
import ua.com.tlftgames.utils.tiled.CellTile;
import ua.com.tlftgames.utils.tiled.TextureRegionTile;

public class TileCreator {
	public static CellTile createFromTiledMapTile(TiledMapTile tile) {
		if (tile instanceof AnimatedTiledMapTile) {
			return createFromAnimatedTiledMapTile((AnimatedTiledMapTile)tile);
		} else {
			return createFromStaticTiledMapTile((StaticTiledMapTile)tile);
		}
	}

	private static CellTile createFromStaticTiledMapTile(StaticTiledMapTile tile) {
		return new TextureRegionTile(tile.getTextureRegion());
	}

	private static CellTile createFromAnimatedTiledMapTile(AnimatedTiledMapTile tile) {
		int keysCount = tile.getFrameTiles().length; 
		if (keysCount == 0) {
			return null;
		}
		Array<TextureRegion> keys = new Array<TextureRegion>();
		for (int i = 0; i < keysCount; i++) {
			keys.add(tile.getFrameTiles()[i].getTextureRegion());
		}
		float keyDuration = (float)tile.getAnimationIntervals()[0] / 1000;
		boolean loop = tile.getProperties().get("loop", true, Boolean.class);
		
		Animation<TextureRegion> animation = new Animation<TextureRegion>(keyDuration, keys, loop ? PlayMode.LOOP : PlayMode.NORMAL);
		return new AnimationTile(animation);
	}
}
