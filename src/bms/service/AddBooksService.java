package bms.service;

import bms.dao.BookListDAO;

/**
 * @author 赵天宇
 * @version 1.0
 */
public class AddBooksService {
    private BookListDAO bookListDAO = new BookListDAO();
    //编写一个增加图书的方法，并调用BookListDAO,对数据库进行增删改查
    public boolean addBooksService(String bookName,Integer bookNumber,Integer bookPrice){
        if(bookListDAO.update("insert into booklist values(null,?,?,?,'未借出',null,null)",bookName,bookNumber,bookPrice)!=-1){
            return true;
        }
        return false;
    }
}
