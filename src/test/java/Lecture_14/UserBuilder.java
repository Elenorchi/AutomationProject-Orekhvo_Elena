package Lecture_14;

import lombok.Builder;

@Builder
public class UserBuilder {
    public String username;
    public String email;
    public Integer age;
/*
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
 */
}
