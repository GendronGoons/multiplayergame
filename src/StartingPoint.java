import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class StartingPoint extends Applet implements Runnable{
	
	
	int x=0;
	int y=0;
	int radius=20;
	double dx =20;
	double dy =0; 
	private Image i;
	private Graphics doubleG;
	double gravity= 15;
	double energyloss =0.7;
	double friction =0.9;
	double dt =0.2;
	
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
		// Thread information
		while(true){
				
			x+=dx;
			if(x+radius>this.getWidth()){
				dx*=-1;
			}
				
			if(x-radius<0 && dx<0){
				dx*=-1;
			}	
			
			if(y>=this.getHeight()-radius){
				y = this.getHeight()-radius-1;
				dy = -dy;
				dy =dy*energyloss;
				dx =dx*friction;
			}
			
			else{
				dy += gravity*dt;
				y += dy*dt + .5*gravity*Math.pow(dt, 2);
				}
			
				
			
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
	
	
	public void stop() {
		if(y==this.getHeight()-radius && dx<0.05)
		super.stop();
	}
	
	private void destory() {
		
		super.destroy();
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
		super.paint(g);
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
