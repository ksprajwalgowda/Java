import java.awt.*; 
import java.applet.*; 
  
 /*<applet code="ScrollingText" height="350" width="450">
 </applet> 
 */
  
 public class ScrollingText extends Applet implements Runnable 
 { 
      String text="Hello everyone.... "; 
      int state; 
      boolean stopflag; 
            
       
      public void start() 
      { 
           Thread t=new Thread(this); 
           stopflag=true; 
           t.start(); 
      } 
       
      public void run() 
      { 
           char ch; 
           try 
           { 
                while(true) 
                { 
                     repaint(); 
                     Thread.sleep(150); 
                     ch=text.charAt(0); 
                     text = text.substring(1,text.length()); 
                     text +=ch; 
                      
                } 
           } 
           catch (InterruptedException e) 
           { 
               System.out.println(e); 
           } 
      } 
       
      public void stop() 
      { 
           stopflag=false; 
            Thread t=null; 
      } 
       
      public void paint(Graphics g) 
      { 
           Font a = new Font("Impact",Font.BOLD,45); 
           g.setFont(a); 
           g.drawString(text,10,60); 
      } 
       
 }  