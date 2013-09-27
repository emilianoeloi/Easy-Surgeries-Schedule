/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unatec.ads.ess.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author emilianoeloi
 */
@DatabaseTable(tableName = "medico")
public class Medico extends Pessoa {

        @DatabaseField(id = true)
	private String crm;

        @DatabaseField
	private String nome;

        @DatabaseField
	private String email;

        @DatabaseField
	private String telefone;

}
