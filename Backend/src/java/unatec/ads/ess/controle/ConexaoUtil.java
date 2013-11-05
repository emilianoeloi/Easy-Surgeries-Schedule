/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unatec.ads.ess.controle;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import unatec.ads.ess.entidadeDao.Pessoas;

/**
 *
 * @author user
 */
public class ConexaoUtil {

    private static Session s = HibernateUtil.getSessionFactory().openSession(); 

    public static List<Object> autenticaLogin(Class objClass, String email,int password) {

        List<Object> listas = null;
        

        try {
            
            s.beginTransaction();
            Criteria crit = s.createCriteria(objClass);
            crit.add(Restrictions.eq("pessoa_email", email));
            crit.add(Restrictions.eq("pessoa_senha_hash", password));
            listas = crit.list();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.fillInStackTrace();
        } finally {
            //s.close();
            return listas;
        }
    }
    
    
    public static List<Object> listar(Class objClass) {

        List<Object> listas = null;
        Query query = null;

        try {
            
            s.beginTransaction();
            query = s.createQuery("From " + objClass.getSimpleName());
            listas = query.list();
            
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.fillInStackTrace();
        } finally {
            //s.close();
            return listas;
        }
    }

    public static Object selecionar(Class objClass,int id) {

        Object objGet = null;

        try {
                
            s.beginTransaction();
            objGet = s.get(objClass, id);
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.fillInStackTrace();
        } finally {
            //s.close();
            return objGet;
        }

    }

    public static boolean inserir(Object obj) {

        try {
            
            s.beginTransaction();
            s.save(obj);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.fillInStackTrace();
        } finally {
           // s.close();
            return true;
        }

    }

    public static boolean atualizar(Object obj) {

        try {
            s.beginTransaction();
            s.update(obj);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.fillInStackTrace();
        } finally {
            //s.close();
            return true;
        }

    }

    public static boolean excluir(Object obj) {

        try {
            s.beginTransaction();
            s.delete(obj);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
            e.fillInStackTrace();
        } finally {
            //s.close();
            return true;
        }

    }
}
