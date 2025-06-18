package com.listaEvento.ListaEvento.View;

import com.listaEvento.ListaEvento.Dominio.Local; // Importar a classe de domínio Local
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Observable;
import java.util.Observer;

public class LocalView extends JFrame implements Observer {

    private JLabel nomeLabel, cepLabel, capacidadeLabel, descricaoLabel, imagemUrlLabel, dataCadastroLabel, precoLabel;
    private JTextField nomeTextField, cepTextField, capacidadeTextField, descricaoTextField, imagemUrlTextField, dataCadastroTextField, precoTextField;
    private JButton atualizarButton;

    public LocalView() {
        super("Cadastro de Local");

        setSize(450, 600); // Ajustado o tamanho
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 3, 10, 10)); // layout vertical organizado

        atualizarButton = new JButton("Atualizar");

        // Nome
        nomeLabel = new JLabel("Nome: ");
        nomeTextField = new JTextField(20);
        add(new JLabel("Nome Atual:"));
        add(nomeLabel);
        add(nomeTextField);

        // Descrição (Adicionado para consistência)
        descricaoLabel = new JLabel("Descrição: ");
        descricaoTextField = new JTextField(20);
        add(new JLabel("Descrição Atual:"));
        add(descricaoLabel);
        add(descricaoTextField);

        // Preço (Adicionado)
        precoLabel = new JLabel("Preço: ");
        precoTextField = new JTextField(20);
        add(new JLabel("Preço Atual:"));
        add(precoLabel);
        add(precoTextField);

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

    // --- Métodos para obter dados dos campos de texto ---
    public String getNomeDoCampo() { return nomeTextField.getText(); }
    public String getDescricaoDoCampo() { return descricaoTextField.getText(); }
    public String getPrecoDoCampo() { return precoTextField.getText(); }
    public String getCepDoCampo() { return cepTextField.getText(); }
    public String getCapacidadeDoCampo() { return capacidadeTextField.getText(); }
    public String getImagemUrlDoCampo() { return imagemUrlTextField.getText(); }
    public String getDataCadastroDoCampo() { return dataCadastroTextField.getText(); }


    // --- Métodos para definir dados nos rótulos e campos de texto ---
    public void setNome(String nome) {
        nomeLabel.setText("Nome: " + nome);
        nomeTextField.setText(nome);
    }

    public void setDescricao(String descricao) {
        descricaoLabel.setText("Descrição: " + descricao);
        descricaoTextField.setText(descricao);
    }

    public void setPreco(BigDecimal preco) {
        precoLabel.setText("Preço: " + (preco != null ? preco.toPlainString() : ""));
        precoTextField.setText(preco != null ? preco.toPlainString() : "");
    }

    public void setCep(String cep) {
        cepLabel.setText("Cep: " + cep);
        cepTextField.setText(cep);
    }

    public void setCapacidade(int capacidade) {
        capacidadeLabel.setText("Capacidade: " + capacidade);
        capacidadeTextField.setText(String.valueOf(capacidade));
    }

    public void setImagemUrl(String imagemUrl) {
        imagemUrlLabel.setText("Imagem URL: " + imagemUrl);
        imagemUrlTextField.setText(imagemUrl);
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        dataCadastroLabel.setText("Data Cadastro: " + (dataCadastro != null ? dataCadastro.toString() : ""));
        dataCadastroTextField.setText(dataCadastro != null ? dataCadastro.toString() : "");
    }

    public void addAtualizarListener(ActionListener listener) {
        atualizarButton.addActionListener(listener);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Local local) {
            setNome(local.getNome());
            setDescricao(local.getDescricao());
            setPreco(local.getPreco());
            setCep(local.getCep());
            setCapacidade(local.getCapacidade());
            setImagemUrl(local.getImagemUrl());
            setDataCadastro(local.getDataCadastro());
        }
    }

    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}