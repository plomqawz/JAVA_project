// Slime.java

package study_gui;

import javax.swing.JOptionPane;

class Slime {

	String name;
	int hp = 80;

	// 생성자
	public Slime(String n) {

		name = n;

	}

	// 공격 : 생성자 2개 for 자식클래스 오버로딩
	public void attack(Human h) {
		attack(h, 10);
	}

	public void attack(Human h, int damage) {
		
		if (hp > 0) {

			h.hp = h.hp - damage;

			if (h.hp < 1) {
				JOptionPane.showMessageDialog(null, "Game Over\n당신은 쓰러지고 말았다.");
				System.exit(0);
			}

			if (damage < 30) { // 데미지가 30 이상일 경우 '강한 공격' 텍스트 출력.
				Study01.lbl2.setText(name + "의 공격! " + h.name + "의 체력은 " + h.hp + "이다.");
			} else {
				Study01.lbl2.setText(name + "의 강한 공격!! " + h.name + "의 체력은 " + h.hp + "이다.");
			}
		}
	}

	// 치료 void
	void heal(Slime s) {

	}
}

class Bum extends Slime { // 부모클래스(몬스터) 상속받은 자식클래스(범)

	// 생성자
	Bum(String n) {
		super(n);
	}

	// 약한 공격
	@Override
	public void attack(Human h) {

		attack(h, 8);

	}

	// 치료
	@Override
	void heal(Slime s) {

		if (hp > 0 && s.hp > 0) {

			s.hp += 10;

			if (s.hp > 80) {
				s.hp = 80;
			}

			Study01.lbl2.setText(name + "은 " + s.name + "를 치료! 그의 체력은 " + s.hp + "이다.");
		}
	}
}

class Dark extends Slime {

	Dark(String n) {
		super(n);
	}

	@Override
	public void attack(Human h) {
		attack(h, 15);
	}

	// 크리티컬 히트
	public void attack2(Human h) {
		attack(h, 30);
	}
}