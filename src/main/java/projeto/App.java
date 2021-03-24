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
        System.out.println(murillo.toString());
        System.out.println(" ");

        System.out.println(" ");

        ContaCorrente murilloContaCorrente = new ContaCorrente(2500.00, 1234, murillo, 3000.00);
        System.out.println(murilloContaCorrente.getSaldo());
        murilloContaCorrente.depositar(1000.00);
        System.out.println(murilloContaCorrente.getSaldo());
        ContaPoupanca murilloContaPoupanca = new ContaPoupanca(3000.00, 12345, murillo,"23/03/2021");
        System.out.println(murilloContaPoupanca.getSaldo());
        murilloContaPoupanca.depositar(1000.00);
        System.out.println(murilloContaPoupanca.getSaldo());
    

        System.out.println(murilloContaCorrente);
        System.out.println(" ");
        System.out.println(murilloContaPoupanca);

    }
}
