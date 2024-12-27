package test.main;

import java.util.Random;

import test.mypac.WowException;

public class MainClass07 {
	public static void main(String[] args) {
		Random ran=new Random();
		//0~9 사이의 랜덤한 숫자를 얻어냄
		int ranNum=ran.nextInt(10);
		
		if(ranNum==7) {
			//여기서 발생하는 Exception은 JVM이 직접 처리함
			throw new WowException("lucky 7");			
		}
		System.out.println(ranNum+"번 숫자입니다.");
	}
}
