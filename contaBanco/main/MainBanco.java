package contaBanco.main;

import contaBanco.modelo.BancoModelo;

import java.util.Scanner;

public class MainBanco {

    void apresentarDados(double saldo) {
        System.out.println("*************************************************\n");
        System.out.println("Dados iniciais do cliente: \n");
        System.out.println("Nome:           Alvaro Carvalho de Lima");
        System.out.println("Tipo Conta:     Corrente");
        System.out.printf("Saldo inicial:  %,.2f", saldo);
        System.out.println("\n*************************************************");
    }

    void exibirOpcoes() {
        System.out.println("\n\nOperações \n");
        System.out.println("1 - Consultar saldos");
        System.out.println("2 - Receber valor");
        System.out.println("3 - Transferir valor");
        System.out.println("4 - Sair \n");
        System.out.print("Digite a opção desejada: ");
    }

    void receberSaldo(double valor, BancoModelo saldoBanco) {
        if (valor >= 0) {
            saldoBanco.setSaldo(saldoBanco.getSaldo() + valor);
            System.out.println("Saldo alterado com sucesso!");
        } else {
            System.out.println("Impossível adicionar um valor negativo");
        }
    }

    void transferirValor(double transferir, BancoModelo saldoBanco) {
        if (transferir <= saldoBanco.getSaldo()) {
            saldoBanco.setSaldo(saldoBanco.getSaldo() - transferir);
            System.out.println("Valor transferido com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar esta transferência.");
        }
    }

    public static void main(String[]args) {
//        Criação variáveis importadas.
        Scanner entrada = new Scanner(System.in);
//        Fim da criação de variáveis importadas.

//        Apresentação dos dados bancários
        BancoModelo saldoBanco = new BancoModelo();
        MainBanco principal = new MainBanco();
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
