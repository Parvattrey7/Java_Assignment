import java.awt.*;
import java.awt.event.*;

public class SimpleAWTApp extends Frame implements ActionListener {

    private Label nameLabel;
    private TextField nameTextField;
    private Button clickButton;

    public SimpleAWTApp() {
        setTitle("AWT Controls Demo");
        setSize(400, 150);
        
        setLayout(new FlowLayout()); 

        nameLabel = new Label("Enter your name:");
        add(nameLabel);

        nameTextField = new TextField(20); 
        add(nameTextField);

        clickButton = new Button("Click Me");
        add(clickButton);

        clickButton.addActionListener(this); 

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clickButton) {
            String userName = nameTextField.getText();
            System.out.println("Hello, " + userName); 
        }
    }

    public static void main(String[] args) {
        new SimpleAWTApp(); 
    }
}