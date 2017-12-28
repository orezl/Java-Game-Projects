/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakenladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author RAHUL
 */
public class tiles extends Rectangle{
    public tiles(int x,int y){
    setWidth(x);
    setHeight(y);
    setFill(Color.BISQUE);
    setStroke(Color.BLACK);
    }
    
    
}
