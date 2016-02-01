import javax.swing.*;      
import java.awt.*;
import java.awt.event.*;
import java.text.*;

/**
   This version of the Converter class presents a more elaborate GUI for
   interacting with the MetricConverter class. In the previous version
   the user had to type in their input. In this version a numeric key
   pad is used to input miles.

    @author Java, Java, Java 
	@author Modified by Amit Jain.  
 */


public class ConverterApplet extends JApplet implements ActionListener
{ 

    private final static int NBUTTONS = 12;  

    private JLabel prompt = new JLabel("Distance in miles: "); 
    private JTextField input = new JTextField(6);
    private JTextArea display = new JTextArea(10,20);
    private JButton convert = new JButton("Convert!");
    private JPanel keypadPanel = new JPanel();
  
    private JButton keyPad[];           // An array of buttons
    private String label[] =            // An array of button labels
                { "1","2","3",
                  "4","5","6",
                  "7","8","9",
                  "C","0","." };

    /**
     *  init() sets the layout and adds
     *  components to the top-level JApplet. Note that components
     */
   public void init () 
    {
        setSize(400, 300);  
        Font myFont = new Font ("Serif", Font.PLAIN, 16);

		/*setTitle("Converter");*/
        getContentPane().setLayout( new BorderLayout() ); 
        initKeyPad();

        JPanel inputPanel = new JPanel();
        prompt.setFont(myFont);
        input.setFont(myFont);
        inputPanel.add(prompt);
        inputPanel.add(input);
        getContentPane().add(inputPanel, "North");

        JPanel controlPanel = new JPanel(new BorderLayout(0,0));
        controlPanel.add(keypadPanel, "Center");
        controlPanel.add(convert, "South");
        getContentPane().add(controlPanel, "East");

        display.setFont(myFont);
        display.setLineWrap( true );
        display.setEditable( false );
        getContentPane().add(display, "Center");
    
      convert.addActionListener(this);   
      input.addActionListener(this);
    } 
  
    /**
     *  initKeyPad() creates an array of JButtons and organizes them
     *   into a graphical key pad panel. Note that you must distinguish
     *   the JButton array, an internal memory structure, from the 
     *   key pad panel, a graphical object that appears in the user interface.
     */
   public void initKeyPad() 
    {   
        keypadPanel.setLayout(new GridLayout(4,3,1,1));
      keyPad = new JButton[NBUTTONS];             // Create the array itself
      for(int k = 0; k < keyPad.length; k++) {    // For each button
          keyPad[k] = new JButton(label[k]);      //  Create a labeled button
          keyPad[k].addActionListener(this);      //  and a listener
          keypadPanel.add(keyPad[k]);             //  and add it to the panel
      } // for
   } 

    /**
     *  actionPerformed() handles all action events for the program.
     *   It must distinguish whether the user clicked on what of the
     *   buttons on the keypad or on the "Convert" or "Input" button.
     *  @param e -- the ActionEvent which prompted this method call
     */
   public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == convert || e.getSource() == input) {
            double miles = Double.valueOf(input.getText()).doubleValue();
            double km = MetricConverter.milesToKm(miles);
                NumberFormat formatter = NumberFormat.getInstance();
                formatter.setMaximumFractionDigits(2);
            display.append(miles + " miles equals " + formatter.format(km) + 
                                                              " kilometers\n");
            input.setText("");
        } else {                                 // A keypad button was pressed
            JButton b = (JButton)e.getSource();
            if (b.getText().equals("C"))
                input.setText("");                   
            else
                input.setText( input.getText() + b.getText() );     
        }
    } 
}
