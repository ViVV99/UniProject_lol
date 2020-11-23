package sistemadefinicaodenotas;

import java.util.*;

public class Professor extends Pessoa{
    private String formacao = "";
    public void setFormacao(String formacao){
        this.formacao = formacao;    
    }
    
    public String getFormacao(){
        return formacao;
    }
    
    public void setNotas(Aluno aluno){
        Scanner scn = new Scanner(System.in);
        int validacao = -1;
        float[] notas = new float[3];
        float nota = 0;
        short qntnotas = 0;
        do{
            try{
                System.out.println("Quantas notas deseja colocar(0 para cancelar)?");
                qntnotas = scn.nextShort();
                if(qntnotas < 0 ||qntnotas > 3){
                    System.out.println("Erro! Quantidade de notas deve estar entre 1 e 3!\n");
                    continue;
                }
                for(short i = 0; i<qntnotas; i++){
                    System.out.print("AV" + (i+1) + ": ");
                    nota = scn.nextFloat();
                    if(nota < 0 || nota > 10){
                        System.out.println("Notas tem que ser entre 0 e 10");
                        i--;
                    }else{
                        notas[i] = nota;
                    }
                }
            }catch(InputMismatchException e){
                System.out.print("Apenas numeros por favor:\n\n");
                scn.nextLine();
                //como vai repetir todo o loop novamente, é necessario
                //redefinir todas as notas pois av2 pode conter um valor antes do
                //erro e o usuario escolher por apenas uma nota, na hora de settar
                //essa nota antiga também será settada.
                notas[0] = 0;
                notas[1] = 0;
                notas[2] = 0;
                continue;
            }
            validacao = 0;
        }while(validacao != 0);
        aluno.setAV1(notas[0]);
        aluno.setAV2(notas[1]);
        aluno.setAV3(notas[2]);
        System.out.print("Notas adicionadas! ");
    }

@Override
public void setDados(){
        short submenu = -1;
        //matricula
        int m = 0;
        Scanner scn = new Scanner(System.in);
        do{ 
            try{
                System.out.println("Digite seus dados:\nNome: ");
                this.setNome(scn.nextLine());
                System.out.println("Formacao: ");
                this.setFormacao(scn.nextLine());
                System.out.println("Senha: ");
                this.setSenha(scn.nextLine());
                System.out.println("\nMatricula: ");
                m = scn.nextInt();
                if(m>2000000000 && m<2021000000){
                    this.setMatricula(m);
                }else{
                    System.out.println(
                    "Matricula deve estar entre '2000000000' e '2021000000'"
                    );
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
}


