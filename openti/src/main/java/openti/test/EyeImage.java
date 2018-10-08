package openti.test;

import java.io.Serializable;

public class EyeImage implements Serializable {
	private int width = 500;
	private int height = 330;
	private int values[][];
	public EyeImage(int width, int height) {
		this.width = width;
		this.height = height;
		values = new int[width][height];
	}
	
	public EyeImage() {
		
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[][] getValues() {
		return values;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setValues(int[][] values) {
		this.values = values;
	}

	public void increment(int x, int y) {
		values[x][y] += 1;
	}

	public int getValue(int x, int y) {
		return values[x][y];
	}

	public void clear() {
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				values[x][y] = 0;
			}
		}
	}	
	
}
