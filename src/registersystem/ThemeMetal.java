/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registersystem;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Prashanth
 */
public class ThemeMetal {

    public ThemeMetal() {
        try {
            // Set cross-platform Java L&F (also called "Metal")

//                    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName());
//                     UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//                     UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
    }

}
