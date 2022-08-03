package bms.domain;

import java.util.Date;

/**
 * @author 赵天宇
 * @version 1.0
 * 这是一个javabean,domain,pojo 和数据库中的bookborrow表对应
 * 1.图书编号 BookId int
 * 2.图书名称 BookName var char 32
 * 3.图书状态 BookStatus var char 3 (已借出/未借出)
 * 4.借书人 BookBorrowPeople var char 32
 * 5.借书日期 BorrowDate datetime
 */
public class BookBorrow {
    private Integer bookId;
    private String bookName;
    private String bookStatus;
    private String bookBorrowPeople;
    private Date borrowDate;
    public BookBorrow(){}


    @Override
    public String toString() {
        return "BookBorrow{" +
                "BookId=" + bookId +
                ", BookName='" + bookName + '\'' +
                ", BookStatus='" + bookStatus + '\'' +
                ", BookBorrowPeople='" + bookBorrowPeople + '\'' +
                ", BorrowDate=" + borrowDate +
                '}';
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getBookBorrowPeople() {
        return bookBorrowPeople;
    }

    public void setBookBorrowPeople(String bookBorrowPeople) {
        this.bookBorrowPeople = bookBorrowPeople;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public BookBorrow(Integer bookId, String bookName, String bookStatus, String bookBorrowPeople, Date borrowDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookStatus = bookStatus;
        this.bookBorrowPeople = bookBorrowPeople;
        this.borrowDate = borrowDate;
    }
}
