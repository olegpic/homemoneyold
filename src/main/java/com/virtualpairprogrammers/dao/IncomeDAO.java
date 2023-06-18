package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.model.Income;

import java.util.List;

public interface IncomeDAO {
    List<Income> findAll();
}
