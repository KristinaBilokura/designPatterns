package builder;

public class Runner {
    public static void main(String[] args) {
        System.out.println(getUser().toString());
    }
    public static User getUser() {
        return User.getUserBuilder().setFistName("Ben")
                .setLastName("Franklin")
                .setGender(Gender.MALE)
                .setUserStatusId(UserStatusId.SUBSCRIBED)
                .build();
    }
}
