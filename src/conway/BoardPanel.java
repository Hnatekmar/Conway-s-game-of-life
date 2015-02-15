/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conway;

import Utils.Position;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;


/**
 *
 * @author martin
 */
class BoardPanel extends JPanel
{
    private final Board board;
    private final int SIZE_OF_CELL;
    
    public BoardPanel(int w, int h)
    {
        super();
        this.SIZE_OF_CELL = 16;
        setOpaque(false);
        setLayout(new BorderLayout());
        this.board = new Board();
        
        
        this.setSize(w, h);
        
        JPanel panel = this;
        
        this.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(e.getButton() ==  MouseEvent.BUTTON1)
                {
                    board.step();
                }
                else if(e.getButton() == MouseEvent.BUTTON3)
                {
                    board.add(e.getX() / SIZE_OF_CELL, e.getY() / SIZE_OF_CELL);
                }
                else if(e.getButton() == MouseEvent.BUTTON2)
                {
                    board.remove(e.getX() / SIZE_OF_CELL, e.getY() / SIZE_OF_CELL);
                }
                panel.repaint();

            }            
        });
        
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Set<Position> positions = new HashSet<>(this.board.getCells());
        positions.stream().forEach((pos) -> {
            g.setColor(Color.red);
            g.drawRect(pos.getX() * SIZE_OF_CELL, pos.getY() * SIZE_OF_CELL, SIZE_OF_CELL, SIZE_OF_CELL);
        });
    }
}