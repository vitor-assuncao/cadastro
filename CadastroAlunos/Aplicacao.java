import javax.swing.JOptionPane;
/**
 * Escreva uma descrição da classe Aplicacao aqui.
 * 
 * @author Julio Arakaki 
 * @version 28/03/2023
 */
public class Aplicacao {

    public static void main(String args[]) {
        CadastroAlunos cad = new CadastroAlunos(60);

        String opcao =JOptionPane.showInputDialog("1 – Inserir \n 2 – Remover \n3 – Listar\n4 – SAIR");
        
    

            

            switch (opcao) {

                case "1":

                //   inserir();

                    break;

                case "2":

                //    remover();

                    break;

                case "3":

                //  listar();

                    break;

                case "4":

                     JOptionPane.showMessageDialog(null, "Somos todos Filé");

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "guguizou10");
                    
                    break;

    

            }

        }

    }
        

