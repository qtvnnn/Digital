/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0004<br>
 * Digital News<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-18    1.0        NangNN           First Version<br>
 */
package dao.impl;

import context.DBContext;
import dao.DigitalDAO;
import entity.News;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements functions of the <code>DigitalDAO</code> interface.<br>
 * This class contains methods to query select data from the table <code>News</code>.<br>
 * There are get Top of <code>News</code>, Search <code>News</code>, get all quantity of 
 * <code>News</code>, get <code>News</code> By ID.
 *
 * @author nangnnhe130538
 */
public class DigitalDAOImpl extends DBContext implements DigitalDAO {

    /**
     * Select a record digital news from <code>News</code> table by id in the database
     *
     * @param id it is a <code>int</code>
     * @return a <code>News</code> object
     * @throws Exception
     */
    @Override
    public News getNewsById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = "select * from news where id = ?";
        try {
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                News news = new News(result.getInt("ID"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("image"),
                        result.getString("author"),
                        result.getDate("timePost"),
                        result.getString("shortDes"));
                return news;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(result);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return null;
    }

    /**
     * Select a number of the latest digital news from <code>News</code> table in the database
     *
     * @param top it is an <code>int</code>
     * @return a list of <code>News</code> object. It is a <code>java.util.List</code> object
     * @throws Exception
     */
    @Override
    public List<News> getTop(int top) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<News> list = new ArrayList<>();
        String query = "select top (?) * from news\n"
                + "order by timePost desc";
        try {
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setInt(1, top);
            result = statement.executeQuery();
            while (result.next()) {
                News news = new News(result.getInt("ID"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("image"),
                        result.getString("author"),
                        result.getDate("timePost"),
                        result.getString("shortDes"));
                list.add(news);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(result);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return list;
    }

    /**
     * Search digital news by title from News <code>News</code> in database and paging
     *
     * @param txt it is a <code>java.lang.String</code>
     * @param pageIndex it is an <code>int</code> 
     * @param pageSize it is an <code>int</code> 
     * @return a list of <code>News</code> object. It is a <code>java.util.List</code> object
     * @throws Exception
     */
    @Override
    public List<News> search(String txt, int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<News> list = new ArrayList<>();
        String query = "select *from("
                + "select ROW_NUMBER() over (order by ID ASC) as rn, *\n"
                + "from news where title \n"
                + "like ?"
                + ")as x\n"
                + "where rn between ?*?-2"
                + "and ?*?";
        try {
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, "%" + txt + "%");
            statement.setInt(2, pageIndex);
            statement.setInt(3, pageSize);
            statement.setInt(4, pageIndex);
            statement.setInt(5, pageSize);
            result = statement.executeQuery();
            while (result.next()) {
                News news = new News(result.getInt("ID"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getString("image"),
                        result.getString("author"),
                        result.getDate("timePost"),
                        result.getString("shortDes"));
                list.add(news);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(result);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return list;
    }

    /**
     * Select all the number of digital news records by title
     *
     * @param txt it is a <code>java.lang.String</code> 
     * @return a number. It is an <code>int</code> 
     * @throws Exception
     */
    @Override
    public int count(String txt) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        int count = 0;
        try {
            String query = "select count(*) from news \n"
                    + "where title like ?";
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, "%" + txt + "%");
            result = statement.executeQuery();
            while (result.next()) {
                count = result.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(result);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return count;
    }
}
