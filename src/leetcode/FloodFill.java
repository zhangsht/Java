package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
	/*
	 * consider the starting pixel, plus any pixels connected 4-directionally to the
	 * starting pixel of the same color as the starting pixel, plus any pixels
	 * connected 4-directionally to those pixels (also with the same color as the
	 * starting pixel), and so on. Replace the color of all of the aforementioned
	 * pixels with the newColor
	 */
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image == null) {
			return image;
		}
		int m = image.length;
		if (m <= 0) {
			return image;
		}
		int n = image[0].length;
		if (n <= 0) {
			return image;
		}

		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}

		Queue<MatrixNode> queue = new LinkedList<>();
		MatrixNode tmp = new MatrixNode(sr, sc);
		queue.add(tmp);
		int[][] to = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int initVal = image[sr][sc];
		while (!queue.isEmpty()) {
			MatrixNode node = queue.poll();
			int x = node.row;
			int y = node.col;
			image[x][y] = newColor;
			visited[x][y] = true;
			
			for (int i = 0; i < 4; i++) {
				int _x = x + to[i][0];
				int _y = y + to[i][1];
				if (isInBox(m, _x) && isInBox(n, _y)
						&& !visited[_x][_y] && image[_x][_y] == initVal) {
					queue.add(new MatrixNode(_x, _y));
				}
			}
		}
		return image;
	}
	
	private boolean isInBox(int len, int x) {
		return x >= 0 && x < len;
	}
}
