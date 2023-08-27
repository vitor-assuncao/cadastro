 package armazenadores;
/**
 * No2 da lista duplamente ligada
 */
public class No2{
    /**
     * Atributos
     */
    Object conteudo; // conteudo
    No2 proximo;  // proximo
    No2 anterior; // anterior
    long id;                  // id do No2         

    /**
     * Construtor
     */
    public No2(Object conteudo){
        setConteudo(conteudo);
        setProximo(null);
        setAnterior(null);
        setId(0);
    }
    /**
     * No2 Construtor
     *
     * @param conteudo dados do No2
     * @param id id do No2
     */
    public No2(Object conteudo, long id){
        setConteudo(conteudo);
        setProximo(null);
        setAnterior(null);
        setId(id);
    }
    /**
     * setters e getters
     */
    public void setConteudo(Object conteudo){
        this.conteudo = conteudo;
    }
    
    public void setProximo(No2 proximo){
        this.proximo = proximo;
    }
    
    public void setAnterior(No2 anterior){
        this.anterior = anterior;
    }

    public Object getConteudo(){
        return(this.conteudo);
    }
    
    public No2 getProximo(){
        return(this.proximo);
    }

    public No2 getAnterior(){
        return(this.anterior);
    }
    /**
     * Método setId
     *
     * @param id Um parâmetro
     */
    public void setId(long id){
        this.id = id;
    }
    
    /**
     * Método getId
     *
     * @return O valor de retorNo2
     */
    public long getId(){
        return (this.id);
    }
    
    public String toString(){
        //return "ID: " + getId() + " " + getConteudo().toString(); 
        return(conteudo.toString());
    }
}
