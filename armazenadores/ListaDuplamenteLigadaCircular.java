package armazenadores;
import java.util.Random;
public class ListaDuplamenteLigadaCircular implements IArmazenador {
    private No2 inicio; // ref para primeiro elemento
    private No2 fim;    // ref para ultimo elemento

    int qtdNo2s; // Quantidade de No2s
    private Random r = new Random(System.currentTimeMillis());

    // -------------------------------------------------------------
    public ListaDuplamenteLigadaCircular() {   
        setInicio(null);
        setFim(null);
        setQtdNo2s(0);
    }
    // Setters e Getters
    /**
     * Method getInicio
     *
     * @return endereco do primeiro No2
     */
    public No2 getInicio() {
        return inicio;
    }

    public void setInicio(No2 inicio) {
        this.inicio = inicio;
    }

    /**
     * Method getFim
     *
     * @return endereco do ultimo No2
     */
    public No2 getFim() {
        return fim;
    }

    public void setFim(No2 fim) {
        this.fim = fim;
    }

    /**
     * Metodo getQtdNo2s
     *
     * @return qtidade de No2s
     */
    public int getQtdNo2s(){
        return this.qtdNo2s;
    }

    /**
     * Metodo setQtdNo2s
     *
     * @param qtdNo2s atualiza qtde de No2s
     */
    private void setQtdNo2s(int qtdNo2s){
        this.qtdNo2s = qtdNo2s;
    }

    public int getQtd(){
        return this.qtdNo2s;
    }
    // -------------------------------------------------------------
    public boolean estaVazia() {
        return getInicio() == null; 
    }
    
     public Object buscar (int i){
        
         int aux = 0;

        No2 prox = getInicio();
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

    // -------------------------------------------------------------
    public void inserirInicio(Object elem) {

        No2 NovoNo2 = new No2(elem, r.nextLong());   // make new link

        if( estaVazia() ) { 
            setFim(NovoNo2);
        } else {
            getInicio().setAnterior(NovoNo2); // 1
        }
        NovoNo2.setProximo(getInicio()); // 2
        setInicio(NovoNo2); // 3
        getFim().setProximo(getInicio()); // 4
        getInicio().setAnterior(getFim()); //5
        // Decrementa qtidade de No2s
        setQtdNo2s(getQtdNo2s() + 1);

    }

    // -------------------------------------------------------------
    public void adicionar(Object elem)    {//void inserirFim
        No2 NovoNo2 = new No2(elem, r.nextLong());  

        if( estaVazia() ) {
            setInicio(NovoNo2);
        } else {
            getFim().setProximo(NovoNo2); //1
            NovoNo2.setAnterior(getFim()); //2
        }
        setFim(NovoNo2); //3
        getFim().setProximo(getInicio()); // 4
        getInicio().setAnterior(getFim()); //5
        // Incrementa quantidade de No2s
        setQtdNo2s(getQtdNo2s() + 1);

    }

    // -------------------------------------------------------------
    public No2 removerInicio() {
        No2 temp = null;
        if(getInicio() != null && getFim() != null) {
            temp = getInicio();

            if (getInicio() == getFim()) {
                setInicio(null);
                setFim(null);
            } else {
                getFim().setProximo(getInicio().getProximo());
                getInicio().getProximo().setAnterior(getFim()); 
                setInicio(getInicio().getProximo());
            }
            temp.setAnterior(null);
            temp.setProximo(null);
        }
        // Decrementa qtidade de No2s
        setQtdNo2s(getQtdNo2s() - 1);
        return temp;
    }

    // -------------------------------------------------------------
    public No2 removerFim() {
        No2 temp = null;
        if(getFim() != null && getInicio() != null) {
            temp = getFim();

            if(getFim() == getInicio()) {
                setFim(null);
                setInicio(null); 
            }
            else {
                getInicio().setAnterior(getFim().getAnterior());
                setFim(getFim().getAnterior());
                getFim().setProximo(getInicio());
            }
            temp.setAnterior(null);
            temp.setProximo(null);
        }
        // Decrementa qtidade de No2s
        setQtdNo2s(getQtdNo2s() - 1);
        return temp;
    }

    // -------------------------------------------------------------
    public boolean inserirApos(long key, Object elem) {
        No2 No2Atual = getInicio(); 

        while((Long)No2Atual.getId() != key) {
            if(No2Atual == getFim()) {
                return false; 
            }
            No2Atual = No2Atual.getProximo(); 
        }
        No2 NovoNo2 = new No2(elem, r.nextLong());

        if(No2Atual==getFim()) {
            NovoNo2.setProximo(getInicio()); 
            setFim(NovoNo2); 
        }
        else {
            NovoNo2.setProximo(No2Atual.getProximo());
            No2Atual.getProximo().setAnterior(NovoNo2);
        }
        NovoNo2.setAnterior(No2Atual);
        No2Atual.setProximo(NovoNo2); 
        // Incrementa quantidade de No2s
        setQtdNo2s(getQtdNo2s() + 1);
        return true; 
    }

    // -------------------------------------------------------------
    public Object remover(int i) {
        No2 No2Atual = null;
        int aux=0;
        if(getInicio() != null) {
            No2Atual = getInicio();
            
            while(aux != i) { //(Long)No2Atual.getId() != chave
                if(No2Atual == getFim()) {
                    return null;  
                }
                No2Atual = No2Atual.getProximo(); 
                aux++;
            }

            if(No2Atual == getInicio()) {
                No2Atual = removerInicio();
            } else if (No2Atual == getFim()) {
                No2Atual = removerFim();
            }
            else {
                No2Atual.getAnterior().setProximo(No2Atual.getProximo());
                No2Atual.getProximo().setAnterior(No2Atual.getAnterior());
                // Decrementa qtidade de No2s
                setQtdNo2s(getQtdNo2s() - 1);
            }
            No2Atual.setAnterior(null);
            No2Atual.setProximo(null);

        }
        return No2Atual;
    }
    
    /*public Object remover(int i){
        int v = 0;

        No2 ant = getInicio();
        No2 prox = getInicio();
        No2 aux = null;

        Object obj = null;

        if(!estaVazia()){
            if(i >= 0 && i < getQtd()){
                if(i == 0)
                    obj = removerInicio();
                else if(i == getQtd() - 1)
                    obj = removerFim();
                else{
                    while(v != i){
                        ant = prox;
                        prox = prox.getProximo();
                        v++;
                    }

                    ant.setProximo(prox.getProximo());
                    setQtd(getQtd() - 1);
                    obj = prox.getConteudo();

                }
            }
        }

        return obj;
    }
     * 
     * /*
     */

    // -------------------------------------------------------------
    public String toString() {
        String s = "[ ";
        No2 No2Atual = getInicio();  // inicia do inicio
        if(No2Atual != null) {
            do {   
                s = s + No2Atual.toString() + " ";  
                No2Atual = No2Atual.getProximo();   
            } while(No2Atual != getInicio());
        }
        s = s + "]";
        return s;
    }

    // -------------------------------------------------------------
    public String toStringDoFim() {
        String s = "[ ";
        No2 No2Atual = getFim();  // inicia No2 fim

        if(No2Atual != null) {
            do {
                s = s + No2Atual.toString() + " "; 
                No2Atual = No2Atual.getAnterior(); 
            }while(No2Atual != getFim());
        }
        s = s + "]";
        return s;
    }

    public void limparLista() {

        No2 temp = getInicio();

        while (temp != getFim()) {
            removerFim();
        }

        setInicio(null);
        setFim(null);

    }
}  
