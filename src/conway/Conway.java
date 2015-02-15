/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conway;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author martin
 */
public class Conway extends JFrame
{
    private BoardPanel panel;
    
    public Conway(int w, int h)
    {
        super.setTitle("Conway's game of life");
        this.setSize(w, h);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.panel = new BoardPanel(w, h);
        
        this.getContentPane().add(this.panel);
        this.setVisible(true);
    }
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Conway c = new Conway(800, 600);
    }
    
}
