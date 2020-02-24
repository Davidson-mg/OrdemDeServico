/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author David
 */
public class Cliente {
    
    private String nome;
    private String email;
    private Date Data_nascimento;
    

    public Cliente(String nome, String email, Date Data_nascimento) {
        this.nome = nome;
        this.email = email;
        this.Data_nascimento = Data_nascimento;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData_nascimento() {
        return Data_nascimento;
    }

    public void setData_nascimento(Date Data_nascimento) {
        this.Data_nascimento = Data_nascimento;
    }
    
    public String toString(){
    
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        return "Cliente: "+nome+" - "+sdf1.format(Data_nascimento)+" - "+email;
    
    }
    
}
