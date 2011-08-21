package com.bigdicegames.soundsample.entry.java;

import com.bigdicegames.soundsample.core.SoundSampleGame;

import forplay.core.ForPlay;
import forplay.java.JavaAssetManager;
import forplay.java.JavaPlatform;

public class SoundSampleEntryJava {
	public static void main(String[] args) {
		JavaAssetManager assets = JavaPlatform.register().assetManager();
		assets.setPathPrefix("src/com/bigdicegames/soundsample/resources");
		ForPlay.run(new SoundSampleGame());
	}
}
