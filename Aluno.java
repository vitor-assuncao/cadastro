import PessoaT.Pessoa;
import java.io.Serializable;
import javax.swing.JOptionPane;
/**
 * Classe que representa o conceito de um aluno.
 * 
 * @author André Cavalcanti Teles dos Santos,João Marcos Ribeirete Garbelini,Mateus Neves Erédia,Vitor Assunção Silva
 * @version 4.1 - 21/05/2023
 */
public class Aluno extends Pessoa implements Serializable {
    String ra;
    int serie;
    int quantidade;
    Disciplina disc[];

    /**
     * Aluno Construtor para montar dados do aluno
     *
     * @param nome String, nome 
     * @param idade int, idade 
     * @param ra String, ra 
     * @param serie int, serie 
     * @param disc array de Disciplinas
     */

    Aluno(String nome, int idade, String ra, int serie,Disciplina disc[]){
        super (nome, idade);
        setRa(ra);
        setSerie(serie);
        setDisciplina(disc);
    }

    private void setRa(String ra)   
    {
        this.ra=ra;   
    }   

    public String getRa(){
        return this.ra;
    }

    private int getSerie(){
        return this.serie;
    }

    private void setSerie(int serie){
        this.serie=serie;   
    }

    private void setDisciplina(Disciplina disc[]){
        this.disc = disc;
    }

    public String toString(){
        return ("Nome: " + getNome() + ",Idade: "+ getIdade() + ",Ra: " + getRa() + ", Serie: " + getSerie());
    }  
}
