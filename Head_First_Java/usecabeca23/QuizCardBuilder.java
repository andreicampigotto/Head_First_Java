package usecabeca23;

import java.awt.Event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class QuizCardBuilder {
    
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private JFrame frame;
    
    public static void main(String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }
    
    public void go(){
        //constrói aqui;
        
        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);
        
        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        answer = new JTextArea(6, 20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);
        
        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JButton nextButton  = new JButton("Next Card");
        
        cardList = new ArrayList<QuizCard>();
        
        JLabel qLabel = new JLabel("Question:");
        JLabel aLabel = new JLabel("Answer:");
        
        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        
        JMenuItem saveMenuItem = new JMenuItem("Save");
        newMenuItem.addActionListener(new NewMenuListener());
        
        saveMenuItem.addActionListener(new SaveMenuListener());
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }
    
    public class NextCardListener implements ActionListener{
        public void actionPerformed(ActiveEvent ev){
            
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);
            clearCard();
        }
    }
    
    public class SaveMenuListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);
            
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
    }
    
    public class NewMenuListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            cardList.clear();
            clearCard();
        }
    }
    private void clearCard(){
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }
    
    private void saveFile(File file){
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(file));
            for (QuizCard card : cardList) {
                write.write(card.getQuestion() + "/");
                write.write(card.getAnswer() + "\n");
            }
            write.close();
        } catch (Exception ex) {
            System.out.println("");
            ex.printStackTrace();
        }
    }
}
