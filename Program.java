


import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		int x = 1;
		int y = 1;
		int nx = 14;
		int ny = 14;

		MapGenerator mapGenerator = new MapGenerator();

		WaveAlg Path = new WaveAlg(15, 15, mapGenerator.getMap());


		Path.traceOut();
		System.out.println();

		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Введите x входа");
			x = scan.nextInt();
			System.out.println("Введите y входа");
			y = scan.nextInt();
			System.out.println("Введите x выхода");
			nx = scan.nextInt();
			System.out.println("Введите y выхода");
			ny = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Введи правильное значение!");
		}

		Path.findPath(x, y, nx, ny);

		Path.traceOut();
		System.out.println();

		Path.waveOut();
	}


	static class MapGenerator {
		int[][] map;

		public MapGenerator() {
			int[][] map = {
					{ 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99 },
					{ 99, -1, -1, -1, 99, -1, -1, -1, -1, -1, -1, -1, -1, -1, 99 },
					{ 99, -1, -1, -1, -1, -1, -1, 99, -1, -1, -1, -1, -1, -1, 99 },
					{ 99, -1, -1, -1, 99, -1, -1, 99, -1, -1, -1, -1, -1, -1, 99 },
					{ 99, -1, -1, -1, 99, -1, 99, 99, 99, 99, -1, -1, -1, -1, 99 },
					{ 99, -1, -1, -1, 99, -1, 99, -1, -1, 99, -1, -1, -1, -1, 99 },
					{ 99, 99, 99, -1, 99, -1, 99, -1, -1, 99, -1, -1, -1, -1, 99 },
					{ 99, -1, -1, -1, 99, -1, 99, -1, -1, 99, 99, 99, -1, -1, 99 },
					{ 99, -1, -1, -1, 99, -1, -1, -1, -1, 99, -1, -1, -1, -1, 99 },
					{ 99, -1, -1, -1, 99, -1, -1, -1, -1, 99, -1, -1, -1, -1, 99 },
					{ 99, -1, -1, -1, 99, 99, 99, 99, 99, 99, -1, -1, -1, -1, 99 },
					{ 99, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 99 },
					{ 99, -1, -1, -1, 99, 99, 99, 99, 99, 99, 99, -1, -1, -1, 99 },
					{ 99, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 99 },
					{ 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99 }
			};

			this.map = map;
		}

		public int[][] getMap() {
			return map;
		}

	}
}
