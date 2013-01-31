package org.cwvs.gfxu.utils;

import java.util.Random;

public class RandomUtils {

	/**
	 * 随机生成一个4位的数字
	 * @return
	 */
	public static Integer randomNumber(){
		Random r = new Random();
		int num = r.nextInt(9999);
		while(num < 1000){
			num = r.nextInt(9999);
		}
		return num;
	}
}
