package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entities.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class LayoutController implements Initializable {
    @FXML
    private ComboBox<Person> comboBoxPerson;
    @FXML
    private Button btAll;

    private ObservableList<Person> obsList;

    @FXML
    public void onComboBoxPersonAction(){
        Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
        System.out.println(person);
    }

    @FXML
    public void onBtAllAction(){
        for(Person p : comboBoxPerson.getItems()){
            System.out.println(p);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Lucas", "lucas@gmail.com"));
        list.add(new Person(2, "Marco", "marco@gmail.com"));
        list.add(new Person(3, "Pablin", "pablin@gmail.com"));

        obsList = FXCollections.observableArrayList(list);
        comboBoxPerson.setItems(obsList);

        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>(){
            @Override
            protected void updateItem(Person p, boolean empty){
                super.updateItem(p,empty);
                setText(empty ? "" : p.getName());
            }
        };
        comboBoxPerson.setCellFactory(factory);
        comboBoxPerson.setButtonCell(factory.call(null));
    }
}
