/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import config.database.IDatabaseConnection;
import data.entities.Cateringorder;

/**
 *
 * @author srostantkritikos06
 */
public class CateringOrderDAOImpl extends DAOFacade<Cateringorder> {
    
    public CateringOrderDAOImpl(IDatabaseConnection dbCon) {
        super(dbCon, Cateringorder.class);
    }
  
    
}
