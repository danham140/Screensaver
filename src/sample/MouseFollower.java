
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent; 

// Magic inheritance that makes the GUI turn on and work
public class MouseFollower extends Application{
//	This is our rectangle that will chase our mouse
    Rectangle theRectangle;
    
//    This is our method which gets called by javafx at the start of the application
    @Override
    public void start(final Stage primaryStage) {
//      Define your stuff that gets drawn
    		theRectangle = new Rectangle(20, 20, Color.WHITE);

//    	Java fx magic
    		Group group = new Group(theRectangle);	
    		Scene scene = new Scene(group, 800, 600, Color.BLACK);
    		primaryStage.setScene(scene);
    		primaryStage.show();
    		
//    	Make a function that we want called every time the mouse moves
    		class MouseMovedHandler implements EventHandler<MouseEvent> {
			@Override
			public void handle(MouseEvent mouseEvent) {
//	          get the position of the mouse
	        		double mouseX = mouseEvent.getX();
	        		double mouseY = mouseEvent.getY();
	        		
//	        	update the position of our rectangle
	        		theRectangle.setTranslateX(mouseX);
	        		theRectangle.setTranslateY(mouseY);
			}
    		}
    		
    		MouseMovedHandler myHandler = new MouseMovedHandler();
        scene.setOnMouseMoved(myHandler);
    }
  public static void main(String[] args) {
  launch(args);
}
}
