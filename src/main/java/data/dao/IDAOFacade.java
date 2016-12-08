/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author srostantkritikos06
 */
@Local
public interface IDAOFacade<T> {

  public boolean create(T entity);

  public boolean delete(T entity);

  public boolean edit(T entity);

  public T find(String id);

  public List<T> getAll();
}
