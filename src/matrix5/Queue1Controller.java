package matrix5;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class Queue1Controller implements Initializable {

    
    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> idColumn;
    @FXML
    private TableColumn<Person, String> nameColumn;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private Label datecode;
    @FXML
    private Button btt1;
    
    
    // لتغير ال id من الجدول 
    public void changeidCellEvent(CellEditEvent edittedCell)
    {
        Person personSelected =  tableView.getSelectionModel().getSelectedItem();
        personSelected.setId(edittedCell.getNewValue().toString());
    }
     
    // to change the name 
    
    public void changeNameCellEvent(CellEditEvent edittedCell)
    {
        Person personSelected =  tableView.getSelectionModel().getSelectedItem();
        personSelected.setName(edittedCell.getNewValue().toString());
    }
    // لفتح صفحة التعريف
    @FXML
    void handAboutAction(ActionEvent event ){
        try {
            FXMLLoader fxmlloder  = new FXMLLoader(getClass().getResource("about.fxml"));
            Parent root1 =(Parent ) fxmlloder.load();
            Stage stage = new Stage();
            stage.setTitle("About ME");
            stage.setScene(new Scene(root1, 579, 340));
            stage.show();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Queue1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    // لجلب ووضع المعلومات ضمن الجدول 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        idColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("Id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("Name"));

        
        tableView.setItems(getPeople());
        
        
        tableView.setEditable(true);
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        


    }

 
    public void time(){
        Date date = new Date(); 
        
    } 
        
        
    
    // زر الحذف
public void deleteButtonPushed()
    {
        ObservableList<Person> selectedRows, allPeople;
        allPeople = tableView.getItems();
        
        //this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        //loop over the selected rows and remove the Person objects from the table
        for (Person person: selectedRows)
        {
            allPeople.remove(person);
        }
    }
// زر الاضافة
public void newPersonButtonPushed()
    {
        Person newPerson = new Person(idTextField.getText(),
                                      nameTextField.getText());
        
        //لوضع المعلومات التي تم كتابتها في التيكست الى الجدول 
        tableView.getItems().add(newPerson);
    }
public ObservableList<Person>  getPeople()
    {
        ObservableList<Person> people = FXCollections.observableArrayList();
        //people.add(new Person("1","ali hazim"));
        
        
        return people;
    }
    
}
