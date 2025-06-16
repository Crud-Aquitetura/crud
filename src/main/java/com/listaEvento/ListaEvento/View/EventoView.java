package com.listaEvento.ListaEvento.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EventoView extends JFrame { // Renomeado de 'evento' para 'EventoView'

    private JLabel nomeLabel;
    private JTextField nomeTextField;
    private JButton atualizarButton;

    public EventoView() { // Construtor renomeado
        super("Aplicação MVC de Usuário");

        // Configurações da janela
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Inicializa os componentes
        nomeLabel = new JLabel("Nome: [Aguardando dados]");
        nomeTextField = new JTextField(20);
        atualizarButton = new JButton("Atualizar Nome");

        // Adiciona os componentes à janela
        add(new JLabel("Nome Atual:"));
        add(nomeLabel);
        add(new JLabel("Novo Nome:"));
        add(nomeTextField);
        add(atualizarButton);

        setVisible(true);
    }

    // --- Métodos públicos para interação ---

    public String getNomeDoCampo() {
        return nomeTextField.getText();
    }

    public void setNome(String nome) {
        nomeLabel.setText("Nome: " + nome);
        nomeTextField.setText(nome);
    }

    public void addAtualizarListener(ActionListener listener) {
        atualizarButton.addActionListener(listener);
    }

    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}