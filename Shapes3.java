import javafx.scene.*;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


/* Constants
 * String colour used to control colour of shape and description
 * String shape used to control colour of shape
 * Background background used to give project uniform scheme
 * String desc used to provide description of shape & colour selected or to provide error message to user
 * 
 * Methods
 * main method only used to launch
 * start method used to instantiate JavaFx
 * mainStage method used for the main selection scene (with radio buttons - poke yoke methodology limits user input to only valid options)
 * textStage method offers same functions as mainStage but allows for text input
 * (textStage included as per university guidelines to allow for examples of user input validation and feedback)
 * createStage method creates the shape / colour combination as selected by the user or displays error messages
 * createStage method requires shape and colour information
 * createTriangle, createRectangle & createHexagon methods create the relevant shape
 */

public class Shapes3 extends Application {
		public static void main(String[] args) {
			launch(args);
	    }

		private String colour;
		private String shape;
        Polygon polygon = new Polygon();
		
		@Override
	    public void start(Stage primaryStage) {
	        mainStage();
		}
		
		
		public void mainStage() {
		Stage mainStage = new Stage();
		mainStage.setTitle("Shape Creator");
        
        Text shapesTitle = new Text("Please select your desired shape");
        shapesTitle.setFont(Font.font ("Verdana", 15));
        final ToggleGroup shapes = new ToggleGroup();

        RadioButton tri = new RadioButton("Triangle");
        tri.setToggleGroup(shapes);
        tri.setSelected(true);

        RadioButton rect = new RadioButton("Rectangle");
        rect.setToggleGroup(shapes);
         
        RadioButton hex = new RadioButton("Hexagon");
        hex.setToggleGroup(shapes);
        
        //colours title and toggle group
        Text coloursTitle = new Text("Please select your desired colour");
        coloursTitle.setFont(Font.font ("Verdana", 15));
        final ToggleGroup colours = new ToggleGroup();

        RadioButton red = new RadioButton("Red");
        red.setToggleGroup(colours);
        red.setSelected(true);

        RadioButton green = new RadioButton("Green");
        green.setToggleGroup(colours);
         
        RadioButton gray = new RadioButton("Gray");
        gray.setToggleGroup(colours);
        
        Text description = new Text("Please choose your shape and colour");
        description.setFont(Font.font ("Verdana", 15));
        
        Group root = new Group(description, polygon);
        
        colours.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
        	public void changed(ObservableValue<? extends Toggle> ob,  
                    Toggle o, Toggle n) 
        	{
        		root.getChildren().clear();
            	colour = ((RadioButton)colours.getSelectedToggle()).getText().toUpperCase();
            	shape = ((RadioButton)shapes.getSelectedToggle()).getText().toUpperCase();
            	root.getChildren().addAll(createShape(colour, shape));
        	}
        });
        
        shapes.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
        	public void changed(ObservableValue<? extends Toggle> ob,  
                    Toggle o, Toggle n) 
        	{
        		root.getChildren().clear();
            	colour = ((RadioButton)colours.getSelectedToggle()).getText().toUpperCase();
            	shape = ((RadioButton)shapes.getSelectedToggle()).getText().toUpperCase();
            	root.getChildren().addAll(createShape(colour, shape));
        	}
        });

        HBox shapeBox = new HBox(10);
        shapeBox.setAlignment(Pos.CENTER);
        shapeBox.getChildren().addAll(tri, rect, hex);
        
        HBox colourBox = new HBox(10);
        colourBox.setAlignment(Pos.CENTER);
        colourBox.getChildren().addAll(red, green, gray);
        
        VBox vbox = new VBox(20);
        vbox.setBackground(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, 
				CornerRadii.EMPTY, Insets.EMPTY)));
        vbox.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(shapesTitle, new Insets(50,0,0,0));
        vbox.getChildren().addAll(shapesTitle, shapeBox, coloursTitle, colourBox, root);
        
        mainStage.setScene(new Scene(vbox, 400, 500));
        mainStage.show();
    }
 
	public Group createShape(String colourIn, String shapeIn)
	{
		
		Color setColour = new Color(0, 0, 0, 0);
				switch (colourIn)
				{
				case "RED": 	setColour = Color.RED;
								break;
				case "GREEN":	setColour = Color.GREEN;
								break;
				case "GRAY":	setColour = Color.GRAY;
								break;
				};
		
		
		Polygon polygon = new Polygon();
        switch (shapeIn)
		{
		case "TRIANGLE": 	polygon = createTriangle();
							break;
		case "RECTANGLE":	polygon = createRectangle();
							break;
		case "HEXAGON":		polygon = createHexagon();
							break;
		}
        
       
        polygon.setFill(setColour);
        polygon.setStroke(setColour);
        

        String desc = colourIn + " " + shapeIn;
		Text description = new Text(desc);
		description.setFont(Font.font ("Verdana", 15));
        description.setFill(setColour);
		description.setWrappingWidth(200);
		description.setTextAlignment(TextAlignment.CENTER);
		
		Group root = new Group(polygon, description);
		return root;		
	}

	public Polygon createRectangle()
	{
		Polygon rectangle = new Polygon (0, 50, 200, 50, 200, 200, 0, 200);
		return rectangle;
	}
	
	public Polygon createTriangle()
	{
		Polygon triangle = new Polygon(0, 200, 100, 50, 200, 200);
		return triangle;
	}
	
	public Polygon createHexagon()
	{
		Polygon hexagon = new Polygon(50, 50, 150, 50, 200, 125, 
									150, 200, 50, 200, 0, 125);
		return hexagon;
	}
	
}
