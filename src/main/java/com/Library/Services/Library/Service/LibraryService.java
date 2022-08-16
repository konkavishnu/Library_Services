package com.Library.Services.Library.Service;


import com.Library.Services.Library.Entity.Books;
import com.Library.Services.Library.Repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LibraryService {

    @Autowired
    private BookRepository Bk_Repo;


    public Books SaveBooks(Books books){

        log.info("Inside Save Books  of Library Service");
        return Bk_Repo.save(books);
    }

    public int getNoBooks(int bookId){
        log.info("Inside getNoBooks  of Library Service");
        return Bk_Repo.findBybooksCount(bookId);
    }

    public Books ActionBk (int action , int bookId){
        log.info("Inside ActionBk  of Library Service");

        if (bookId != 0) {
            Books Bk = Bk_Repo.findByBookId(bookId);
            Bk.setAction(action);
            return Bk_Repo.save(Bk);
        }
        else{
            return Bk_Repo.findByBookId(bookId);
        }
    }

    public Books SearchBk(int bookId){
        log.info("Inside SearchBk of Library Service");

        return Bk_Repo.findByBookId(bookId);
    }
}
