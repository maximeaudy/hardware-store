import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.RandomAccessFile;

/** ********************************************************
 *  Class:
 ********************************************************/
public class MouseClickedHandler extends MouseAdapter {
    JTable table;
    String pData[] [], columnNames[] ;
    RandomAccessFile f ;
    HardwareStore hw_store;

    /** ********************************************************
     *  Method:
     ********************************************************/
    MouseClickedHandler( RandomAccessFile fPassed , JTable tablePassed ,
                         String p_Data[] [], HardwareStore hw_store) {
        table = tablePassed ;
        pData = p_Data ;
        f     = fPassed ;
        hw_store = hw_store;
    }
    /** ********************************************************
     *  Method: mouseClicked()
     ********************************************************/
    public void mouseClicked( MouseEvent e )    {
        if ( e.getSource() == table) {
            int ii = table.getSelectedRow() ;
            JOptionPane.showMessageDialog(null,
                    "Enter the record ID to be updated and press enter.",
                    "Update Record", JOptionPane.INFORMATION_MESSAGE) ;
            UpdateRec update = new UpdateRec( this.hw_store, f , pData , ii ) ;
            if (  ii < 250) {
                update.setVisible( true );
                table.repaint();
            }
        }
    }
}