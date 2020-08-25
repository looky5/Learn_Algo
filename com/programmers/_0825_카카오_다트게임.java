package com.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0825_카카오_다트게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String dartResult = br.readLine();
		int answer = solution(dartResult);
		System.out.println(answer);
	} // end of main

	private static int solution(String dartResult) {
		int answer = 0;

		int[] board = new int[3];
		int boardIdx = -1;
		char[] arr = dartResult.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if (c >= '0' && c <= '9') {
				boardIdx++;
				if (c == '1' && arr[i + 1] == '0') {
					i++;
					board[boardIdx] = 10;
				} else {
					board[boardIdx] = c - '0';
				}
				continue;
			}
			switch (c) {
			case 'D':
				board[boardIdx] = (int) Math.pow(board[boardIdx], 2);
				break;
			case 'T':
				board[boardIdx] = (int) Math.pow(board[boardIdx], 3);
				break;
			case '*':
				board[boardIdx] *= 2;
				if (boardIdx > 0)
					board[boardIdx - 1] *= 2;
				break;
			case '#':
				board[boardIdx] *= -1;
			}
		}
		for(int i = 0; i < 3; i++) {
			System.out.println("Idx: " + board[i]);
			answer += board[i];
		}

		return answer;
	} // end of solution
} // end of class
