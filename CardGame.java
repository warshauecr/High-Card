import java.util.NoSuchElementException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Casey Warshauer
 */
public class CardGame extends Application {
    
    private VBox banner;
    private HBox player;
    private HBox buttonPane;
    private BorderPane root;
    
    private TextArea player1;
    private TextArea player2;
    private Label p1;
    private Label p2;
    private Label title;
    
    private Button deal;
    private Button exit;
    private Button newDeck;
    
    private Deck CardDeck;
    
    @Override
    public void start(Stage primaryStage) {
     
       
        //Create player pane and Text Area for each player and add to Hbox
        playerOutPut();
        
        //Create Button pane
        addButtonPane();
                 
         //Add Buttons
        addButtons();
         
         //Add Event Handler
        addHandler();
         
         //Add Banner and lable
        addBanner();
      
        //Create and add player pane to root pane
        addRootPanes();
       
        //Create Scene
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("High Card");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void playerOutPut()
    {
        //Create Text Area for each player and add to Hbox
        player = new HBox(10);
        player.setAlignment(Pos.CENTER);
        
        //player 1 output
        player1 = new TextArea("Player 1");
        player1.setPrefColumnCount(15);
        player1.setPrefRowCount(5);
        player1.setEditable(false);
        
        //player2 output
        player2 = new TextArea("Player2");
        player2.setPrefColumnCount(15);
        player2.setPrefRowCount(5);
        player2.setEditable(false);
        
        //Add player output to panel
        player.getChildren().addAll(player1, player2);
    }
    
    /*
      Method creates button pane.
    */
    private void addButtonPane()
    {
       buttonPane = new HBox(10);
       buttonPane.setPrefSize(500, 50);
       buttonPane.setAlignment(Pos.CENTER);  
    }
    
    /*
      Method creates buttons and adds them to the button pane.
    */
    private void addButtons()
    {
     newDeck = new Button("New Deck");
     deal = new Button("Deal");
     exit = new Button("Exit");
     buttonPane.getChildren().addAll(newDeck, deal, exit);
    }
    
    /*
      Assigns event handlers to buttons
    */
    private void addHandler()
    {
         newDeck.setOnAction(
          event ->
          {
          CardDeck = new Deck(); 
          }
          );
         
         
        deal.setOnAction(
          event ->
          {
              try
              {
            CardDeck.dealCards(player1, player2);
              }
              catch(NoSuchElementException e)
              {
                  exceptionMethod();
              }
          
          }
          );
        
        exit.setOnAction(
          event ->
          {
           System.exit(0);          
          }
          );
    }
    
    /*
      Creates top pane, titles and lables
    */
    private void addBanner()
    {
         banner = new VBox();
         Label title = new Label("High Card!");
         Label playerTitle = new Label("Player 1" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "Player2");
         banner.setAlignment(Pos.CENTER);
         banner.getChildren().addAll(title, playerTitle);
    }
    
    /*
      Creates root pane and adds component panes to it
    */
      
    private void addRootPanes()
    {
        root = new BorderPane();
        root.setCenter(player);
        root.setBottom(buttonPane);
        root.setTop(banner);
    }
    
    /*
      Handles exeception
    */
     private void exceptionMethod()
    {
          player1.clear();
          player2.clear();
          player1.setText("There are not enough cards" + " to deal" + "\n" + "another hand");
          player2.setText("There are not enough cards" + " to deal" + "\n" + "another hand");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

