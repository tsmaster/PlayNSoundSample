package com.bigdicegames.soundsample.core;

import static forplay.core.ForPlay.assetManager;
import static forplay.core.ForPlay.graphics;
import static forplay.core.ForPlay.log;
import forplay.core.GroupLayer;
import forplay.core.Image;
import forplay.core.ImageLayer;
import forplay.core.ResourceCallback;

public class Button {
	private ImageLayer upImageLayer;
	private ImageLayer downImageLayer;
	private GroupLayer parentLayer;
	private int xPos;
	private ClickAction clickAction;
	boolean isDown = false;
	int width;
	int height;

	public Button(GroupLayer parentLayer, final String upImageName, String downImageName, int xPos, boolean toggle) {
		this.xPos = xPos;
		Image upImage = assetManager().getImage(upImageName);
		upImage.addCallback(new ResourceCallback<Image>(){
			@Override
			public void done(Image resource) {
				width = resource.width();
				height = resource.height();
			}

			@Override
			public void error(Throwable err) {
				log().error("Failed to load "+upImageName);
				log().error(err.toString());
			}});
		Image downImage = assetManager().getImage(downImageName);
		upImageLayer = graphics().createImageLayer(upImage);
		downImageLayer = graphics().createImageLayer(downImage);
		upImageLayer.setTranslation(xPos, 0);
		downImageLayer.setTranslation(xPos, 0);
		
		this.parentLayer = parentLayer;
		parentLayer.add(upImageLayer);
	}

	public void setDown(boolean isDown) {
		if(this.isDown == isDown) {
			return;
		}
		this.isDown = isDown;
		if (isDown) {
			parentLayer.add(downImageLayer);
			parentLayer.remove(upImageLayer);
		} else {
			parentLayer.add(upImageLayer);
			parentLayer.remove(downImageLayer);
		}
	}

	public void onMouseDown(float x, float y, int button) {
		float localX = x-xPos;
		float localY = y;
		
		if (localX > 0 && localX < width && localY > 0 && localY < height) {
			if (clickAction != null) {
				clickAction.onClick();
			}
		}
	}
	
	public void setClickAction(ClickAction action) {
		clickAction = action;
	}
	
	public interface ClickAction {
		public void onClick();
	}
}
