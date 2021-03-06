/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author martin
 */
public class Position
{
    private final int x;
    private final int y;
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
    
    @Override
    public int hashCode()
    {
        return toString().hashCode();
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Position)
        {
           Position p = (Position)o;
           return this.x == p.x && this.y == p.y; 
        }
        return false;
    }
    
    @Override
    public String toString()
    {
        return "(" + this.x + ", " + this.y + ")";
    }
}
