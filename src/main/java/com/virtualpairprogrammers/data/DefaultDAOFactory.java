package com.virtualpairprogrammers.data;

public class DefaultDAOFactory {
    private static DefaultDAO dao;

    public static DefaultDAO getDao() {
        if (dao == null) {
            dao = new DefaultDAO();
        }
        return dao;
    }
}
