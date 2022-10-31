// Study01.java
 
package study_tui;
 
import javax.swing.JOptionPane;
 
public class Study01 {
 
    public static void main(String[] args) {
 
        // 빈 슬라임 변수
        Slime s = null;
 
        // 슬라임과 인간 객체 생성
        Slime s1 = new Slime("슬라삐");
        Slime s2 = new Slime("슬라디");
        Human h = new Human("알렉스");
 
        System.out.println(s1.name + "와 " + s2.name + "가 나타났다! 당신의 이름은 " + h.name + "이다\n");
 
        while (true) {
 
            // 인풋박스
            String sTarget = JOptionPane.showInputDialog("어느 슬라임을 공격하겠습니까? 1은 " + s1.name + " 2는 " + s2.name);
 
            // 널값이나 빈값이 입력되면 종료
            if (sTarget == null || sTarget.equals("")) {
                System.exit(0);
            }
 
            // 형변환
            int target = Integer.parseInt(sTarget);
 
            if (target == 1) {
                
                s = s1;
 
            } else if (target == 2) {
                
                s = s2;
                
            } else {
 
                System.out.println("올바른 숫자를 입력하세요");
 
            }
 
            // 슬라임이 살아있을때만 공격
            if(s.hp<1) {
            	System.out.println(s.name + "는 이미 죽어있다.\n");
            } else {
            h.attack(s);
            s.attack(h);
            }
            
            // 슬라임이 모두 죽으면 게임 클리어
            if (s1.hp < 1 && s2.hp < 1) {
            	JOptionPane.showMessageDialog(null, "Game Clear!");
            	System.exit(0);
            	
            }
        } // while 끝
    }
 
}
