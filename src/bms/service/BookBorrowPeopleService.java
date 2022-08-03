package bms.service;

import bms.dao.BookBorrowDAO;
import bms.dao.BookBorrowPeopleDAO;
import bms.domain.BookBorrowPeople;

/**
 * @author 赵天宇
 * @version 1.0
 */
public class BookBorrowPeopleService {
        private BookBorrowPeopleDAO bookBorrowPeopleDAO = new BookBorrowPeopleDAO();
        //编写一个校验用户名和密码的方法
        public BookBorrowPeople getBBPbyNameAndPwd(String bbpId,String pwd){
            return bookBorrowPeopleDAO.querySingle("select * from bookborrowpeople where bbpId = ? and pwd=md5(?)",BookBorrowPeople.class,bbpId,pwd);
        }
}
