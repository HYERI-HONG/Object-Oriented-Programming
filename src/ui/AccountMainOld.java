package ui;
/**
 비트뱅크
 기본통방
 계좌번호 : 123-456-789
 이름: 홍길동
 생성일 : 2018년 6월 12일
 잔액 : 10000원
 
 입금하시겠습니까?
 --------------------------
  비트뱅크
마이너스통장
 계좌번호 : 123-456-789
 이름: 홍길동
 생성일 :2018년 6월 12일
 잔액 : -10000원
 
 대출하시겠습니까?
 * */
import javax.swing.JOptionPane;
import domain.*;

enum Butt2{
	EXIT,
	BASICACCOUNT,
	MINUSACCOUNT,
	DEPOSIT,
	WITHDRAWAL
}
public class AccountMainOld {
	public static void main(String[] args) {
		Butt2[] buttons= {
			Butt2.EXIT,
			Butt2.BASICACCOUNT,
			Butt2.MINUSACCOUNT,
			Butt2.DEPOSIT,
			Butt2.WITHDRAWAL
		};
		AccountOld acc = null;
		
		while(true) {
			Butt2 select = (Butt2)JOptionPane.showInputDialog(null,"비트뱅크\n통장타입을 선택하세요.","0 : 종료\n1 : 기본 통장\n2 : 마이너스 통장\n3 : 입금\n4 : 출금",
					JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[1]);
			switch(select){
				case EXIT :
					return;
				case BASICACCOUNT :
					acc = new AccountOld(JOptionPane.showInputDialog("이름을 입력하세요 :"),
							JOptionPane.showInputDialog("뱅킹에 사용할 ID를 입력하세요 :"),
							JOptionPane.showInputDialog("뱅킹에 사용할 비밀번호를 입력하세요 :"));
					acc.setMoney(Integer.parseInt(JOptionPane.showInputDialog("입급하시겠습니까?")));
					JOptionPane.showMessageDialog(null,acc.toString());
					break; 
				case MINUSACCOUNT :
					acc = new MinusAccountOld(JOptionPane.showInputDialog("이름을 입력하세요 :"),
							JOptionPane.showInputDialog("뱅킹에 사용할 ID를 입력하세요 :"),
							JOptionPane.showInputDialog("뱅킹에 사용할 비밀번호를 입력하세요 :"));
					((MinusAccountOld) acc).setLimit(Integer.parseInt(JOptionPane.showInputDialog("대출 한도를 입력하세요 :")));
					((MinusAccountOld) acc).setWithdrawal(Integer.parseInt(JOptionPane.showInputDialog("대출하시겠습니까?")));
					JOptionPane.showMessageDialog(null,acc.toString());
					break;
				case DEPOSIT :
					acc.setMoney(Integer.parseInt(JOptionPane.showInputDialog("입급 금액 : ")));
					JOptionPane.showMessageDialog(null,acc.getBalance());
					break;
				case WITHDRAWAL:
			 	if(acc. getAccountType().equals("기본통장")) {
						acc.setWithdrawal(Integer.parseInt(JOptionPane.showInputDialog("출금 금액")));
				}else {
					((MinusAccountOld) acc).setWithdrawal(Integer.parseInt(JOptionPane.showInputDialog("대출 금액")));
				}	
				JOptionPane.showMessageDialog(null,acc.getBalance());
				break;
			}
		}
	}
}
