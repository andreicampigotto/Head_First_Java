package usecabeca23;

import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class QuizCardPlayer {
    
    private JTextArea display;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;

    public static void main(String[] args) {
        QuizCardPlayer reader = new QuizCardPlayer();
        reader.go();
    }
    
    public void go(){
        //constrói a gui
    
        frame = new JFrame("Quiz Card Player");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        
        display = new JTextArea(10, 20);
        display.setFont(bigFont);
        
        display.setLineWrap(true);
        display.setEditable(false);
        
        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        nextButton = new JButton("Show Question");
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(nextButton);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(640, 500);
        frame.setVisible(true);
    } // fecha go;
    
    public class NextCardListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            if (isShowAnswer){
                // exibe a resposta porque a pergunta já foi vista;
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer = false;
            }else {
                //proxima pergunta;
                if(currentCard < cardList.size()){
                    showNextCard();
                }else{
                    // não há mais cartões
                    display.setText("That was last card");
                    nextButton.setEnabled(false);
                }
            }
        }
    }
    public class OpenMenuListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }
    private void loadFile(File file){
        cardList = new ArrayList<QuizCard>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                makeCard(line);                
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println("Couldn't read the card file" );
            ex.printStackTrace();
        }
        
        showNextCard();
    }
    private void makeCard(String lineToParse){
        String result[] = lineToParse.split("/");
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        System.out.println("made a card");
    }
    private void showNextCard(){
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }
}


