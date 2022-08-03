package bms.domain;

import java.util.Date;

/**
 * @author 赵天宇
 * @version 1.0
 * 这是一个javabean,domain,pojo 和数据库中的booklist表对应
 * 1.图书编号BookId int
 * 2.图书名称BookName var char 32
 * 3.图书数量BookNumber int
 * 4.单价 BookPrice int
 * 5.图书状态 BookStatus var char 3 (已借出/未借出)
 * 6.借书人 BookBorrowPeople var char 32
 * 7.归还期限 ReturnDate datetime
 */
public class BookList {
        private Integer bookId;
        private String bookName;
        private Integer bookNumber;
        private Integer bookPrice;
        private String bookStatus;
        private String bookBorrowPeople;
        private Date returnDate;
        public BookList(){}


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

        public Integer getBookNumber() {
                return bookNumber;
        }

        public void setBookNumber(Integer bookNumber) {
                this.bookNumber = bookNumber;
        }

        public Integer getBookPrice() {
                return bookPrice;
        }

        public void setBookPrice(Integer bookPrice) {
                this.bookPrice = bookPrice;
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

        public Date getReturnDate() {
                return returnDate;
        }

        public void setReturnDate(Date returnDate) {
                this.returnDate = returnDate;
        }

        public BookList(Integer bookId, String bookName, Integer bookNumber, Integer bookPrice, String bookStatus, String bookBorrowPeople, Date returnDate) {
                this.bookId = bookId;
                this.bookName = bookName;
                this.bookNumber = bookNumber;
                this.bookPrice = bookPrice;
                this.bookStatus = bookStatus;
                this.bookBorrowPeople = bookBorrowPeople;
                this.returnDate = returnDate;
        }

        @Override
        public String toString() {
                return bookId+"\t\t\t"+bookName+"\t\t"+bookNumber+"\t\t\t"+bookPrice+"\t\t"+bookStatus+"\t\t"+bookBorrowPeople+"\t\t"+returnDate;
        }


}
