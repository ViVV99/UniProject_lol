package sistemadefinicaodenotas;

import java.util.*;
public class SistemaDefinicaoDeNotas {


    public static void main(String[] args){
//Variaveis e objetos************************************        
        short menu= -1; 
        short submenu = 0;
        //short submenu = -1;
        String nome, senha;
        int matricula;
        Aluno aluno;
        Professor professor;
        //como nao ha no menu meio de se criar turmas vamos definir uma antes;
        Turma turma = new Turma();
        turma.setId(861);
        turma.setNome("POO");
//*******************************************************
        System.out.println("Ola!");
        Scanner scn = new Scanner(System.in);
        do{
            System.out.println("\nEscolha umas das opcoes:\n");
            System.out.println("1 - Cadastrar Aluno\n2 - Cadastrar Professor");
            System.out.println("3 - Logar\n0 - Sair");
            try{
                menu = scn.nextShort();
                
            }catch(InputMismatchException e){
                System.out.println("Insira numeros apenas!");
                
                
            }
            //pra limpar o scanner
            scn.nextLine();
            switch(menu){
                case 0: break;
                case 1:
                    //Cadastro do Aluno
                    aluno = new Aluno();
                    aluno.setDados();
                    if(!(turma.hasPessoa(aluno))){
                        turma.setAluno(aluno);
                        System.out.println("Aluno adicionado na turma " + turma.getId());
                    }
                    break;
                case 2:
                    professor = new Professor();
                    professor.setDados();
                    if(!(turma.hasPessoa(professor))){
                        turma.setProfessor(professor);
                        System.out.println("Professor adicionado na turma " + turma.getId());
                    }
                    break;
                case 3: 
                    System.out.println("Digite sua matricula e senha para logar: ");
                    try{
                        //Busca pelo aluno na turma
                       System.out.print("Matricula: "); 
                       matricula = scn.nextInt();
                       scn.nextLine();
                       System.out.print("Senha: ");
                       senha = scn.nextLine();
                       aluno = turma.getAluno(matricula,senha);
                       if(aluno != null){
                           String nomeprof = (String) turma.getProfessor().getNome();
                           System.out.print("Professor: "  
                                  + ((nomeprof.equals(""))? "N/A" : nomeprof));
                           System.out.print("|| Turma: " + turma.getNome());
                           System.out.print(" " + turma.getId());
                           System.out.print("\n");
                           aluno.imprimirAluno();                          
                           System.out.println("\n00Deslogando...\n");
                       }else{
                           //Se nao encontrar aluno busca professor
                           professor = turma.getProfessor(matricula, senha);
                           if(professor != null){
                               submenu = -1;
                               do{
                                   System.out.println(
                                   "Ola " + professor.getNome() +"!\nEscolha "
                                   + "uma das opcoes abaixo: \n"
                                   + "1 - Obter dados da turma\n"
                                   + "2 - Definir notas de aluno\n"
                                   + "0 - Deslogar"
                                   );
                                   try{
                                    submenu = scn.nextShort();
                                   }catch(InputMismatchException e){
                                       System.out.println("Insira numeros apenas!");
                                       scn.nextLine();
                                       continue;
                                   }
                                   scn.nextLine();
                                   switch(submenu){
                                       case 0: submenu = 0; break;
                                       case 1: turma.getRelacaoAlunos(); 
                                               break;
                                       case 2:
                                           do{
                                              try{
                                                System.out.print(
                                                "Digite a matricula do aluno"
                                                + "a se definir a nota:\nMatricula: "        
                                                );
                                                matricula = scn.nextInt();
                                                aluno = turma.getAluno(matricula);
                                                if(aluno != null){
                                                    professor.setNotas(aluno);
                                                }else{
                                                    System.out.println(
                                                    "Aluno nao encontrado;"
                                                    );
                                                    }
                                                }catch(InputMismatchException e){
                                                    System.out.println(
                                                    "Erro! Digite os dados novamente: "
                                                    );
                                                    scn.nextLine();
                                                    continue;
                                                }  
                                               submenu =0;
                                           }while(submenu != 0);
                                           submenu = -1;
                                           break;
                                       default: 
                                           System.out.println("Digite apenas as opcoes!");
                                           break;
                                   }
                               
                               }while(submenu != 0);
                               
                           }else 
                                System.out.println("Usuario nao cadastrado!\n");
                       
                       }
                    }catch(InputMismatchException e){
                        System.out.println("Erro! Tente novamente!");
                        scn.next();
                    }
                    break;
                default: System.out.println("Digite apenas as opcoes!");
            }      
        }while(menu != 0);
       
        System.out.println("\n\n\n\t****Bye****");
    }
    
}
