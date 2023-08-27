package PessoaT;
import java.io.Serializable;
/**
 * 
 * 
 * @author André Cavalcanti Teles dos Santos,João Marcos Ribeirete Garbelini,Mateus Neves Erédia,Vitor Assunção Silva
 * @version 20/04/2023
 */
public class TestaPessoa implements Serializable
{
    public static void main(String args[]) {
        Pessoa p = new Pessoa ("Zé da          Silva", 22);

        System.out.println(p);
    }
}
