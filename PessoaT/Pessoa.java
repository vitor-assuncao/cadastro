package PessoaT;
import java.io.Serializable;
/**
 * Classe que representa o conceito de uma Pessoa.
 * 
 * @author André Cavalcanti Teles dos Santos,João Marcos Ribeirete Garbelini,Mateus Neves Erédia,Vitor Assunção Silva
 * @version 20/04/2023
 */
public class Pessoa implements Serializable{
    // variaveis de instancia 
    private int idade;
    private NomePessoa nome;

    /**
     * Instanciar uma pessoa
     * 
     *
     * @param nome String, nome da pessoa
     * @param idade int, idade da pessoa
     */
    public Pessoa(String nome, int idade) {
        setIdade(idade);
        setNome(nome);
    }

    /**
     * setIdade - altera a idade
     * @param idade int
     */
    private void setIdade(int idade) {
        this.idade = idade;   
    }

    /**
     * setNome - altera atributo nome
     * @param nome string
     */
    private void setNome(String nome) {
        this.nome = new NomePessoa(nome);   
    }

    public String getNome(){
        return this.nome.getNome(); 
    }

    public int getIdade(){
        return this.idade; 
    }

    public String getNomeInvertido(){
        return (this.nome.getNomeInvertido());
    }

    public String toString(){
        return ("Nome: " + getNome() + ", Idade: " + getIdade());
    }   
}
