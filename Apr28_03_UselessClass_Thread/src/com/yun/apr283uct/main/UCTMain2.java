package com.yun.apr283uct.main;

// mainThread : 0.5초 마다 ㅋ 찍기 x 10
// subThread : 0.5초 마다 ㅎ 찍기 x 무한

// => mainThread 끝난다고 subThread도 끝나는거 아님
public class UCTMain2 {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				while (true) {
					System.out.println("ㅎ");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();	
		for (int i = 0; i < 10; i++) {
				System.out.println("ㅋ");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
	}
}
