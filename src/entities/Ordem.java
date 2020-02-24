/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.enums.OrdemStatus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Ordem {
    
    private Date momento;
    private OrdemStatus status;
    
    private List<OrdemItem> ordemItem = new ArrayList<>();
    private Cliente cliente;
    

    public Ordem(){};
    
    public Ordem(Date momento, OrdemStatus status, Cliente cliente ) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
        
    }


    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public OrdemStatus getStatus() {
        return status;
    }

    public void addOrdemItem (OrdemItem ordemItem){
    
        this.ordemItem.add(ordemItem);
    
    }
    
    public void removeOrdemItem (OrdemItem ordemItem){
    
        this.ordemItem.remove(ordemItem);
        
    }
    
 
    public double total (){
    
        
        double soma = 0.0;

            for (OrdemItem i: ordemItem ) {

		soma = soma + i.subTotal();

            }

	return soma;
    }
    
    public String or(){
    
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat ("dd/MM/yyyy");
        
        StringBuilder sb = new StringBuilder();  
        sb.append("Momento da ordem: "+sdf1.format(momento)+"\n");
        sb.append("Status da ordem: "+status.Processando+"\n");     
        sb.append("Ordem de intens \n");     
        
        sb.append("Cliente: "+cliente.getNome()+" - "+sdf2.format(cliente.getData_nascimento())+" - "+cliente.getEmail());
        
        for (OrdemItem ordem : ordemItem){   
            sb.append(ordem.getProduto().getNome()+" Quantidade: "+ordem.getQuantidade()+", subtotal: "+ordem.subTotal()+"\n");          
        }
        
        sb.append("Preço total;"+total()); 
        return sb.toString();
           
    } 
    
}
