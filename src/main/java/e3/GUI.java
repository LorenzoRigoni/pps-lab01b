package e3;

import e3.gameObjects.AdjacentCellsStrategy;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton,Pair<Integer,Integer>> buttons = new HashMap<>();
    private final Logics logics;
    
    public GUI(int size, int numOfMines) {
        this.logics = new LogicsImpl(size, numOfMines, new AdjacentCellsStrategy());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*size, 100*size);
        
        JPanel panel = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(BorderLayout.CENTER,panel);
        
        ActionListener onClick = (e)->{
            final JButton bt = (JButton)e.getSource();
            final Pair<Integer,Integer> pos = buttons.get(bt);
            boolean aMineWasFound = this.logics.doesCellContainsAMine(pos);
            if (aMineWasFound) {
                quitGame();
                JOptionPane.showMessageDialog(this, "You lost!!");
                System.exit(0);
            } else {
                drawBoard();            	
            }
            boolean isThereVictory = this.logics.isGameOver();
            if (isThereVictory){
                quitGame();
                JOptionPane.showMessageDialog(this, "You won!!");
                System.exit(0);
            }
        };

        MouseInputListener onRightClick = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final JButton bt = (JButton)e.getSource();
                if (bt.isEnabled()){
                    final Pair<Integer,Integer> pos = buttons.get(bt);
                    logics.setCellFlag(pos, !logics.isCellFlagged(pos));
                }
                drawBoard(); 
            }
        };
                
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                final JButton jb = new JButton(" ");
                jb.addActionListener(onClick);
                jb.addMouseListener(onRightClick);
                this.buttons.put(jb,new Pair<>(i,j));
                panel.add(jb);
            }
        }
        this.drawBoard();
        this.setVisible(true);
    }
    
    private void quitGame() {
        this.drawBoard();
    	for (var entry: this.buttons.entrySet()) {
            if (this.logics.doesCellContainsAMine(entry.getValue())) {
                entry.getKey().setText("*");
                entry.getKey().setEnabled(false);
            }
    	}
    }

    private void drawBoard() {
        for (var entry: this.buttons.entrySet()) {
            if (this.logics.isCellFlagged(entry.getValue()))
                entry.getKey().setText("F");
            else if (this.logics.isCellAlreadyShown(entry.getValue())) {
                entry.getKey().setText("" + this.logics.getNumOfMinesOfACell(entry.getValue()));
                entry.getKey().setEnabled(false);
            }
            else
                entry.getKey().setText("");
    	}
    }
    
}
