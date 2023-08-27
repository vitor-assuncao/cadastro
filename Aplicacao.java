import javax.swing.JOptionPane;
import java.io.Serializable;
import InterfaceTG.Interface;
import InterfaceTG.EntraDadosG;
import InterfaceTG.EntraDadosT;
/**
 *  Classe programada para a realização da função das escolhas no menu.
 * 
 * @author André Cavalcanti Teles dos Santos,João Marcos Ribeirete Garbelini,Mateus Neves Erédia,Vitor Assunção Silva
 * @version 4.1 - 21/05/2023
 */
public class Aplicacao implements Serializable {

    public static void main(String args[]) {
        
      
        
        int k = 0; //Variavel auxiliar para teste de qual interface grafica está sendo usada.
        int esc;// Variavel para utilização no switch ( escolhas do menu)
        int teste = 0;
        
        
        //Opções de interfaces:
        
        //Interface dado = new EntraDadosG ();k=1;
        Interface dado = new EntraDadosT ();k=0;
        
        CadastroAlunos cad = new CadastroAlunos(k);

        do{
            esc = dado.lerOpcao();
            switch (esc) {
                case 1:
                    String nome = dado.lerNome();
                    if(nome == null){
                        break;
                    }
                    String ra = dado.lerRA();
                    if(ra == null){
                        break;
                    }
                    cad.boolRA(ra);
                    if(cad.boolRA(ra)==false){
                        if(k == 1)//Teste para ver qual interface grafica está sendo usada.
                        {
                            JOptionPane.showMessageDialog(null,"RA inválido ou já usado, tente outro RA");
                        }
                        else
                        {
                            System.out.println("RA inválido ou já usado, tente outro RA");
                        }

                        continue;
                    }
                    
                    int idade = dado.lerIdade();
                    if(idade == 0){
                        break;
                    }
                    int ano = dado.lerAno();
                    if(ano == 0){
                        break;
                    }
                    
                    int qtde = dado.lerTotalDisciplinas();
                    if(qtde == 0){
                        break;
                    }
                    
                    Disciplina disc[];
                    disc= new Disciplina [qtde];
                    for(int i =0;i<qtde;i++){
                        String disciplina= dado.lerDisciplina();
                        if(disciplina == null)
                        {
                            teste = 1;
                            break;
                        }
                        float nota=dado.lerNota();
                         if(nota == -1)
                        {
                            teste = 1;
                            break;
                        }
                        disc[i]= new Disciplina (disciplina,nota);
                    }
                    if(teste == 1)
                    {
                        break;
                    }
                    Aluno aluno = new Aluno(nome,idade,ra,ano,disc);
                    cad.inserir(aluno);
                    break;
                case 2:
                   
                    if(cad.testeVazio() == false)
                    {
                        String raremov =dado.lerRemover();
                        cad.remover(raremov);
                    
                    }else
                    {
                        if(k == 1)//Teste para ver qual interface grafica está sendo usada.
                        {
                            JOptionPane.showMessageDialog(null,"Lista vazia");
                        }
                        else
                        {
                            System.out.println("Lista Vazia");
                        }
                    }
                    
                                      
                    break;
                case 3:

                    cad.listar();
                    break;
                case 6:

                    if(k == 1)
                    {
                        JOptionPane.showMessageDialog(null, "Saindo do programa");
                    }
                    else
                    {
                        System.out.println("Saindo do programa");
                    }
                    break;
                    
                case 4:
                    
                    
                    if(cad.testeVazio() == false)
                    {
                         cad.salvar();
                    }else
                    {
                        if(k == 1)//Teste para ver qual interface grafica está sendo usada.
                        {
                            JOptionPane.showMessageDialog(null,"Lista vazia");
                        }
                        else
                        {
                            System.out.println("Lista Vazia");
                        }
                    }
                    break;
                    
                case 5:
                    
                    cad.lersalvo();
                    break;
                default:

                    if(k == 1)
                    {
                        JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    else
                    {
                        System.out.println("Opção inválida");
                    }
                    break;

            }
        }while(esc!= 6);
    }
}
