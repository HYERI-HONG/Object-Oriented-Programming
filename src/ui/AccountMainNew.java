package ui;
import javax.swing.JOptionPane;

import domain.*;
import serviceImpl.*;
import service.*;
enum ButtAcc{
	EXIT,
	BASICACCOUNT,
	MINUSACCOUNT,
	DEPOSIT,
	WITHDRAWAL,
	LIST,
	FIND_BY_ID
}
public class AccountMainNew {
	public static void main(String[] args) {
		ButtAcc[] buttons= {
			ButtAcc.EXIT,
			ButtAcc.BASICACCOUNT,
			ButtAcc.MINUSACCOUNT,
			ButtAcc.DEPOSIT,
			ButtAcc.WITHDRAWAL,
			ButtAcc.LIST,
			ButtAcc.FIND_BY_ID
		};
		AccountBean acc = null;
		AccountService service = new AccountServiceImpl();
		AccountBean account = null;
		while(true) {
			ButtAcc select = (ButtAcc)JOptionPane.showInputDialog(null,"비트뱅크\n통장타입을 선택하세요.","0 : 종료\n1 : 기본 통장\n2 : 마이너스 통장\n3 : 입금\n4 : 출금\n5 : 보여주기",
					JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[1]);
			switch(select){
				case EXIT :
					return;
				case BASICACCOUNT :
					account = new AccountBean();
					account.setName(JOptionPane.showInputDialog("이름을 입력하세요 :"));
					account.setUserId(JOptionPane.showInputDialog("뱅킹에 사용할 ID를 입력하세요 :"));
					account.setPassword(JOptionPane.showInputDialog("뱅킹에 사용할 비밀번호를 입력하세요 :"));
					service.createAccount(account);
					
					break; 
				case MINUSACCOUNT :
					acc = new MinusAccountNew(JOptionPane.showInputDialog("이름을 입력하세요 :"),
							JOptionPane.showInputDialog("뱅킹에 사용할 ID를 입력하세요 :"),
							JOptionPane.showInputDialog("뱅킹에 사용할 비밀번호를 입력하세요 :"));
					((MinusAccountNew) acc).setLimit(Integer.parseInt(JOptionPane.showInputDialog("대출 한도를 입력하세요 :")));
					((MinusAccountNew) acc).setWithdrawal(Integer.parseInt(JOptionPane.showInputDialog("대출하시겠습니까?")));
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
					((MinusAccountNew) acc).setWithdrawal(Integer.parseInt(JOptionPane.showInputDialog("대출 금액")));
				}	
				JOptionPane.showMessageDialog(null,acc.getBalance());
				break;
				case LIST :
					JOptionPane.showMessageDialog(null, service.showResult());
					break;
				case FIND_BY_ID :
					/** 
					 ID와 PASS받아서 일치하면 계돠내역을 보여줘.단, 혹시 모르니까 비밀번호는 ***처리해
					 * */
					account = new AccountBean();
					account.setUserId(JOptionPane.showInputDialog("뱅킹에 사용할 ID를 입력하세요 :"));
					account.setPassword(JOptionPane.showInputDialog("뱅킹에 사용할 비밀번호를 입력하세요 :"));
					AccountBean  a = service.findById(account); 
					break;
			}
		}
	}
}
