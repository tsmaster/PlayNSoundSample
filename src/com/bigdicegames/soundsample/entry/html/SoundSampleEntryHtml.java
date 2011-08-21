package com.bigdicegames.soundsample.entry.html;

import com.bigdicegames.soundsample.core.SoundSampleGame;

import forplay.core.ForPlay;
import forplay.html.HtmlAssetManager;
import forplay.html.HtmlGame;
import forplay.html.HtmlPlatform;

public class SoundSampleEntryHtml extends HtmlGame {
	@Override
	public void start() {
		HtmlAssetManager assets = HtmlPlatform.register().assetManager();
		assets.setPathPrefix("soundsample/");
		ForPlay.run(new SoundSampleGame());
	}
}
