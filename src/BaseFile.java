import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class BaseFile extends Applet implements Runnable {
	
	private Image i;
	private Graphics doubleG;
		
	public void init() {
		super.init();
		setSize(800, 600);
	}
	
	@Override
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		// TODO Auto-generated method stub
		// Thread information
		
		while(true){
				
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
	
	@Override
	public void stop() {
		
		super.stop();
	}
	
	private void destory() {
		
		super.destroy();
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.fillOval(x, 20, 10, 20);
				
	}
	
	@Override
	public void update(Graphics g) {
		if(i == null){
			i= createImage(this.getSize().width,this.getSize().height);
			doubleG = i.getGraphics();
		}
		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
	
		doubleG.setColor(getForeground());
		paint(doubleG);
		
		g.drawImage(i, 0, 0, this);
				
	}
	

}
