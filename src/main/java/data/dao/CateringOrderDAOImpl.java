/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import config.database.IDatabaseConnection;
import data.entities.Cateringorder;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author srostantkritikos06
 */
@Stateless
public class CateringOrderDAOImpl extends DAOFacade<Cateringorder> implements ICateringOrderDAO{
    
    @Inject
    @Named("homedbcon")
    public CateringOrderDAOImpl(IDatabaseConnection dbCon) {
        super(dbCon, Cateringorder.class);
    }
    
}
