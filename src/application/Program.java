/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entities.Cliente;
import entities.Ordem;
import entities.OrdemItem;
import entities.Produto;
import entities.enums.OrdemStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Program {

    
    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        Scanner leia = new Scanner(System.in);
        
        
        
        System.out.println("Informe os dados do cliente");
        System.out.println("");
        System.out.print("Nome: ");
        String nome = leia.nextLine();
        System.out.print("Email: ");
        String email = leia.nextLine();
        System.out.print("Informe a data de nascimento (dd/MM/yyyy): ");
        Date dataNascimento = sdf1.parse(leia.next());
 
        Cliente cliente = new Cliente (nome, email, dataNascimento);
        
        System.out.println(cliente.toString());
            
        
        System.out.print("Status:");
        OrdemStatus status = OrdemStatus.valueOf(leia.next());
        
        System.out.println("");
        
        
        System.out.print("Quantas ordens de produtos deseja inserir: ");
        int qtdOrdem = leia.nextInt();
        System.out.println("");
        
        Ordem ordem = new Ordem(new Date(), status, cliente);
            
        for(int i = 0; i<qtdOrdem; i++){
            
            Date dataOrdem = new Date();
            sdf2.format(dataOrdem);
            
            System.out.println("Informe os dados da ordem");
            System.out.print("");
            System.out.print("Nome do produto: ");
            String nomeProduto = leia.next(); 
            System.out.print("Preço: ");
            Double precoProduto = leia.nextDouble();

            Produto produto = new Produto (nomeProduto, precoProduto);
            
            
            System.out.print("Quantidade: ");
            int qtdProduto = leia.nextInt();
            
            OrdemItem ordemItem = new OrdemItem (qtdProduto, precoProduto, produto);
            
            ordem.addOrdemItem(ordemItem);
            
        }
        
        System.out.println("");
        System.out.println("Resumo de ordem");
        System.out.println(ordem.or());
        
        System.out.println("");
        
        
    }
    
}
