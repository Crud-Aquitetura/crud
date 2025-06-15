package com.listaEvento.ListaEvento.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class LocalView extends JFrame implements Observer {

    private JLabel nomeLabel, cepLabel, capacidadeLabel, descricaoLabel, imagemUrlLabel, dataCadastroLabel;
    private JTextField nomeTextField, cepTextField, capacidadeTextField, descricaoTextField, imagemUrlTextField, dataCadastroTextField;
    private JButton atualizarButton;

    public LocalView() {
        super("Cadastro de Local");

        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 3, 10, 10)); // layout vertical organizado

        atualizarButton = new JButton("Atualizar");

        // Nome
        nomeLabel = new JLabel("Nome: ");
        nomeTextField = new JTextField(20);
        add(new JLabel("Nome Atual:"));
        add(nomeLabel);
        add(nomeTextField);

        // Cep
        cepLabel = new JLabel("Cep: ");
        cepTextField = new JTextField(20);
        add(new JLabel("Cep Atual:"));
        add(cepLabel);
        add(cepTextField);

        // Capacidade
        capacidadeLabel = new JLabel("Capacidade: ");
        capacidadeTextField = new JTextField(20);
        add(new JLabel("Capacidade Atual:"));
        add(capacidadeLabel);
        add(capacidadeTextField);

        // Descrição
        descricaoLabel = new JLabel("Descrição: ");
        descricaoTextField = new JTextField(20);
        add(new JLabel("Descrição Atual:"));
        add(descricaoLabel);
        add(descricaoTextField);

        // Imagem URL
        imagemUrlLabel = new JLabel("Imagem URL: ");
        imagemUrlTextField = new JTextField(20);
        add(new JLabel("Imagem URL Atual:"));
        add(imagemUrlLabel);
        add(imagemUrlTextField);

        // Data Cadastro
        dataCadastroLabel = new JLabel("Data Cadastro: ");
        dataCadastroTextField = new JTextField(20);
        add(new JLabel("Data Cadastro Atual:"));
        add(dataCadastroLabel);
        add(dataCadastroTextField);

        add(new JLabel()); // espaçamento
        add(atualizarButton);
        add(new JLabel());

        setVisible(true);
    }

    // Exemplo de método para capturar texto
    public String getNomeDoCampo() {
        return nomeTextField.getText();
    }

    public void addAtualizarListener(ActionListener listener) {
        atualizarButton.addActionListener(listener);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String nome) {
            nomeLabel.setText("Nome: " + nome);
            nomeTextField.setText(nome);
        }
    }

    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}
