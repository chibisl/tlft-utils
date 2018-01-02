package ua.com.tlftgames.utils.tiled;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationTile extends CellTile {
	private Animation<TextureRegion> animation;
	private float stateTime = 0;

	public AnimationTile(Animation<TextureRegion> animation) {
		this.animation = animation;
	}
	
	private void updateStateTime() {
		this.stateTime += Gdx.graphics.getDeltaTime();
		if (this.stateTime > animation.getAnimationDuration() && animation.getPlayMode() != PlayMode.NORMAL) {
			this.stateTime -= animation.getAnimationDuration();
		}
	}

	public TextureRegion getRegion() {
		this.updateStateTime();
		return animation.getKeyFrame(stateTime);
	}
	
	public void reset() {
		this.stateTime = 0;
	}
	
	public float getDuration() {
		return this.animation.getAnimationDuration();
	}
	
	public boolean isFinished() {
		return this.animation.isAnimationFinished(stateTime);
	}
}
