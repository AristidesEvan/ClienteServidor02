import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class aula02 {
    public JPanel painelPrincipal;
    public JButton botaoMsg;
    public JTextField textField1;
    public JTextField textField2;
    public JRadioButton radioButton1;
    public JRadioButton radioButton2;
    public JRadioButton radioButton3;
    public JRadioButton radioButton4;
    private ButtonGroup group;

    public aula02() {
        // Adicionando os radio buttons a um grupo para que apenas um possa ser selecionado
        group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        group.add(radioButton4);

        botaoMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().isEmpty() || textField2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(painelPrincipal, "Campos com valores vazios!", "ERRO", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        double num1 = Double.parseDouble(textField1.getText());
                        double num2 = Double.parseDouble(textField2.getText());
                        double resultado = 0;

                        if (radioButton1.isSelected()) {
                            resultado = num1 + num2;
                        } else if (radioButton2.isSelected()) {
                            resultado = num1 - num2;
                        } else if (radioButton3.isSelected()) {
                            resultado = num1 * num2;
                        } else if (radioButton4.isSelected()) {
                            if (num2 != 0) {
                                resultado = num1 / num2;
                            } else {
                                JOptionPane.showMessageDialog(painelPrincipal, "Divisão por zero!", "ERRO", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        } else {
                            JOptionPane.showMessageDialog(painelPrincipal, "Selecione uma operação!", "ERRO", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        JOptionPane.showMessageDialog(painelPrincipal, "O resultado é: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(painelPrincipal, "Valores inválidos!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}

