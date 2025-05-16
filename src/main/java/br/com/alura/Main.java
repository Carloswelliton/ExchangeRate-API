package br.com.alura;


import br.com.alura.conexao.API;
import br.com.alura.conexao.ConversionRate;
import br.com.alura.conexao.ExchangePanel;

import javax.swing.*;



public class Main {
    public static void main(String[] args) {
        API api = new API();
        ConversionRate newConversion = new ConversionRate();
        int opcao = 0;

        do{
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, """
                selecione a moeda de origem:
                [1] - Real para Dolar dos Estados unidos "BRL"
                [2] - Dolar dos Estados Unidos  para Real "USD"
                [3] - Euro para Real"EUR"
                [4] - Peso Argentino para Real"ARS"
                [5] - Iene japonês  para Real"JPY"
                [6] - Libra Esterlina para Real"GBP"
                [0] - Sair
                """));
            String valor = "";

            switch(opcao){
                case 1:
                    valor =  JOptionPane.showInputDialog(null, "Digite o valor a ser convertido");
                    String origem = "BRL";
                    String destino = "USD";
                    ExchangePanel newExchange = api.exchange(origem, destino, valor);
                    JOptionPane.showMessageDialog(null, """
                        Valor: %s,
                        Origem:%s,
                        Destino: %s,
                        Taxa: %s,
                        Conversão: %s,
                        """.formatted(valor, newExchange.base_code(), newExchange.target_code(), newExchange.conversion_rate(), newExchange.conversion_result()));
                    valor =  JOptionPane.showInputDialog(null, "Digite o valor a ser convertido");
                    break;
                case 2:
                    valor =  JOptionPane.showInputDialog(null, "Digite o valor a ser convertido");
                    String origem2 = "USD";
                    String destino2 = "BRL";
                    ExchangePanel newExchange2 = api.exchange(origem2, destino2, valor);
                    JOptionPane.showMessageDialog(null, """
                        Valor: %s,
                        Origem:%s,
                        Destino: %s,
                        Taxa: %s,
                        Conversão: %s,
                        """.formatted(valor, newExchange2.base_code(), newExchange2.target_code(), newExchange2.conversion_rate(), newExchange2.conversion_result()));
                    break;
                case 3:
                    valor =  JOptionPane.showInputDialog(null, "Digite o valor a ser convertido");
                    String origem3 = "EUR";
                    String destino3 = "BRL";
                    ExchangePanel newExchange3 = api.exchange(origem3, destino3, valor);
                    JOptionPane.showMessageDialog(null, """
                        Valor: %s,
                        Origem:%s,
                        Destino: %s,
                        Taxa: %s,
                        Conversão: %s,
                        """.formatted(valor, newExchange3.base_code(), newExchange3.target_code(), newExchange3.conversion_rate(), newExchange3.conversion_result()));
                    break;
                case 4:
                    valor =  JOptionPane.showInputDialog(null, "Digite o valor a ser convertido");
                    String origem4 = "ARS";
                    String destino4 = "BRL";
                    ExchangePanel newExchange4 = api.exchange(origem4, destino4, valor);
                    JOptionPane.showMessageDialog(null, """
                        Valor: %s,
                        Origem:%s,
                        Destino: %s,
                        Taxa: %s,
                        Conversão: %s,
                        """.formatted(valor, newExchange4.base_code(), newExchange4.target_code(), newExchange4.conversion_rate(), newExchange4.conversion_result()));
                    break;
                case 5:
                    valor =  JOptionPane.showInputDialog(null, "Digite o valor a ser convertido");
                    String origem5 = "JPY";
                    String destino5 = "BRL";
                    ExchangePanel newExchange5 = api.exchange(origem5, destino5, valor);
                    JOptionPane.showMessageDialog(null, """
                        Valor: %s,
                        Origem:%s,
                        Destino: %s,
                        Taxa: %s,
                        Conversão: %s,
                        """.formatted(valor, newExchange5.base_code(), newExchange5.target_code(), newExchange5.conversion_rate(), newExchange5.conversion_result()));
                case 6:
                    valor =  JOptionPane.showInputDialog(null, "Digite o valor a ser convertido");
                    String origem6 = "GBP";
                    String destino6 = "BRL";
                    ExchangePanel newExchange6 = api.exchange(origem6, destino6, valor);
                    JOptionPane.showMessageDialog(null, """
                        Valor: %s,
                        Origem:%s,
                        Destino: %s,
                        Taxa: %s,
                        Conversão: %s,
                        """.formatted(valor, newExchange6.base_code(), newExchange6.target_code(), newExchange6.conversion_rate(), newExchange6.conversion_result()));
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null,"Saindo...");
                    break;
            }
        }while(opcao != 0);
    }
}
