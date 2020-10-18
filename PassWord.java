import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** *************************************************************************
 *
 * <p> class PassWord </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c)</p>
 * <p>Company: TSSD</p>
 * @author Ronald S. Holland
 * @version 1.0
 ****************************************************************************/
public class PassWord  extends Dialog
        implements ActionListener {

    private JButton cancel , enter;
    private JTextField userID ;
    private JLabel userIDLabel, passwordLabel ;
    private JPasswordField password ;
    private JPanel buttonPanel, mainPanel ;
    private Container c ;
    private HardwareStore hwStore ;
    private String whichDialog ;

    /** ********************************************************
     *  Method: PassWord() constructor is used to create the
     *          Password dialoog's
     *          1- Labels
     *          2- Text fields
     *          3- Buttons
     *          4- Panels
     ********************************************************/
    public PassWord( HardwareStore hw_Store ) {
        super( new Frame(), "Password Check", true );

        hwStore = hw_Store ;

        /** Create the Enter and Cancel Buttons */
        enter = new JButton( "Enter" );
        cancel = new JButton( "Cancel" );

        /** Create the buttonPanel and the mainPanel */
        buttonPanel = new JPanel() ;
        mainPanel   = new JPanel() ;

        /** declare the GridLayout manager for the mainPanel */
        mainPanel.setLayout( new GridLayout( 3, 2 ) );
        add( mainPanel , BorderLayout.CENTER) ;

        /** Create the text fields */
        userID         = new JTextField( 10 );
        password       = new JPasswordField( 10 );

        /** Create the labels */
        userIDLabel    = new JLabel( "Enter your user ID" );
        passwordLabel  = new JLabel( "Enter your user password" );

        /** add the labels and text fields to the main panel */
        mainPanel.add( userIDLabel );
        mainPanel.add( userID );
        mainPanel.add( passwordLabel );
        mainPanel.add( password );

        /** add the buttons to the button panel */
        buttonPanel.add( enter ) ;
        buttonPanel.add( cancel ) ;
        add( buttonPanel , BorderLayout.SOUTH);

        /** add the actionlisteners to the buttons */
        enter.addActionListener( this );
        cancel.addActionListener( this );

        setSize( 400, 300 );

    }

    /** **************************************************************
     *  Method: displayDialog () is used to display the dialog that
     *          checks the userID and password that allows the user
     *          to add, update, delete hardware items for the various
     *          tables.
     ****************************************************************/
    public void displayDialog ( String which_Dialog ) {
        whichDialog = which_Dialog ;

        /** set userid and password
         *  In a real application, the following two lines are not used.
         *  The dialog interrogates the user for an authorized userID and
         *  password. This information is preset in this case for convenience.*/
        userID.setText( "admin" );
        password.setText( "hwstore" );

        setVisible( true ) ;
    }

    /** ******************************************************************
     * Method: actionPerformed() method responds to the enter or cancel
     * button being pressed on the Password dialog.
     *********************************************************************/
    public void actionPerformed( ActionEvent e )    {

        if ( e.getSource() == enter ) {

            String pwd =  new String ( password.getPassword() ) ;
            String uID =  new String ( userID.getText() ) ;

            if ( ( uID.equals("admin") ) &&
                    ( pwd.equals("hwstore") ) ) {
                if ( whichDialog == "delete"  ) {
                    hwStore.displayDeleteDialog();
                    whichDialog = "closed" ;
                    userID.setText( "" );
                    password.setText( "" );
                    clear();
                }
                else if ( whichDialog == "update"  ) {
                    hwStore.displayUpdateDialog();
                    whichDialog = "closed" ;
                    userID.setText( "" );
                    password.setText( "" );
                    clear();
                }
                else if ( whichDialog == "add"  ) {
                    hwStore.displayAddDialog();
                    whichDialog = "closed" ;
                    userID.setText( "" );
                    password.setText( "" );
                    clear();
                }
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "A userid or the password was incorrect.\n",
                        "Invalid Password", JOptionPane.INFORMATION_MESSAGE) ;
                userID.setText( "" );
                password.setText( "" );
            }
        }

        clear();
    }

    /** ********************************************************
     *  Method: clear()
     ********************************************************/
    private void clear()    {
        setVisible( false );
        return ;
    }

}
/************ This end of the PassWord class **************/