package fr.soat.impots.ui.controller;

import fr.soat.impots.CalculetteImpots;
import fr.soat.impots.model.AutoEntreprise;
import fr.soat.impots.model.Entreprise;
import fr.soat.impots.model.SAS;
import fr.soat.impots.model.TypesEntreprise;
import fr.soat.impots.ui.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController {

    private MainFrame mainFrame;
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
    private JTextArea resultArea;
    private JLabel resultLabel;
    private JPanel resultPanel;
    private JPanel typePanel;
    private JTextField caField;
    private JLabel caLabel;


    public MainFrameController() {
        initComponents();
        initListeners();

    }

    public void showMainController(){
        mainFrame.setVisible(true);
    }

    private void initComponents() {
        mainFrame = new MainFrame();

        backBtn = mainFrame.getBackBtn();
        upBtnsPanel = mainFrame.getUpBtnsPanel();

        typePanel = mainFrame.getTypePanel();
        typeLabel = mainFrame.getTypeLabel();
        typeCombo= mainFrame.getTypeCombo();

        siretField = mainFrame.getSiretField();
        denomField = mainFrame.getDenomField();
        adresseField= mainFrame.getAdresseField();
        formPanel = mainFrame.getFormPanel();
        siretLabel = mainFrame.getSiretLabel();
        denomLabel = mainFrame.getDenomLabel();
        adresseLabel = mainFrame.getAdresseLabel();
        caField = mainFrame.getCaField();
        caLabel = mainFrame.getCaLabel();
        caLabel.setVisible(false);
        caField.setVisible(false);
        adresseField.setVisible(false);
        adresseLabel.setVisible(false);
        denomField.setVisible(false);
        denomLabel.setVisible(false);
        siretField.setVisible(false);
        siretLabel.setVisible(false);
        formPanel.setVisible(false);


        calcBtn = mainFrame.getCalcBtn();
        resultArea = mainFrame.getResultArea();
        resultLabel = mainFrame.getResultLabel();
        resultPanel = mainFrame.getResultPanel();

        typeCombo.removeAllItems();
        for(int i=0; i<TypesEntreprise.values().length; i++)
            typeCombo.addItem(TypesEntreprise.values()[i]);
    }

    private void initListeners() {
        backBtn.addActionListener(new BackBtnListener());
        typeCombo.addActionListener(new TypeComboListener());
        siretField.addActionListener(new SiretFieldListener());
        denomField.addActionListener(new DenomFieldListener());
        adresseField.addActionListener(new AdresseFieldListener());
        caField.addActionListener(new CAFieldListener());

        calcBtn.addActionListener(new CalcBtnListener());
    }

    private class BackBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(resultArea.isVisible()) resultArea.setText("");

            if(adresseField.isVisible()) adresseField.setText("");
            if(denomField.isVisible()) denomField.setText("");
            if(siretField.isVisible()) siretField.setText("");

            caLabel.setVisible(false);
            caField.setVisible(false);
            adresseField.setVisible(false);
            adresseLabel.setVisible(false);
            denomField.setVisible(false);
            denomLabel.setVisible(false);
            siretField.setVisible(false);
            siretLabel.setVisible(false);
            formPanel.setVisible(false);

            typeCombo.setSelectedItem(null);
            calcBtn.setBorderPainted( false );
            calcBtn.setFocusPainted( false );
        }
    }

    private class TypeComboListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            TypesEntreprise type = (TypesEntreprise) typeCombo.getSelectedItem();
            if(null!=type && type.toString()!="" ){
                if(type==TypesEntreprise.AUTO || type==TypesEntreprise.SAS){
                    formPanel.setVisible(true);
                    siretField.setVisible(true);
                    siretLabel.setVisible(true);
                } else {
                    caLabel.setVisible(false);
                    caField.setVisible(false);
                    adresseField.setVisible(false);
                    adresseLabel.setVisible(false);
                    denomField.setVisible(false);
                    denomLabel.setVisible(false);
                    siretField.setVisible(false);
                    siretLabel.setVisible(false);
                    formPanel.setVisible(false);

                    caField.setText("");
                    adresseField.setText("");
                    denomField.setText("");
                    siretField.setText("");
                    resultArea.setText("Le type d'entreprise que vous avez saisi n'existe pas ou n'est pas encore prise en charge par cette application.");

                    calcBtn.setBorderPainted( false );
                    calcBtn.setFocusPainted( false );
                }
            } else {
                caLabel.setVisible(false);
                caField.setVisible(false);
                adresseField.setVisible(false);
                adresseLabel.setVisible(false);
                denomField.setVisible(false);
                denomLabel.setVisible(false);
                siretField.setVisible(false);
                siretLabel.setVisible(false);
                formPanel.setVisible(false);

                caField.setText("");
                adresseField.setText("");
                denomField.setText("");
                siretField.setText("");
                resultArea.setText("");

                calcBtn.setBorderPainted( false );
                calcBtn.setFocusPainted( false );
            }
        }
    }

    private class SiretFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String siret = siretField.getText();
            if(null!=siret && siret!=""){
                denomField.setVisible(true);
                denomLabel.setVisible(true);
            } else {
                caLabel.setVisible(false);
                caField.setVisible(false);
                adresseField.setVisible(false);
                adresseLabel.setVisible(false);
                denomField.setVisible(false);
                denomLabel.setVisible(false);

                caField.setText("");
                adresseField.setText("");
                denomField.setText("");
                resultArea.setText("");

                calcBtn.setBorderPainted( false );
                calcBtn.setFocusPainted( false );
            }
        }
    }

    private class DenomFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String denomination = denomField.getText();
            TypesEntreprise type = (TypesEntreprise) typeCombo.getSelectedItem();
            if(null!=denomination && denomination!=""){
                if(null!=type && TypesEntreprise.SAS == type) {
                    adresseField.setVisible(true);
                    adresseLabel.setVisible(true);
                } else {
                    caLabel.setVisible(true);
                    caField.setVisible(true);
                }
            } else {
                if(null!=type && TypesEntreprise.SAS == type) {
                    adresseField.setVisible(false);
                    adresseLabel.setVisible(false);
                }
                caLabel.setVisible(false);
                caField.setVisible(false);
                caField.setText("");
                adresseField.setText("");
                resultArea.setText("");
                calcBtn.setBorderPainted( false );
                calcBtn.setFocusPainted( false );
            }
        }
    }

    private class AdresseFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String adresse = adresseField.getText();
            TypesEntreprise type = (TypesEntreprise) typeCombo.getSelectedItem();
            if(null!=adresse && adresse!=""){
                if(null!=type && TypesEntreprise.SAS == type) {
                    caLabel.setVisible(true);
                    caField.setVisible(true);
                }
            } else {
                if(null!=type && TypesEntreprise.SAS == type) {
                    caLabel.setVisible(false);
                    caField.setVisible(false);
                }
                caField.setText("");
                resultArea.setText("");
                calcBtn.setBorderPainted( false );
                calcBtn.setFocusPainted( false );
            }
        }
    }

    private class CAFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Long CA = Long.parseLong(caField.getText());
            if(null!=CA && CA.toString()!=""){
                calcBtn.setBorderPainted( true );
                calcBtn.setFocusPainted( true );
            } else {
                resultArea.setText("");
                calcBtn.setBorderPainted( false );
                calcBtn.setFocusPainted( false );
            }
        }
    }

    private class CalcBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TypesEntreprise type = (TypesEntreprise) typeCombo.getSelectedItem();
            Entreprise entreprise;
            if(null!=type) {
                if(TypesEntreprise.SAS == type){
                    entreprise = new SAS(siretField.getText(), denomField.getText(), adresseField.getText());

                    resultArea.setText(CalculetteImpots.calculImpotEntreprise(entreprise, Long.parseLong(caField.getText())) + " €");
                } else if(TypesEntreprise.AUTO == type){
                    entreprise = new AutoEntreprise(siretField.getText(), denomField.getText());

                    resultArea.setText(CalculetteImpots.calculImpotEntreprise(entreprise, Long.parseLong(caField.getText())) + " €");
                } else {
                    resultArea.setText("Le type d'entreprise que vous avez saisi n'existe pas ou n'est pas encore prise en charge par cette application.");
                }
            }
        }
    }
}
