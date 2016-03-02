package com.epam.alex.dao;

import com.epam.alex.model.Word;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 3/1/2016.
 *
 * @author Alexander Bocharnikov
 */
@Repository(value = "myDao")
@Transactional
public class MyDao implements Dao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public List<Word> readAll() {
        Query query = getCurrentSession().createQuery("from Word");
        return query.list();
    }
}
