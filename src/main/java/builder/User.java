package builder;
public class User {
    private String firstName;
    private String lastName;
    private Gender gender;
    private UserStatusId userStatusId;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserStatusId getUserStatusId() {
        return userStatusId;
    }

    public Gender getGender() {
        return gender;
    }

    public static UserBuilder getUserBuilder() {
        return new User().new UserBuilder();
    }

    @Override
    public String toString() {
        return "User{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", userStatusId=" + userStatusId +
                '}';
    }

    public class UserBuilder {
        private String firstName;
        private String lastName;
        private Gender gender;
        private UserStatusId userStatusId;

        public UserBuilder setFistName(String firstName) {
            User.this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            User.this.lastName = lastName;
            return this;
        }

        public UserBuilder setGender(Gender gender) {
            User.this.gender = gender;
            return this;
        }

        public UserBuilder setUserStatusId(UserStatusId userStatusId) {
            User.this.userStatusId = userStatusId;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}