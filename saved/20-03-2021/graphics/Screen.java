package com.mindofmodz.lostlands.graphics;

import java.util.Random;

import com.mindofmodz.lostlands.Game;

public class Screen extends Render {

	private Render test;

	public Screen(int width, int height) {
		super(width, height);
		Random random = new Random();
		test = new Render(256, 256);
		for (int i = 0; i < 256 * 256; i++) {
			test.pixels[i] = random.nextInt() * (random.nextInt(5) / 4);
		}

	}

	public void render(Game game) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = 0;
		}

		for (int i = 0; i < 50; i++) {
			int anim = (int) (Math.sin((game.time + i * 2) % 1000.0 / 100) * 100);
			int anim2 = (int) (Math.cos((game.time + i * 2) % 1000.0 / 100) * 100);

			draw(test, (width - 256) / 2 + anim, (height - 256) / 2 + anim2);
		}
	}
}
