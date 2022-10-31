// Study01.java

package study_gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class Study01 {

	// 전역 변수 선언
	static JLabel lbl, lbl2, lbl3, imgLbl, imgLbl2, imgLbl3;
	static ImageIcon bumImg, siniImg, gabiImg;
	static JButton btn1, btn2, btn3;

	// 몬스터와 인간 객체 생성
	static Bum b1 = new Bum("장산범");
	static Dark d1 = new Dark("어둑시니");
	static Bum b3 = new Bum("도깨비");
	static Human h = new Human("헌터J");

	public static void main(String[] args) {

		// [start] 디자인코드

		// 모든 글꼴 통일
		Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource)
				UIManager.put(key, new FontUIResource("명조", Font.BOLD, 15));
		}

		// [start] 프레임 설정
		JFrame frm = new JFrame(); // 프레임 선언
		frm.setTitle("몬스터 헌터"); // 프레임 제목설정
		frm.setSize(800, 600); // 프레임 크기설정
		frm.setLocationRelativeTo(null); // 프레임을 화면 가운데에 배치
		// 프레임을 닫았을 때 메모리에서 제거되도록 설정
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 레이아웃 설정 : 자동레이아웃은 자유도가 떨어져서 null로 설정.
		frm.getContentPane().setLayout(null);
		// [end] 프레임 설정

		// [start] 버튼 설정
		btn1 = new JButton(b1.name); // 버튼 생성
		btn2 = new JButton(d1.name);
		btn3 = new JButton(b3.name);
		btn1.setBounds(30, 350, 221, 30); // 버튼 위치,크기 설정
		btn2.setBounds(281, 350, 222, 30);
		btn3.setBounds(533, 350, 221, 30);
		frm.getContentPane().add(btn1); // 프레임에 버튼 추가
		frm.getContentPane().add(btn2);
		frm.getContentPane().add(btn3);
		// [end] 버튼 설정

		// 라벨 설정
		lbl = new JLabel();
		lbl.setBounds(250, 30, 320, 50);
		lbl.setText("공격할 몬스터를 클릭하세요.");
		lbl.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬
		frm.getContentPane().add(lbl);

		// 라벨2 설정
		lbl2 = new JLabel();
		lbl2.setBounds(250, 60, 320, 50);
		lbl2.setText(h.name + "의 체력은 " + h.hp + "입니다.");
		lbl2.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬
		frm.getContentPane().add(lbl2);

		// 라벨3 설정
		lbl3 = new JLabel();
		lbl3.setBounds(250, 450, 300, 50);
		lbl3.setText("야생(?)의 몬스터 무리가 앞을 막아섰다!");
		lbl3.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬
		frm.getContentPane().add(lbl3);

		// [start] 이미지 라벨 생성
		imgLbl = new JLabel();
		bumImg = new ImageIcon(Study01.class.getResource("/study_gui/img/1.png")); // 라벨1에 넣을 아이콘 생성
		imgLbl.setIcon(bumImg); // 라벨1에 아이콘 설정
		imgLbl.setBounds(60, 200, 150, 150); // 라벨1 기타설정
		imgLbl.setHorizontalAlignment(JLabel.CENTER);
		frm.getContentPane().add(imgLbl);
		// [end] 이미지 라벨 생성

		// [start] 이미지 라벨2 생성
		imgLbl2 = new JLabel();
		siniImg = new ImageIcon(Study01.class.getResource("/study_gui/img/2.png"));
		imgLbl2.setIcon(siniImg);
		imgLbl2.setBounds(317, 200, 150, 150);
		imgLbl2.setHorizontalAlignment(JLabel.CENTER);
		frm.getContentPane().add(imgLbl2);
		// [end] 이미지 라벨2 생성

		// [start] 이미지 라벨3 생성
		imgLbl3 = new JLabel();
		gabiImg = new ImageIcon(Study01.class.getResource("/study_gui/img/3.png"));
		imgLbl3.setIcon(gabiImg);
		imgLbl3.setBounds(563, 200, 150, 150);
		imgLbl3.setHorizontalAlignment(JLabel.CENTER);
		frm.getContentPane().add(imgLbl3);
		// [end] 이미지 라벨3 생성

		// 프레임이 보이도록 설정
		frm.setVisible(true);

		// [end] 디자인 코드

		// 맨 처음 화면구성기획을 위한 컨텐츠 영역의 크기 표시
		// System.out.println(frm.getContentPane().getSize());

		// * 버튼을 눌렀을 때
		btn1.addActionListener(event -> {

			battle(b1);
			lbl3.setText("익숙한 목소리가 들려온다. 속지마라!");

			// 0,1,2 숫자 중 하나를 랜덤하게 창으로 띄움 -> 게임에 확률요소 추가.
			// int randomNum = (int)(Math.random()*3);
			// JOptionPane.showMessageDialog(null, randomNum);

		});

		btn2.addActionListener(event -> {

			battle(d1);
			lbl3.setText("\"너의 가장 어두운 부분을 보여다오...\"");

		});

		btn3.addActionListener(event -> {

			battle(b3);
			lbl3.setText("\"김서방! 씨름 좋아해?\"");

		});

	}

	public static void battle(Slime s) {

		// 확률추가 : 랜덤메서드 0,1,2 중 0이 나오면 공격 빗나감.
		int randomNum = (int) (Math.random() * 3);

		if (randomNum == 0) {
			lbl.setText(h.name + "의 공격은 빗나갔다!");
		} else {
			h.attack(s);
		}

		if (s instanceof Bum) { // 범 클래스형일 경우 확률추가 : 1/3 확률로 장산범이 범 클래스 치유, 그 외 숫자가 나오면 공격.

			randomNum = (int) (Math.random() * 3);

			if (randomNum == 0) {
				((Bum) b1).heal(s);
			} else {
				s.attack(h);
			}

		} else { // 다크 클래스일 경우 확률추가 : 1/3 확률로 강한 공격.

			randomNum = (int) (Math.random() * 3);

			if (randomNum == 0) {
				((Dark) s).attack2(h);
			} else {
				s.attack(h);
			}
		}

		// 몬스터가 모두 죽으면 게임 클리어
		if (b1.hp < 1 && d1.hp < 1 && b3.hp < 1) {
			JOptionPane.showMessageDialog(lbl2, "Game Clear!\n모든 몬스터를 사냥했다!");
			System.exit(0);
		}

	}

}