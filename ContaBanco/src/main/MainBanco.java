package main;

import metodos.Metodos;
import modelo.BancoModelo;

import java.util.Scanner;

public class MainBanco {



    public static void main(String[]args) {
//        Criação variáveis importadas.
        Scanner entrada = new Scanner(System.in);
//        Fim da criação de variáveis importadas.

//        Apresentação dos dados bancários
        BancoModelo saldoBanco = new BancoModelo();
        Metodos principal = new Metodos();
        principal.apresentarDados(saldoBanco.getSaldo());
//        Fim da apresentação dos dados bancários

        int resposta = 0;
        while (resposta != 4) {
            principal.exibirOpcoes();
            resposta = entrada.nextInt();

            switch (resposta) {
                case 1:
                    System.out.printf("Saldo Atual: %,.2f", saldoBanco.getSaldo());
                    break;
                case 2:
                    System.out.println("Informe o valor que deseja adiconar à conta: ");
                    double receber = entrada.nextDouble();
                    principal.receberSaldo(receber, saldoBanco);
                    break;
                case 3:
                    System.out.println("Informe o valor que deseja transferir da conta: ");
                    double transferir = entrada.nextDouble();
                    principal.transferirValor(transferir, saldoBanco);
                    break;
            }
        }
    }
}
