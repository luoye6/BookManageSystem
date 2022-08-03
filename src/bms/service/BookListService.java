package bms.service;

import bms.dao.BookBorrowDAO;
import bms.dao.BookListDAO;
import bms.domain.BookList;

import java.awt.print.Book;
import java.util.List;

/**
 * @author 赵天宇
 * @version 1.0
 */
public class BookListService {
    private BookListDAO bookListDAO = new BookListDAO();
    //编写一个返回图书信息的方法
    public List<BookList> list(){
        return bookListDAO.queryMulti("select * from bookList",BookList.class);
    }
}
