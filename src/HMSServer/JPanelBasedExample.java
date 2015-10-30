package HMSServer;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.TimingSource;
import org.jdesktop.core.animation.timing.sources.ScheduledExecutorTimingSource;

import aeym.swingLibs.dockEffect.DockEffectPanel;
import aeym.swingLibs.dockEffect.DockEffectPanel.DockEffectLayout;

/**
 * A demonstration class of the DockEffectPanel class.
 */
public class JPanelBasedExample {
	/**
	 * The main method of the demonstration.
	 * @param args The command line parameters of the main method (unused).
	 */
	public static void main(String[] args){
		// Initializing the Timing Framework (see http://java.net/projects/timingframework)
		TimingSource ts = new ScheduledExecutorTimingSource();
		Animator.setDefaultTimingSource(ts);
		ts.init();
		
		// Create and show the frame.
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					JFrame theFrame = createFrame();
					theFrame.setVisible(true);
				}
			});
		} catch (Exception e) {
			System.err.println("The GUI creation didn't successfully complete");
		}
	}
	
	/**
	 * Creates the frame where this demonstration is displayed.
	 * @return The frame where this demonstration is displayed.
	 */
	private static JFrame createFrame(){
		// Create the frame of the demonstration.
		JFrame demoFrame = new JFrame("Dock effect demonstration frame.");
		demoFrame.setSize(new Dimension(800, 600));
		demoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create the content pane of the frame.
		JPanel contentPane = new JPanel();
		demoFrame.setContentPane(contentPane);
		
		// Create and add the docking area of the demonstration.
		DockEffectPanel<JPanel> dockEffectPanel = createDockEffectPanel();
		dockEffectPanel.setBorder(BorderFactory.createEtchedBorder()); // Put a border on the dock effect panel
		
		// Create the layout of the docking area.
		GroupLayout layout = new GroupLayout(contentPane);
		contentPane.setLayout(layout);
		layout.setHorizontalGroup(layout.createSequentialGroup()
			.addGap(0, 0, Short.MAX_VALUE)
			.addComponent(dockEffectPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			.addGap(0, 0, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addGap(0, 0, Short.MAX_VALUE)
			.addComponent(dockEffectPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			.addGap(0, 0, Short.MAX_VALUE)
		);
		
		return demoFrame;
	}
	
	/**
	 * Creates the docking area of this demonstration.
	 * @return The docking area of this demonstration.
	 */
	private static DockEffectPanel<JPanel> createDockEffectPanel(){
		DockEffectPanel<JPanel> result = new DockEffectPanel<JPanel>(
			new Dimension(50, 50), // The normal dimensions of the items in the docking area
			new Dimension(75, 75), // The dimensions of the items in the docking area if they are next to the currently hovered item
			new Dimension(200, 200), // The dimensions of the items in the docking area if they are hovered
			DockEffectLayout.HORIZONTAL_WITH_TOP_EXTENSION, // How the items in the docking area are laid out.
			10, // The gap between items in the docking area.
			5 // The number of items in the docking area.
		){
			private static final long serialVersionUID = 1L;
			protected JPanel createComponent(int index) {
				JPanel dockedElt = new JPanel();
				Color bgColor = Color.BLACK;
				switch(index%5){
				case 0:
					bgColor = Color.BLUE;
					break;
				case 1:
					bgColor = Color.CYAN;
					break;
				case 2:
					bgColor = Color.GREEN;
					break;
				case 3:
					bgColor = Color.MAGENTA;
					break;
				case 4:
					bgColor = Color.ORANGE;
					break;
				}
				dockedElt.setBackground(bgColor);
				return dockedElt;
			}
			
		};
		return result;
	}
}
