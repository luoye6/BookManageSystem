package bms.service;

import bms.dao.BooKBorrowRecordDAO;
import bms.domain.BookBorrowRecord;

import java.util.List;

/**
 * @author 赵天宇
 * @version 1.0
 */
public class ListBookBorrowRecordService {
    //编写一个可以显示借书记录的方法，并调用BooKBorrowRecordDAO
    private BooKBorrowRecordDAO booKBorrowRecordDAO = new BooKBorrowRecordDAO();
    public List<BookBorrowRecord> listBookBorrowRecords(){
        List<BookBorrowRecord> bookBorrowRecords = booKBorrowRecordDAO.queryMulti("select * from bookborrowrecord", BookBorrowRecord.class);
        if(bookBorrowRecords==null){
            return null;
        }
        return bookBorrowRecords;


    }
}
