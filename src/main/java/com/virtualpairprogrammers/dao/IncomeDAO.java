package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.model.Income;

import java.util.List;

public interface IncomeDAO {
    /**
     * Returns all {@link Income} records.
     *
     * @return list of {@link Income}s
     */
    List<Income> findAll();
}
