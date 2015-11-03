package aeym.swingLibs.dockEffect.demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.TimingSource;
import org.jdesktop.core.animation.timing.sources.ScheduledExecutorTimingSource;

import aeym.swingLibs.dockEffect.DockEffectPanel;
import aeym.swingLibs.dockEffect.DockEffectPanel.DockEffectLayout;

/**
 * The demo applet of the {@link DockEffectPanel} class.
 */
public class DemoApplet extends JFrame {

    /**
     * The main method of the class.
     */
    /**
     * Serialization ID.
     */
    private static final long serialVersionUID = 268900549028365545L;

    /**
     * @see java.applet.Applet#start()
     */
    public void start() {
        // Initializing the Timing Framework (see http://java.net/projects/timingframework)
        TimingSource ts = new ScheduledExecutorTimingSource();
        Animator.setDefaultTimingSource(ts);
        ts.init();

        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createView();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the view of the applet.
     */
    private void createView() {
        System.out.println("ADARSHhhhhhh");
        getContentPane().setLayout(new BorderLayout());
        JLabel title = new JLabel("<html><big><b>Dock effect demonstration application.</b></big></html>");
        getContentPane().add(title, BorderLayout.NORTH);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Horizontal layout", new JScrollPane(createHorizontalLayoutPanel()));
        tabbedPane.add("Vertical layout", new JScrollPane(createVerticalLayoutPanel()));
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    /**
     * Creates the view element related to horizontally laid out docks.
     *
     * @return The view element related to horizontally laid out docks.
     */
    private JPanel createHorizontalLayoutPanel() {
        JPanel result = new JPanel();

        final DockEffectPanel<JPanel> dockPan1 = createJPanelDockEffectPanel(DockEffectLayout.HORIZONTAL_WITH_BOTTOM_EXTENSION);
        dockPan1.setBorder(new TitledBorder("Horizontal align - bottom extension"));
        JButton dockPan1SrcBtn = new JButton("View source");
        final String source = "// Text to put at the beginning of the program\n"
                + "TimingSource ts = new ScheduledExecutorTimingSource();\n"
                + "Animator.setDefaultTimingSource(ts);\n"
                + "ts.init();\n"
                + "// END\n"
                + "\n"
                + "Component swingComponent = ... ;\n"
                + "\n"
                + "DockEffectPanel<JPanel> thePanel = new DockEffectPanel<JPanel>(\n"
                + "	new Dimension(50, 50), // Normal size of an item\n"
                + "	new Dimension(100, 100), // Size of an item next to the hovered one\n"
                + "	new Dimension(200, 200), // Size of an hovered item\n"
                + "	DockEffectLayout.HORIZONTAL_WITH_BOTTOM_EXTENSION,\n"
                + "	10, // The gap between items in the docking area.\n"
                + "	5 // The number of items in the docking area.\n"
                + "){\n"
                + "	private static final long serialVersionUID = 1L;\n"
                + "	protected JPanel createComponent(int index) {\n"
                + "		JPanel dockedElt = new JPanel();\n"
                + "		Color bgColor = Color.BLACK;\n"
                + "		switch(index%5){\n"
                + "		case 0:\n"
                + "			bgColor = Color.BLUE;\n"
                + "			break;\n"
                + "		case 1:\n"
                + "			bgColor = Color.CYAN;\n"
                + "			break;\n"
                + "		case 2:\n"
                + "			bgColor = Color.GREEN;\n"
                + "			break;\n"
                + "		case 3:\n"
                + "			bgColor = Color.MAGENTA;\n"
                + "			break;\n"
                + "		case 4:\n"
                + "			bgColor = Color.ORANGE;\n"
                + "			break;\n"
                + "		}\n"
                + "		dockedElt.setBackground(bgColor);\n"
                + "		return dockedElt;\n"
                + "	}\n"
                + "};\n"
                + "\n"
                + "// Add the swing component to the application\n"
                + "swingComponent.add(thePanel);\n";
        dockPan1SrcBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        dockPan1,
                        new TextArea(source.toString(), 0, 400),
                        "Horizontal align - bottom extension - source code",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        JSeparator sep1 = new JSeparator(JSeparator.HORIZONTAL);

        final DockEffectPanel<JButton> dockPan2 = createJButtonDockEffectPanel(DockEffectLayout.HORIZONTAL_WITH_CENTERED_ITEMS);
        dockPan2.setBorder(new TitledBorder("Horizontal align - centered extension"));
        JButton dockPan2SrcBtn = new JButton("View source");
        final String source2 = "// Text to put at the beginning of the program\n"
                + "TimingSource ts = new ScheduledExecutorTimingSource();\n"
                + "Animator.setDefaultTimingSource(ts);\n"
                + "ts.init();\n"
                + "// END\n"
                + "\n"
                + "Component swingComponent = ... ;\n"
                + "\n"
                + "DockEffectPanel<JButton> thePanel = new DockEffectPanel<JButton>(\n"
                + "	new Dimension(50, 50), // Normal size of an item\n"
                + "	new Dimension(100, 100), // Size of an item next to the hovered one\n"
                + "	new Dimension(200, 200), // Size of an hovered item\n"
                + "	DockEffectLayout.HORIZONTAL_WITH_CENTERED_ITEMS,\n"
                + "	10, // The gap between items in the docking area.\n"
                + "	5 // The number of items in the docking area.\n"
                + "){\n"
                + "	private static final long serialVersionUID = 1L;\n"
                + "	protected JButton createComponent(int index) {\n"
                + "		JButton dockedElt = new JButton(\"Button \" + index);\n"
                + "		return dockedElt;\n"
                + "	}\n"
                + "};\n"
                + "\n"
                + "// Add the swing component to the application\n"
                + "swingComponent.add(thePanel);\n";
        dockPan2SrcBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        dockPan2,
                        new TextArea(source2.toString(), 0, 400),
                        "Horizontal align - centered extension - source code",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        JSeparator sep2 = new JSeparator(JSeparator.HORIZONTAL);

        final DockEffectPanel<JPanel> dockPan3 = createJPanelDockEffectPanel(DockEffectLayout.HORIZONTAL_WITH_TOP_EXTENSION);
        dockPan3.setBorder(new TitledBorder("Horizontal align - top extension"));
        JButton dockPan3SrcBtn = new JButton("View source");
        final String source3 = "// Text to put at the beginning of the program\n"
                + "TimingSource ts = new ScheduledExecutorTimingSource();\n"
                + "Animator.setDefaultTimingSource(ts);\n"
                + "ts.init();\n"
                + "// END\n"
                + "\n"
                + "Component swingComponent = ... ;\n"
                + "\n"
                + "DockEffectPanel<JPanel> thePanel = new DockEffectPanel<JPanel>(\n"
                + "	new Dimension(50, 50), // Normal size of an item\n"
                + "	new Dimension(100, 100), // Size of an item next to the hovered one\n"
                + "	new Dimension(200, 200), // Size of an hovered item\n"
                + "	DockEffectLayout.HORIZONTAL_WITH_TOP_EXTENSION,\n"
                + "	10, // The gap between items in the docking area.\n"
                + "	5 // The number of items in the docking area.\n"
                + "){\n"
                + "	private static final long serialVersionUID = 1L;\n"
                + "	protected JPanel createComponent(int index) {\n"
                + "		JPanel dockedElt = new JPanel();\n"
                + "		Color bgColor = Color.BLACK;\n"
                + "		switch(index%5){\n"
                + "		case 0:\n"
                + "			bgColor = Color.BLUE;\n"
                + "			break;\n"
                + "		case 1:\n"
                + "			bgColor = Color.CYAN;\n"
                + "			break;\n"
                + "		case 2:\n"
                + "			bgColor = Color.GREEN;\n"
                + "			break;\n"
                + "		case 3:\n"
                + "			bgColor = Color.MAGENTA;\n"
                + "			break;\n"
                + "		case 4:\n"
                + "			bgColor = Color.ORANGE;\n"
                + "			break;\n"
                + "		}\n"
                + "		dockedElt.setBackground(bgColor);\n"
                + "		return dockedElt;\n"
                + "	}\n"
                + "};\n"
                + "\n"
                + "// Add the swing component to the application\n"
                + "swingComponent.add(thePanel);\n";
        dockPan3SrcBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        dockPan3,
                        new TextArea(source3.toString(), 0, 400),
                        "Horizontal align - right extension - source code",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        GroupLayout layout = new GroupLayout(result);
        result.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(dockPan1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dockPan1SrcBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                )
                .addComponent(sep1, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(dockPan2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dockPan2SrcBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                )
                .addComponent(sep2, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(dockPan3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dockPan3SrcBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(dockPan1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(dockPan1SrcBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                        )
                )
                .addGap(5)
                .addComponent(sep1, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(5)
                .addGroup(layout.createParallelGroup()
                        .addComponent(dockPan2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(dockPan2SrcBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                        )
                )
                .addGap(5)
                .addComponent(sep2, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(5)
                .addGroup(layout.createParallelGroup()
                        .addComponent(dockPan3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(dockPan3SrcBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                        )
                )
        );
        return result;
    }

    private JPanel createVerticalLayoutPanel() {
        JPanel result = new JPanel();

        final DockEffectPanel<JPanel> dockPan1 = createJPanelDockEffectPanel(DockEffectLayout.VERTICAL_WITH_LEFT_EXTENSION);
        dockPan1.setBorder(new TitledBorder("Vertical align - left extension"));
        JButton dockPan1SrcBtn = new JButton("View source");
        final String source = "// Text to put at the beginning of the program\n"
                + "TimingSource ts = new ScheduledExecutorTimingSource();\n"
                + "Animator.setDefaultTimingSource(ts);\n"
                + "ts.init();\n"
                + "// END\n"
                + "\n"
                + "Component swingComponent = ... ;\n"
                + "\n"
                + "DockEffectPanel<JPanel> thePanel = new DockEffectPanel<JPanel>(\n"
                + "	new Dimension(50, 50), // Normal size of an item\n"
                + "	new Dimension(100, 100), // Size of an item next to the hovered one\n"
                + "	new Dimension(200, 200), // Size of an hovered item\n"
                + "	DockEffectLayout.VERTICAL_WITH_LEFT_EXTENSION,\n"
                + "	10, // The gap between items in the docking area.\n"
                + "	5 // The number of items in the docking area.\n"
                + "){\n"
                + "	private static final long serialVersionUID = 1L;\n"
                + "	protected JPanel createComponent(int index) {\n"
                + "		JPanel dockedElt = new JPanel();\n"
                + "		Color bgColor = Color.BLACK;\n"
                + "		switch(index%5){\n"
                + "		case 0:\n"
                + "			bgColor = Color.BLUE;\n"
                + "			break;\n"
                + "		case 1:\n"
                + "			bgColor = Color.CYAN;\n"
                + "			break;\n"
                + "		case 2:\n"
                + "			bgColor = Color.GREEN;\n"
                + "			break;\n"
                + "		case 3:\n"
                + "			bgColor = Color.MAGENTA;\n"
                + "			break;\n"
                + "		case 4:\n"
                + "			bgColor = Color.ORANGE;\n"
                + "			break;\n"
                + "		}\n"
                + "		dockedElt.setBackground(bgColor);\n"
                + "		return dockedElt;\n"
                + "	}\n"
                + "};\n"
                + "\n"
                + "// Add the swing component to the application\n"
                + "swingComponent.add(thePanel);\n";
        dockPan1SrcBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        dockPan1,
                        new TextArea(source.toString(), 0, 400),
                        "Vertical align - left extension - source code",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        JSeparator sep1 = new JSeparator(JSeparator.VERTICAL);

        final DockEffectPanel<JButton> dockPan2 = createJButtonDockEffectPanel(DockEffectLayout.VERTICAL_WITH_CENTERED_ITEMS);
        dockPan2.setBorder(new TitledBorder("Vertical align - centered extension"));
        JButton dockPan2SrcBtn = new JButton("View source");
        final String source2 = "// Text to put at the beginning of the program\n"
                + "TimingSource ts = new ScheduledExecutorTimingSource();\n"
                + "Animator.setDefaultTimingSource(ts);\n"
                + "ts.init();\n"
                + "// END\n"
                + "\n"
                + "Component swingComponent = ... ;\n"
                + "\n"
                + "DockEffectPanel<JButton> thePanel = new DockEffectPanel<JButton>(\n"
                + "	new Dimension(50, 50), // Normal size of an item\n"
                + "	new Dimension(100, 100), // Size of an item next to the hovered one\n"
                + "	new Dimension(200, 200), // Size of an hovered item\n"
                + "	DockEffectLayout.VERTICAL_WITH_CENTERED_ITEMS,\n"
                + "	10, // The gap between items in the docking area.\n"
                + "	5 // The number of items in the docking area.\n"
                + "){\n"
                + "	private static final long serialVersionUID = 1L;\n"
                + "	protected JButton createComponent(int index) {\n"
                + "		JButton dockedElt = new JButton(\"Button \" + index);\n"
                + "		return dockedElt;\n"
                + "	}\n"
                + "};\n"
                + "\n"
                + "// Add the swing component to the application\n"
                + "swingComponent.add(thePanel);\n";
        dockPan2SrcBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        dockPan2,
                        new TextArea(source2.toString(), 0, 400),
                        "Vertical align - centered extension - source code",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        JSeparator sep2 = new JSeparator(JSeparator.VERTICAL);

        final DockEffectPanel<JPanel> dockPan3 = createJPanelDockEffectPanel(DockEffectLayout.VERTICAL_WITH_RIGHT_EXTENSION);
        dockPan3.setBorder(new TitledBorder("Vertical align - right extension"));
        JButton dockPan3SrcBtn = new JButton("View source");
        final String source3 = "// Text to put at the beginning of the program\n"
                + "TimingSource ts = new ScheduledExecutorTimingSource();\n"
                + "Animator.setDefaultTimingSource(ts);\n"
                + "ts.init();\n"
                + "// END\n"
                + "\n"
                + "Component swingComponent = ... ;\n"
                + "\n"
                + "DockEffectPanel<JPanel> thePanel = new DockEffectPanel<JPanel>(\n"
                + "	new Dimension(50, 50), // Normal size of an item\n"
                + "	new Dimension(100, 100), // Size of an item next to the hovered one\n"
                + "	new Dimension(200, 200), // Size of an hovered item\n"
                + "	DockEffectLayout.VERTICAL_WITH_RIGHT_EXTENSION,\n"
                + "	10, // The gap between items in the docking area.\n"
                + "	5 // The number of items in the docking area.\n"
                + "){\n"
                + "	private static final long serialVersionUID = 1L;\n"
                + "	protected JPanel createComponent(int index) {\n"
                + "		JPanel dockedElt = new JPanel();\n"
                + "		Color bgColor = Color.BLACK;\n"
                + "		switch(index%5){\n"
                + "		case 0:\n"
                + "			bgColor = Color.BLUE;\n"
                + "			break;\n"
                + "		case 1:\n"
                + "			bgColor = Color.CYAN;\n"
                + "			break;\n"
                + "		case 2:\n"
                + "			bgColor = Color.GREEN;\n"
                + "			break;\n"
                + "		case 3:\n"
                + "			bgColor = Color.MAGENTA;\n"
                + "			break;\n"
                + "		case 4:\n"
                + "			bgColor = Color.ORANGE;\n"
                + "			break;\n"
                + "		}\n"
                + "		dockedElt.setBackground(bgColor);\n"
                + "		return dockedElt;\n"
                + "	}\n"
                + "};\n"
                + "\n"
                + "// Add the swing component to the application\n"
                + "swingComponent.add(thePanel);\n";
        dockPan3SrcBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        dockPan3,
                        new TextArea(source3.toString(), 0, 400),
                        "Vertical align - right extension - source code",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        GroupLayout layout = new GroupLayout(result);
        result.setLayout(layout);
        layout.setVerticalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(dockPan1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dockPan1SrcBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                )
                .addComponent(sep1, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(dockPan2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dockPan2SrcBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                )
                .addComponent(sep2, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(dockPan3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dockPan3SrcBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                )
        );
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup()
                        .addComponent(dockPan1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(dockPan1SrcBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                        )
                )
                .addGap(5)
                .addComponent(sep1, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(5)
                .addGroup(layout.createParallelGroup()
                        .addComponent(dockPan2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(dockPan2SrcBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                        )
                )
                .addGap(5)
                .addComponent(sep2, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(5)
                .addGroup(layout.createParallelGroup()
                        .addComponent(dockPan3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(dockPan3SrcBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                        )
                )
                .addGap(0, 0, Short.MAX_VALUE)
        );
        return result;
    }

    /**
     * Creates the docking area of this demonstration.
     *
     * @param layout The layout of the docking panel.
     * @return The docking area of this demonstration.
     */
    private static DockEffectPanel<JPanel> createJPanelDockEffectPanel(DockEffectLayout layout) {
        DockEffectPanel<JPanel> result = new DockEffectPanel<JPanel>(
                new Dimension(50, 50), // The normal dimensions of the items in the docking area
                new Dimension(100, 100), // The dimensions of the items in the docking area if they are next to the currently hovered item
                new Dimension(200, 200), // The dimensions of the items in the docking area if they are hovered
                layout, // How the items in the docking area are laid out.
                10, // The gap between items in the docking area.
                5 // The number of items in the docking area.
        ) {
            private static final long serialVersionUID = 1L;

            protected JPanel createComponent(int index) {
                JPanel dockedElt = new JPanel();
                Color bgColor = Color.BLACK;
                switch (index % 5) {
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

    /**
     * Creates the docking area of this demonstration.
     *
     * @param layout The layout of the docking panel.
     * @return The docking area of this demonstration.
     */
    private static DockEffectPanel<JButton> createJButtonDockEffectPanel(DockEffectLayout layout) {
        DockEffectPanel<JButton> result = new DockEffectPanel<JButton>(
                new Dimension(50, 50), // The normal dimensions of the items in the docking area
                new Dimension(100, 100), // The dimensions of the items in the docking area if they are next to the currently hovered item
                new Dimension(200, 200), // The dimensions of the items in the docking area if they are hovered
                layout, // How the items in the docking area are laid out.
                10, // The gap between items in the docking area.
                5 // The number of items in the docking area.
        ) {
            private static final long serialVersionUID = 1L;

            protected JButton createComponent(int index) {
                JButton dockedElt = new JButton("Button " + index);
                return dockedElt;
            }
        };
        return result;
    }
}
