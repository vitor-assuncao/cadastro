package armazenadores;
import java.io.Serializable;
/**
 * IArmazenador interface para armazenadores.
 * 
 * @author Julio Arakaki 
 * @version 12/04/2023
 */

public interface IArmazenador { 
    public void adicionar(Object a);
    public Object remover(int i);
    public boolean estaVazia();
    public Object buscar (int i);
    public int getQtd();
    public String toString();
}

