package com.Library.Services.Library.Controller;


import com.Library.Services.Library.Entity.Books;
import com.Library.Services.Library.Service.LibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Library")
@Slf4j
public class LibraryController {

    @Autowired
    private LibraryService Lib_Service;

    @PostMapping("/Store")
    public Books SaveBks(@RequestBody Books books){

        return Lib_Service.SaveBooks(books);
    }

    @GetMapping("/Book_count/{id}")
    public int Find_Bks_No (@PathVariable("id") int bookId){

        return Lib_Service.getNoBooks(bookId);
    }

    @PutMapping("/{id}/{Action}")
    public Books Bk_Action(@PathVariable("id") int bookId , @PathVariable("Action") int action){
        return Lib_Service.ActionBk(action , bookId);
    }

    @GetMapping("/{id}")
    public Books getBooks(@PathVariable("id") int bookId){
        return Lib_Service.SearchBk(bookId);
    }

}
