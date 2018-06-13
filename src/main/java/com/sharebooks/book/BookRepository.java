package com.sharebooks.book;

import com.sharebooks.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

public interface BookRepository  extends CrudRepository<Book, Long> {

    @Modifying
    @Query("update Book b set b.borrowedDateFrom = ?1, b.borrowedDateTo = ?2, b.status = ?3 where b.id = ?4")
    int setBorrowedDatesFor(Date borrowedDateFrom, Date borrowedDateTo, String status, Long id);

    @Nullable
    List<Book> findByUser(User user);

    @Nullable
    List<Book> findByStatus(String status);
}
