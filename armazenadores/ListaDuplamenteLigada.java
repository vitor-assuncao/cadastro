package armazenadores;
import java.util.Random;
/**
 * classe: ListaDuplamenteLigada
 *     Implementa a TAD Lista Duplamente Ligada
 * 
 * @author Julio Arakaki
 * @version 20210527
 */
public class ListaDuplamenteLigada implements IArmazenador {
    private No3 inicio; // ref para primeiro elemento
    private No3 fim;    // ref para ultimo elemento

    int qtdNos; // Quantidade de nos
    
    // Para o ID do No (utiliza o timer do computador)
    private Random r = new Random(System.currentTimeMillis());

    /**
     * Construtor da Lista
     */
    public ListaDuplamenteLigada() {   
        setInicio(null);
        setFim(null);
        setQtdNos(0);
    }

    // Setters e Getters
    /**
     * @return endereco do primeiro elemento da lista
     */
    public No3 getInicio() {
        return inicio;
    }

    /**
     * @param inicio endereco do primeiro elemento da lista
     */
    public void setInicio(No3 inicio) {
        this.inicio = inicio;
    }

    /**
     * @return endereco do ultimo elemento da lista
     */
    public No3 getFim() {
        return fim;
    }

    /**
     * @param fim endereco do ultimo elemento da lista
     */
    public void setFim(No3 fim) {
        this.fim = fim;
    }

    /**
     * Metodo getQtdNos
     *
     * @return qtidade de nos
     */
    public int getQtd(){
        return this.qtdNos;
    }

    /**
     * Metodo setQtdNos
     *
     * @param qtdNos atualiza qtde de nos
     */
    private void setQtdNos(int qtdNos){
        this.qtdNos = qtdNos;
    }

    /**
     * Verifica se a Lista esta vazia
     * 
     * @return true se estiver vazia e false caso contrario
     * 
     */
    public boolean estaVazia() {
        return (getInicio() == null && getFim() == null); 
    }

    /**
     * Insere um novo No no inicio da Lista
     *  
     */
    public void inserirInicio(Object elem) {

        // Cria novo No com o conteudo e ID
        No3 novoNo = new No3(elem, r.nextLong()); 

        // Insere novo no na Lista (atualizando ponteiros)
        if( estaVazia() ) {   // se a lista estiver vazia
            setFim(novoNo);
        } else {
            getInicio().setAnterior(novoNo); // this.inicio.anterior = novoNo; 
        }
        novoNo.setProximo(getInicio());
        setInicio(novoNo);
        // Incrementa quantidade de nos
        setQtdNos(getQtd() + 1);
    }

    /**
     * Insere um novo No no finsl da Lista
     *  
     */
    public void adicionar(Object elem)    {
        // Cria novo no
        No3 novoNo = new No3(elem, r.nextLong());  

        // Insere novo no na Lista (atualizando ponteiros)
        if( estaVazia() ) { // se a lista estiver vazia
            setInicio(novoNo);
             //setFim(novoNo);
        } else {
            getFim().setProximo(novoNo); 
            novoNo.setAnterior(getFim());
        }
        setFim(novoNo);
        // Incrementa quantidade de nos
        setQtdNos(getQtd() + 1);
    }

    /**
     * Insere um novo No apos um No encontrado (pela chave)
     * 
     * @param chave codigo do elemento a ser encontrado
     * 
     * @param elem elemento a ser inserido
     * 
     * @return true se o o no foi inserido e false caso contrario
     * 
     */
    public boolean inserirApos(long chave, Object elem) {
        No3 noAtual = getInicio(); 

        // percorre a lista em busca do No
        while((Long)noAtual.getId() != chave) {
            noAtual = noAtual.getProximo(); 
            if(noAtual == null) { // nao encontrou posicao
                return false;  
            }
        }

        // Cria novo no
        No3 novoNo = new No3(elem);

        // Insere novo no na Lista (atualizando ponteiros)
        if(noAtual == getFim()) {
            novoNo.setProximo(null); 
            setFim(novoNo); 
        }
        else {
            novoNo.setProximo(noAtual.getProximo());
            noAtual.getProximo().setAnterior(novoNo);
        }
        novoNo.setAnterior(noAtual);
        noAtual.setProximo(novoNo); 
        // Incrementa quantidade de nos
        setQtdNos(getQtd() + 1);

        return true; 
    }

    /**
     * Remove o primeiro No da Lista
     * 
     * @return No removido ou null se a Lista estiver vazia
     * 
     */
    public No3 removerInicio() {
        No3 temp = null;
        if(getInicio() != null) {
            temp = getInicio();
            if(getInicio().getProximo() == null) {
                setFim(null); 
            } else {
                getInicio().getProximo().setAnterior(null); 
            }
            setInicio(getInicio().getProximo());

            // isola o no removido (remove as referencias para proximo e anterior)
            temp.setProximo(null);
            temp.setAnterior(null);
        }
        // Decrementa qtidade de nos
        setQtdNos(getQtd() - 1);

        // retorna o no removido
        return temp;
    }

    /**
     * Remove o ultimo No da Lista
     * 
     * @return No removido ou null se a Lista estiver vazia
     * 
     */
    public No3 removerFim() {
        No3 temp = null;

        if(getFim() != null) {

            // Guarda o no
            temp = getFim();

            // Acerta todas as referencias (ponteiros)
            if(getInicio().getProximo() == null) {
                setInicio(null); 
            }
            else {
                getFim().getAnterior().setProximo(null);
            }
            setFim(getFim().getAnterior());

            // isola o no removido (remove as referencias para proximo e anterior)
            temp.setProximo(null);
            temp.setAnterior(null);
        }
        // Decrementa qtidade de nos
        setQtdNos(getQtd() - 1);

        // retorna o no removido
        return temp;
    }

    /**
     * Remove um No de acordo com uma chave (inteiro)
     * 
     * 0param chave numero inteiro para buscar o no a ser removido
     * 
     * @return No removido ou null caso nao encontre
     * 
     */
    public No3 remover(int i) {
        No3 temp = null; // Ponteiro para percorrer a lista
        int aux = 0;
        if(getInicio() != null) {

            temp = getInicio(); // comeca do nicio

            // Percorre ate encontrar o No, ou retorn null caso nao encontre
            while((aux != i)) {
                temp = temp.getProximo(); 
                if(temp == null) {
                    return null;                 
                }
                aux++;
            }

            // Acerta todas as referencias (ponteiros)
            if(temp == getInicio()) { // se for inicio
                setInicio(temp.getProximo());
            } else {
                temp.getAnterior().setProximo(temp.getProximo());
            }

            if(temp == getFim()) { // se for fim
                setFim(temp.getAnterior());
            } else {
                temp.getProximo().setAnterior(temp.getAnterior());
            }

            // isola o no removido (remove as referencias para proximo e anterior)
            temp.setProximo(null);
            temp.setAnterior(null);
        }
        // Decrementa qtidade de nos
        setQtdNos(getQtd() - 1);

        // retorna o no removido        
        return temp;
    }

    /**
     * Retorna o conteudo da Lista como String (do inicio ate o fim)
     */
    public String toString() {
        String s = "[ ";
        No3 noAtual = getInicio();  // inicia do inicio
        while(noAtual != null) {    // enquanto nao for fim da lista,
            s = s + noAtual.toString() + " ";  // monta os dados como string
            noAtual = noAtual.getProximo();   // vai para o proximo
        }
        s = s + "]";

        return s;
    }

    /**
     * Retorna o conteudo da Lista como String (do fim ate o inicio)
     */
    public String toStringDoFim() {
        String s = "[ ";
        No3 noAtual = getFim();  // inicia no fim

        while(noAtual != null) { // enquanto nao for inicio da lista,
            s = s + noAtual.toString() + " "; // monta os dados como string
            noAtual = noAtual.getAnterior(); // vai para o anterior
        }

        s = s + "]";

        return s;
    }
    
    public Object buscar (int i){
        
         int aux = 0;

        No3 prox = getInicio();
        Object obj = null;

        if(!estaVazia()){

            if(i >= 0 && i < getQtd()){
                while(aux != i)
                {
                    prox = prox.getProximo(); 
                    aux++;
                }  
                obj = prox.getConteudo();
            }

        }

        return obj;
        }
}  
