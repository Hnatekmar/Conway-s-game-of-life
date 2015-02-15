/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conway;

import Utils.Position;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author martin
 */
public class Board
{
    private Set<Position> cells;
    public Board()
    {
        this.cells = new HashSet<>();
    }
    
    public void add(int x, int y)
    {
        this.cells.add(new Position(x, y));
    }
    
    public void remove(int x, int y)
    {
        this.cells.remove(new Position(x, y));
    }
    
    public boolean isAlive(int x, int y)
    {
        return this.cells.contains(new Position(x, y));
    }
    
    public Set<Position> getCells()
    {
        return new HashSet<>(this.cells);
    }
    
    private void revive(Set<Position> deadCells, Set<Position> newBoard)
    {
        for(Position pos : deadCells)
        {
            int neighborCells = 0;
            for(int i = -1; i <= 1; i++)
            {
                for(int j = -1; j <= 1; j++)
                {
                    if(i != 0 || j != 0)
                    {
                        if(this.cells.contains(new Position(pos.getX() + i, pos.getY() + j)))
                        {
                            neighborCells++;
                        }
                    }
                }
            }
            
            if(neighborCells == 3)
            {
                newBoard.add(pos);
            }
        }
    }
    
    private void handleCell(Position pos, Set<Position> newBoard)
    {
        Set<Position> deadCells = new HashSet<>();
        int neighborCells = 0;
        
        for(int i = -1; i <= 1; i++)
        {
            for(int j = -1; j <= 1; j++)
            {
                if(i != 0 || j != 0)
                {
                    if(this.cells.contains(new Position(pos.getX() + i, pos.getY() + j)))
                    {
                        neighborCells++;
                    }
                    else
                    {
                        deadCells.add(new Position(pos.getX() + i, pos.getY() + j));
                    }
                }
            }
        }        
        
        revive(deadCells, newBoard);
        
        if(neighborCells < 2 || neighborCells > 3)
        {
            newBoard.remove(pos);
        }
        
    }

    public void step()
    {
        Position[] positions;
        Set<Position> newBoard = new HashSet<Position>(this.cells);
        positions = this.cells.toArray(new Position[this.cells.size()]);
        for (Position position : positions) {
            handleCell(position, newBoard);
        }
        this.cells = newBoard;
    }
    
}
