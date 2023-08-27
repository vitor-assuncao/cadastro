import texto.Texto;
import PessoaT.Pessoa;
import PessoaT.NomePessoa;
import java.io.Serializable;
/**
 * Classe que representa a idea de uma disciplina
 * 
 * @author André Cavalcanti Teles dos Santos,João Marcos Ribeirete Garbelini,Mateus Neves Erédia,Vitor Assunção Silva
 * @version 4.1 - 21/05/2023
 */
public class Disciplina implements Serializable{
    private float nota;
    String materia;
    public Texto nomeDisc;
    Disciplina disc;
    /**
     * Construtor dos objetos desta classe (disciplina)
     */
    public Disciplina(String disciplina, float nota) {
        setDisciplina(disciplina);
        setNota(nota);
    }

    public void setDisciplina(String disciplina){
        this.nomeDisc= new Texto(disciplina);
    }

    public void setNota(float nota){
        this.nota=nota;
    }

    public String getDisciplina(){
        return this.nomeDisc.getTxt(); 
    }

    public float getNota(){
        return this.nota;
    }

    public String toString(){
        return (getDisciplina() + ",Nota: "+ getNota());
    }  
}
