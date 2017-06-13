package library;

import java.util.ArrayList;

import org.junit.Test;

public class libraryTest {
	Member member1 = new Member();
	Member member2 = new Member();
	Member member3 = new Member();
	Book book1 = new Book("0001", "ISBN-1-1", "语文");
	Book book2 = new Book("0001", "ISBN-1-2", "语文");
	Book book3 = new Book("0002", "ISBN-2-1", "英语");
	Book book4 = new Book("0002", "ISBN-2-2", "英语");
	Member loanmember = member1;
	Book loanbook = book1;
	ArrayList<Loan> Loans = new ArrayList<Loan>();

	public libraryTest() {
		/*
		 * 添加借书人信息
		 */
		member1.setId("01");
		member1.setName("小张");
		member2.setId("02");
		member2.setName("小李");
		member3.setId("03");
		member3.setName("小红");		
		/*
		 * 添加借书记录
		 */
		Loan loan1 = new Loan();
		loan1.setMember(loanmember);
		loan1.setBook(book3);
		Loans.add(loan1);				
		loanmember.setLoans(Loans);
	}

	@Test
	
	public void Loan() {
		 Loan loan=loanmember.Loan(loanbook);
		 if(!(loan==null)){
		 System.out.println("借书成功");
		 System.out.println("借书记录：*************"+'\r'+"借书时间: " +
		 loan.getLoanDate()+
		 " 到期时间:" + loan.getDateForReuturn()+
		 " 借书人: " + loanmember.getName()+
		 " 所借书籍:  " + loanbook.getTitle());
		 }
		 else{
		 System.out.println("您不能借书！");
		 }
		/**规则测试**/
		loanmember.Return(loanbook); 

	}
	
	@Test
	/* 
	 * 瑙勫垯娴嬭瘯
	 */
	public void rule(){
	LoanOnlyOneSpecification one = new LoanOnlyOneSpecification(loanbook);
	System.out.println(one.IsSatisfiedBy(loanmember));		
	}

}
