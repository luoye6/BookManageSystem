package bms.domain;

import java.util.Date;

/**
 * @author 赵天宇
 * @version 1.0
 */
public class BookBorrowRecord {
    private Integer recordId;
    private String bookName;
    private String bookStatus;
    private String bookBorrowPeople;
    private Date borrowDate;
    private Date returnDate;

    public BookBorrowRecord() {
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
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

    @Override
    public String toString() {
        return recordId + "\t\t\t"
                + bookName + "\t\t"
                + bookStatus + "\t\t"
                + bookBorrowPeople + "\t\t"
                + borrowDate + "\t\t"
                + returnDate
                ;
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public BookBorrowRecord(Integer recordId, String bookName, String bookStatus, String bookBorrowPeople, Date borrowDate, Date returnDate) {
        this.recordId = recordId;
        this.bookName = bookName;
        this.bookStatus = bookStatus;
        this.bookBorrowPeople = bookBorrowPeople;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }
}
