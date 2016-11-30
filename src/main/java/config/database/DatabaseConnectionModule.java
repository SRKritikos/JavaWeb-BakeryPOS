/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.database;

import com.google.inject.AbstractModule;

/**
 *
 * @author srostantkritikos06
 */
public class DatabaseConnectionModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IDatabaseConnection.class).to(SchoolDatabaseConnection.class);
    }
    
}
