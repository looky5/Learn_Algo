package com.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class _0827_카카오_파일명정렬 {
	public static class Mysort implements Comparator<String[]> {

		@Override
		public int compare(String[] o1, String[] o2) {
			if (o1[1].equals(o2[1])) {
				int num1 = Integer.parseInt(o1[2]);
				int num2 = Integer.parseInt(o2[2]);
				return num1 - num2;
			} else {
				return o1[1].compareTo(o2[1]);
			}
		}

	}

	public static void main(String[] args) {
//		String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
//		String[] files = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
		String[] files = { "F-15000", "F-1111111", "F-15" };

		String[] answer = solution(files);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static String[] solution(String[] files) {
		StringBuffer sb = new StringBuffer();
		String[] answer = new String[files.length];
		String[][] fileList = new String[files.length][4];

		for (int i = 0; i < files.length; i++) {
			fileList[i][0] = files[i];
			sb.append(files[i].toUpperCase());
			for (int j = 0; j < sb.length(); j++) {
				if (sb.charAt(j) >= 48 && sb.charAt(j) <= 57) {
					fileList[i][1] = sb.substring(0, j);
					sb.delete(0, j);
					break;
				}
			}
			boolean flag = false;
			for (int j = 0, numbersize = 5; j < sb.length(); j++, numbersize--) {
				if (sb.charAt(j) < 48 || sb.charAt(j) > 57) {
					fileList[i][2] = sb.substring(0, j);
					sb.delete(0, j);
					flag = true;
					break;
				} else if(numbersize == 0) {
					fileList[i][2] = sb.substring(0, 5);
					sb.delete(0, j);
					flag = true;
					break;
				}
			}
			if (flag) {
				fileList[i][3] = sb.toString();
			} else {
				fileList[i][2] = sb.toString();
				fileList[i][3] = "";
			}
			sb.delete(0, sb.length());
		}

		Arrays.sort(fileList, new Mysort());
		
		for(int i = 0; i < files.length; i++) {
			System.out.println(Arrays.toString(fileList[i]));
		}
		
		for (int i = 0; i < files.length; i++) {
			answer[i] = fileList[i][0];
		}
		return answer;
	}
}
