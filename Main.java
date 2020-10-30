import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel firstLabel;
  JLabel secondLabel;

  JTextField firstInput;
  JTextField secondInput;

  JButton fcButton;
  JButton cfButton;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Tempurature Converter");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //initialize the main panel
    mainPanel = new JPanel();
    //disable layout helpers
    mainPanel.setLayout(null);

    //create labels
    firstLabel = new JLabel("Degrees Fahrenheit");
    secondLabel = new JLabel("Degrees Celsius");

    //set location and size of labels
    firstLabel.setBounds(100,150,150,20);
    secondLabel.setBounds(100,180,150,20);

    //create text fields
    firstInput = new JTextField();
    secondInput = new JTextField();

    //set location and size of text fields
    firstInput.setBounds(300,150,150,20);
    secondInput.setBounds(300,180,150,20);

    //create buttons
    fcButton = new JButton("F -> C");
    cfButton = new JButton("C -> F");

    //set location and size of buttons
    fcButton.setBounds(500,150,150,20);
    cfButton.setBounds(500,180,150,20);

    //add action listener to buttons
    fcButton.addActionListener(this);
    cfButton.addActionListener(this);

    //set action command to buttons
    fcButton.setActionCommand("F to C");
    cfButton.setActionCommand("C to F");

    //add labels to the panel
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);

    //add text fields to the panel
    mainPanel.add(firstInput);
    mainPanel.add(secondInput);

    //add buttons to the panel
    mainPanel.add(fcButton);
    mainPanel.add(cfButton);

    //add the panel to the frame
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("F to C")){
      //get the text from first text fields
      String firstText = firstInput.getText();
      //convert text to integer
      int num1 = Integer.parseInt(firstText);

      //change Fahrenheit to Celsius
      int celsius = (num1 - 32)*5/9;
      //put answer in text field
      secondInput.setText("" + celsius);
    }else if(command.equals("C to F")){
      //get the text from second text field;
      String secondText = secondInput.getText();
      //conver text to integer
      int num2 = Integer.parseInt(secondText);

      //change celsuis to Fahrenheit
      int fahrenheit = (num2/5*9 + 32);
      //put answer in text field
      firstInput.setText("" + fahrenheit);
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
