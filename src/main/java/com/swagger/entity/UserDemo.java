package com.swagger.entity;

public class UserDemo {
	private long id;
	private String username;
	private String firstName;
	private String lastName;
	private int age;
	private String placeOfBirth;
	private String dateOfBirth;
	private String gender;
	private String email;

	public UserDemo(long id, String username, String firstName, String lastName, int age, String placeOfBirth,
			String dateOfBirth, String gender, String email) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.placeOfBirth = placeOfBirth;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
	}

	private UserDemo(Builder builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.placeOfBirth = builder.placeOfBirth;
		this.dateOfBirth = builder.dateOfBirth;
		this.gender = builder.gender;
		this.email = builder.email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private long id;
		private String username;
		private String firstName;
		private String lastName;
		private int age;
		private String placeOfBirth;
		private String dateOfBirth;
		private String gender;
		private String email;

		private Builder() {
		}

		public Builder withId(long id) {
			this.id = id;
			return this;
		}

		public Builder withUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder withAge(int age) {
			this.age = age;
			return this;
		}

		public Builder withPlaceOfBirth(String placeOfBirth) {
			this.placeOfBirth = placeOfBirth;
			return this;
		}

		public Builder withDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public Builder withGender(String gender) {
			this.gender = gender;
			return this;
		}

		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}

		public UserDemo build() {
			return new UserDemo(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("UserDemo [id=");
		builder2.append(id);
		builder2.append(", username=");
		builder2.append(username);
		builder2.append(", firstName=");
		builder2.append(firstName);
		builder2.append(", lastName=");
		builder2.append(lastName);
		builder2.append(", age=");
		builder2.append(age);
		builder2.append(", placeOfBirth=");
		builder2.append(placeOfBirth);
		builder2.append(", dateOfBirth=");
		builder2.append(dateOfBirth);
		builder2.append(", gender=");
		builder2.append(gender);
		builder2.append(", email=");
		builder2.append(email);
		builder2.append("]");
		return builder2.toString();
	}

}
