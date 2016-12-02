/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import java.util.List;

/**
 *
 * @author srostantkritikos06
 */
public interface DAOFacade<T> {
    public T create(T entity);
    public boolean delete(T entity);
    public T edit(T entity);
    public T find(T entity);
    public List<T> getAll();
}
