package com.Library.Services.Library.Repository;

import com.Library.Services.Library.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books,Integer> {

     Books findByBookId(int bookId);

     @Query("select t.booksCount from Books t where t.bookId = :bookId")
     int findBybooksCount(@Param("bookId") int bookId);

}
