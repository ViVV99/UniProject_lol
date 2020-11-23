package sistemadefinicaodenotas;

import java.util.*;

public class Pessoa {
    protected String nome = "";
    protected int matricula = 0;
    protected String senha = "";
    
    public void Pessoa(){
    
    }
    
    public void setNome(String nome){
       this.nome = nome;

    }
    
    public void setMatricula(int matricula){
        this.matricula = matricula;
      
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public void setDados(){
        short submenu = -1;
        //matricula
        int m = 0;
        Scanner scn = new Scanner(System.in);
        do{ 
            try{
                System.out.print("Digite seus dados:\nNome: ");
                this.setNome(scn.nextLine());
                System.out.print("Senha: ");
                this.setSenha(scn.nextLine());
                System.out.print("\nMatricula: ");
                m = scn.nextInt();
                 if(m>2000000000 && m<2021000000){
                    this.setMatricula(m);
                }else{
                    System.out.println(
                    "Matricula deve estar entre '2000000000' e '2021000000'"
                    );
                    scn.nextLine();
                    continue;
                }
            }catch(InputMismatchException e){
                System.out.println("Erro! Digite os dados novamente: ");
                scn.nextLine();
                continue;
            }   
            submenu = 0;
        }while(submenu != 0);
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getMatricula(){
        return matricula;
    }
    
    public String getSenha(){
        return senha;
    }
}
