
package sistemadefinicaodenotas;

public class Aluno extends Pessoa{
    private float av1 = 0;
    private float av2 = 0;
    private float av3 = 0;
    
    public void setAV1(float av1){
        this.av1 = av1;
    }
    
    public void setAV2(float av2){
        this.av2 = av2;
    }
    
    public void setAV3(float av3){
        this.av3 = av3;
    }
    
    public float getAV1(){
        return av1;
    }
    
    public float getAV2(){
        return av2;
    }
    
    public float getAV3(){
        return av3;
    }
    
    
    public void imprimirAluno(){
        float media = media();
        System.out.println(
        "**********************************************************************"
            );
            System.out.print("||Nome: " + nome); 
            System.out.print("|| Matricula:" + matricula);
            System.out.print("|| AV1: " + av1);
            System.out.print("|| AV2: " + av2);
            System.out.print("|| AV3: " + av3);
            
            System.out.print("|| Media: " + media);
                System.out.print(
            "||" + ((media>=7f)? "Aprovado":"Reprovado") + "\n"
            );
            
    }
    
    public float media(){
        if(av1 == 0 && av2 == 0){
            return 0f;
        }else{
            float media;
            if(getAV1() >= getAV3() && getAV2() >= getAV3()){
                //a terceira nota e a menor entao é descartada
                media = getAV1() + getAV2();
            //a terceira nota não é a menor
            }else{
                //verifica se a menor é a av1 ou a av3
                media = getAV3() + ((getAV1() >= getAV2())? getAV1() : getAV2());
            
            }
            media /= 2;
            return media;     
        }
            
    }
    

    
}
