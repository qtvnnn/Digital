/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0004<br>
 * Digital News<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-18    1.0        NangNN           First Version<br>
 */
package dao;

import entity.News;
import java.util.List;

/**
 * The interface of <code>DigitalDaoImpl</code> class defines methods to help us 
 * manipulate <code>News</code> object from <code>News</code> tables in database.
 *
 * @author nangnnhe130538
 */
public interface DigitalDAO {

    /**
     * Select a number of the latest digital news from <code>News</code> table in the database
     *
     * @param top it is an <code>int</code>
     * @return a list of <code>News</code> object. It is a <code>java.util.List</code> object
     * @throws Exception
     */
    public List<News> getTop(int top) throws Exception;

    /**
     * Select a record digital news from <code>News</code> table by id in the database
     *
     * @param id it is a <code>int</code>
     * @return a <code>News</code> object
     * @throws Exception
     */
    public News getNewsById(int id) throws Exception;

    /**
     * Search digital news by title from <code>News</code> table in database and paging
     *
     * @param txt it is a <code>java.lang.String</code>
     * @param pageIndex it is an <code>int</code> 
     * @param pageSize it is an <code>int</code> 
     * @return a list of <code>News</code> object. It is a <code>java.util.List</code> object
     * @throws Exception
     */
    public List<News> search(String txt, int pageIndex, int pageSize) throws Exception;

    /**
     * Select all the number of digital news records by title
     *
     * @param txt it is a <code>java.lang.String</code> 
     * @return a number. It is an <code>int</code> 
     * @throws Exception
     */
    public int count(String txt) throws Exception;

}
