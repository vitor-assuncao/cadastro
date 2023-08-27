import javax.swing.JOptionPane;
import java.io.Serializable;
import PessoaT.Pessoa;
import PessoaT.NomePessoa;
import armazenadores.VetDin;
import armazenadores.IArmazenador;
import armazenadores.ListaArray;
import armazenadores.ListaLigadaSimples;
import armazenadores.ListaDuplamenteLigada;
import salvar.ArquivoBinario;
import armazenadores.ListaDuplamenteLigadaCircular;
/**
 * Armazenador - classe para implementar operacoes de persistencia 
 * em memoria.
 *
 * @author André Cavalcanti Teles dos Santos,João Marcos Ribeirete Garbelini,Mateus Neves Erédia,Vitor Assunção Silva
 * @version 4.1 - 21/05/2023
 */
public class CadastroAlunos implements Serializable{
    IArmazenador cadastro;
    String arquivo = "SAVE Cadastro Alunos";
    private Aluno cad;
    private Disciplina disc[];
    int k;
    /**
     * CadastroClientes Construtor para armazenar objetos em memoria
     * param int k , variavel que diferencias as interfaces graficas
     */
    CadastroAlunos(int k){
        //this.cadastro = new VetDin();   // em VetDin
        //this.cadastro = new ListaArray(); // em ArrayList
        //this.cadastro = new ListaLigadaSimples();
        //this.cadastro = new ListaDuplamenteLigadaCircular();
        this.cadastro = new ListaDuplamenteLigada();
        setK(k);
    }

    /**
     * setK 
     * 
     * param int k , variavel que diferencias as interfaces graficas
     */
    private void setK(int k)   
    {
        this.k=k;   
    }  

    /**
     * inserir
     *
     * @param Aluno aluno a ser adicionada no armazenador
     */
    public void inserir(Aluno aluno ){
        cadastro.adicionar(aluno);
    }

    /**
     * Método testeVazio
     *
     * 
     * @return cadastro.estaVazia() , booleano se a lista esta vazia 
     */
    public boolean testeVazio(){
        return cadastro.estaVazia();
    }

    /**
     * Método remover
     *
     * Reemove um aluno do cadastro pelo RA, caso exista um para ser removido.
     * param String raremov,ra para comparação e conseguentimente sua remoção do vetor
     */
    public void remover(String raremov){

        Aluno alunos = null;
        int find=0;

        if(!cadastro.estaVazia()){ // se cadastro nao estiver vazia
            for(int i = 0; i < cadastro.getQtd(); i++){
                // busca cliente no armazenador
                alunos = (Aluno)cadastro.buscar(i);
                // verifica se o sal eh negativo
                if(alunos.getRa().equals(raremov)){
                    if(k == 1)
                    {
                        JOptionPane.showMessageDialog(null,"Aluno(a) " + alunos.getNome() + " removido(a) com sucesso\n");
                    }
                    else
                    {
                        System.out.println("Aluno(a) " + alunos.getNome() + " removido(a) com sucesso\n");
                    }

                    cadastro.remover(i);
                    find=1;
                }
            } 
            if(find==0){ // se não encontrar, quer dizer que o RA não existe na lista

                if(k == 1)
                {
                    JOptionPane.showMessageDialog(null,"RA inválido, tente novamente\n");
                }
                else
                {
                    System.out.println("RA inválido, tente novamente\n");
                }
            }
        }   else if(k == 1)
        {
            JOptionPane.showMessageDialog(null,"Lista vazia! \n");
        }
        else
        {
            System.out.println("Lista vazia! \n");
        }
    }

    /**
     * listar
     * Lista todos alunos(nome,idade,ra,ano,materias e notas) e mostra ao usuario
     * 
     */
    public void listar(){
        int lvazia=1;
        int i=0;
        String s = "";
        if(!cadastro.estaVazia()){
            do{
                cad= (Aluno)cadastro.buscar(i); 
                if(k == 1)
                {
                    JOptionPane.showMessageDialog(null,cad);
                }
                else
                {
                    System.out.println(cad);
                }

                listarMaterias(cad,disc); // para imprimir as materias correspondentes as dos alunos certos, passamos como parametro tanto o vetor como um todo como o índice atual da varredura
                i++;
            }while(i<cadastro.getQtd());
        }else if(k == 1)
        {
            JOptionPane.showMessageDialog(null,"Lista vazia! \n");
        }
        else
        {
            System.out.println("Lista vazia! \n");
        }

    }

    /**
     * Método listarMaterias
     *
     * Listas todas materias e notas dos alunos cadastrados
     * 
     */
    public void listarMaterias (Aluno cad,Disciplina[] disc){
        int j=0;

        if(k == 1)
        {
            JOptionPane.showMessageDialog(null,"Materias do aluno: " +cad.getNome());
        }
        else
        {
            System.out.println("Materias do aluno: " +cad.getNome());
        }

        for (j=0; j<cad.disc.length;j++){
            if((cad.disc[j]!=null)){ //acessamos o array disc por meio do array cad para verificar se as matérias associadas ao aluno não estão vazias

                if(k == 1)
                {
                    JOptionPane.showMessageDialog(null,cad.disc[j]);
                }
                else
                {
                    System.out.println(cad.disc[j]);
                }
            }
        }
        System.out.println("\n\n");
    }

    /**
     * Método boolRA
     *
     * @return boolean teste 
     * 
     */
    public boolean boolRA(String ra){

        Aluno alunos = null;
        String s = "";
        boolean teste = true;
        if(!cadastro.estaVazia()){ // se cadastro nao estiver vazia
            for(int i = 0; i < cadastro.getQtd(); i++){
                // busca cliente no armazenador
                alunos = (Aluno)cadastro.buscar(i);
                // verifica se o sal eh negativo

                if(alunos.getRa().equals(ra))
                    teste=false;

            }
        }    
        return teste;
    }

    /**
     * toString imprime dados do cadastro
     *
     * @return String s
     */
    public String toString(){
        String s = "";
        if(cadastro != null){
            s = "\nAlunos: " + cadastro;
        }
        return s;
    }

    /**
     * Função para salvamento do cadastro
     *
     * 
     */
    public void salvar(){

        int qtd = cadastro.getQtd();
        int aux = 0;

        Aluno save[] = new Aluno[qtd] ;
        ArquivoBinario salvar = new ArquivoBinario();

        for(aux=0;aux<qtd;aux++)//<=
        {
            save[aux] = (Aluno)cadastro.buscar(aux);
        }

        salvar.gravarObj(save,arquivo);
        if(k == 1)
            {
                JOptionPane.showMessageDialog(null,"Arquivo Salvo");
            }
            else
            {
                System.out.println("Arquivo Salvo");
            }

    }

    /**
     * Função para leitura de irformção salvas do cadastro
     *
     */
    public void lersalvo(){
        int test =0 ;
        int aux = 0;
        int qtd = 0;

        int total = cadastro.getQtd();

        if(k == 1)
            {
                JOptionPane.showMessageDialog(null,"carregando...");
            }
            else
            {
                System.out.println("carregando...");
            }
        while(!cadastro.estaVazia())
        {
           cadastro.remover(test);
           test++;
        }
        ArquivoBinario salvar = new ArquivoBinario();
        Aluno save[] = null;
        save =(Aluno[])salvar.lerObj(arquivo);
        
        if(save != null)
        {
            qtd = save.length;

            for(aux=0;aux<qtd;aux++) //loop para adicianar todos os elementos no armazenador 
            {
                inserir(save[aux]); 
            }
            
            if(k == 1)
            {
                JOptionPane.showMessageDialog(null,"Arquivo recuperado");
            }
            else
            {
                System.out.println("Arquivo recuperado");
            }


        }else

        {
            if(k == 1)
            {
                JOptionPane.showMessageDialog(null,"Erro para encontrar o arquivo,é possivel que não haja um arquivo salvo");
            }
            else
            {
                System.out.println("Erro para encontrar o arquivo,é possivel que não haja um arquivo salvo");
            }

        }

    }
}
