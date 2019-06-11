package daoPattern;

public class Books {
	private int isbn;
	private String bookName;

	public Books() {
	}

	public Books(int isbn, String bookName) {
		this.setIsbn(isbn);
		this.setBookName(bookName);
	}

	// getter setter methods
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

}
