package com.bigdicegames.soundsample.core;

import static forplay.core.ForPlay.graphics;
import static forplay.core.ForPlay.log;

import java.util.ArrayList;

import forplay.core.GroupLayer;
import static forplay.core.ForPlay.assetManager;

import forplay.core.AssetWatcher;
import forplay.core.Image;
import forplay.core.ImageLayer;
import forplay.core.ResourceCallback;
import forplay.core.Sound;
import forplay.core.Surface;


public class SoundWidget {
	private GroupLayer parentLayer;
	private GroupLayer myGroupLayer;
	private Image playButtonImage;
	private Image stopButtonImage;
	private Image loopButtonImage;
	private ImageLayer playButtonLayer;
	private ImageLayer stopButtonLayer;
	private ImageLayer loopButtonLayer;
	private Sound sound;
	private boolean looping;
	private String assetName;
	private int displayPosition;
	private Button playButton;
	
	ArrayList<Button> buttons = new ArrayList<Button> ();
	private Button stopButton;
	private Button loopButton;

	public SoundWidget(String assetName, int displayPosition, GroupLayer groupLayer) {
		this.assetName = assetName;
		this.displayPosition = displayPosition;
		parentLayer = groupLayer;
		myGroupLayer = graphics().createGroupLayer();
		myGroupLayer.setTranslation(0, displayPosition);
		parentLayer.add(myGroupLayer);

		playButton = new Button(myGroupLayer, "images/playButton.png", "images/playButtonDown.png", 0, false); 
		buttons.add(playButton);
		playButton.setClickAction(new Button.ClickAction() {
			@Override
			public void onClick() {
				play();
			}
		});
		
		stopButton = new Button(myGroupLayer, "images/stopButton.png", "images/stopButtonDown.png", 50, false); 
		buttons.add(stopButton);
		stopButton.setClickAction(new Button.ClickAction() {
			@Override
			public void onClick() {
				stop();
			}
		});
		
		loopButton = new Button(myGroupLayer, "images/loopButtonUp.png", "images/loopButtonDown.png", 100, false); 
		buttons.add(loopButton);
		loopButton.setClickAction(new Button.ClickAction() {
			@Override
			public void onClick() {
				setLooping(!isLooping());
			}
		});
		
		sound = assetManager().getSound(assetName);
	}

	public void update(float delta) {
		playButton.setDown(isPlaying());
		loopButton.setDown(isLooping());
	}

	private void play() {
		if (!sound.play()) {
            log().error("cannot play " + assetName);
		}
	}
	
	private void stop() {
		sound.stop();
	}
	
	private void setLooping(boolean loop) {
		looping = loop;
		sound.setLooping(loop);
	}
	
	private boolean isPlaying() {
		return sound.isPlaying();
	}
	
	private boolean isLooping() {
		return looping;
	}

	public void onMouseDown(float x, float y, int button) {
		float localX = x;
		float localY = y - displayPosition;
		
		for (Button b : buttons) {
			b.onMouseDown(localX, localY, button);
		}
	}

	public void onMouseUp(float x, float y, int button) {
		// TODO Auto-generated method stub
		
	}
}
