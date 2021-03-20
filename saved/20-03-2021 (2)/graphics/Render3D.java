package com.mindofmodz.lostlands.graphics;

import com.mindofmodz.lostlands.Game;

public class Render3D extends Render {

	public Render3D(int width, int height) {
		super(width, height);
	}

	public void floor(Game game) {

		// floor and ceiling height
		double floorPosition = 8;
		double ceilingPosition = 500;
		
		// forward and right speeds
		double forward = game.controls.z;
		double right = game.controls.x;
		
		
		// game.time / 100.0 to make it rotate. Remove to stop rotation.
		double rotation = 0;
		double cosine = Math.cos(rotation);
		double sine = Math.sin(rotation);

		for (int y = 0; y < height; y++) {
			double ceiling = (y - height / 2.0) / height;

			double z = floorPosition / ceiling;
			if (ceiling < 0) {
				z = ceilingPosition / -ceiling;
			}

			for (int x = 0; x < width; x++) {
				double depth = (x - width / 2.0) / height;
				depth *= z;
				
				// add forward to add forward movement
				double xx = depth * cosine + z * sine;
				// add right to add right movement
				double yy = z * cosine - depth * sine;
				// Add game.time in (xx) to move it left and right
				int xPix = (int) (xx + forward);
				// Add game.time in (yy) to move it forward
				int yPix = (int) (yy + right);
				pixels[x + y * width] = ((xPix & 15) * 16) | ((yPix & 15) * 16) << 8;
			}
		}
	}
}
