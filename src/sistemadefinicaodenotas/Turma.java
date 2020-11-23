
package sistemadefinicaodenotas;

import java.util.*;

public class Turma {
    private int idTurma = 0;
    private String nomeTurma = "";
    private List<Aluno> alunos = new ArrayList<>();
    private Professor professor = new Professor();
    
    
    boolean hasPessoa(Pessoa pessoa){
        int pessoaMatr = pessoa.getMatricula();
        if(pessoaMatr == professor.getMatricula()){
            System.out.println("Dados já cadastrados como professor");
            return true;
        }else{
            ListIterator i = alunos.listIterator();
            while(i.hasNext()){
                Aluno aluno = (Aluno) i.next();
                if(pessoaMatr == aluno.getMatricula()){
                    System.out.println("Dados já cadastrados como aluno\n");
                    return true;
                }
            }
        }
        return false;
    }
    
    void getRelacaoAlunos(){
        if(alunos.isEmpty()){
            System.out.println("\nNão há alunos nessa turma!");
            
        }else{
            Aluno aluno;
            ListIterator i = alunos.listIterator();
            float media = 0;
            while(i.hasNext()){
                //coverte para o tipo aluno
                aluno  = (Aluno) i.next();
                media = aluno.media();
                aluno.imprimirAluno();
            }
        }
    }
    
    Aluno getAluno(int matricula, String senha){
        ListIterator i = alunos.listIterator();
        Aluno aluno;
        while(i.hasNext()){
            aluno = (Aluno) i.next();
            if(matricula == aluno.getMatricula()
           && senha.equals(aluno.getSenha())){
                return aluno;
            }
        }
        return null;
    }
    
    Aluno getAluno(int matricula){
         ListIterator i = alunos.listIterator();
        Aluno aluno;
        while(i.hasNext()){
            aluno = (Aluno) i.next();
            if(matricula == aluno.getMatricula()){
                return aluno;
            }
        }
        return null;
    }
    Professor getProfessor(){
        return professor;
    }
    
    Professor getProfessor(int matricula, String senha){
        if(matricula == professor.getMatricula()
           && senha.equals(professor.getSenha())){
            return professor;  
        }
        return null;
    }
    
    void setId(int id){
        idTurma = id;
    }
    
    int getId(){
        return idTurma;
    }
    
    void setNome(String nome){
        nomeTurma = nome;
    
    }
    
    String getNome(){
        return nomeTurma;
    }
    
    void setProfessor(Professor professor){
        this.professor = professor;   
    }
    
    void setAluno(Aluno aluno){
        alunos.add(aluno);
    }   
}
