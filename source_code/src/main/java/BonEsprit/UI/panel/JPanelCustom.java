package BonEsprit.UI.panel;

import java.awt.Dimension;

import javax.swing.JPanel;

public class JPanelCustom extends JPanel {
	int width;
	int height;
	
	Dimension d = null;
	
	public JPanelCustom(int width, int height) {
		this.width = width;
		this.height = height;
		
		d = new Dimension(width, height);
	}
	
	public void setDimension(int width, int height) {
		this.width = width;
		this.height = height;
		d.setSize(width, height);
	}
	
	@Override
    public Dimension getMinimumSize(){
        return d;
    }
    @Override
    public Dimension getPreferredSize(){
        return d;
    }
    @Override
    public Dimension getMaximumSize(){
        return d;
    }
    
    
}
