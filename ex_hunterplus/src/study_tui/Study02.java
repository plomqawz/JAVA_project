// Study02.java
 
package study_tui;
 
public class Study02 {
 
    public static void main(String[] args) {
 
        // 빈 슬라임 변수
        Slime s = null;
 
        // 슬라임 객체 생성
        Slime s1 = new Slime("슬라삐");
        Slime s2 = new Slime("슬라디");
 
        s = s1;
 
        System.out.println(s.name);
 
    }
 
}