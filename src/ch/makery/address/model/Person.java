package ch.makery.address.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ch.makery.address.util.LocalDateAdapter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person.
 *
 * @author JoseManuel
 */
public class Person {

	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty street;
	private final IntegerProperty postalCode;
	private final StringProperty city;
	private final ObjectProperty<LocalDate> birthday;

	/**
	 * Default constructor of Person
	 */
	public Person() {
		this(null, null);
	}

	/**
	 * Constructor of Person with some initial data.
	 *
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);

		// Some initial dummy data, just for convenient testing.
		this.street = new SimpleStringProperty("some street");
		this.postalCode = new SimpleIntegerProperty(1234);
		this.city = new SimpleStringProperty("some city");
		this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));

	}

	/**
	 * Method Getter of firstName
	 *
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName.get();
	}

	/**
	 * Method Setter of firstName
	 *
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	/**
	 *
	 * Method firstNameProperty
	 *
	 * @return firstName
	 */
	public StringProperty firstNameProperty() {
		return firstName;
	}

	/**
	 * Method to get lastName
	 *
	 * @return lastName
	 */
	public String getLastName() {
		return lastName.get();
	}

	/**
	 * Method to set lastName
	 *
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}

	/**
	 * Method to get lastName
	 *
	 * @return street
	 */
	public String getStreet() {
		return street.get();
	}

	/**
	 * Method to set street
	 *
	 * @param street
	 */
	public void setStreet(String street) {
		this.street.set(street);
	}

	/**
	 * Method streetProperty
	 *
	 * @return street
	 */
	public StringProperty streetProperty() {
		return street;
	}

	/**
	 * Method to get PostalCode
	 *
	 * @return postalCode
	 */
	public int getPostalCode() {
		return postalCode.get();
	}

	/**
	 * Method to set PostalCode
	 *
	 * @param postalCode
	 */
	public void setPostalCode(int postalCode) {
		this.postalCode.set(postalCode);
	}

	/**
	 * Method postalCodeProperty
	 *
	 * @return postalCode
	 */
	public IntegerProperty postalCodeProperty() {
		return postalCode;
	}

	/**
	 * Method to get city
	 *
	 * @return city
	 */
	public String getCity() {
		return city.get();
	}

	/**
	 * Method to set city
	 *
	 * @return city
	 */
	public void setCity(String city) {
		this.city.set(city);
	}

	/**
	 * Method cityProperty
	 *
	 * @return city
	 */
	public StringProperty cityProperty() {
		return city;
	}

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getBirthday() {
		return birthday.get();
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday.set(birthday);
	}

	public ObjectProperty<LocalDate> birthdayProperty() {
		return birthday;
	}

}
