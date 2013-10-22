/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unatec.ads.ess.entidade;

import unatec.ads.ess.entidade.Pessoa;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author USER
 */
@DatabaseTable(tableName = "medicos")
public class Medico {

    @DatabaseField(generatedId = true, columnName = "medico_id", allowGeneratedIdInsert = true)
    private int id;
    @DatabaseField(canBeNull = false, columnName = "medico_crm")
    private String crm;
    @DatabaseField(canBeNull = false, foreign = true, columnName = "especialidade_id")
    private Pessoa pessoa;

    public Medico() {
        // ORMLite needs a no-arg constructor 
        pessoa = new Pessoa();
    }

    public Medico(int id, String crm, Pessoa pessoa) {
        this.id = id;
        this.crm = crm;
        this.pessoa = pessoa;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the especialidades
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param especialidades the especialidades to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}