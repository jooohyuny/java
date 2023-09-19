package com.yun.apr214os.main;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.yun.apr214os.hero.Hulk;
//	JFrame 클래스는 이미 있음
import com.yun.apr214os.planet.Planet;

//awt/swing(Java GUI프로그래밍)
//	1)	웹기반으로 바꾸는 중
//	2)	윈도우프로그램 : C# -> WinSDK
//	3)	웹, BD/AI에 1도 도움이 안됨 : Android에는 도움이 되는

public class OMain2 {
	public static void main(String[] args) {
		// 텍스트가 홍길동인 JTextField
		// JTextField hg = new JTextField("홍길동");
		// e.add(hg);
		// 텍스트가 홍길동인 JFileChooser
		// JFileChooser hgd = new JFileChooser();
		// e.add(hgd);

		JFrame e = new JFrame("지구"); // 제목이 지구인 JFrame

		JButton h = new JButton("홍길동"); // 텍스트가 홍길동인 JButton

		e.add(h); // 저 JFrame에 저 JButton 추가

		// 이벤트 처리를 하자
		// 반드시 attack()이 필요 : Hero interface [사수]
		// 반드시 acrionPerformed() : ActionListener interface [Java]

		// 영웅인 아이언맨이었다면
		// ActionListener인 헐크
		Hulk i = new Hulk();

		// 저 JButton이 담당 ActionListener로 헐크를 찜
		h.addActionListener(i); // 버튼 클릭하면 나옴
		// 도움요청 -> 버튼 클릭하면 Hulk에 저장되있는 오버라이딩이 나옴

		// 그 JFrame 사이즈가 500, 300
		e.setSize(500, 300);

		// 그 JFrame 보이게
		e.setVisible(true);

	}
}
