package com.shubham.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.HashMap;

@SpringBootApplication
@EnableElasticsearchRepositories
public class ElasticsearchApplication {

	public static void main(String[] args) {
		int[][] grid = {
				{1,0,1},
				{1,0,1}
		};
		ElasticsearchApplication elasticsearchApplication = new ElasticsearchApplication();
//		System.out.println(elasticsearchApplication.shortestPath(grid, new int[]{0,0},
//				new int[]{2,3}));
		String s = "AA";
		String t = "AA";

		boolean matched = false;

		HashMap<Character, Integer> currMap = new HashMap<>();
		HashMap<Character, Integer> ogMap = new HashMap<>();
		for (char c : t.toCharArray()) {
			ogMap.put(c, ogMap.getOrDefault(c, 0) + 1);
		}
		int need = t.length();
		int have = 0;

		int high = 0;
		int low = 0;

		int ans[] = new int[] {0, s.length()};
		int length = 0;

		while (high < s.length()) {

			currMap.put(s.charAt(high), currMap.getOrDefault(s.charAt(high), 0) + 1);
			if (ogMap.keySet().contains(s.charAt(high)) &&
					ogMap.get(s.charAt(high)) == currMap.get(s.charAt(high))) {
				have++;
			}
			high++;
			if (have == need) {
				matched = true;
				while (have == need) {
					length = high - low;
					if (length < ans[1] - ans[0]) {
						ans[0] = low;
						ans[1] = high;
					}
					currMap.put(s.charAt(low), currMap.get(s.charAt(low)) - 1);
					if (ogMap.keySet().contains(s.charAt(low)) &&
							currMap.get(s.charAt(low)) < ogMap.get(s.charAt(low))) {
						have--;
					}
					if (currMap.get(s.charAt(low)) == 0) {
						currMap.remove(s.charAt(low));
					}
					low++;
				}
			}
		}

		System.out.println( matched ? s.substring(ans[0], ans[1]) : "");

	}

	private static int minDistance;
	int shortestPath(int[][] grid, int[] source, int[] destination) {

		// Your code here
		minDistance = Integer.MAX_VALUE;

		dfs(grid, source[0], source[1], destination[0], destination[1], 0);

		return minDistance;
	}

	private void dfs(int[][] grid, int sI, int sJ, int dI, int dJ, int currDistance) {

		if (sI < 0 || sJ < 0 || sI > grid.length - 1 || sJ > grid[sI].length - 1 ||
				grid[sI][sJ] == 0) {
			return;
		}

		System.out.println(grid[sI][sJ]);

		if (sI == dI && sJ == dJ) {
			minDistance = Math.min(minDistance, currDistance);
			return;
		}

		grid[sI][sJ] = 0;
		dfs(grid, sI + 1, sJ, dI, dJ, currDistance + 1);
		dfs(grid, sI - 1, sJ, dI, dJ, currDistance + 1);
		dfs(grid, sI, sJ + 1, dI, dJ, currDistance + 1);
		dfs(grid, sI, sJ - 1, dI, dJ, currDistance + 1);
		grid[sI][sJ] = 1;
	}
}
