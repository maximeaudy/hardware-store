import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** ********************************************************
 *  class: WindowHandler
 ********************************************************/
class WindowHandler extends WindowAdapter {
    HardwareStore h;

    /** ********************************************************
     *  Method: WindowHandler()
     ********************************************************/
    public WindowHandler( HardwareStore s ) { h = s; }

    /** ********************************************************
     *  Method: windowClosing()
     ********************************************************/
    public void windowClosing( WindowEvent e ) { h.cleanup(); }
}