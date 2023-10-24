package metodos;

import modelo.BancoModelo;

public class Metodos {
    public void apresentarDados(double saldo) {
        System.out.println("*************************************************\n");
        System.out.println("Dados iniciais do cliente: \n");
        System.out.println("Nome:           Alvaro Carvalho de Lima");
        System.out.println("Tipo Conta:     Corrente");
        System.out.printf("Saldo inicial:  %,.2f", saldo);
        System.out.println("\n*************************************************");
    }

    public void exibirOpcoes() {
        System.out.println("\n\nOperações \n");
        System.out.println("1 - Consultar saldos");
        System.out.println("2 - Receber valor");
        System.out.println("3 - Transferir valor");
        System.out.println("4 - Sair \n");
        System.out.print("Digite a opção desejada: ");
    }

    public void receberSaldo(double valor, BancoModelo saldoBanco) {
        if (valor >= 0) {
            saldoBanco.setSaldo(saldoBanco.getSaldo() + valor);
            System.out.println("Saldo alterado com sucesso!");
        } else {
            System.out.println("Impossível adicionar um valor negativo");
        }
    }

    public void transferirValor(double transferir, BancoModelo saldoBanco) {
        if (transferir <= saldoBanco.getSaldo()) {
            saldoBanco.setSaldo(saldoBanco.getSaldo() - transferir);
            System.out.println("Valor transferido com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar esta transferência.");
        }
    }
}
