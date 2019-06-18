package AmbroseRen.method.calendar;

import java.util.Scanner;

public class daysDemo {
	
	public static void main(String[] args) {
		Scanner src=new Scanner(System.in);
		System.out.println("请输入年份：");
		int year=src.nextInt();
		System.out.println("请输入月份：");
		int month=src.nextInt();
		System.out.println("请输入日：");
		int day=src.nextInt();
		
		
		
		int days;
		switch(month){
		case 1:
			System.out.println("31天");
		case 2:
			if(year%4==0&&year%100!=0||year%400==0){
				int a=29;
				System.out.println(a+31+"天");
				}else{
				int	b=28;
					System.out.println(b+31+"天");
			}
		case 3:
			if(year%4==0&&year%100!=0||year%400==0){
				int day20=29;
				System.out.println(day20+31);
				}else{
				int	day21=28;
					System.out.println(day21+31);
				}
			System.out.println(day+31		);
		case 4:
			int day4=30;
			System.out.println(day4+31*2		);
		case 5:
			int day5=31;
			System.out.println(day5+31*2+30		);
		case 6:
			int day6=30;
			System.out.println(day6);
		case 7:
			int day7=31;
			System.out.println(day7);
		case 8:
			int day8=31;
			System.out.println(day8);
		case 9:
			int day9=30;
			System.out.println(day9);
		case 10:
			int day10=31;
			System.out.println(day10);
		case 11:
			int day11=30;
			System.out.println(day11);
		case 12:
			int day12=31;
			System.out.println(day12);
		}
		
	}

}
