

import java.util.ArrayList;
import java.util.List;

public class WaveAlg {
	int width;
	int height;
	int wall = 99;
	int[][] map;
	List<Point2D> wave = new ArrayList<>();




	//конструктор
	public WaveAlg(int width, int height, int[][] map) {
		this.width = width;
		this.height = height;
		this.map = map;

	}

	//ищем путь
	public void findPath(int x, int y, int nx, int ny) {
		if (map[y][x] == wall || map[ny][nx] == wall) {
			return;
		}

		int[][] cloneMap = clone(map);
		List<Point2D> oldWave = new ArrayList<>();
		oldWave.add(new Point2D(nx, ny));
		int nstep = 0;
		map[ny][nx] = nstep;

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };

		while (!oldWave.isEmpty()) {
			nstep++;
			wave.clear();
			for (Point2D i : oldWave) {
				for (int d = 0; d < 4; d++) {
					nx = i.x + dx[d];
					ny = i.y + dy[d];

					if (map[ny][nx] == -1) {
						wave.add(new Point2D(nx, ny));
						map[ny][nx] = nstep;
					}
				}
			}
			oldWave = new ArrayList<>(wave);
		}

		boolean flag;
		wave.clear();
		wave.add(new Point2D(x, y));
		while (map[y][x] != 0) {
			flag = true;
			for (int d = 0; d < 4; d++) {
				nx = x + dx[d];
				ny = y + dy[d];
				if (map[y][x] - 1 == map[ny][nx]) {
					x = nx;
					y = ny;
					wave.add(new Point2D(x, y));
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("пыщ!");
				break;
			}
		}

		map = cloneMap;

		for (Point2D i : wave) {
			map[i.y][i.x] = 0;
		}
	}

	private static class Point2D {
		public Point2D(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int x;
		public int y;
	}

	public void waveOut()
	{
		for (Point2D i : wave) {
			System.out.println("x = " + i.x + ", y = " + i.y);
		}
	}

	public void traceOut()
	{
		String m = null;
		System.out.print("   ");
		for (int i = 0; i < height; i++)
		{
			System.out.print(i > 9 ? i + " " : i + "  ");
		}
		System.out.println();
		for (int i = 0; i < width; i++) {
			m = i > 9 ? i + " " : i + "  ";
			for (int j = 0; j < height; j++) {
				m += map[i][j] > 9 || map[i][j] < 0 ? map[i][j] + " " : map[i][j] + "  ";
			}
			System.out.println(m);
		}

	}

	private int[][] clone(int[][] map) {
		int[][] cloneMap = new int[width][height];
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[i].length; j++)
				cloneMap[i][j] = map[i][j];
		return cloneMap;
	}
}
