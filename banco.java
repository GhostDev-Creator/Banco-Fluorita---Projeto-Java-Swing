import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("ALL")
public class banco {
    public static void main(String[] args) {
        // Tela principal inicia
        JFrame totem = new JFrame();

        JLabel banco = new JLabel("Bem-Vindo(a) ao Banco Fluorita");
        banco.setBounds(100, 50, 180,30);

        // Botão Entrar inicia
        JButton entrar = new JButton("Entrar na sua conta");
        entrar.setBounds(120,100,150,30);
        entrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre tela de login com nome padrão "Usuário"
                abrirTelaLogin(totem, "Usuário");
            }
        });
        // Botão Entrar finaliza

        // Botão Criar conta inicia
        JButton registrar = new JButton("Criar sua conta");
        registrar.setBounds(120,150,150,30);
        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tela criar conta inicia
                JFrame criar = new JFrame();

                JLabel name = new JLabel("Nome: ");
                name.setBounds(100,50,180,30);
                JTextField camponame = new JTextField();
                camponame.setBounds(100, 80, 180, 30);

                JLabel textlogin = new JLabel("Usuario: ");
                textlogin.setBounds(100,110,180,30);
                JTextField campologin = new JTextField();
                campologin.setBounds(100, 140, 180, 30);

                JLabel textsenha = new JLabel("Senha: ");
                textsenha.setBounds(100, 170, 180, 30);
                JPasswordField camposenha = new JPasswordField();
                camposenha.setBounds(100, 200, 180, 30);

                JButton criarconta = new JButton("Fazer login na sua conta");
                criarconta.setBounds(100, 250, 180, 30);
                criarconta.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Pega o nome digitado e abre tela de login passando o nome
                        String nomeDigitado = camponame.getText();
                        abrirTelaLogin(criar, nomeDigitado);
                    }
                });

                criar.add(name);
                criar.add(camponame);
                criar.add(textlogin);
                criar.add(campologin);
                criar.add(textsenha);
                criar.add(camposenha);
                criar.add(criarconta);

                criar.setLayout(null);
                criar.setBounds(600,130,400,600);
                criar.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                criar.setVisible(true);
                // Tela criar conta finaliza

                totem.dispose();
            }
        });
        // Botão Criar conta finaliza

        totem.add(banco);
        totem.add(entrar);
        totem.add(registrar);

        totem.setLayout(null);
        totem.setBounds(600, 130, 400, 600);
        totem.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        totem.setVisible(true);
        // Tela principal finaliza
    }

    // Tela de login inicia
    private static void abrirTelaLogin(JFrame telaAnterior, String nomeUsuario) {
        JFrame login = new JFrame();

        JLabel textlogin = new JLabel("Usuario: ");
        textlogin.setBounds(100,50,180,30);
        JTextField campologin = new JTextField();
        campologin.setBounds(100, 80, 180, 30);

        JLabel textsenha = new JLabel("Senha: ");
        textsenha.setBounds(100, 120, 180, 30);
        JPasswordField camposenha = new JPasswordField();
        camposenha.setBounds(100, 150, 180, 30);

        JButton entrarconta = new JButton("Entrar na sua conta");
        entrarconta.setBounds(100, 200, 180, 30);
        entrarconta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pega usuário e senha digitados
                String usuario = campologin.getText();
                String senha = new String(camposenha.getPassword());

                System.out.printf("Usuario: %s\nSenha: %s\n", usuario, senha);

                // Abre tela conta passando o nome recebido
                abrirTelaConta(login, nomeUsuario);
            }
        });

        login.add(textlogin);
        login.add(campologin);
        login.add(textsenha);
        login.add(camposenha);
        login.add(entrarconta);

        login.setLayout(null);
        login.setBounds(600, 130, 400, 600);
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.setVisible(true);
        // Tela de login finaliza

        telaAnterior.dispose();
    }

    // Tela da conta inicia
    private static void abrirTelaConta(JFrame telaAnterior, String nome) {
        JFrame conta = new JFrame();

        JLabel nomeconta = new JLabel("Bem-vindo(a), " + nome + "!");
        nomeconta.setBounds(50,50,300,30);

        JLabel valor = new JLabel("Saldo: R$ 98.021,14");
        valor.setBounds(50,80,180,30);

        JCheckBox saldo = new JCheckBox();
        saldo.setBounds(160,85, 20,20);
        saldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (saldo.isSelected()) {
                    valor.setText("Saldo: R$ ***");
                } else {
                    valor.setText("Saldo: R$ 98.021,14");
                }
            }
        });

        conta.add(nomeconta);
        conta.add(valor);
        conta.add(saldo);
        conta.setLayout(null);
        conta.setBounds(600, 130, 400, 600);
        conta.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        conta.setVisible(true);
        // Tela da conta finaliza

        telaAnterior.dispose();
    }
}
