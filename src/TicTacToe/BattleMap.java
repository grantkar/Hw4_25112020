package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class BattleMap extends JPanel {
    private GameWindow gameWindow;

    static final int MODE_H_VS_AI = 0;
    static final int MODE_H_VS_H = 1;

    private int mode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;
    static int cellX2;
    static int cellY2;


    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.lightGray);
        setForeground(Color.YELLOW);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;
                 cellX2 = e.getX() / cellWidth;
                 cellY2 = e.getY() / cellHeight;

                 if (mode == MODE_H_VS_AI) {
                     if (!Logic.gameFinished) {
                         Logic.humanTurn(cellX, cellY);
                         DialogWinner();
                     }
                 } else
                     if (mode == MODE_H_VS_H) {

                     if (!Logic.gameFinished) {
                         Logic.humanTurn2(cellX, cellY);
                         DialogWinner();
                     }
                   }

                repaint();
            }
        });


    }

    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }

        cellHeight = getHeight() / fieldSize;
        cellWidth = getWidth() / fieldSize;

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);

        }

        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if(Logic.map[i][j] == Logic.DOT_X){
                    drawX(g, j, i);
                }
                else if (Logic.map[i][j] == Logic.DOT_O){
                    drowO(g, j, i);
                }

            }
        }
        winLine(g);

    }
    private void winLine(Graphics g){
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.GREEN);
        if (Logic.checkWinLines(Logic.DOT_X,Logic.DOTS_TO_WIN) || Logic.checkWinLines(Logic.DOT_O,Logic.DOTS_TO_WIN)){
            g.drawLine(Logic.pointY1*cellHeight, Logic.pointX1*cellWidth,
                    (Logic.pointY2+1)*cellHeight, (Logic.pointX2+1)*cellWidth);
        }
    }

    private void drawX(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.RED);
        g.drawLine(cellX * cellWidth, cellY * cellHeight,
                (cellX + 1) * cellWidth, (cellY + 1) * cellHeight);
        g.drawLine((cellX+1) * cellWidth, cellY * cellHeight,
                cellX  * cellWidth, (cellY +1) * cellHeight);
    }
    private void drowO(Graphics g, int cellX, int cellY){
        g.setColor(Color.BLUE);
        g.drawOval(cellX * cellWidth, cellY * cellHeight, cellWidth, cellHeight);
    }

    private void DialogWinner(){

        if (Logic.checkWinLines(Logic.DOT_X, Logic.DOTS_TO_WIN)) {
            JOptionPane.showMessageDialog(BattleMap.this, Logic.WinToHuman, "Winner",
                    JOptionPane.INFORMATION_MESSAGE);

        } else if (Logic.checkWinLines(Logic.DOT_O, Logic.DOTS_TO_WIN)) {
            JOptionPane.showMessageDialog(BattleMap.this, Logic.WinToIA, "Winner",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (Logic.isFull()) {
            JOptionPane.showMessageDialog(BattleMap.this, Logic.NoWin, "Winner",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
