package fr.soat.impots.ui.view;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    private JPanel mainPanel;
    private JButton backBtn;
    private JPanel upBtnsPanel;
    private JLabel typeLabel;
    private JComboBox typeCombo;
    private JTextField siretField;
    private JTextField denomField;
    private JTextField adresseField;
    private JPanel formPanel;
    private JLabel siretLabel;
    private JLabel denomLabel;
    private JLabel adresseLabel;
    private JButton calcBtn;
    private JLabel resultLabel;
    private JPanel resultPanel;
    private JPanel typePanel;
    private JTextField caField;
    private JLabel caLabel;
    private JTextArea resultArea;

    public MainFrame() {
        setSize(WIDTH, HEIGHT);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        caField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_ENTER)){
                    e.consume();
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getTypePanel() {
        return typePanel;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public JPanel getUpBtnsPanel() {
        return upBtnsPanel;
    }

    public JLabel getTypeLabel() {
        return typeLabel;
    }

    public JComboBox getTypeCombo() {
        return typeCombo;
    }

    public JTextField getSiretField() {
        return siretField;
    }

    public JTextField getDenomField() {
        return denomField;
    }

    public JTextField getAdresseField() {
        return adresseField;
    }

    public JPanel getFormPanel() {
        return formPanel;
    }

    public JLabel getSiretLabel() {
        return siretLabel;
    }

    public JLabel getDenomLabel() {
        return denomLabel;
    }

    public JLabel getAdresseLabel() {
        return adresseLabel;
    }

    public JButton getCalcBtn() {
        return calcBtn;
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }

    public JPanel getResultPanel() {
        return resultPanel;
    }

    public JTextField getCaField() {
        return caField;
    }

    public JLabel getCaLabel() {
        return caLabel;
    }

    public JTextArea getResultArea() {
        return resultArea;
    }
}
