// Human.java
 
package study_gui;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

class Human {
 
    String name;
    int hp = 100;
 
    public Human(String n) {
        name = n;
    }
 
    public void attack(Slime s) {
    	
    	// 몬스터가 공격받는 그림.
    	ImageIcon bumImg_fire = new ImageIcon(Study01.class.getResource("/study_gui/img/10.png"));
    	ImageIcon siniImg_fire = new ImageIcon(Study01.class.getResource("/study_gui/img/20.png"));
    	ImageIcon gabi_fire = new ImageIcon(Study01.class.getResource("/study_gui/img/30.png"));
    	
    	if(s == Study01.b1) {
    		Study01.imgLbl.setIcon(bumImg_fire);
    	} else if (s == Study01.d1) {
    		Study01.imgLbl2.setIcon(siniImg_fire);
    	} else {
    		Study01.imgLbl3.setIcon(gabi_fire);
    	}
    	
    	// 타이머 세팅, 일정시간 텀 두고 이미지 원상복구.
    	Timer timer1 = new Timer();
    	TimerTask task1 = new TimerTask() {
    		
    		@Override
    		public void run() {
    			// 일정시간 후에 수행할 코드
    			Study01.imgLbl.setIcon(Study01.bumImg);
    			Study01.imgLbl2.setIcon(Study01.siniImg);
    			Study01.imgLbl3.setIcon(Study01.gabiImg);
    			timer1.cancel();
    		}
    		
    	};
    	
    	timer1.schedule(task1, 500); // 타이머는 0.5초
    	
        //System.out.println("사냥꾼은 " + s.name + "를 공격했다!");
        //Study01.lbl.setText("사냥꾼은 " + s.name + "를 공격했다!");
        
        s.hp = s.hp - 30;
        
        if(s.hp < 1) { // 몬스터 사망 시.
        	if (s == Study01.b1) {
        		Study01.frm.remove(Study01.imgLbl); // 이미지 없애기.
        		Study01.frm.repaint(); // 없앤 결과를 다시 그려줘야함.
        		Study01.btn1.setEnabled(false); // 버튼 비활성화.
        	} else if (s == Study01.d1) {
        		Study01.frm.remove(Study01.imgLbl2);
        		Study01.frm.repaint();
        		Study01.btn2.setEnabled(false);
        	} else {
        		Study01.frm.remove(Study01.imgLbl3);
        		Study01.frm.repaint();
        		Study01.btn3.setEnabled(false);
        	}

        	Study01.lbl.setText(s.name+"는 사망했다.");
        	Study01.lbl2.setText("");
        
        } else {
        Study01.lbl.setText(name+"의 공격! "+s.name+"의 체력은 " + s.hp + "이다.");
        }
    }
}