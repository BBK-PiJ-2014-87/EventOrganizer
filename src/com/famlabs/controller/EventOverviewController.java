package com.famlabs.controller;

import com.famlabs.application.Event;
import com.famlabs.application.Main;
import com.famlabs.util.CalendarUtil;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controller class.
 * 
 * @author Famlabs
 */
public class EventOverviewController {

	@FXML
	private TableView<Event> eventTable;

	@FXML
	private TableColumn<Event, String> eventNameColumn;

	@FXML
	private TableColumn<Event, String> eventOrganizerColumn;

	@FXML
	private Label eventNameLabel;

	@FXML
	private Label eventOrganizerLabel;

	@FXML
	private Label eventGuestsLabel;

	@FXML
	private Label eventHostLabel;

	@FXML
	private Label eventCountryLabel;

	@FXML
	private Label eventCityLabel;

	@FXML
	private Label eventDateLabel;

	@FXML
	private Label statusBarLebel;

	// reference to the main application
	private Main main;

	/**
	 * Constructor is called before the initialize() method.
	 */

	public EventOverviewController() {

	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */

	@FXML
	private void initialize() {
		eventNameColumn
				.setCellValueFactory(new PropertyValueFactory<Event, String>(
						"eventName"));
		eventOrganizerColumn
				.setCellValueFactory(new PropertyValueFactory<Event, String>(
						"eventOrganizer"));

		// auto resize columns
		eventTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		// clear event details
		showEventDetails(null);

		// Listen for changes
		eventTable.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<Event>() {

					@Override
					public void changed(
							ObservableValue<? extends Event> observable,
							Event oldValue, Event newValue) {
						showEventDetails(newValue);
					}
				});

	}

	/**
	 * Is called by main application to give a reference back to itself.
	 * 
	 * @param main
	 */

	public void setMain(Main main) {
		this.main = main;

		// Add observable list to data to the table
		eventTable.setItems(main.getEventData());
	}

	private void showEventDetails(Event e) {
		if (e != null) {

			eventNameLabel.setText(e.getEventName());
			eventOrganizerLabel.setText(e.getEventOrganizer());
			eventGuestsLabel
					.setText(Integer.toString(e.getEventGuestsNumber()));
			eventHostLabel.setText(e.getEventHost());
			eventCountryLabel.setText(e.getEventCountry());
			eventCityLabel.setText(e.getEventCity());
			eventDateLabel.setText(CalendarUtil.format(e.getEventDate()));

		} else {
			eventNameLabel.setText("");
			eventOrganizerLabel.setText("");
			eventGuestsLabel.setText("");
			eventHostLabel.setText("");
			eventCountryLabel.setText("");
			eventCityLabel.setText("");
			eventDateLabel.setText("");

		}
	}

	@FXML
	private void deleteEvent() {
		// to get an index of selected item
		try {
			int selectedIndex = eventTable.getSelectionModel()
					.getSelectedIndex();
			eventTable.getItems().remove(selectedIndex);
			statusBarLebel.setText("Event deleted");
		} catch (Exception e) {
			//pop up alert window
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("Event Application Manager");
			alert.setContentText("There are no more events to delete");

			alert.showAndWait();
			statusBarLebel.setText("No events to delete");
		}

	}

}
