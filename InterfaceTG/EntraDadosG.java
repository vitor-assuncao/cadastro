package InterfaceTG;
import javax.swing.JOptionPane;
import java.io.Serializable;

/**
 * Classe destinada a perguntar e recerber a resposta do usuaria e analizar se a prorpia é possivel.(via caixas de diálogo)
 * 
 * @author André Cavalcanti Teles dos Santos,João Marcos Ribeirete Garbelini,Mateus Neves Erédia,Vitor Assunção Silva 
 * @version 4.1 - 21/05/2023
 */

public class EntraDadosG implements Interface,Serializable {

    String aux=null;
    boolean TestBool;
    /**
     * lerOpção - Rebece o valor desejado do usuario e testa se ele é possivel.
     *
     * @return int opcao, numero recebido pelo usuario (dentro dos parametros estabelecidos)
     */
    public int lerOpcao() {
        int opcao = 0;
        TestBool = false;
        do{
            try {
                aux = JOptionPane.showInputDialog("Digite uma opção: \n1 – Inserir \n2 – Remover \n3 – Listar\n4 – Salvar\n5 – Recuperar salvo\n6 – SAIR");
                opcao = Integer.parseInt(aux);
                TestBool = true;
            } catch (NumberFormatException e ) {
                if (aux == null) { // Caso o usuário clique no botão cancelar
                    JOptionPane.showMessageDialog(null,"Programa fechado");
                    System.exit(0);
                } else if (aux.trim().isEmpty()) { // Se o nome digitado está vazio ou contém apenas espaços em branco
                    JOptionPane.showMessageDialog(null,"Obrigatório digitar uma das opções (1,2,3,4), tente novamente");
                }else{
                    JOptionPane.showMessageDialog(null,"Erro de formato do numero, tente novamente");
                }
            }
        } while (!TestBool);

        return(opcao);
    }

    /**
     * lerNome - Rebece a String do nome que o usuario deseja cadastrar e testa se está dentro dos parametros.
     *
     * @return String nome, nome colocado pelo usuario (dentro dos parametros estabelecidos)
     */
    public String lerNome() {
        String nome = null;
        TestBool = false;
        do {
            try {
                nome = JOptionPane.showInputDialog("Forneca o nome do aluno");
                if (nome == null) { //Caso o usuário clique no botão cancelar

                    //System.exit(0);
                    return null;
                } else if (nome.trim().isEmpty()) { // Se o nome digitado está vazio ou contém apenas espaços em branco
                    JOptionPane.showMessageDialog(null,"Obrigatório digitar um nome, tente novamente");
                } else {
                    TestBool = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } while (!TestBool);

        return nome;
    }

    /**
     * lerRA - Rebece a String do RA que o usuario deseja cadastrar e testa se está dentro dos parametros.
     *
     * @return String ra, ra colocado pelo usuario (dentro dos parametros estabelecidos)
     */
    public String lerRA() {
        String ra = null;
        TestBool = false;
        do {
            try {
                ra = JOptionPane.showInputDialog("Forneca o ra do aluno");
                if (ra == null) { //Caso o usuário clique no botão cancelar

                    //System.exit(0);
                    return null;
                } else if (ra.trim().isEmpty()) { // Se o nome digitado está vazio ou contém apenas espaços em branco
                    JOptionPane.showMessageDialog(null,"Obrigatório digitar o RA(numero), tente novamente");
                } else {
                    TestBool = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } while (!TestBool);

        return ra;
    }

    /**
     * lerRemover - Recebe o ra ( String) que o usuario deseja remover e testa se o mesmo esta dentro do parametro.
     *
     * @return String raRemov, ra colocado pelo usuario (dentro dos parametros estabelecidos)
     */
    public String lerRemover(){
        String raRemov= null;
        TestBool = false;
        do{
            try{
                raRemov = JOptionPane.showInputDialog("Insira o ra do aluno");
                if(raRemov==null){

                    //System.exit(0);
                    return null;
                }else if(raRemov.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Obrigatório digitar o RA(numero), tente novamente");
                } else {
                    TestBool = true;
                }
            }catch(NumberFormatException e){
                if(raRemov.trim().isEmpty())
                    JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage());
            }
        }while(!TestBool);
        return raRemov;
    } 

    /**
     * lerIdade - Recebe a idade fornecida pelo usuario e testa se a mesma esta dentro do parametro.
     *
     * @return int, idade fornecida e testada
     */
    public int lerIdade(){ 
        int idade =0 ; 
        TestBool=false;
        do{
            try{
                aux = JOptionPane.showInputDialog("Forneca a idade do aluno: ");

                idade = Integer.parseInt(aux);

                if(idade<=0)
                {
                    JOptionPane.showMessageDialog(null,"Valor inválido");
                }else
                {
                    TestBool = true;
                }

            }catch(NumberFormatException e){
                if(aux==null){

                    return 0;
                    //System.exit(0);
                }else if(aux.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Obrigatório digitar a idade(numero), tente novamente");
                }else{
                    JOptionPane.showMessageDialog(null,"Erro de formato do numero, tente novamente");
                }
            }
        }while(!TestBool);

        return idade;
    }

    /**
     * lerTotalDisciplinas - Recebe a nota fornecida pelo usuario e testa se a mesma esta dentro do parametro
     *
     * @return float total,numero de materias realizadas para o cadastro fornecida pelo usuario e testada
     */
    public int lerTotalDisciplinas(){ 
        TestBool=false;
        int total = 0;
        do{
            try{
                aux = JOptionPane.showInputDialog("Forneca a quantidade de disciplinas cursadas pelo aluno: ");

                total = Integer.parseInt(aux);

                if(total<=0)
                {
                    JOptionPane.showMessageDialog(null,"Valor inválido");
                }else
                {
                    TestBool = true;
                }

            }catch(NumberFormatException e){
                if(aux==null){

                    //System.exit(0);
                    return 0;
                }else if(aux.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Obrigatório digitar a quantidade(numero), tente novamente");
                }else{
                    JOptionPane.showMessageDialog(null,"Erro de formato do numero, tente novamente");
                }
            }
        }while(!TestBool);

        return total;
    }

   
    /**
     * lerDisciplina - Rebece a String do nome da matéria que o usuario deseja cadastrar e testa se está dentro dos parametros.
     *
     * @return String disciplina, disciplina colocado pelo usuario (dentro dos parametros estabelecidos)
     */
    public String lerDisciplina(){
        String disciplina = null;
        TestBool = false;
        do{
            try{
                disciplina= JOptionPane.showInputDialog("Insira o nome da matéria");

                if(disciplina==null){

                    //System.exit(0);
                    return null;
                }else if(disciplina.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Obrigatório digitar o nome da matéria, tente novamente");
                } else {
                    TestBool = true;
                }
            }catch(NumberFormatException e){
                if(disciplina.trim().isEmpty())
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }while(!TestBool);

        return disciplina;
    } 

    /**
     * lerNota - Recebe a nota fornecida pelo usuario e testa se a mesma esta dentro do parametro.
     *
     * @return int, nota fornecida e testada
     */
    public float lerNota(){ 
        float nota = -1;
        TestBool = false;
        do{
            try{
                aux = JOptionPane.showInputDialog("Forneca a nota do aluno: ");

                nota = Float.parseFloat(aux);
                if((nota <  0) || (nota>10)){
                    JOptionPane.showMessageDialog(null,"Obrigatório digitar uma nota (0 >= nota <= 10), tente novamente");                   
                }else{
                    TestBool = true;
                }
            }catch(Exception e){
                if (aux == null){

                    //System.exit(0);
                    return -1;
                }else if(aux.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Obrigatório digitar uma nota (0 <= nota <= 10), tente novamente");
                }else{
                    JOptionPane.showMessageDialog(null,"Erro de formato do numero, tente novamente");
                }
            }
        }while(!TestBool);

        return nota;
    }

    /**
     * lerAno - Recebe a o periodo fornecida pelo usuario e testa se a mesma esta dentro do parametro.
     *
     * @return int, periodo fornecida e testada
     */
    public int lerAno(){ 
        int ano = 0;
        TestBool=false;
        do{
            try{
                aux = JOptionPane.showInputDialog("Forneca o período do aluno: ");
                ano=Integer.parseInt(aux);

                if(ano<=0)
                {
                    JOptionPane.showMessageDialog(null,"Valor inválido");
                }else
                {
                    TestBool = true;
                }

            }catch(NumberFormatException e){
                if(aux==null){

                    //System.exit(0);
                    return 0;
                }else if(aux.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Obrigatório digitar um numero do período, tente novamente");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Erro de formato do numero, tente novamente");
                }
            }
        }while(!TestBool);

        return ano;
    }

}

