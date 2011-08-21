package com.bigdicegames.soundsample.core;

import java.util.ArrayList;

import forplay.core.Game;
import static forplay.core.ForPlay.graphics;
import static forplay.core.ForPlay.mouse;
import forplay.core.AssetWatcher;
import forplay.core.ForPlay;
import forplay.core.Game;
import forplay.core.GroupLayer;
import forplay.core.Mouse;
import forplay.core.SurfaceLayer;
import static forplay.core.ForPlay.log;


public class SoundSampleGame implements Game, Mouse.Listener  {
	ArrayList<SoundWidget> widgets = new ArrayList<SoundWidget>();
	
	@Override
	public void init() {
		graphics().setSize(800, 240);
		GroupLayer groupLayer = graphics().createGroupLayer();
		graphics().rootLayer().add(groupLayer);
		widgets.add(new SoundWidget("sounds/freesoundproject_28917__junggle__btn107", 0, groupLayer));
		widgets.add(new SoundWidget("sounds/freesoundproject_12742__Leady__reverse_fill_effect", 60, groupLayer));
		widgets.add(new SoundWidget("sounds/lovelace_0", 120, groupLayer));
		widgets.add(new SoundWidget("sounds/title", 180, groupLayer));
		
	    mouse().setListener(this);
	}

	@Override
	public void update(float delta) {
		for (SoundWidget w : widgets) {
			w.update(delta);
		}
	}

	@Override
	public void paint(float alpha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updateRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void onMouseDown(float x, float y, int button) {
		for (SoundWidget w : widgets) {
			w.onMouseDown(x, y, button);
		}
	}

	@Override
	public void onMouseUp(float x, float y, int button) {
		for (SoundWidget w : widgets) {
			w.onMouseUp(x, y, button);
		}
	}

	@Override
	public void onMouseMove(float x, float y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseWheelScroll(float velocity) {
		// TODO Auto-generated method stub
		
	}

}
