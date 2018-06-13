package com.sharebooks.borrowtransaction;

import com.sharebooks.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface BorrowTransactionRepository extends CrudRepository<BorrowTransaction, Long> {

    @Nullable
    List<BorrowTransaction> findByBorrower(User borrower);
}
