import java.util.Random;
import java.util.Scanner;

public class jogo {
    private static int numeroLimite = 50;
    private static int numeroSecreto = numeroAleatorio();
    private static int chute;
    private static int tentativas = 1;

    public static void main(String[] args) {
        Scanner interacaoUsuario = new Scanner(System.in);

        mensagemInicial();

        while (chute != numeroSecreto) {
            System.out.print("Escolha um Número entre 0 e " + numeroLimite + " : ");
            chute = interacaoUsuario.nextInt();
            verificarChute();   
        }

        interacaoUsuario.close();

    }


    public static void mensagemInicial() {
        System.out.println("Bem Vindo ao Jogo do número secreto");
    }

    public static int numeroAleatorio() {
        Random random = new Random();
        return random.nextInt(numeroLimite) + 1;
    }

    public static void verificarChute () {

            if (chute == numeroSecreto) {
            acertou();
            reiniciarJogo();
            }else if (chute < numeroSecreto) {
                System.out.println("O número secreto é maior");
            }else if (chute > numeroSecreto) {
                System.out.println("O número secreto é menor");
            } else {
                System.out.println("Digito Inválido");
            }
            tentativas++;
    }

    public static void acertou ()  {
        String palavraTentativa = tentativas > 1  ? "tentativas" : "tentativa";
        String mensagemTentativas = "Você descobriu o número Secreto com" + " " + tentativas +
                " " + palavraTentativa;
        System.out.println(mensagemTentativas);
    }

    public static void reiniciarJogo () {
        numeroSecreto = numeroAleatorio();
        tentativas = 1;
    }
}

