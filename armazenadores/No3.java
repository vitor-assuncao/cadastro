package armazenadores;
/**
 * @author jarakaki
 * @version 20210527
 */
public class No3 {
    private Object conteudo;  // dados do No3
    private No3 proximo;       // proximo na lista
    private No3 anterior;      // anterior na lista
    long id;                  // id do No3         
    
    /**
     * constructor
     * 
     * @param conteudo dados do No3
     */
    public No3(Object conteudo) {   // 
        setConteudo(conteudo);
        setProximo(null);
        setAnterior(null);
        setId(0);
    }
    /**
     * No3 Construtor
     *
     * @param conteudo dados do No3
     * @param id id do No3
     */
    public No3(Object conteudo, long id){
        setConteudo(conteudo);
        setProximo(null);
        setAnterior(null);
        setId(id);
    }

    /**
     * @return conteudo do No3
     */
    public Object getConteudo() {
        return this.conteudo;
    }

    /**
     * @param conteudo dados do No3
     */
    public void setConteudo(Object conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * @return endereco do proximo No3
     */
    public No3 getProximo() {
        return proximo;
    }

    /**
     * @param proximo endereco do proximo No3
     */
    public void setProximo(No3 proximo) {
        this.proximo = proximo;
    }

    /**
     * @return endereco do No3 anterior
     */
    public No3 getAnterior() {
        return anterior;
    }

    /**
     * @param anterior endereco do No3 anterior
     */
    public void setAnterior(No3 anterior) {
        this.anterior = anterior;
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
     * @return O valor de retorNo3
     */
    public long getId(){
        return (this.id);
    }
    /**
     * Retorna o conteudo do No3 como String
     */
    public String toString() { 
        //return "ID: " + getId() + " " + getConteudo().toString(); 
        return getConteudo().toString(); 
    }
} 
