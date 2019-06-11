package daoPattern;

public class AccessBook {

	// https://www.journaldev.com/16813/dao-design-pattern
	public static void main(String[] args) {

		/*
		 * 程式需要利用別的媒介來儲存或取得資料 *ex:儲取不同ＤＢ, memory...
		 * 程式需要能移植到其它儲存媒介 *interface
		 * 各個儲存媒介之間使用的存取方式不同 
		 * 希望程式不會受到儲存媒介的變換而修改
		 */
		BookDao bookDao = new BookDaoImpl();

		System.out.println("begin size : " + bookDao.getAllBooks().size());
		
		for (Books book : bookDao.getAllBooks()) {
			System.out.println("Book ISBN : " + book.getIsbn());
		}

		// update book
		Books book = bookDao.getAllBooks().get(1);
		book.setBookName("Algorithms");
		bookDao.saveBook(book);
		
		System.out.println("end size : " + bookDao.getAllBooks().size());
	}

}
