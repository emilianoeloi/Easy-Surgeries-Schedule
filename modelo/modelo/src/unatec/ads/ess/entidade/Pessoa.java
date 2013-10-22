/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unatec.ads.ess.entidade;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author USER
 */
@DatabaseTable(tableName = "pessoas")
public class Pessoa {

    @DatabaseField(generatedId = true, columnName = "pessoa_id", allowGeneratedIdInsert = true)
    private int id;
    @DatabaseField(columnName = "pessoa_nome")
    private String nome;
    @DatabaseField(columnName = "pessoa_email")
    private String email;
    @DatabaseField(columnName = "pessoa_telefone")
    private String telefone;
    @DatabaseField(columnName = "pessoa_login")
    private String login;
    @DatabaseField(columnName = "pessoa_hash_senha")
    private String hashSenha;
    
    public Pessoa() {
        // ORMLite needs a no-arg constructor
    }

    public Pessoa(int id, String name, String email, String telefone, String login, String hashSenha) {
        this.id = id;
        this.nome = name;
        this.email = email;
        this.telefone = telefone;
        this.login = login;
        this.hashSenha = hashSenha;
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the hashSenha
     */
    public String getHashSenha() {
        return hashSenha;
    }

    /**
     * @param hashSenha the hashSenha to set
     */
    public void setHashSenha(String hashSenha) {
        this.hashSenha = hashSenha;
    }
}