package bms.service;

import bms.dao.BooKBorrowRecordDAO;
import bms.dao.BookBorrowDAO;
import bms.dao.BookListDAO;
import bms.domain.BookBorrow;
import bms.domain.BookBorrowRecord;
import bms.domain.BookList;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author 赵天宇
 * @version 1.0
 */
public class BookBorrowService {
    private BookBorrowDAO bookBorrowDAO = new BookBorrowDAO();
    private BookListDAO bookListDAO = new BookListDAO();
    private BooKBorrowRecordDAO booKBorrowRecordDAO = new BooKBorrowRecordDAO();
    //编写实现借书的操作，并调用BookBorrowDAO,对数据库进行增删改查操作
    public boolean BorrowBooks(String bookName, String bookBorrowPeople, LocalDate bookBorrowDate){
        BookList bookList = bookListDAO.querySingle("select * from booklist where bookName = ?", BookList.class, bookName);
        if(bookList == null){
            return false;
        }
        if(bookList.getBookStatus().equals("未借出")){
            if((bookBorrowDAO.update("insert into bookborrow values(?,?,'已借出',?,?)",null,bookName,bookBorrowPeople,bookBorrowDate)!=-1)&&(bookListDAO.update("update booklist set bookStatus = '已借出',bookBorrowPeople = ?,returnDate = null where bookName = ?",bookBorrowPeople,bookName)!=-1)&&(booKBorrowRecordDAO.update("insert into bookborrowrecord values(null,?,'未归还',?,?,null)",bookName,bookBorrowPeople,bookBorrowDate)!=-1)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
