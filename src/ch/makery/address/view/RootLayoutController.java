package ch.makery.address.view;

import java.io.File;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

import org.controlsfx.dialog.Dialogs;
import ch.makery.address.control.MainApp;
import ch.makery.address.model.Person;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 *
 * @author Marco Jakob
 */
public class RootLayoutController {

	// Reference to the main application
	private MainApp mainApp;
	@FXML
	private TextField campo_busqueda;

	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Creates an empty address book.
	 */
	@FXML
	private void handleNew() {
		mainApp.getPersonData().clear();
		mainApp.setPersonFilePath(null);
	}

	/**
	 * Opens a FileChooser to let the user select an address book to load.
	 */
	@FXML
	private void handleOpen() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

		if (file != null) {
			mainApp.loadPersonDataFromFile(file);
		}
	}

	/**
	 * Saves the file to the person file that is currently open. If there is no
	 * open file, the "save as" dialog is shown.
	 */
	@FXML
	private void handleSave() {
		File personFile = mainApp.getPersonFilePath();
		if (personFile != null) {
			mainApp.savePersonDataToFile(personFile);
		} else {
			handleSaveAs();
		}
	}

	/**
	 * Opens a FileChooser to let the user select a file to save to.
	 */
	@FXML
	private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

		if (file != null) {
			// Make sure it has the correct extension
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			mainApp.savePersonDataToFile(file);
		}
	}

	/**
	 * Opens the birthday statistics.
	 */
	@FXML
	private void handleShowBirthdayStatistics() {
		mainApp.showBirthdayStatistics();
	}

	/**
	 * Opens the Graphical View
	 */
	@FXML
	private void handleGraphical() {
		mainApp.showGraphicalView();

	}

	@FXML
	private void handleStyles1() {
		mainApp.ChangeStyle1();

	}

	@FXML
	private void handleStyles2() {
		mainApp.ChangeStyle2();

	}

	/**
	 *
	 * Listener del TextField Busqueda
	 *
	 */
	@FXML
	public void handleBusqueda() {
		ObservableList<Person> lista_personas = this.mainApp.getPersonData();
		String texto_ingresado = this.campo_busqueda.getText();
		this.campo_busqueda.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					int contador = 0;
					boolean encontrado = false;
					while ((!encontrado) && (contador < lista_personas.size())) {
						String comparador = lista_personas.get(contador).getFirstName()
								+ lista_personas.get(contador).getLastName();
						comparador = comparador.toLowerCase();
						if (comparador.contains(texto_ingresado)) {
							mostrar(lista_personas.get(contador));
							encontrado = true;
						}
						contador++;
					}
				}
			}

		});

	}

	private void mostrar(Person person) {
		this.mainApp.showPersonEditDialog(person);

	}

	/**
	 * Opens an about dialog.
	 */
	@FXML
	private void handleAbout() {
		Dialogs.create().title("AddressApp").masthead("About").message("Author: Jmc\nWebsite: http://github.com")
				.showInformation();
	}

	/**
	 * Closes the application.
	 */
	@FXML
	private void handleExit() {
		System.exit(0);
	}
}
