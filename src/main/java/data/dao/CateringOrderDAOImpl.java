/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import com.google.inject.Inject;
import config.database.IDatabaseConnection;
import data.entities.Cateringorder;
import java.util.List;

/**
 *
 * @author srostantkritikos06
 */
public class CateringOrderDAOImpl implements ICateringOrderDAO {
    private IDatabaseConnection dbCon;

    @Inject
    public CateringOrderDAOImpl(IDatabaseConnection dbCon) {
        this.dbCon = dbCon;
    }
    
    
    @Override
    public Cateringorder create(Cateringorder entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Cateringorder entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cateringorder edit(Cateringorder entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cateringorder find(Cateringorder entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cateringorder> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
