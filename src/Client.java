import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Lucas Campanelli de Souza
 */
public class Client {

    static Conexao c;
    static Socket socket;

    public Client() {
        try {
            socket = new Socket("localhost", 9600);
        } catch (IOException e) {
            System.err.println("Nao consegui resolver o host...");
        }
    }

    public static void main(String[] args) throws IOException{
        try {
            new Client();
            float op1, op2;
            char oper;
            Scanner in = new Scanner(System.in);

            System.out.println("*********************************");
            System.out.println("***  CALCULADORA DISTRIBUIDA  ***");
            System.out.println("*********************************");

            System.out.println("Digite o primeiro numero");
            op1 = in.nextFloat();
            System.out.println("Digite o segundo numero");
            op2 = in.nextFloat();
            System.out.println("Escolha uma operação");
            System.out.println("(+)SOMA (-)SUBTRACAO (x)MULTIPLICACAO (/)DIVISAO");
            oper = in.next().charAt(0);

            Requisicao msgReq = new Requisicao(op1, op2, oper);
            c.send(socket, msgReq);
            Resposta msgRep = (Resposta) c.receive(socket);

            switch (msgRep.getStatus()) {
                case 0:
                    System.out.println("Resultado = " + msgRep.getResult());
                    break;
                case 1:
                    System.out.println("Operacao nao Implementada");
                    break;
                default:
                    System.out.println("Divisao por Zero");
                    break;
            }
        } catch (Exception e) {
            System.out.println("problemas ao fechar socket");
        } finally {
            socket.close();
        }
        
    }
}
