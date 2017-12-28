/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakenladder;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author RAHUL
 */
public class Snakenladder extends Application {
    public Random rand;
    public int diceval;
    public Label result;
    
    public int[][] ppos=new int[10][10];
    public int[][] snl=new int[6][3];  // 3 snakes and 6 ladder
    
    public static final int size=60;
    public static final int width=10;
    public static final int height=10;
    
    public Circle p1;
    public Circle p2;
    
    public int pos1=1;
    public int pos2=1;
    
    public boolean p1turn=true;
    public boolean p2turn=true;
    
    public boolean play=false;
    Button game;
    
    public int poscir1=1;
    public int poscir2=1;
    
    public static int p1xpos=(size/2); // player size taken is 20*20  THIS IS CENTRE POSITION
    public static int p1ypos=600-(size/2);
    
    public static int p2xpos=(size/2); // player size taken is 20*20
    public static int p2ypos=600-(size/2);    
    
    private Group tilegrp=new Group();
    
    private Parent createcontent(){
    Pane root=new Pane();
    root.setPrefSize((width*size), ((height*size)+100));
      root.getChildren().addAll(tilegrp);
      
        for(int i=0;i<height;i++){
        for(int j=0;j<width;j++){
        tiles tile=new tiles(size,size);// setting the size of tile
        tile.setTranslateX(size*j);// setting the x coordinate of tile
        tile.setTranslateY(size*i);// setting the y coordinate of tile
        tilegrp.getChildren().add(tile);
        }}
        
        
        p1=new Circle(20);
        p1.setFill(Color.BLUE);
        p1.setId("p1");
        p1.getStyleClass().add("snakenladder/style.css");
        p1.setTranslateX(p1xpos);
        p1.setTranslateY(p1ypos);
        
        p2=new Circle(20);
        p2.setFill(Color.RED);
        p2.setId("p2");
        p2.getStyleClass().add("snakenladder/style.css");
        p2.setTranslateX(p2xpos);
        p2.setTranslateY(p2ypos);
        
        Button btn1=new Button("Player 1");
        btn1.setTranslateX(30);
        btn1.setTranslateY(630);
        
        btn1.setOnAction(e ->{
            if(play){
            if(p1turn){
        diceroll();
        result.setText(Integer.toString(diceval));
        moveplayer1();
        playermove(p1xpos,p1ypos,p1);
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////  LADDER
        
        if(p1xpos==30+120 && p1ypos==600-(size/2)){
        p1xpos=30+60;
        p1ypos=600-(size/2)-180;
        playermove(p1xpos,p1ypos,p1);
        poscir1=4;
        }
        
        if(p1xpos==600-(size/2) && p1ypos==600-(size/2)){
        p1xpos-=60;
        p1ypos-=60;
        playermove(p1xpos,p1ypos,p1);
        poscir1=2;
        }
        
        if(p1xpos==600-(size/2)-180 && p1ypos==600-(size/2)-120){
        p1xpos+=60;
        p1ypos-=180;
        playermove(p1xpos,p1ypos,p1);
        poscir1=6;
        }
        
        if(p1xpos==600-(size/2)-300 && p1ypos==600-(size/2)-300){
        p1xpos-=60;
        p1ypos-=180;
        playermove(p1xpos,p1ypos,p1);
        poscir1=9;
        }
        
        if(p1xpos==(size/2)&& p1ypos==600-(size/2)-360){
        p1xpos+=60;
        p1ypos=(size/2);
        playermove(p1xpos,p1ypos,p1);
        poscir1=10;
        }
        
        if(p1xpos==600-(size/2)-60 && p1ypos==600-(size/2)-420){
        p1xpos+=60;
        p1ypos-=60;
        playermove(p1xpos,p1ypos,p1);
        poscir1=9;
        }
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////  LADDER ENDS        

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////  SNAKE
        
        if(p1xpos==(size/2)+240 && p1ypos==600-(size/2)-60){
        p1xpos+=180;
       // p1ypos-=60;
        playermove(p1xpos,p1ypos,p1);
        
        }
        
        if(p1xpos==600-(size/2) && p1ypos==600-(size/2)-180){
        p1xpos=(size/2)+180;
       p1ypos=600-(size/2);
        playermove(p1xpos,p1ypos,p1);
        poscir1=1;
        }
        
         if(p1xpos==(size/2)+360 && p1ypos==600-(size/2)-240){
        p1xpos=(size/2)+240;
       p1ypos=600-(size/2)-120;
        playermove(p1xpos,p1ypos,p1);
        poscir1=3;
        }
        
        if(p1xpos==(size/2)+300 && p1ypos==600-(size/2)-360){
        p1xpos+=180;
       p1ypos+=60;
        playermove(p1xpos,p1ypos,p1);
        poscir1=6;
        }
        
        if(p1xpos==(size/2)+120 && p1ypos==600-(size/2)-360){
        p1xpos=(size/2);
       p1ypos+=60;
        playermove(p1xpos,p1ypos,p1);
        poscir1=6;
        }
        
        if(p1xpos==(size/2)+180 && p1ypos==(size/2)){
        p1xpos+=120;
       p1ypos+=120;
        playermove(p1xpos,p1ypos,p1);
        poscir1=8;
        }
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////  SNAKE ENDS
        
        p1turn=false;
        p2turn=true;
        }
        }});
        
        Button btn2=new Button("Player 2");
        btn2.setTranslateX(510);
        btn2.setTranslateY(630);
        btn2.setOnAction(e ->{
            if(play){
            if(p2turn){
        diceroll();
        result.setText(Integer.toString(diceval));
        moveplayer2();
        playermove(p2xpos,p2ypos,p2);
        
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////  LADDER
        if(p2xpos==30+120 && p2ypos==600-(size/2)){
        p2xpos=30+60;
        p2ypos=600-(size/2)-180;
      
        playermove(p2xpos,p2ypos,p2);
        poscir2=4;
        }
        
        if(p2xpos==600-(size/2) && p2ypos==600-(size/2)){
        p2xpos-=60;
        p2ypos-=60;
        playermove(p2xpos,p2ypos,p2);
        poscir2=2;
        }
        
        if(p2xpos==600-(size/2)-180 && p2ypos==600-(size/2)-120){
        p2xpos+=60;
        p2ypos-=180;
        playermove(p2xpos,p2ypos,p2);
        poscir2=6;
        }
        
        if(p2xpos==600-(size/2)-300 && p2ypos==600-(size/2)-300){
        p2xpos-=60;
        p2ypos-=180;
        playermove(p2xpos,p2ypos,p2);
        poscir2=9;
        }
        
        if(p2xpos==(size/2)&& p2ypos==600-(size/2)-360){
        p2xpos+=60;
        p2ypos=(size/2);
        playermove(p2xpos,p2ypos,p2);
        poscir2=10;
        }
        
        if(p2xpos==600-(size/2)-60 && p2ypos==600-(size/2)-420){
        p2xpos+=60;
        p2ypos-=60;
        playermove(p2xpos,p2ypos,p2);
        poscir2=9;
        }
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////  LADDER  ENDS

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////  SNAKE

        if(p2xpos==(size/2)+240 && p2ypos==600-(size/2)-60){
        p2xpos+=180;
       // p1ypos-=60;
        playermove(p2xpos,p2ypos,p2);
        }
        
        if(p2xpos==600-(size/2) && p2ypos==600-(size/2)-180){
        p2xpos=(size/2)+180;
       p2ypos=600-(size/2);
        playermove(p2xpos,p2ypos,p2);
        poscir2=1;
        }
        
         if(p2xpos==(size/2)+360 && p2ypos==600-(size/2)-240){
        p2xpos=(size/2)+240;
       p2ypos=600-(size/2)-120;
        playermove(p2xpos,p2ypos,p2);
        poscir2=3;
        }
        
        if(p2xpos==(size/2)+300 && p2ypos==600-(size/2)-360){
        p2xpos+=180;
       p2ypos+=60;
        playermove(p2xpos,p2ypos,p2);
        poscir2=6;
        }
        
        if(p2xpos==(size/2)+120 && p2ypos==600-(size/2)-360){
        p2xpos=(size/2);
       p2ypos+=60;
        playermove(p2xpos,p2ypos,p2);
        poscir2=6;
        }
        
        if(p2xpos==(size/2)+180 && p2ypos==(size/2)){
        p2xpos+=120;
       p2ypos+=120;
        playermove(p2xpos,p2ypos,p2);
        poscir2=8;
        }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////  SNAKE ENDS
        p2turn=false;
        p1turn=true;
        }
        }});
        
        game=new Button("Start THE GAME!!");
        game.setTranslateX(100);
        game.setTranslateY(660);
        game.setOnAction(e -> {
            
            play=true;
            game.setText("Game Started!!");
            
            p1xpos=(size/2); // player size taken is 20*20  THIS IS CENTRE POSITION
            p1ypos=600-(size/2);
    
            p2xpos=(size/2); // player size taken is 20*20
            p2ypos=600-(size/2);    
            
            p1.setTranslateX(p1xpos);
            p1.setTranslateY(p1ypos);
            p2.setTranslateX(p2xpos);
            p2.setTranslateY(p2ypos);
            
            poscir2=1;
            poscir1=1;
            
            
        });
        
        result=new Label("0");
        result.setTranslateX(400);
        result.setTranslateY(630);
        
        Image img=new Image("snakenladder/snakebg.jpg");
        ImageView imv=new ImageView();
        imv.setImage(img);
        imv.setFitWidth(600);
        imv.setFitHeight(600);
        
        tilegrp.getChildren().addAll(imv,p1,p2,btn1,btn2,game,result);
    return root;
    }
    public  void diceroll(){
        rand=new Random();
    diceval=rand.nextInt(6)+1;}
    
    public void moveplayer1(){
    for(int i=0;i<diceval;i++){
        
    if(poscir1%2!=0)p1xpos+=60;
    
    if(poscir1%2==0)p1xpos-=60;
    
    if(p1xpos<=(size/2) && p1ypos<=(size/2)){
    p1xpos=(size/2);
    p1ypos=(size/2);
    result.setText("Player 1 WON!!");
    game.setText("Start THE GAME!!");
    play=false;
    }
    
    if(p1xpos>(600-(size/2))){
        p1xpos-=60;
        p1ypos-=60;
        poscir1++;
    }
    
    if(p1xpos<((size/2))){
    p1xpos+=60;
    p1ypos-=60;
    poscir1++;
    }
    
    }
    }
    
    
    public void moveplayer2(){
    for(int i=0;i<diceval;i++){
        
    if(poscir2%2!=0)p2xpos+=60;
    
    if(poscir2%2==0)p2xpos-=60;
    
    if(p2xpos<=(size/2) && p2ypos<=(size/2)){
    p2xpos=(size/2);
    p2ypos=(size/2);
    result.setText("Player 2 WON!!");
    game.setText("Start THE GAME!!");
    play=false;
    }
    
    if(p2xpos>(600-(size/2))){
        p2xpos-=60;
        p2ypos-=60;
        poscir2++;
    }
    
    if(p2xpos<((size/2))){
    p2xpos+=60;
    p2ypos-=60;
    poscir2++;
    }
    
    }
    }
    
    
    public void playermove(int x,int y, Circle c){
    TranslateTransition move=new TranslateTransition(Duration.millis(1000),c);
    move.setToX(x);
    move.setToY(y);
    move.setAutoReverse(false);
    move.play();
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Scene scene = new Scene(createcontent());
        scene.getStylesheets().add("snakenladder/style.css");
        stage.setTitle("snake n ladder");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
