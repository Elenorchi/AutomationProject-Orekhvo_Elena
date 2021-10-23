package patterns;

public class UserBuilder {
String username;
String email;
Integer age;

    public static class Builder {
        private UserBuilder builder;

        public  Builder () {
            builder = new UserBuilder();
        }

        public Builder withUsername(String username) {
            builder.username = username;
            return this;
        }

        public Builder withAge(Integer age) {
            builder.age = age;
            return this;
        }

        public Builder withEmail(String email) {
            builder.email = email;
            return this;
        }

        public UserBuilder build() {
            return builder;
        }
    }
}
