package projeto;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Cliente murillo = new Cliente(1, "Murillo Godoi", "27/12/2000");
        Conta murilloConta = new Conta(2000.00, 123, murillo);
        System.out.println(murillo.toString());
        System.out.println(" ");
        System.out.println(murilloConta);
    }
}
