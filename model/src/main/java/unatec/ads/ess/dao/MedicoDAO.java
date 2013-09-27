/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unatec.ads.ess.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import unatec.ads.ess.model.Medico;

/**
 *
 * @author emilianoeloi
 */
public class MedicoDAO extends BaseDaoImpl<Medico, String>{
    
    Dao<Medico, String> medicoDAO;
    
    public MedicoDAO(ConnectionSource connectionSource) throws SQLException{
        super(Medico.class);
    }
    
}
