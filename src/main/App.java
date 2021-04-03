import Models.Cliente;
import Models.ContaCorrente;
import daoCliente.ClienteDAO;
import daoContas.ContaCorrenteDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Cliente murillo = new Cliente("Murillo Godoi", "27/12/2000", "123456");
        ClienteDAO clientedao = new ClienteDAO();
        clientedao.adicionarCliente(murillo);
        murillo.setId(1);
        
        ContaCorrente conta = new ContaCorrente(2000.00, 123, 5000.00);
        ContaCorrenteDAO contadao = new ContaCorrenteDAO();
        contadao.criarConta(conta, murillo);
        
    }   
}
