package com.swagger.entity;

public class Pet {
	private long id;
	private String name;
	private int age;
	private String dateOfBirth;
	private String gender;
	

	public Pet(long id, String name, int age, String dateOfBirth, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	private Pet(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.age = builder.age;
		this.dateOfBirth = builder.dateOfBirth;
		this.gender = builder.gender;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private long id;
		private String name;
		private int age;
		private String dateOfBirth;
		private String gender;

		private Builder() {
		}

		public Builder withId(long id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withAge(int age) {
			this.age = age;
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

		public Pet build() {
			return new Pet(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("Pet [id=");
		builder2.append(id);
		builder2.append(", name=");
		builder2.append(name);
		builder2.append(", age=");
		builder2.append(age);
		builder2.append(", dateOfBirth=");
		builder2.append(dateOfBirth);
		builder2.append(", gender=");
		builder2.append(gender);
		builder2.append("]");
		return builder2.toString();
	}

}
