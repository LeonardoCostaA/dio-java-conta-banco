import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    
    
    static int numeroConta;
    static String agencia;
    static String nomeCompleto;
    static Double saldo;

    public static void main(String[] args) {

        //criando scanner
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Olá, bem vindo ao sistema do nosso banco, por favor informar os dados solicitados a seguir conforme orientado.");
        
        coletarNomeCompleto(scanner);
        coletarAgencia(scanner);
        coletarNumeroConta(scanner);
        coletarSaldo(scanner);

        imprimirMensagem();

    }

    /**
     * Este método é utilizado para solicitar o nome completo do cliente
     * @param scanner parâmetro do Scanner que será utilizado para coletar os dados solicitados
     */
    private static void coletarNomeCompleto(Scanner scanner) {
        boolean nomeValido = false;
        String nomeValidar;
        System.out.println("Informe seu nome completo: ");
        while (!nomeValido) {
            nomeValidar = scanner.nextLine();            
            if (nomeValidar.split(" ").length > 1) {
                nomeCompleto = nomeValidar;
                nomeValido = true;
            } else {
                System.out.println("Por favor, informe seu nome completo: ");
            }
        }
    }

    /**
     * Este método é utilizado para solicitar o número da agência do cliente
     * @param scanner parâmetro do Scanner que será utilizado para coletar os dados solicitados
     */
    private static void coletarAgencia(Scanner scanner) {
        boolean agenciaValido = false;
        String agenciaValidar;
        System.out.println("Informe os 4 dígitos do número da agência: ");
        while (!agenciaValido) {
            agenciaValidar = scanner.next();
            if (agenciaValidar.length() == 4 && agenciaValidar.matches("[0-9]+")) {
                agencia = agenciaValidar.substring(0, 3).concat("-").concat(agenciaValidar.substring(3, 4));
                agenciaValido = true;
            } else {
                System.out.println("Por favor, informe somente os 4 números da agência: ");
            }
        }
    }

    /**
     * Este método é utilizado para solicitar o número da conta do cliente
     * @param scanner parâmetro do Scanner que será utilizado para coletar os dados solicitados
     */
    private static void coletarNumeroConta(Scanner scanner) {
        boolean numeroValido = false;
        String numeroValidar;
        System.out.println("Informe o número da sua conta: ");
        while (!numeroValido) {
            numeroValidar = scanner.next();
            if (numeroValidar.matches("[0-9]+")) {
                numeroConta = Integer.parseInt(numeroValidar);
                numeroValido = true;
            } else {
                System.out.println("Por favor, informe somente números: ");
            }
        }
    }

    /**
     * Este método é utilizado para solicitar o saldo da conta do cliente
     * @param scanner parâmetro do Scanner que será utilizado para coletar os dados solicitados
     */
    private static void coletarSaldo(Scanner scanner) {
        boolean saldoValido = false;
        String saldoValidar;
        System.out.println("Informe o saldo que deseja depositar na sua conta: ");
        while (!saldoValido) {
            saldoValidar = scanner.next();
            if (validarDoublePositivo(saldoValidar)) {
                saldo = Double.parseDouble(saldoValidar);
                saldoValido = true;
            } else {
                System.out.println("Por favor, informe um valor válido: ");
            }
        }
    }

    /**
     * Este método é utilizado para verificar se o valor informado é um double maior que 0
     * @param valor parâmetro com o valor informado pelo cliente
     * @return true se o valor for do tipo double maior que 0
     */
    private static boolean validarDoublePositivo(String valor) {
        try {
            Double valorSaldo = Double.parseDouble(valor);
            return valorSaldo > 0.0 ? true : false;
        }
        catch(Exception e) {
            return false;
        }
    }

    /**
     * Este método imprime a mensagem final com os dados informados pelo cliente da conta
     */
    private static void imprimirMensagem() {
        String mensagem = "Olá ".concat(nomeCompleto).concat(", obrigado por criar uma conta em nosso banco, sua agência é ").concat(agencia).concat(", conta ").concat(Integer.toString(numeroConta)).concat(" e seu saldo de R$ ").concat(Double.toString(saldo)).concat(" já está disponível.");
        System.out.println(mensagem);
    }

}
