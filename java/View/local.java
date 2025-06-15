package com.pagafacil.PagaFacil.View;

public class local {
    // src/main/java/com/exemplo/mvc/view/UsuarioView.java
package com.pagafacil.PagaFacil.View.local;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener; // Usaremos para o botão
import java.util.Observable;
import java.util.Observer; // Importa Observer para a View "observar" a Model

    // UsuarioView é a nossa "View" e também um "Observer" da nossa Model
    public class UsuarioView extends JFrame implements Observer {

        private JLabel nomeLabel; // Onde exibimos o nome do usuário
        private JTextField nomeTextField; // Campo para o usuário digitar um novo nome
        private JButton atualizarButton; // Botão para atualizar o nome

        public UsuarioView() {
            super("Aplicação MVC de Usuário");

            // Configurações da janela
            setSize(400, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Layout mais organizado

            // Inicializa os componentes
            nomeLabel = new JLabel("Nome: [Aguardando dados da Model]");
            nomeTextField = new JTextField(20); // Campo de texto com 20 colunas de largura
            atualizarButton = new JButton("Atualizar Nome");

            // Adiciona os componentes à janela
            add(new JLabel("Nome Atual:"));
            add(nomeLabel);
            add(new JLabel("Novo Nome:"));
            add(nomeTextField);
            add(atualizarButton);

            cepLabel = new JLabel("Cep: [Aguardando dados da Model]");
            cepTextField = new JTextField(20); // Campo de texto com 20 colunas de largura
            atualizarButton = new JButton("Atualizar Cep");

            // Adiciona os componentes à janela
            add(new JLabel("Cep Atual:"));
            add(cepLabel);
            add(new JLabel("Cep Nome:"));
            add(cepTextField);
            add(atualizarButton);

            capacidadeLabel = new JLabel("Capacidade: [Aguardando dados da Model]");
            capacidadeTextField = new JTextField(20); // Campo de texto com 20 colunas de largura
            atualizarButton = new JButton("Atualizar Capacidade");

            // Adiciona os componentes à janela
            add(new JLabel("Capacidade Atual:"));
            add(capacidadeLabel);
            add(new JLabel("Novo Capacidade:"));
            add(capacidadeTextField);
            add(atualizarButton);

            descricaoLabel = new JLabel("Descrição: [Aguardando dados da Model]");
            descricaoTextField = new JTextField(20); // Campo de texto com 20 colunas de largura
            atualizarButton = new JButton("Atualizar Descrição");

            // Adiciona os componentes à janela
            add(new JLabel("Descrição Atual:"));
            add(descricaoLabel);
            add(new JLabel("Novo Descrição:"));
            add(descricaoTextField);
            add(atualizarButton);

            imagem_urlLabel = new JLabel("Imagem_url: [Aguardando dados da Model]");
            imagem_urlTextField = new JTextField(20); // Campo de texto com 20 colunas de largura
            atualizarButton = new JButton("Atualizar Imagem_url");

            // Adiciona os componentes à janela
            add(new JLabel("Imagem_url Atual:"));
            add(imagem_urlLabel);
            add(new JLabel("Novo Imagem_url:"));
            add(imagem_urlTextField);
            add(atualizarButton);

            data_cadastroLabel = new JLabel("Data_cadastro: [Aguardando dados da Model]");
            data_cadastroTextField = new JTextField(20); // Campo de texto com 20 colunas de largura
            atualizarButton = new JButton("Atualizar Data_cadastro");

            // Adiciona os componentes à janela
            add(new JLabel("Data_cadastro Atual:"));
            add(data_cadasstroLabel);
            add(new JLabel("Novo Data_cadastro:"));
            add(data_cadastroTextField);
            add(atualizarButton);

            setVisible(true);
        }

        // --- Métodos para interagir com o Controller ---

        // Retorna o texto digitado no campo de texto
        public String getNomeDoCampo() {
            return nomeTextField.getText();
        }

        // Adiciona um listener ao botão (o Controller irá "escutar" este botão)
        public void addAtualizarListener(ActionListener listener) {
            atualizarButton.addActionListener(listener);
        }

        // --- Métodos para interagir com a Model (implementando Observer) ---

        // Este método é chamado pela Model (Usuario) sempre que ela muda
        @Override
        public void update(Observable o, Object arg) {
            // arg é o objeto que a Model passou em notifyObservers()
            if (arg instanceof String) {
                String novoNome = (String) arg;
                nomeLabel.setText("Nome: " + novoNome); // Atualiza o rótulo da View
                // Opcional: Limpar ou preencher o campo de texto com o novo nome
                nomeTextField.setText(novoNome);
            }
        }

        // Método para exibir mensagens de erro/sucesso (pode ser chamado pelo Controller)
        public void exibirMensagem(String mensagem) {
            JOptionPane.showMessageDialog(this, mensagem);
        }
    }
}
