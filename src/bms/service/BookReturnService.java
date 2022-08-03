package bms.service;

import bms.dao.BooKBorrowRecordDAO;
import bms.dao.BookBorrowDAO;
import bms.dao.BookListDAO;
import bms.domain.BookBorrow;
import bms.domain.BookList;

import java.awt.print.Book;
import java.time.LocalDate;

/**
 * @author 赵天宇
 * @version 1.0
 */
public class BookReturnService {
    //编写一个能够实现借书人归还图书的方法，并调用BookListDAO 和 BookBorrowDAO
    private BookListDAO bookListDAO = new BookListDAO();
    private BookBorrowDAO bookBorrowDAO = new BookBorrowDAO();
    private BooKBorrowRecordDAO booKBorrowRecordDAO = new BooKBorrowRecordDAO();
    public boolean returnBooksGetByBookNameAndBookBorrowPeople(String bookName, String bookBorrowPeople, LocalDate returnDate) {
        //先从bookBorrow表中寻找，是否有此借出的图书名称和相应的借书人，然后判断状态是否是已借出
        BookBorrow bookBorrow = bookBorrowDAO.querySingle("select * from bookborrow where bookName = ? and bookBorrowPeople = ?", BookBorrow.class, bookName, bookBorrowPeople);
        BookList bookList = bookListDAO.querySingle("select * from booklist where bookName = ? and bookBorrowPeople = ?", BookList.class, bookName, bookBorrowPeople);
        if(bookBorrow == null || bookList == null){
            return false;//如果查询结果为空，直接返回false
        }
        //查询结果不为空，继续判断图书状态
        if(bookBorrow.getBookStatus().equals("已借出")&&bookList.getBookStatus().equals("已借出")){
            if((bookBorrowDAO.update("delete from bookborrow where bookName = ? and bookBorrowPeople = ?", bookName, bookBorrowPeople)!=-1)&&(bookListDAO.update("update booklist set bookStatus = '未借出',bookBorrowPeople = null,returnDate = ? where bookName = ? and bookBorrowPeople = ?",returnDate,bookName,bookBorrowPeople)!=-1)&&(booKBorrowRecordDAO.update("update bookborrowrecord set bookStatus = '已归还',returnDate = ? where bookName = ? and bookBorrowPeople = ?",returnDate,bookName,bookBorrowPeople)!=-1)){
                return true;
            };
        }
        return false;

    }

}
